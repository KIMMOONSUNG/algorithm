package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
/*
F: 한 눈금 앞으로
B: 한 눈금 뒤로
L: 왼쪽으로 90도 회전
R: 오른쪽으로 90도 회전
//처음 0,0 // 첫 방향 위 //
*/
class nnn{
	int x,y,dir,index;
	nnn(int x, int y, int dir,int index){
		this.x =x;
		this.y = y;
		this.dir = dir;
		this.index = index;
	}
}

public class N8911 { //거북이 
	static int dx[] = {0,0,-1,1};
	static int dy[] = {1,-1,0,0};
	
public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
    int testcase = Integer.parseInt(bf.readLine());
    String order;
    Queue<nnn> q ;
    
    for(int i =1; i<=testcase; i++){
    
    	int maxx = -100; 
        int maxy = -100;
        int minx = 100;
        int miny = 100;
    	
    	order = bf.readLine();
    	q = new LinkedList<>();
    	q.offer(new nnn(0,0,3,0)); // 위 부터 시작이니 3 
    	
    	while(!q.isEmpty()){ // y 와 x 가 반대로 해야하지만 상관없음 
    		
    		nnn p = q.poll();
    		maxx= Math.max(maxx, p.x);
			maxy = Math.max(maxy, p.y);
			minx = Math.min(minx, p.x);
			miny = Math.min(miny, p.y);
    		
    		if(p.index >=order.length()){
    			break;
    		}
    		
    		char ch = order.charAt(p.index);
    		
    		if(ch=='F'){
    			int x = p.x+dx[p.dir];
    			int y = p.y+dy[p.dir];
    			maxx= Math.max(maxx, x);
    			maxy = Math.max(maxy, y);
    			minx = Math.min(minx, x);
    			miny = Math.min(miny, y);
    			
    			q.offer(new nnn(x,y,p.dir,(p.index+1)));
    		}
    		
    		else if(ch=='B'){
    			int x = p.x-dx[p.dir];
    			int y = p.y-dy[p.dir];
    			maxx= Math.max(maxx, x);
    			maxy = Math.max(maxy, y);
    			minx = Math.min(minx, x);
    			miny = Math.min(miny, y);
    			q.offer(new nnn(x,y,p.dir,(p.index+1)));
    		}
    		
    		else if(ch =='L'){
    			q.offer(new nnn(p.x,p.y,direction(p.dir,ch),(p.index+1)));
    		}
    		
    		else if(ch=='R'){
    			q.offer(new nnn(p.x,p.y,direction(p.dir,ch),(p.index+1)));
    		}
    	
    	}
    	
    	int x = maxx + Math.abs(minx) ;
    	int y = maxy + Math.abs(miny) ;
    
    	int abs = x*y;
    	System.out.println(abs);
    	
   	
    }
}

static int direction(int dir,char ch) { // 방향 
	/*
	L: 왼쪽으로 90도 회전
	R: 오른쪽으로 90도 회전
	
	//오 -> 왼(위) / 오(아래) 
	//왼 -> 왼(아래) / 오 (위)
	//아래->왼(오) / 오(왼)
	//위 -> 왼(왼)/ 오 (오)
	  
	*/
	
    if(dir==0){
    	if(ch=='L'){
    		return 3;
    	}else{
    		return 2;
    	}
    }
    else if(dir==1){
    	if(ch=='L'){
    		return 2;
    	}
    	else{
    		return 3;
    	}
    }
    else if(dir==2){
    	if(ch=='L'){
    		return 0;
    	}
    	else{
    		return 1;
    	}
    }
    else if(dir==3){
    	if(ch=='L'){
    		return 1;
    	}else{
    		return 0;
    	}
    }
    else {
    	return -999;
    }
}

}

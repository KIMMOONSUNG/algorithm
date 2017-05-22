package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class G9{
	int x,y,dir,time , count;//count 는 사과먹은 개수 
	G9(int x, int y, int dir ,int time ,int count){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.time = time;
		this.count = count;
	}
}

public class G3190 { //삼성 기출문제 - - > 3190 뱀 
	static int n; // n*n
	static int k; // 사과개수 
	static int L;// 뱀 방향 변환 개수 
	static int map[][]; 
	static int cnt[][]; // 갈때마다 카운트 저장됨 
	static boolean order1[]; //시간초 
	static char order2[]; // 시간초에 맞는 방향 
	
	static int dx[] = {0,0,1,-1}; // 동서남북 
	static int dy[] = {1,-1,0,0};
	
public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	k = Integer.parseInt(bf.readLine());
	map = new int [n][n];
	order1 = new boolean[100001];
	order2 = new char[100001];
	cnt = new int[n][n];
	StringTokenizer st ;
	
	for(int i =0; i<k; i++){
      st= new StringTokenizer(bf.readLine()); 
      int a = Integer.parseInt(st.nextToken())-1;
      int b = Integer.parseInt(st.nextToken())-1;
      map[a][b] = -1; // 사과있는위치 -> -1 로 
    
	}
	
    int t = Integer.parseInt(bf.readLine());
    
    for(int i =0; i<t; i++){
    st = new StringTokenizer(bf.readLine());
     int tt = Integer.parseInt(st.nextToken());
     char ch = st.nextToken().charAt(0);
    	order1[tt] = true; // 초. 
    	order2[tt] = ch; // 회전.
    }
    
    Queue<G9> q = new LinkedList<>();
    q.offer(new G9(0,0,0,1,0)); // 처음 부터 1초를 넣어줌 (다음일을 먼저 생각하니 )
    
    cnt[0][0] =1;
    while(!q.isEmpty()){
    	G9 p = q.poll();
    	int x = p.x+dx[p.dir];
    	int y = p.y+dy[p.dir];
    	int dir = p.dir;
    	int time = p.time; 
    	int count = p.count;
    	if(x>=0 && y>=0 && x<n && y<n){
    	  if( cnt[x][y] >=time-count ){ // 자기 몸에 부딪힘
    		  System.out.println(p.time);
    		  break;
    	  }
    	  else if(map[x][y]==-1){ // 사과 먹음 
    		  map[x][y] = 0; // 사과위치 빈공간으로 변환 
    		  cnt[x][y] = time+1;
    		  if(order1[time]==true){ // 시간초에 맞는 명령이  있을시에  방향 함수 호출 
      		    q.offer(new G9(x,y,direction(dir,order2[time]),(time+1),(count+1))); // count 증가시킴 -> 사과먹었으니 
      		  }
      		  else{ // 명령없다면 방향 그대로 
      			  q.offer(new G9(x,y,dir,(time+1),(count+1)));
      		  }
    	  }
    	  else if(map[x][y] ==0){ // 빈공간 
    		  cnt[x][y] = time+1;
    		  if(order1[time]==true){ //시간초에 맞는 명령이 있을시에  방향 함수 호출 
    		    q.offer(new G9(x,y,direction(dir,order2[time]),(time+1),count)); // 사과안먹었으니 count는 그대로 
    		  }
    		  else{ // 명령없다면 방향 그대로 
    			  q.offer(new G9(x,y,dir,(time+1),count));
    		  }
    	  }
    	  
    	}
    	
    	else{ // 범위초과 -> 벽에 부딪혔을때 
    		System.out.println(p.time);
    		break;
    	}
    }
    
 }

static int direction(int dir , char ch){
 // 오 -> 오(아), 왼(위.) 
 // 왼-> 오(위), 왼(아)
 // 아 ->오(왼), 왼 (오)
 // 위 ->오(오), 왼(왼)
	if(dir==0){
		if(ch=='D'){
			return 2;
		}
		else{
			return 3;
		}
	}
	else if(dir==1){
		if(ch=='D'){
			return 3;
		}
		else{
			return 2;
		}
	}
	else if(dir==2){
		if(ch=='D'){
			return 1;
		}
		else{
			return 0;
		}
	}
	else if(dir==3){
		if(ch=='D'){
			return 0;
		}
		else{
			return 1;
		}
	}
	else{
		return -9999;
	}
}

}

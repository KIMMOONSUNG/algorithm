package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class code_1{
	int x,y;
	boolean okay ;
	code_1(int x, int y, boolean okay){
		this.x = x;
		this.y = y;
		this.okay = okay;
	
	}
}
public class code1 { // 폭격 
	static int n ;
	static int m;
	static int map[][];
	static boolean visit[][];
	static int cnt;
	
  static int rlx[] = {0,0};
  static int rly[] = {1,-1};
  static int udx[] = {1,-1};
  static int udy[] = {0,0};
  static Queue<code_1> q ;
 public static void main(String[] args) throws IOException{
	BufferedReader  bf = new BufferedReader(new InputStreamReader(System.in));
	int test = Integer.parseInt(bf.readLine());
	int Case = 1;
	for(int a =0; a<test; a++){
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int goalcnt = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		q= new LinkedList<code_1>();
		visit = new boolean[n][m];
		
		for(int i =0; i<goalcnt; i++){
			st = new StringTokenizer(bf.readLine());
			int x = Integer.parseInt(st.nextToken()) -1;
			int y = Integer.parseInt(st.nextToken()) -1;
			q.offer(new code_1(x,y,false));
			map[x][y] = -1;
	        
		}
		

		cnt=0; // 폭격기 개수 
		
		// 0 0 0 0 0
		// 0 0 0 0 0
		// 0 0 1 0 0
		// 0 0 0 0 0
		// 0 0 0 0 0
		// 자기자신에서 위아래 , 왼쪽으로 한칸가서 위아래  두칸가서 위 아래 검사//
		// 자기자신에서 위아래 , 오른쪽으로 한가서 위아래  두칸가서 위 아래 검사 끝 
		
		//자기자신에서위검사 오른쪽1칸가서 위 검사 ㅇ오른쪽 2칸가서 위 검사 
		
		
		System.out.println("Case #" + Case);
		System.out.println(func());
		Case++;
	}
 }
 static int func(){
	 
	 while(!q.isEmpty()){
			
			code_1 p = q.poll();
			visit[p.x][p.y] = true; //
		    boolean result = false; // // 3*3 안에 폭격기 유무 (위 일때랑 아래 일때 따로검사 )  
		  for(int t =0; t<2; t++){	
		   for(int k=0; k<=2; k++){ // 현재자신포함해서 RL
			   int x = p.x+(rlx[t]*k);
			   int y = p.y+(rly[t]*k);
			   
			for(int i=0; i<2; i++){
		       for(int h =0; h<=2; h++){ // 위아래1칸 2칸 검사

		    	 x = x+(udx[i]*h);
		         y = y+(udy[i]*h);
		    
		    	if(x>=0 && y>=0 && x<n && y<m &&visit[x][y]==false ){
		    		if(map[x][y]==-1 ){ // 폭격기가 안에 있다는 뜻
		    			result = true; 
		    		}
		    		
		    	}
		    	
		      }  
		    }
			
		   }
		   if(result== false){
	    	   return -1;
	       }
		  }
		 
		}
	 return cnt;
	 
 }
static int reverse(int dir){
	if(dir == 0){
		return 1; 
	}
	else if(dir==1){
		return 0;
	}
	else if(dir==2){
		return 3;
	}
	else if (dir ==3){
		return 2;
	}
	else return -99999;
}
}

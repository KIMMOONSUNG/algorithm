package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G14499 { // 주사위 굴리기 
	static int n,m,xx,yy,k; 
	static int map[][];	
	static int dx[] = {0,0,0,-1,1};
	static int dy[] = {0,1,-1,0,0};
	static int rl[];
	static int ud[];
	static int top;
	static int bottom;
	
 public static void main(String[] args) throws IOException{
	 
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	StringTokenizer st= new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken()); 
	m = Integer.parseInt(st.nextToken());
	xx = Integer.parseInt(st.nextToken());
	yy = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	
	//map
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	//order
	Queue<Integer> order = new LinkedList<>();
	st = new StringTokenizer(bf.readLine());
	for(int i =0; i<k; i++){
        int dir = Integer.parseInt(st.nextToken());
		order.offer(dir);
	}
	
    rl = new int[4]; // 1 -> 가장 위  3-> 가장 아래 
    ud = new int[4]; // 3 -> 가장 아래 1 -> 가장 위 
   
    /*
    지도의 각 칸에는 정수가 하나씩 쓰여져 있다. 
    주사위를 굴렸을 때, 이동한 칸에 써 있는 수가 0이면, 주사위의 바닥면에 써 있는 수가 칸에 복사된다.
    0이 아닌 경우에는 칸에 써 있는 수가 주사위의 바닥면으로 복사되며, 칸에 써 있는 수는 0이 된다.
    */
    
    while(!order.isEmpty()){
    	
      int d = order.poll();
    	   xx = xx+dx[d];
    	   yy = yy+dy[d];
    	   if(xx>=0 && yy>=0 && xx<n && yy<m){
    		   if(d==1){
    			   right();
    			   
    		   }
    		   else if(d==2){    			   
    			   left();
    		   }
    		   else if(d==3){
    			   up();
    		   }
    		   else if(d==4){
    			   down();
    		   }
    		   
    		   if(map[xx][yy]==0){
    			   if(d==1||d==2){
				      map[xx][yy] = rl[3];
				      ud[3] = rl[3];
				      ud[1] = rl[1];
    			   }
    			   else if(d==3|| d==4){
    				   map[xx][yy] = ud[3];
    				   rl[3] = ud[3];
    				   rl[1] = ud[1];
    			   }
    			   
			   }
    		   
			   else if(map[xx][yy]!=0){
				   if(d==1 || d==2){
				     rl[3] = map[xx][yy] ;
				     map[xx][yy] = 0;
				     ud[3] = rl[3];
				     ud[1] = rl[1];
				   }
				   else if(d==3 || d==4){
					   ud[3] = map[xx][yy] ;
					   map[xx][yy] = 0;
					   rl[3] = ud[3];
					   rl[1] = ud[1];
				   }
			   }
    		   
    		   String str = Integer.toString(rl[1]);
    		   bw.write(str+"\n");
    		   
    	   }
    	   
    	   else{
    		   xx=  xx-dx[d];
    		   yy=  yy-dy[d];
    	   }
    	   
    }
    
    bf.close();
    bw.close();
}
 
 static void right (){
	 
		 int mid1 = rl[1];
		 int mid2 = rl[2];
		 int last = rl[3];
		 rl[1] = rl[0];
		 rl[2] = mid1;
		 rl[3] = mid2;
		 rl[0] = last;
		 
 }
 static void left(){
	 
	  int mid1 = rl[2];
	  int mid2 = rl[1];
	  int last = rl[0];
	  rl[2] = rl[3];
	  rl[1] = mid1;
	  rl[0] = mid2;
	  rl[3] = last;
 }
 static void up(){
	 
	 int mid1 = ud[2];
	 int mid2 = ud[1];
	 int last = ud[0];
	 ud[2] = ud[3];
	 ud[1] = mid1;
	 ud[0] = mid2;
	 ud[3] = last;
 }
 
 static void down(){
	 int mid1 = ud[1];
	    int mid2 = ud[2];
	    int last = ud[3];
	    ud[1] = ud[0];
	    ud[2] = mid1;
	    ud[3] = mid2;
	    ud[0] = last;
	 
 }
 
}

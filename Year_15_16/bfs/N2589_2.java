package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class nn{
	int x;
	int y;
	int len;
}
public class N2589_2 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int map[][];
	static int n;
	static int m;
	static int result;
  public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	 n = sc.nextInt();
	 m = sc.nextInt();
	 map = new int[n][m];
	 result =-1;
	 for(int i =0; i<n; i++){
		 String str= sc.next();
		 for(int j =0; j<m; j++){
			 if(str.charAt(j) == 'L'){
				map[i][j] =1; 
			 }
		 }
	 }
	 for(int i=0; i<n; i++){
		 for(int j =0; j<m; j++){
			 if(map[i][j]==1){
		   fun(i,j);	 
			 }
		 }
	 }
	 System.out.println(result);
	}
  static void fun(int a, int b){
	  boolean visit[][] = new boolean[n][m];
	 Queue<nn> q = new LinkedList<nn>();
	 nn p = new nn();
	 p.x = a;
	 p.y = b;
	 p.len = 0;
	 q.offer(p);
	 int count =0;
	 visit[p.x][p.y] = true;
	 while(!q.isEmpty()){
		 p = q.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x + dx[i];
			 int y= p.y +dy[i];
			 int len = p.len;
			 if(x>=0 && y>=0 && x<n && y<m && visit[x][y] ==false
					 && map[x][y]==1){
				 visit[x][y] = true;
				 nn p2 = new nn();
       		     p2.x = x;
       		     p2.y = y;
       		     p2.len = len+1;
       		     
       		     q.offer(p2);
             	   if(count<p2.len){ 
              		   count = p2.len; //육지도착할때마다 길이를count에 넣어줌
              	   }
             	   
             	   if(result<count){ // 전체count인 result를 계속 count와 비교해줌 
            		   result = count;
            	   }
			 }
						 
		 }
	 }
	 
  }
}

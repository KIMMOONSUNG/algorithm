package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pr2{
	int x;
	int y;
	int len;
	pr2(int x, int y, int len){
		this.x = x;
		this.y = y;
		this.len =len;
	}
}

public class pr {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int map[][];
	static boolean visit[][];
	static int n;
	static int m;
	static int result;
  public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	 n = sc.nextInt();
	 m = sc.nextInt();
	 map = new int[n][m];
	 visit= new boolean[n][m];
	 result =-1;
	 for(int i =0; i<n; i++){
		 String str= sc.next();
		 for(int j =0; j<m; j++){
			 if(str.charAt(j) == 'L'){
				map[i][j] =1; 
			 }
		 }
	 }
	 Queue<pr2> q = new LinkedList<pr2>();
	 
	 for(int i=0; i<n; i++){
		 for(int j =0; j<m; j++){
			 if(map[i][j]==1){
		   q.offer(new pr2(i,j,0));	 
			 }
		 }
	 }
	 while(!q.isEmpty()){
		 pr2 p = q.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x + dx[i];
			 int y= p.y +dy[i];
			 int len = p.len+1;
			 if(x>=0 && y>=0 && x<n && y<m && visit[x][y] ==false
					 && map[x][y]==1){
				 visit[x][y] = true;
       		     q.offer(new pr2(x,y,len));
             	result = Math.max(result, len);
			 }
						 
		 }
	 }
	 
	 System.out.println(result);
	}
  
}

package bfs;

import java.util.PriorityQueue;
import java.util.Scanner;

class N implements Comparable<N>{
	int x;
	int y;
	int count;
	
	N(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
	public int compareTo(N n){
	  if(this.count >n.count){
		  return 1;
	  }
	  else if(this.count < n.count){
		  return -1;
	  }
	  else{
		  return 0;
	  }
	}
}

public class N_1261_2 {
	static int m ;
	static int n;
	static int map[][];
	static boolean visit[][];
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	 m = sc.nextInt();
	 n = sc.nextInt();
	map = new int[n][m];
	visit = new boolean [n][m];
	for(int i =0; i<n; i++){
		String str =sc.next();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j)-48;
		}
	}
	bfs();
}
 
 static void bfs(){
	 PriorityQueue<N> q = new PriorityQueue<N>();
	 
	 q.offer(new N(0,0,0));
	 visit[0][0] = true;
	 int dx[] = {0,0,1,-1};
	 int dy[] = {1,-1,0,0};
	 
	 while(!q.isEmpty()){
		 N c = q.poll();
		 if(c.x == n-1 &&c.y==m-1){
			 System.out.println(c.count);
			 break;
		 }
		 for(int i=0 ;i<4; i++){
			 int x = c.x+dx[i];
			 int y = c.y+dy[i];
			 int cnt = c.count;
			 
			 if(x>=0 && y>=0 && x<n && y<m && visit[x][y] ==false){
				 
				 if(map[x][y]==1){ //벽O 
					q.offer(new N(x,y,cnt+1)); 
				 }
				 if(map[x][y]==0){ //벽X
					q.offer(new N(x,y,cnt));
				 }
				 visit[x][y] = true;
			 }
		 }
	 }
 }
}


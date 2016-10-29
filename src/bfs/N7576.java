package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_7576{
	int x;
	int y;
	int time;
	n_7576(int x, int y,int time){
		this.x = x;
		this.y = y;
		this.time = time;
	}
}
public class N7576 { // 토마토
	// 가장 오래걸리는 시간 출력하면 됨 
  public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int m = Integer.parseInt(st.nextToken());
	int n = Integer.parseInt(st.nextToken());
	int map[][] = new int[n][m];
	boolean visit[][]= new boolean[n][m];
	 int confirm [][] = new int [n][m];
	 int resulttime =0;
	 int dx[] = {0,0,1,-1};
	 int dy[] = {1,-1,0,0};
	 Queue<n_7576> q = new LinkedList<n_7576>();	  
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine().trim());
		for(int j =0; j<m; j++){
		  map[i][j] = 	Integer.parseInt(st.nextToken());
		  if(map[i][j]==1){
              q.offer(new n_7576(i,j,0));
		  }
		}
	}
	while(!q.isEmpty()){
		n_7576 p = q.poll();
		for(int i =0; i<4; i++){
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			int time = p.time;
			if(x>=0 && y>=0 && x<n && y<m && (map[x][y]==0||map[x][y]==1) &&visit[x][y]==false){
			  	visit[x][y] = true;
			  	confirm[x][y] =7; // 
			  	q.offer(new n_7576(x, y, time+1));
			  	resulttime = Math.max(resulttime, time+1);
			}
		}
	}
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
		  if(map[i][j] ==0 && confirm[i][j] !=7){ // 0인곳중 바뀐값이 7이아닌곳은 토마토가 모두 익지않은 상황
			  resulttime = -1;
		  }
		}
	}
	System.out.println(resulttime);
 }
  
}

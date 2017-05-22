package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class n_1261 implements Comparable<n_1261>{
	int x, y,cnt;
	n_1261(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	public int compareTo(n_1261 c){
		if(this.cnt > c.cnt){
			return 1;
		}
		else if(this.cnt == c.cnt){
			return 0;
		}
		else{
			return -1;
		}
	}
}

public class N1261 { // 알고스팟
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int m = Integer.parseInt(st.nextToken());
	int n = Integer.parseInt(st.nextToken());
	int map [][] = new int[n][m];
	boolean visit[][] = new boolean[n][m];
	
	for(int i =0; i<n; i++){
		String str = bf.readLine();
	 for(int j =0; j<m; j++){
		 map[i][j] = str.charAt(j)-48;
	 }
	}
	
	PriorityQueue<n_1261> pq = new PriorityQueue<>();
	pq.offer(new n_1261(0,0,0));
	
	while(!pq.isEmpty()){
      n_1261 p = pq.poll();
      if(p.x == n-1 && p.y == m-1){
    	  System.out.println(p.cnt);
    	  break;
      }
      for(int i =0; i<4; i++){
    	  int x = p.x+ dx[i];
    	  int y = p.y+ dy[i];
    	  int cnt = p.cnt;
    	  if(x>=0 && y>=0 && x<n && y<m && visit[x][y] == false){
    		  visit[x][y] = true;
    		  if(map[x][y] == 1){
    			  
    			  pq.offer(new n_1261(x,y,cnt+1));
    		  }
    		  else{
    			  pq.offer(new n_1261(x,y,cnt));
    		  }
    		  
    	  }
      }
	}
	
	
 }
}

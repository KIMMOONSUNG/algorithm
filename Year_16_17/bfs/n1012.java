package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_1012{
	int x,y;
	n_1012(int x, int y){
		this.x =x;
		this.y= y;
	}
}
public class n1012 { // 유기농배추 
	static int n;
	static int m;
	static int num;
	static int map[][];
	static boolean visit[][];
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static Queue<n_1012> q ;
    static int cnt;
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= testcase; t++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			visit = new boolean[n][m];
			cnt = 1;
			q = new LinkedList<>();
			for(int i =0; i<num; i++){
			 st = new StringTokenizer(bf.readLine());
			 int y = Integer.parseInt(st.nextToken());
			 int x = Integer.parseInt(st.nextToken());
			 map[x][y] = 1;
			}
			
			
			for(int i =0; i<n; i++){
			  for(int j=0; j<m; j++){
				  if(map[i][j]==1 && visit[i][j]==false){
					  cnt++;
					  func(i,j);
					  
				  }
			  }
			}
			
			System.out.println(cnt-1);
			
		}
	}
	
	static void func(int a, int b){
      q.offer(new n_1012(a,b));
      map[a][b] = cnt;
      while(!q.isEmpty()){
    	  n_1012 p = q.poll();
    	  for(int i =0; i<4; i++){
    		  int x = p.x+dx[i];
    		  int y = p.y+dy[i];
    		  if(x>=0 && y>=0 && x<n && y<m && map[x][y]==1){
    			  if(visit[x][y] == false){
    				  visit[x][y] = true;
    				  map[x][y] = cnt;
    				  q.offer(new n_1012(x,y));
    			  }
    		  }
    	  }
      }
	}
	
}

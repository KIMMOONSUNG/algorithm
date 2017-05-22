package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n1012{
	int x;
	int y;
	n1012(int x,int y){
		this.x =x ;
		this.y =y ;
	}
}

public class N_1012 { // 유기농 배추 ->> m이 가로 n이 세로 // 순서 잘  
	static int map[][] ;
	static int m;
	static int n;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		for (int a = 0; a < testcase; a++) {
			int count =0;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			 m = Integer.parseInt(st.nextToken());
			 n = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			int num = Integer.parseInt(st.nextToken());
			
            for(int k=0 ; k<num; k++){
            	
            	st = new StringTokenizer(bf.readLine());
            	int x = Integer.parseInt(st.nextToken());
            	int y = Integer.parseInt(st.nextToken());            			
            	map[y][x] = 1;
            	
            }
            
            for(int i=0; i<n; i++){
            	for(int j=0; j<m; j++){
            		if(map[i][j]==1){
            			func(i,j);            			
            			count++;
            		}
            	}
            }
            
            System.out.println(count);                
		}
	}
	static void func(int a, int b){
		Queue<n1012> q= new LinkedList<n1012>();
		boolean visit[][] = new boolean[n][m];
		q.offer(new n1012(a,b));
		map[a][b] =2;
		while(!q.isEmpty()){
			n1012 p = q.poll();
			for(int i =0; i<4; i++){
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				if(x>=0 && y>=0 && x<n && y<m && map[x][y]==1&&visit[x][y]==false){
					visit[x][y]=true;
					map[x][y]=2;
					q.offer(new n1012(x,y));
				}
			}
		}		
	}
	
}

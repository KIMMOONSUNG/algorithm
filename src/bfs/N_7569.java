package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n7569{
	int x,y,h,cnt ; 
	n7569(int x, int y, int h ,int cnt){
		this.x = x;
		this.y =y ;
		this.h = h;
		this.cnt = cnt;
	}
}
public class N_7569 {
	static int m;
	static int n;
	static int h;
	static int map[][][];
    static boolean visit[][][];
    static boolean check[][][];
    static int dx[]= {0,0,1,-1, 0,0};
    static int dy[]= {1,-1,0,0, 0,0};
    static int dh[]= {0,0,0,0,  1,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		map = new int[n][m][h];
		visit = new boolean[n][m][h];
		check = new boolean[n][m][h];
		Queue<n7569> q = new LinkedList<n7569>();
		
		for (int k = 0; k < h; k++){
			for (int i = 0; i < n; i++){
				st = new StringTokenizer(bf.readLine().trim());
				for (int j = 0; j < m; j++){
                   map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                	   q.offer(new n7569(i,j,k,0));
                    }
				}
			}
		}
		int time = 0;
		while(!q.isEmpty()){
			n7569 p = q.poll();	
			 for(int i=0; i<6; i++){
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				int hh = p.h+dh[i];
				int cnt=p.cnt;
				if(x>=0 && y>=0 && x<n && y<m && hh>=0 &&hh<h  && (map[x][y][hh]==0||map[x][y][hh]==1)){
					if(visit[x][y][hh]==false){
						visit[x][y][hh]=true;
						check[x][y][hh]= true;
						q.offer(new n7569(x,y,hh,cnt+1));
					    time = Math.max(time, cnt+1);
					}
				}
			 }
		}
		for(int a=0;a<h; a++){
			for(int i=0; i<n; i++ ){
				for(int j =0; j<m; j++){
					if(map[i][j][a]==0 && check[i][j][a]==false){
						time = -1;
					}
				}
			}
		}
		System.out.println(time);
		
	}
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class n_5427{
	int x,y,cnt;
	n_5427(int x, int y, int cnt){
		this.x =x ;
		this.y = y;
		this.cnt = cnt;
		
	}
}

public class n5427 { // 불  
	static int m;
	static int n ;
    static char map[][];
    static int fire[][];
    static boolean visit[][];
    static Queue<n_5427> f ;
    static Queue<n_5427> q ;
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		for(int a = 1; a<=testcase; a++){
			StringTokenizer st = new StringTokenizer(bf.readLine().trim());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new char [n][m];
			fire = new int[n][m];
			f = new LinkedList<>();
			q = new LinkedList<>();
			
			for(int i =0; i<n; i++){
				String str = bf.readLine();
				for(int j =0; j<m; j++){
					map[i][j] = str.charAt(j);
					fire[i][j] = 9999999; // 최대로 넣어주는게 중요함.
					if(map[i][j] == '*'){
						f.offer(new n_5427(i,j,0));
					}
					if(map[i][j] == '@'){
						q.offer(new n_5427(i,j,0));
					}
				}
			}
			firecnt();
			
			sang();
			
		}
		
	}
	
	static void firecnt(){ // 불 카운트 
		visit = new boolean[n][m];
	   while(!f.isEmpty()){
		   n_5427 p = f.poll();
		   for(int i=0; i<4; i++){
			   int x = p.x+dx[i];
			   int y = p.y+dy[i];
			   int cnt = p.cnt;
			   if(x>=0 && y>=0 && x<n && y<m && map[x][y]=='.'){ // 빈공간일때만 이동가능 
				   if(visit[x][y]==false){
					   visit[x][y] = true;
					   fire[x][y] = cnt+1; // 불 카운트 넣어줌 
					   f.offer(new n_5427(x,y,cnt+1));
					   
				   }
			   }
		   }
	   }
	}
	
	
	static void sang(){
		boolean result = false;
		visit = new boolean[n][m];
		while(!q.isEmpty()){
			n_5427 p = q.poll();
			for(int i =0; i<4; i++){
				int x = p.x +dx[i];
				int y = p.y +dy[i];
				int cnt = p.cnt;
				if(x>=0 && y>=0 && x<n && y<m && map[x][y]=='.' && (cnt+1) < fire[x][y]) { // 불카운트보다 상근이 이동하는 카운트가 더 작아야함 // 빈공간이여야
					if(visit[x][y] ==false){
						visit[x][y] = true;
						q.offer(new n_5427(x,y,cnt+1));
						
					}
				}
				if(x<0 || y<0 || x>=n || y>=m){
					result = true;
					System.out.println(p.cnt+1);
					break;
				}
			}
			if(result == true){
				break;
			}
		}
		if(result == false){
			System.out.println("IMPOSSIBLE");
		}
	}
}

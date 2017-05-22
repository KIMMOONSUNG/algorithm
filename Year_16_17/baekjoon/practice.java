package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class pr {
	int x,y,cnt;
	pr(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}
public class practice { // 불 - >> 불의 위치를 큐에넣고 불의 인접한 4방향으로 가면서 cnt +1 시킨다 (여기서 불의 cnt측정해줄 배열하나만드는게 요점임)
	                    //         그 후 상근이의 위치를 이동시키며서 불보다 cnt수가 적을때 이동가능하도록 한다.
	static int testcase;
	static int m;
	static int n;
	static char map[][];
	static int firecnt[][]; //불의 카운
	static boolean visit[][]; // 방문 
	static Queue<pr> f; //불의 위치 넣을 큐 
	static Queue<pr> sang; // 상근이의 위치넣을 큐 
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		testcase = Integer.parseInt(bf.readLine());
		StringTokenizer st ; 
		
		for(int t =0; t < testcase; t++){
			
			st = new StringTokenizer(bf.readLine().trim());
			m = Integer.parseInt(st.nextToken());
		    n = Integer.parseInt(st.nextToken());
		    map = new char[n][m];
		    visit = new boolean[n][m];
		    firecnt = new int[n][m];
		    f = new LinkedList<pr>(); // 불의 위치
		    sang = new LinkedList<pr>();//상근이의 위치
		    for(int i=0; i<n; i++){
		    	String str = bf.readLine();
		    	for(int j=0; j<m; j++){
		    		firecnt[i][j] = 99999999; // 불의 카운트를 최대로 다 넣어놓는다 !
		    		map[i][j] = str.charAt(j);
		    		if(map[i][j]=='*'){ //불의위치입니다  
 		    			f.offer(new pr(i,j,0));
		    		    visit[i][j]=true; // 초기방문true
		    		}
		    		if(map[i][j]=='@'){ //상근이위치입니다  
		    			sang.offer(new pr(i,j,0));
		    		}
		    	}
		    }
		    
		    while(!f.isEmpty()) // 불 cnt개수 반복문 
		    {
		    	pr p = f.poll();
		    	for(int i =0; i<4; i++){
		    		int x = p.x+dx[i];
		    		int y = p.y+dy[i];
		    		int cnt = p.cnt;
		    		if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='#'){ // 범위초과안하고 벽이아닌곳은 다 갈수있다 
		    			if(visit[x][y]==false){
		    				visit[x][y]=true;
		    				firecnt[x][y] = Math.min(firecnt[x][y], cnt+1); // cnt확인하는 배열 -> cnt중 최소값을 넣어준다 .
		    				f.offer(new pr(x,y,cnt+1));
		    			}
		    		}
		    	}
		    }
		    int result = gps();
		    if(result==-9999){ //범위못벗어났을때 즉 탈출 못했을때
		    	System.out.println("IMPOSSIBLE");
		    }
		    else{
		    	System.out.println(result);
		    }
		    
		}
		
	}
	
	static int gps(){ //상근이를 탈출시키자
		visit = new boolean [n][m];
		while(!sang.isEmpty()){
			pr p = sang.poll();
			
			for(int i =0; i<4; i++){
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				int cnt = p.cnt;
				if(x<0 || y<0|| x>=n || y>=m){ //범위벗어나면 탈출완료 !
					return cnt+1;
				}
				if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='*' && firecnt[x][y]>cnt+1 && map[x][y]!='#'){ //범위안에서 불과 안만나고 cnt보다 적고 벽도 안만나야함 
					if(visit[x][y]==false){
						visit[x][y] = true;
						sang.offer(new pr(x,y,cnt+1));
					}
				}
			}
			
		}
		return -9999;
	}
}


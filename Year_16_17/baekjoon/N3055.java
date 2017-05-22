package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_3055{
	int x,y,cnt;
	n_3055(int x, int y, int cnt){
	this.x = x;
	this.y =y;
	this.cnt = cnt;
	}
}
public class N3055 { // 탈출
	static int n;
	static int m;
	static char map[][];
	static boolean visit[][];
	static int watercnt[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new char [n][m];
	visit = new boolean [n][m];
	watercnt = new int [n][m];
	Queue<n_3055> water = new LinkedList<n_3055>();
	Queue<n_3055> animal = new LinkedList<n_3055>();
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j);
			if(map[i][j]=='*'){
				water.offer(new n_3055(i,j,0));
			}
			if(map[i][j]=='S'){
				animal.offer(new n_3055(i,j,0));
			}
			
			watercnt[i][j]=999999; 
		}
	}
	while(!water.isEmpty()){
		n_3055 p = water.poll();
		for(int i =0; i<4; i++){
			int x= p.x+dx[i];
			int y = p.y+dy[i];
			int cnt = p.cnt;
			if(x>=0 && y>=0 && x<n && y<m && map[x][y]=='.'){
				if(visit[x][y]==false){
					visit[x][y]= true;
					watercnt[x][y]=Math.min(watercnt[x][y], cnt+1); //최소사용할때는 위에 최대로 초기화하는게 핵심.
					water.offer(new n_3055(x,y,cnt+1));
				}
			}
		}
	}
	visit= new boolean[n][m];
	
	boolean result = false;
	while(!animal.isEmpty()){
		n_3055 p = animal.poll();
		if(map[p.x][p.y]=='D'){
			result = true;
			System.out.println(p.cnt);
			break;
		}
		for(int i =0; i<4; i++){
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			int cnt = p.cnt;
			if(x>=0 && y>=0 && x<n && y<m && (map[x][y]=='.' || map[x][y]=='D')&& watercnt[x][y]>cnt+1){
				if(visit[x][y]==false){
					visit[x][y] =true;
					animal.offer(new n_3055(x,y,cnt+1));
				}
			}
		}
	}
	if(result == false){
		System.out.println("KAKTUS");
	}
	
 }
}

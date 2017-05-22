package dfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n2146 { // 다리만들기 -> 디에프에스 / 비에프에스 
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int map[][];
	static boolean visit[][];	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int result = 1000000;
	
	static Queue<n_2146> q ;
	static class n_2146{
		int x,y,c,len;
		n_2146(int x, int y, int c,int len){
			this.x = x;
			this.y = y;
			this.c = c;
			this.len = len;
		}
	}
	public static void main(String[] args) throws IOException {
		bf= new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(bf.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for(int i =0; i<n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<n; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count =1;
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] !=0 && visit[i][j] ==false){
					visit[i][j] = true;
					map[i][j] = count;
					numdfs(i,j,count);
					count++;
				}
			}
		}

		
		q = new LinkedList<>();
		for(int i =0; i<n; i++){
			for(int j=0; j<n; j++){
				if(map[i][j] !=0 ){
					bfs(i,j);
				}
			}
		}
		
		
		bw.write(Integer.toString(result-1));
		bf.close();
		bw.close();
		
	}
	
 static void numdfs(int a, int b ,int c) { //  섬 번호 매김 
	 
	 for(int i =0; i<4; i++){
		 int x =a+dx[i];
		 int y= b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<n && map[x][y] !=0){
			 if(visit[x][y] ==false){
				 visit[x][y] = true;
				 map[x][y] = c;
				 numdfs(x,y,c);
			 }
		 }
	 }
	 
 }
 
static void bfs(int a, int b) {
	q = new LinkedList<>();
	q.offer(new n_2146(a,b,map[a][b],0));
	visit = new boolean[n][n];
	visit[a][b] = true;
	while(!q.isEmpty()){
	n_2146 p =q.poll();
    
	if(map[p.x][p.y] !=0 && map[p.x][p.y] !=p.c){
		result = Math.min(p.len,result);
		break;
	}
	
	for(int i =0; i<4; i++){
		 int x =p.x+dx[i];
		 int y= p.y+dy[i];
		 int c= p.c;
		 int len = p.len;
		 if(x>=0 && y>=0 && x<n && y<n && map[x][y] !=c){
			 if(visit[x][y] ==false){
				 visit[x][y] = true;
				 q.offer(new n_2146(x,y,c,len+1));
 
			 }
		 }
	 }
	
	}
}

 
}

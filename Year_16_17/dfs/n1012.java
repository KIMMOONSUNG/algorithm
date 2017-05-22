package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1012  { // 유기농 배추 - > DFS (라벨링))
	static int n;
	static int m;
	static int map[][];
	static int d[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=0; t<testcase ; t++){
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		d = new int [n][m];
		int k =Integer.parseInt(st.nextToken());
		for(int i =0; i<k; i++){
			st = new StringTokenizer(bf.readLine());
			int b = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			map[a][b] = 1;
		}
		int cnt = 1;
		for(int i=0 ;i<n; i++){
			for(int j =0; j<m; j++){
				if(map[i][j] ==1 && d[i][j] ==0){
					d[i][j] = cnt;
					cnt++;
					dfs(i,j);
				}
			}
		}
		System.out.println(cnt-1);
	}
	 
}
 
 static void dfs(int a, int b){
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 & x<n && y<m){
			 if(map[x][y] ==1 && d[x][y] ==0){
				 d[x][y] = d[a][b];
				 dfs(x,y);
			 }
		 }
	 }
	 
 }
 
}

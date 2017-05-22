package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1937 { // 욕심쟁이판다 - > 디에프에스 디피  
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int map[][];
	static int dp[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int day = -1;
 public static void main(String[] args) throws IOException{
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	n = Integer.parseInt(bf.readLine());
	map = new int[n+1][n+1];
	dp = new int[n+1][n+1];
	
	for(int i =1; i<=n; i++) {
		st = new StringTokenizer(bf.readLine());
		for(int j =1; j<=n; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			dp[i][j] = 1;
		}
	}
	
	for(int i =1; i<=n; i++){
		for(int j=1; j<=n; j++){
			day = Math.max(dfs(i,j),day);
		}
	}
	bw.write(Integer.toString(day));
	bw.close();
	bf.close();
	
}
 static int dfs(int a, int b){
	 if(dp[a][b] !=1){
		 return dp[a][b];
	 }
	 for(int i =0; i<4; i++){
		 int x= a+dx[i];
		 int y = b+dy[i];
		 if(x>=1 && y>=1 && x<=n && y<=n && map[a][b] < map[x][y]){
			 dp[a][b] = Math.max( dp[a][b] , 1+dfs(x,y));
		 }
	 }
	 return dp[a][b];
 }
 
}

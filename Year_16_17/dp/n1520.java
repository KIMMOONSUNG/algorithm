package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n1520 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n ;
	static int m;
	static int map[][];
	static int dp[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};	
	
 public static void main(String[] args) throws IOException{
	 
 	bf = new BufferedReader(new InputStreamReader(System.in));
 	bw = new BufferedWriter(new OutputStreamWriter(System.out));
 	st = new StringTokenizer(bf.readLine());
 	n = Integer.parseInt(st.nextToken());
 	m = Integer.parseInt(st.nextToken());
 	map = new int[n+1][m+1];
 	dp= new int[n+1][m+1];
 	for(int i =1 ; i<=n; i++){
 		st = new StringTokenizer(bf.readLine());
 		for(int j =1; j<=m; j++){
 			map [i][j] = Integer.parseInt(st.nextToken());
 			dp[i][j] = -1;
 		}
 	}
 	bw.write(Integer.toString(dfs(1,1)));
 	bw.close();
 	bf.close();
 	
}
 static int dfs(int a, int b){
	 if(a==n && b==m){
		 return 1;
	 }
	 
	 if(dp[a][b] !=-1){
		 return dp[a][b];
	 }
	 dp[a][b] = 0;
	 
	 for(int i =0; i<4; i++){
		 int x= a+dx[i];
		 int y= b+dy[i];
		 if(x>=1 && y>=1 && x<=n && y<=m && map[a][b] >map[x][y]){
			 dp[a][b] += dfs(x,y);
		 }
	 }
	 
	 return dp[a][b];
 }
 
}

package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n11048 { //이동하기 -> 디에프에스디피 
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static int map[][];
	static int dp[][];
	static int dx[] = {0,1};
	static int dy[] = {1,0};
 public static void main(String[] args) throws IOException{
	bf= new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m  = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	dp = new int[n][m];
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			dp[i][j] = -1;
		}
	}
	dp[n-1][m-1] = map[n-1][m-1];
	bw.write(Integer.toString(dfs(0,0)));
	bw.close();
	bf.close();
	
 }
 static int dfs(int a, int b){
	 if(dp[a][b] !=-1){
		 return dp[a][b];
	 }
	 for(int i =0; i<2; i++){
		 int x =a+dx[i];
		 int y =b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 dp[a][b] = Math.max(dp[a][b], dfs(x,y)+map[a][b]);
		 }
	 }
	 return dp[a][b];
 }
}

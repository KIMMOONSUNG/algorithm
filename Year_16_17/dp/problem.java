package dp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class problem {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int map[][];
	static long dp[][];
	static int dx[] ={0,1};
	static int dy[] ={1,0};
	
 public static void main(String[] args) throws IOException{
  bf= new BufferedReader(new InputStreamReader(System.in));
  bw = new BufferedWriter(new OutputStreamWriter(System.out));
  n = Integer.parseInt(bf.readLine());
  map = new int[n][n];
  dp = new long[n][n];
  for(int i =0; i<n; i++){
	  st = new StringTokenizer(bf.readLine());
	  for(int j =0; j<n; j++){
		  map[i][j] = Integer.parseInt(st.nextToken());
		  dp[i][j] = -1;
	  }
  }
  long ans = dfs(0,0);
  StringBuilder sb= new StringBuilder();
  sb.append(ans);
  bw.write(sb.toString());
  bw.close();
  bf.close();
}
 static long dfs(int a, int b){
	 if( a==n-1 && b==n-1){
		 return 1;
	 }
	 if(map[a][b]==0){
		 return 0;
	 }
	 if(dp[a][b]!=-1){
		 return dp[a][b];
	 }
	 dp[a][b] =0;
	 
	 for(int i =0; i<2; i++){
		 int x= a+(dx[i] * map[a][b]);
		 int y= b+(dy[i] * map[a][b]);
		 
		 if(x>=0 && y>=0 && x<n && y<n ){
			 dp[a][b] += dfs(x,y);
		 }
	 }
	 
	 return dp[a][b];
	 
 }
}

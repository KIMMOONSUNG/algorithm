package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1890 { // !!!!! 내리막길도이렇게 해서 풀어보셈 메모이제이션 중요.
		static int n;
		static int[][] arr;
		static long[][] dp;
		static int[] dx = {1, 0}; 
		static int[] dy = {0, 1}; 
		
		public static void main(String[] args)  throws IOException{
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			n = Integer.parseInt(bf.readLine());
			arr = new int[n][n];
			dp = new long[n][n];
			for( int i = 0 ; i < n ; i ++ ){
				StringTokenizer st = new StringTokenizer(bf.readLine());
				for( int j = 0 ; j < n ; j ++ ){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(dfs(0,0));
			
		}
	
 static long dfs(int a , int b){
	 if(arr[a][b]==0 && a==n-1 && b==n-1){
		 return 1;
	 }
	 else if(arr[a][b]==0){
		 return 0;
	 }
	 
	 if(dp[a][b]==0){
	  for(int i =0; i<2; i++){
		 int x = a+ dx[i]*arr[a][b];
		 int y = b+ dy[i]*arr[a][b];
		 if(x>=0 && y>=0 && x<n && y<n ){
			/* if(dp[x][y]>0){
				 dp[a][b] +=dp[x][y];
			 }
			 else{
			 */
				 dp[a][b] += dfs(x,y);
			 //}
		 }
	  }
	 }
	 
	 return dp[a][b];
 }

 //메모이제이션 안하는 dfs -> 시간초과남 
 /*
 static void func(int a, int b){
     if(a==n-1 && b==n-1){
    	 length++;
    	 return;
     }
     if(map[a][b]==0){
    	 return;
     }
     for(int i =0; i<2; i++){
    	 int x = a+dx[i]*map[a][b];
    	 int y = b+dy[i]*map[a][b];
    	 if(x>=0 && y>=0 && x<n && y<n){
    		 if(visit[x][y] == false){
    			 visit[x][y] = true;
    			 func(x,y);
    			 visit[x][y] = false;
    		 }
    	 }
     }
 }
 */
 
	}

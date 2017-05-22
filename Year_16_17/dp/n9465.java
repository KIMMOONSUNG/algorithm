package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n9465 { // 스티커  
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	for(int t=1; t<=testcase; t++){
 	  int n = Integer.parseInt(bf.readLine());
 	  int map[][] = new int[2][n];
 	  int d[][] = new int[2][n];
 	  for(int i =0; i<2; i++){
 		  StringTokenizer st = new StringTokenizer(bf.readLine());
 		  for(int j =0; j<n; j++){
 			  map[i][j] = Integer.parseInt(st.nextToken()); 
 		  }
 	  }
 	  d[0][0] = map[0][0];
 	  d[1][0] = map[1][0];
 	  for(int j=1; j<n; j++){
 		  d[0][j] = Math.max(d[0][j-1], map[0][j]+d[1][j-1]);
 		  d[1][j] = Math.max(d[1][j-1], map[1][j]+d[0][j-1]);
 	  }
 	  int result = Math.max(d[0][n-1], d[1][n-1]);
 	  System.out.println(result);
	}
 }
}

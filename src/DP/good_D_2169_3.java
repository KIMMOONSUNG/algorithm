package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class good_D_2169_3 {
	public static void main(String[] args) throws IOException{
	      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	      StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	      int n = Integer.parseInt(st.nextToken());
	      int m = Integer.parseInt(st.nextToken());
	      int [][] map = new int[n][m];
	      int [][] max = new int[n][m];
	      int [][] num = new int[2][m];
	      for(int i=0; i<n; i++){
	    	  st = new StringTokenizer(bf.readLine().trim());
	    	  for(int j =0; j<m; j++){
	    		map[i][j] = Integer.parseInt(st.nextToken());
	    	  }
	      }
	      max[0][0] = map[0][0];
	      
	      for(int i =1; i<m; i++){
	    	 max[0][i] = map[0][i] + max[0][i-1]; 
	      }
	      
	      for(int i =1; i<n; i++){
	    	  
	    	for(int j=0; j<m; j++){
	    		num[1][j] = map[i][j] + max[i-1][j];
	    		num[0][j] = map[i][j] + max[i-1][j];
	    		
	    	}
	    	for(int j=1; j<m; j++){
	    		num[0][j] = Math.max(num[0][j], map[i][j] + num[0][j-1]);
	    	}
	    	for(int j=m-2; j>=0; j--){
	    		num[1][j] = Math.max(num[1][j], map[i][j] + num[1][j+1]);
	    	}
	    	
	    	for(int j=0; j<m; j++){
	    		max[i][j] = Math.max(num[0][j], num[1][j]);
	    	}
	      }
	      System.out.println(max[n-1][m-1]);
	      
	 }
	 
}

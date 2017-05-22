package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class good_D_2169_2 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" ");
	int n = Integer.valueOf(str[0]);
	int m = Integer.parseInt(str[1]);
	int map[][] = new int[n][m];
	int max[][] = new int[n][m];
	int up[][] = new int[2][m];
	for(int i =0; i<n; i++){
		String st[] = bf.readLine().split(" ");
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st[j]);
		}
	}
	max[0][0] = map[0][0];
	for(int j =1; j<m; j++){
		max[0][j] = max[0][j-1]+map[0][j];
	}
	
	for(int i=1; i<n; i++){
		for(int j=0; j<m; j++){// 위
			up[0][j] = max[i-1][j] + map[i][j]; 
		    up[1][j] = max[i-1][j] + map[i][j];
		}
		for(int j=1; j<m; j++){ // 위와 왼쪽 
		  up[0][j] = Math.max(up[0][j], up[0][j-1]+map[i][j]);
		}
		for(int j = m-2; j>=0; j--){ //위와 오른쪽 
		  up[1][j] = Math.max(up[1][j], up[1][j+1] +map[i][j]);
		}
		for(int j=0; j<m; j++){
			max[i][j] = Math.max(up[0][j], up[1][j]);
		}
	}
	System.out.println(max[n-1][m-1]);
	
} 
}

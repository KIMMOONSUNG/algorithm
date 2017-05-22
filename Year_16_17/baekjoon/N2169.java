package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N2169 { // 로봇조종하기  
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int map[][] = new int[n][m];
	int num[][] = new int[2][m];
	int max[][] = new int[n][m];
	
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine().trim());
		for(int j=0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	max[0][0] = map[0][0] ;
	for(int j =1; j<m; j++){
		max[0][j] = map[0][j] +max[0][j-1];
	}
	
	for(int i=1; i<n; i++){
		for(int j=0; j<m; j++){ // from up
			num[0][j] = map[i][j] +max[i-1][j];
			num[1][j] = map[i][j] +max[i-1][j];
		}
		for(int j=1; j<m; j++){ // from left
			num[0][j] = Math.max(num[0][j], num[0][j-1]+map[i][j]);
		}
		for(int j=m-2; j>=0; j--){ //from right
			num[1][j] = Math.max(num[1][j], num[1][j+1] + map[i][j]);
		}
		for(int j=0; j<m; j++){ //result
			max[i][j] = Math.max(num[0][j],num[1][j]);
		}
	}
	
	System.out.println(max[n-1][m-1]);
	
 }
}

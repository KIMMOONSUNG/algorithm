package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2169 { //로봇 조종하기 
	static int n;
	static int m;
	static int map[][];
	static int d[][];
	static int up[][];
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	d = new int[n][m];
	up = new int[2][m];
	
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	d[0][0] = map[0][0];
	for(int j =1; j<n; j++){
		d[0][j] = map[0][j] + d[0][j-1] ;
	}
	
	for(int i =1; i<n; i++){
		
		for(int j =0; j<m; j++){
			up[0][j] = d[i-1][j] + map[i][j]; 
			up[1][j] = d[i-1][j] + map[i][j]; 
		}
		for(int j=1; j<m; j++){
			up[0][j] = Math.max(up[0][j-1]+map[i][j], up[0][j]);
		}
		
		for(int j=m-2; j>=0; j--){
			up[1][j] = Math.max(up[1][j+1] + map[i][j], up[1][j]);
		}
		for(int j =0; j<m; j++){
			d[i][j] = Math.max(up[1][j], up[0][j]);
		}
		
	}
	System.out.println(d[n-1][m-1]);
	
 }
}

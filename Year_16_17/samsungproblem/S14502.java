package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S14502 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][];
	
 public static void main(String[] args) throws IOException {
	 
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
 }
}

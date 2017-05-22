package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2174 { //로봇 조종하기
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int map[][] = new int[n][m];
	int result [][] = new int[n][m];
	int cnt [][] = new int[2][m];
	
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	result[0][0] = map[0][0];
	
	for(int i=1; i<m; i++){
		result[0][i] = map[0][i] + result[0][i-1];
	}
	
	for(int i =1; i<n; i++){
		for(int j=0; j<m; j++){ // 가장윗단 
			cnt[0][j] = result[i-1][j] + map[i][j];
			cnt[1][j] = result[i-1][j] + map[i][j];
		}
		for(int j=1; j<m; j++){ // 왼쪽에서 온경우 최대값 비교 
			cnt[0][j] = Math.max(cnt[0][j], map[i][j] + cnt[0][j-1]);
		}
		for(int j=m-2; j>=0; j--){ // 오른쪽에서 온경우 최대값 비교 
			cnt[1][j] = Math.max(cnt[1][j], map[i][j] + cnt[1][j+1]);
		}
		for(int j=0; j<m; j++){ // 오른쪽과 왼쪽 최대값 중 큰값 결과에 
			result[i][j] = Math.max(cnt[0][j], cnt[1][j]);
		}
	}
	
	System.out.println(result[n-1][m-1]);
	
 }
 
}

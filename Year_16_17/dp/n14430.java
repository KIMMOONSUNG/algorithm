package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n14430 { //자원캐기 
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int map[][] = new int [n+1][m+1];
		int d[][] = new int[n+1][m+1];
		for(int i=1; i<=n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j =1; j<=m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<=n; i++){
			for(int j=1; j<=m; j++){
				d[i][j] = Math.max(d[i][j-1]+map[i][j], d[i-1][j]+map[i][j]);
			}
		}
		System.out.println(d[n][m]);
	 }
}

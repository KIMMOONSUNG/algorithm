package dp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1010 { // 다리 놓기 
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine());
		int d[][];
		StringTokenizer st;
		while(true){
			if(t==0){
				break;
			}
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			d = new int[n+1][m+1];
			for(int i=0;i<=m;i++) d[1][i] = i;
			for(int i=2;i<=n;i++)
				for(int j=i;j<=m;j++)
					for(int k=j;k>=i;k--)
						d[i][j]+=d[i-1][k-1];
			System.out.println((d[n][m]));
			t --;
		}
	
	}



}

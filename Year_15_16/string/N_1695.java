package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1695 {
	static int dp[][] = new int[5010][5010];
	static int data[] = new int[5010];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		for(int i =0; i<num; i++){
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		System.out.println(func(0,num-1)); // 첫 ,마지막
	}
	
	static int func(int s, int e){
		if(s>=e) return 0;
		if(dp[s][e] !=0) return dp[s][e];
		if(data[s]==data[e]){
			return func(s+1,e-1);
		}
		dp[s][e] = Math.min(func(s+1,e), func(s,e-1)) + 1 ;
		return dp[s][e];
	}
}

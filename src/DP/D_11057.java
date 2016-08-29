package DP;

import java.util.Scanner;

public class D_11057 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();// 주어지는 길이 
	long d[][] = new long[n+1][10];
	int mod = 10007;
	for(int a =0; a<=9; a++){//길이가 1일때 (시작 숫자 0도 포함)
		d[1][a] = 1;
	}
	for(int i =2; i<=n; i++){ //길이가 2이상부터
		for(int j=0;j<=9; j++){
			for(int k=0; k<=j; k++){
				d[i][j] += d[i-1][k];
				d[i][j] %= mod;
			}
		}
	}
	
	long ans=0;
	for(int j=0; j<=9; j++){
		ans+=d[n][j];
	}
	  ans %= mod;
	System.out.println(ans);
}
}

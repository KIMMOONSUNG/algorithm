package DP;

import java.util.Scanner;

public class D_11057 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();// 주어지는 길이 
	long d[][] = new long[n+1][10]; //[길이][0~9]
	int mod = 10007;
	for(int a =0; a<=9; a++){//길이가 1일때이므로   0~ 9 까지 몇개있나 
		d[1][a] = 1;   //0~9 각 인덱스 배열에 개수1을 저장 
	}
	for(int i =2; i<=n; i++){ //길이가 2이상부터
		for(int j=0;j<=9; j++){ 
			for(int k=0; k<=j; k++){ 
				d[i][j] = d[i][j]+ d[i-1][k]; //오르막수니까  현위치에 전꺼더할때 전꺼 k는 j보다 작아야하니까 
				d[i][j] %= mod;
			}
		}
	}
	
	long ans=0;
	for(int j=0; j<=9; j++){
		ans+=d[n][j]; // 각 인덱스에 저장되어있는 수 다 더해 
	}
	  ans %= mod;
	System.out.println(ans);
}
}

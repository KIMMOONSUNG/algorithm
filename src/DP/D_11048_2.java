package DP;

import java.util.Scanner;
// 도착지를 가기위한 그 다음상황 파악 다음갈 곳중에 최대를 구함 
public class D_11048_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int d[][] = new int[n + 2][m + 2];
		int a[][] = new int[n + 2][m + 2];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				a[i][j] = sc.nextInt();
			} 
		}
		for (int i = 0; i <=n; i++) {
			for (int j = 0; j <= m; j++) {
				if (d[i][j + 1] < d[i][j] + a[i][j + 1]) {
					d[i][j + 1] = d[i][j] + a[i][j + 1];
					//System.out.println(d[i][j+1]);
				}
				if (d[i + 1][j] < d[i][j] + a[i + 1][j]) {
					d[i + 1][j] = d[i][j] + a[i + 1][j];
					//System.out.println(d[i+1][j+1]);
				}
				/*
				if (d[i + 1][j + 1] < d[i][j] + a[i + 1][j + 1]) {
					d[i + 1][j + 1] = d[i][j] + a[i + 1][j + 1];
				}
				*/ // 대각선 지워도 상관없음 
			}
		}

		System.out.println(d[n][m]);
	}
}

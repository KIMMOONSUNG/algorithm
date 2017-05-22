package DP;

import java.util.Scanner;

public class D_2096_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[][] = new int[n][3];
		int d[][] = new int[n][3];// 최대
		int d2[][] = new int[n][3];// 최소
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 3; i++) {
			d[0][i] = a[0][i];
			d2[0][i] = a[0][i];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < 3; j++) {
				if(j==0){
				d[i][j] = Math.max(d[i - 1][j], d[i - 1][j + 1]) + a[i][j];
				d2[i][j] = Math.min(d2[i - 1][j], d2[i - 1][j + 1]) + a[i][j];
				}
				if(j==1){
					d[i][j] = Math.max(d[i - 1][j + 1],
                            (Math.max(d[i - 1][j], d[i - 1][j - 1]))) + a[i][j];
                     
                    d2[i][j] = Math.min(d2[i - 1][j + 1],
                            (Math.min(d2[i - 1][j], d2[i - 1][j - 1]))) + a[i][j];
				}
				if(j==2){
					d[i][j] = Math.max(d[i-1][j], d[i-1][j-1]) +a[i][j];
					d2[i][j] = Math.min(d2[i-1][j], d2[i-1][j-1]) +a[i][j];
				}
			}
		}
		
		System.out.println( Math.max(d[n-1][2],(Math.max(d[n-1][1], d[n-1][0])))+ " " +
				Math.min(d2[n-1][2],(Math.min(d2[n-1][1], d2[n-1][0]))));
	}
}

package DP;

import java.util.Scanner;
public class D_2096 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			int a[][] = new int[n][3];
			int d[][] = new int[n][3]; // 최대
			int d2[][] = new int[n][3];// 최소
			for (int i = 0; i <n; i++) {
				for (int j = 0; j < 3; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			for (int i = 0; i <3; i++) {
				d[0][i] = a[0][i];
				d2[0][i] = a[0][i];
			}		
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < 3; j++) {
					//최대
					d[i][j] = d[i - 1][j] + a[i][j]; // 동일라인
					if (j != 0 && d[i][j] < d[i - 1][j - 1] + a[i][j]) {  
						d[i][j] = d[i - 1][j - 1] + a[i][j]; 
					}
					if (j != 2 && d[i][j] < d[i - 1][j + 1] + a[i][j]) {
						d[i][j] = d[i - 1][j + 1] + a[i][j]; 
					}
					//최소
					d2[i][j] = d2[i - 1][j] + a[i][j]; // 동일라인
					if (j != 0 && d2[i][j] > d2[i - 1][j - 1] + a[i][j]) {  
						d2[i][j] = d2[i - 1][j - 1] + a[i][j]; 
					}
					if (j != 2 && d2[i][j] > d2[i - 1][j + 1] + a[i][j]) {
						d2[i][j] = d2[i - 1][j + 1] + a[i][j]; 
					}
				}
			}
			// d 값 중에 최대를 , d2값중에 최소를 ,
			System.out.print(Math.max(d[n-1][2], Math.max(d[n-1][0], d[n-1][1])) + " "
	                + Math.min(d2[n-1][2], Math.min(d2[n-1][0], d2[n-1][1])));
		}
	

}

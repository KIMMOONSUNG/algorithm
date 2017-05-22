package DP;

import java.util.Scanner;

public class D_1149 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 집의 수
		int d[][] = new int[n + 1][3 + 1];
		int a[][] = new int[n + 1][3 + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		int min = 100000; //비용범위는 어차피 최소라서 안나와있음 문제에 그래서 최대 
		
		//가장 아래꺼 기준으로 자신의 바로 위 빼고 더한거중 최소 구함 
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= 3; j++) {
				if (j == 1) { 
					min = d[i - 1][j + 1];
					if (min > d[i - 1][j + 2]) {
						min = d[i - 1][j + 2];
					}
					d[i][j] = min + a[i][j];
				}
				if (j == 2) {
                    min = d[i-1][j-1];
                    if(min>d[i-1][j+1]){
                    	min=d[i-1][j+1];
                    }
                    d[i][j] = min + a[i][j];
				}
				if (j == 3) {
                    min = d[i-1][j-2];
                    if(min> d[i-1][j-1]){
                    	min = d[i-1][j-1];
                    }
                    d[i][j] = min + a[i][j];
				}
			}
		}
		 min = d[n][1];
		 if(min>d[n][2])
		 {
			 min = d[n][2];
		 }
		 if(min > d[n][3]){
			 min = d[n][3];
		 }
		System.out.println(min);
		
	}
}

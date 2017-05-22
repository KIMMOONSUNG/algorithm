package DP;

import java.util.Scanner;

public class D_2167 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int start_i, start_j, x, y = 0;
		int map[][] = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = sc.nextInt();
		for (int a = 0; a < count; a++) {
			start_i = sc.nextInt();
			start_j = sc.nextInt();
			x = sc.nextInt();
			y = sc.nextInt();
			int sum =0;
			for (int i = start_i; i <= x; i++) {
				for (int j = start_j; j <= y; j++) {
                   sum += map[i][j];
				}
			}
			System.out.println(sum);
		}
	}
}
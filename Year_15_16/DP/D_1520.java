package DP;

import java.util.Scanner;

public class D_1520 { // BFS로 못풀고 DFS는 시간초과 남 //재귀 문제!! 내리막길 -> 재귀호출
	                
	static int n;
	static int m;
	static int map[][];
	static int num[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[501][501];
		num = new int[501][501];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println(fun(0, 0));

	}
	static int fun(int a, int b) {
		if (a == n - 1 && b == m - 1){ //마지막도착하면 return1 
			return 1;
		}
		if (num[a][b] == 0) { //방문안한곳
			for (int i = 0; i < 4; i++) {
				int x = a + dx[i];
				int y = b + dy[i];
				if (x>=0 && y>=0 && x<n && y<m && (map[x][y] < map[a][b])) {
					num[a][b] += fun(x,y); 
				}
			}
		}
		return num[a][b];
	}
}
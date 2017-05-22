package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1520_2 { //내리막길
	// 재귀문제임. bfs X , dfs X
	static int n;
	static int m;
	static int map[][];
	static int number[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		number = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(func(0, 0));
	}

	static int func(int a, int b) {
		if (a == n - 1 && b == m - 1) {
			return 1; // 마지막도착했을시에 
			          //길이 추가.더하는것 길 1개 , 길2개 이런식
		}
		if (number[a][b] == 0) { // 방문안한곳.
			for (int i = 0; i < 4; i++) {
				int x = a + dx[i];
				int y = b + dy[i];
				if (x >= 0 && y >= 0 && x < n && y < m && (map[a][b] > map[x][y])) { 
					// 앞으로 갈 곳보다 현위치값이																						
					// 더커야함		
                    //내리막길이니까
					number[a][b] += func(x, y);
				}
			}
		}
		return number[a][b];
	}
}

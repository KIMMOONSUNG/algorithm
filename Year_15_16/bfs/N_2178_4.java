package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class prac {
	int x;
	int y;
	int len;
}

public class N_2178_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int map[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char ch[] = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = ch[j] - 48;
			}
		}
		Queue<prac> q = new LinkedList<prac>();
		prac p = new prac();
		p.x = 0;
		p.y = 0;
		p.len = 1;
		q.offer(p);
		visit[p.x][p.y] = true;
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		while (!q.isEmpty()) {
			prac p2 = q.poll();
			if (p2.x == n - 1 && p2.y == m - 1) {
				System.out.println(p2.len);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = p2.x + dx[i];
				int y = p2.y + dy[i];
				int len = p2.len + 1;
				if (x >= 0 && y >= 0 && x < n && y < m && visit[x][y] == false && map[x][y] == 1) {
					visit[x][y] = true;
					prac p3 = new prac();
					p3.x = x;
					p3.y = y;
					p3.len = len;
					q.offer(p3);
				}
			}
		}
	}
}

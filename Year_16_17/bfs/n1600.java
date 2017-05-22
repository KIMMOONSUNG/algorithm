package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_1600 {
	int x, y, len, cnt;

	n_1600(int x, int y, int len, int cnt) {
		this.x = x;
		this.y = y;
		this.len = len;
		this.cnt = cnt;
	}
}

public class n1600 { // 말이되고픈 원숭이
	static int k;
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][][];
	static int hx[] = { 0, 0, 1, -1, -1, -2, -1, -2, 1, 2, 1, 2 };
	static int hy[] = { 1, -1, 0, 0, -2, -1, 2, 1, -2, -1, 2, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visit = new boolean[n][m][k + 1];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Queue<n_1600> q = new LinkedList<>();
		q.offer(new n_1600(0, 0, 0, 0));
		boolean check = false;
		int result = 1000000;

		while (!q.isEmpty()) {
			n_1600 p = q.poll();
			if (p.x == n - 1 && p.y == m - 1) {
				check = true;
				result = p.len;
				break;
			}

			for (int i = 0; i < 12; i++) {
				int x = p.x + hx[i];
				int y = p.y + hy[i];
				int cnt = p.cnt;
				int len = p.len;
				if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == 0) {
					if (i < 4) {
						if (visit[x][y][cnt] == false) {
							visit[x][y][cnt] = true;
							q.offer(new n_1600(x, y, len + 1, cnt));
						}
					}
					
					else {
						if (cnt < k) { 
							if (visit[x][y][cnt + 1] == false) {
								visit[x][y][cnt + 1] = true;
								q.offer(new n_1600(x, y, len + 1, cnt + 1));

							}
						}

					}
				}
			}
		}

		if (check == false) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

}

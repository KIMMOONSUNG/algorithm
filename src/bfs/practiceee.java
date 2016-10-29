package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class pract {
	int x;
	int y;
	int count;
	int d;
}

public class practiceee {
	static int map[][];
	static boolean visit[][][];
	static int n;
	static int m;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visit = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String a = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = a.charAt(j) - 48;
			}
		}

		bf();
	}

	static void bf() {
		pract p = new pract();
		Queue<pract> q = new LinkedList<pract>();
		p.x = 0;
		p.y = 0;
		p.count = 0;
		p.d = 1;

		q.offer(p);

		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		while (!q.isEmpty()) {
			p = q.poll();
			if (p.x == n - 1 && p.y == m - 1) {
				System.out.println(p.d);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				int d = p.d + 1;
				int count = p.count;

				if (x >= 0 && y >= 0 && x < n && y < m && visit[x][y][count] == false
						&& (map[x][y] == 0 || (map[x][y] == 1 && count == 0))) {
					visit[x][y][count] = true;
					pract p2 = new pract();
					p2.x = x;
					p2.y = y;
					p2.d = d;
					if (map[x][y] == 1) {
						p2.count = count + 1;
					} else {
						p2.count = count;
					}
					q.offer(p2);
				}
			}
		}
	}
}

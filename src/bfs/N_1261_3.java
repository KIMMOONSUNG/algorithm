
package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class pra implements Comparable<pra> {
	int x;
	int y;
	int count;

	pra(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

	public int compareTo(pra p) {
		if (this.count > p.count) {
			return 1;
		} else if (this.count < p.count) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class N_1261_3 { 
	static int n;
	static int m;
	static int map[][];
    static boolean visit[][];
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		m = Integer.parseInt(str[0]);
		n = Integer.parseInt(str[1]);
		// m 과 n 거구로 //
		map = new int[n][m];
		visit = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char ch[] = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = (ch[j]-48);
			}
		}
		BFS();
	}

	static void BFS() {
		PriorityQueue<pra> q = new PriorityQueue<pra>();
		q.offer(new pra(0, 0, 0));
		visit[0][0] = true;
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };

		while (!q.isEmpty()) {
			pra p = q.poll();

			if (p.x == n - 1 && p.y == m - 1) {
				System.out.println(p.count);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				int cnt = p.count;
				if (x >= 0 && y >= 0 && x < n && y < m && visit[x][y] == false) {
					visit[x][y] = true;
					if(map[x][y] ==1){
						q.offer(new pra(x,y,cnt+1));
					}
					if(map[x][y] ==0){
						q.offer(new pra(x,y,cnt));
					}
				}
			}

		}

	}
}

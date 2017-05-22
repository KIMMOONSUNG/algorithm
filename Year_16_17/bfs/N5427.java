package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_5427 {
	int x, y, cnt;

	n_5427(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class N5427 {
	static int m;
	static int n;
	static char map[][];
	static boolean visit[][];
	static int firecnt[][]; // 불카운트 
	static Queue<n_5427> fq;
	static Queue<n_5427> q;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static boolean ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(bf.readLine());
		for (int t = 1; t <= testcase; t++) {
			ans = false;
			StringTokenizer st = new StringTokenizer(bf.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			map = new char[n][m];
			visit = new boolean[n][m];
			firecnt = new int[n][m];
			fq = new LinkedList<>();
			q = new LinkedList<>();

			for (int i = 0; i < n; i++) {
				String str = bf.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);
					firecnt[i][j] = 1000000; // 가장중요  
					if (map[i][j] == '*') {
						fq.offer(new n_5427(i, j, 0));
					}
					if (map[i][j] == '@') {
						q.offer(new n_5427(i, j, 0));
					}
				}
			}
			fire();
			func();
			if (ans == false) {
				System.out.println("IMPOSSIBLE");
			}

		}
	}

	static void fire() { // 불 
		visit = new boolean[n][m];
		while (!fq.isEmpty()) {
			n_5427 p = fq.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				int cnt = p.cnt;
				if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == '.') {
					if (visit[x][y] == false) {
						visit[x][y] = true;
						firecnt[x][y] = cnt + 1; // 불 이 지나가는 카운트 
						fq.offer(new n_5427(x, y, cnt + 1));
					}
				}
			}
		}
	}

	static void func() { // 상근이 
		visit = new boolean[n][m];
		while (!q.isEmpty()) {
			n_5427 p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				int cnt = p.cnt;
				if (x >= 0 && y >= 0 && x < n && y < m && map[x][y] == '.' && (firecnt[x][y] > (cnt + 1))) { // 불지나간 카운트보다 다음 카운트가 더 작아야 함  
					if (visit[x][y] == false) {
						visit[x][y] = true;
						q.offer(new n_5427(x, y, cnt + 1));
					}
				}
				if(x<0 ||y<0 ||x>=n | y>=m){ // 범위 넘어가면 끝 그때의 cnt 
					System.out.println(p.cnt+1);
					ans = true;
					return;
				}
			}

		}
	}
}

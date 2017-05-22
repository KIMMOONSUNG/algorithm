package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n2573 {
	int x;
	int y;

	n2573(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class N_2573 { //실패
	static int n;
	static int m;
	static int map[][];
	static int nummap[][];
	static int nummap2[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int year;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		nummap = new int[n][m];
		nummap2 = new int[n][m];
		year = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int t = 0;
		boolean result = false;
		while (true) {
			year++;
			time();
			t = 0;
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					if (nummap2[i][j] != 0 && nummap2[i][j] != -1) {
						t++;
						if(t>=2){
							result =true;
							break;
						}	
						dung(i, j);
						
											
					}
				}
				if(result==true){
					break;
				}
			}
			if (result==true) {
				break;
			}
			for (int i = 1; i < n-1; i++) {
				for (int j = 1; j < m-1; j++) {
					map[i][j] = nummap[i][j];
					nummap2[i][j] = nummap[i][j];
				}
			}

		}
		System.out.println(year);

	}

	static void time() { // 시간
		for (int i = 1; i < n-1; i++) {
			for (int j = 1; j < m-1; j++) {
				if (map[i][j] != 0) {
					int count = 0;
					for (int a = 0; a < 4; a++) {
						int x = i + dx[a];
						int y = j + dy[a];
						if (x >= 0 && y >= 0 && x < n && y < m) {
							if (map[x][y] == 0) {
								count++;
							}
						}
					}
					if (map[i][j] - count > 0) {
						nummap[i][j] = map[i][j] - count;
						nummap2[i][j] = map[i][j] - count;

					} else {
						nummap[i][j] = 0;
						nummap2[i][j] = 0;
						
					}
				}
			}
		}
		
	}

	static void dung(int a, int b) { // 덩어리분리
		Queue<n2573> q = new LinkedList<n2573>();
		boolean visit[][] = new boolean[n][m];
		q.offer(new n2573(a, b));
		nummap2[a][b] = -1;
		while (!q.isEmpty()) {
			n2573 p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x >= 1 && y >= 1 && x < n-1 && y < m-1 && visit[x][y] == false
						&& (nummap2[x][y] != 0 && nummap2[x][y] != -1)) {
					visit[x][y] = true;
					q.offer(new n2573(x, y));
					nummap2[x][y] = -1;
				}
			}
		}
	}

}

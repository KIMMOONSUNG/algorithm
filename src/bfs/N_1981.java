package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N_1981 {
	static int n;
	static int map[][];
	static boolean visit[][];
	static int queue[];
	static int front;
	static int rear;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(bf.readLine());
		
		map = new int[n][n];
		queue = new int[n * n];
		front = 0;
		rear = 0;
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str[] = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.valueOf(str[j]);
			}
		}
		BFS();
	}
	static void BFS() {
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };

		//이분탐색
		int mind = 198;
		for (int min = 0; min < 199; min++){
			int smax = min;
			int emax = min + mind;
			while (smax <= emax){ // 이분탐색 !!
				int max = smax + (emax - smax) / 2;
				front = 0;
				rear = 0;
				for(boolean[] v : visit){ // visit 배열 다 fasle로 초기화
				Arrays.fill(v, false);
				}
				boolean ava = false;
				if (map[0][0] >=min && map[0][0] <= max) {
					queue[rear++] = 0;
					visit[0][0] = true;
				}

				while (front != rear) {
					int node = queue[front++];
					int x = node / 1000;
					int y = node % 1000;
					
					if (x == n - 1 && y == n - 1) {
						ava = true;
						break;
					}
					for (int i = 0; i < 4; i++) {
						int xx = x + dx[i];
						int yy = y + dy[i];
						if (xx >= 0 && yy >= 0 && xx<n && yy<n && map[xx][yy] <= max && map[xx][yy] >= min
								&& visit[xx][yy] ==false) {
							queue[rear++] = xx * 1000 + yy;
							visit[xx][yy] = true;
						}					
					}
				}
				
				if (ava == true) {
					if (mind > (max - min)) {
						mind = max - min;
					}
					emax = max - 1;
				} else {
					smax = max + 1;
				}
			}
		}
     System.out.println(mind);
	}
}

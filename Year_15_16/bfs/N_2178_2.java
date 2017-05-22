package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_2178_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		int map[][] = new int[n][m];
		int len[][] = new int[n][m];
		boolean visit[][] = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			char ch[] = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = ch[j] - 48;
			}
		}
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		
		qx.offer(0);
		qy.offer(0);
		
		visit[0][0] = true;
		len[0][0] = 1; //시작점포함 
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		while (!qx.isEmpty() || !qy.isEmpty()) {
			
			int xx  = qx.poll();
			int yy  = qy.poll();
			if (xx == n - 1 && yy == m - 1) {
				System.out.println(len[xx][yy]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = xx + dx[i];
				int y = yy + dy[i];
				
				if (x >= 0 && y >= 0 && x < n && y < m && visit[x][y] == false && map[x][y] == 1) {
					visit[x][y] = true;
					len[x][y] = len[xx][yy] + 1;
					qx.offer(x);
					qy.offer(y);
				}
			}
		}
	}
}

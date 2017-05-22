package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class N_1261_3_c{ 
	int x ;
	int y ;
}
 
public class N_1261_3 { //dfs 로 품 (stack)
	static int n;
	static int m;
	static int map[][];
	static int wmap[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		m = Integer.valueOf(str[0]);
		n = Integer.valueOf(str[1]);
		map = new int[n][m];
		wmap = new int[n][m];
		for (int i = 0; i < n; i++) {
			char ch[] = bf.readLine().toCharArray();
			for (int j = 0; j < m; j++) {
				map[i][j] = ch[j] - 48;
				wmap[i][j] = 10001;
			}
		}

		Stack<N_1261_3_c> s = new Stack<N_1261_3_c>();
		
		N_1261_3_c a = new N_1261_3_c();
		s.add(a);
		wmap[0][0] = 0;
           
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };

		while (!s.isEmpty()) {
			a = s.pop();
			
			// 이조건없어도됨
			/*
			if (a.x == n - 1 && a.y == m - 1) { // 도착한경우 전체를 다봐서
				continue;
			}
             */
			for (int i = 0; i < 4; i++) {
				int x = a.x + dx[i];
				int y = a.y + dy[i];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (wmap[x][y] > wmap[a.x][a.y] + map[x][y]) { 
						wmap[x][y] = wmap[a.x][a.y] + map[x][y];
						N_1261_3_c a2 = new N_1261_3_c();
						a2.x= x;
						a2.y =y;

						s.add(a2);						
					}
				}
			}
		}
		System.out.println(wmap[n - 1][m - 1]);
	}
}

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class c_2206_2 {
	int x;
	int y;
	int length;
	int count;
}

public class N_2206_2 {
	static int N;
	static int M;
	static int map[][];
	static boolean visit[][][];
	static int qx[];
	static int qy[];
	static int index;
	static int len[];
	static int c[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		N = Integer.valueOf(str[0]);
		M = Integer.valueOf(str[1]);
		map = new int[N][M];
		visit = new boolean[N][M][2];
		index = 0;
		
		// 1000*1000 인데 밑에서 100넘으면 0으로 인덱스바꿔줌
		qx = new int[101];
		qy = new int[101];
		len = new int[101];
		c = new int[101];

		for (int i = 0; i < N; i++) {
			char ch[] = bf.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = ch[j] - 48;
			}
		}

		bfs();
	}

	static void qq(int x, int y, int l, int count) {
		if(index >100){ //배열 1000001 해주면 낭비 니까 인덱스 100넘으면 0으로
			index =0;
		}
		qx[index] = x;
		qy[index] = y;
		len[index] = l;
		c[index] = count;
		index++;
		
	}

	static void bfs() {
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		int index2 = 0;
		c_2206_2 m = new c_2206_2();
		m.x = 0;
		m.y = 0;
		m.length = 1;
		m.count = 0;

		qq(m.x, m.y, m.length, m.count);
		visit[m.x][m.y][m.count] = true; 
        boolean result = false;
		
		while (true) {
			m.x = qx[index2];
			m.y = qy[index2];
			m.length = len[index2];
			m.count = c[index2];
			if (m.x == N - 1 && m.y == M - 1) {
				result = true;
				System.out.println(m.length);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = m.x + dx[i];
				int y = m.y + dy[i];
				int length = m.length + 1;
				int count = m.count;
				if (x >= 0 && y >= 0 && x < N && y < M && visit[x][y][count] == false
						&& (map[x][y] == 0 || (map[x][y] == 1 && count == 0))) {
					visit[x][y][count] = true;
					c_2206_2 m2 = new c_2206_2();
					m2.x = x;
					m2.y = y;
					m2.length = length;
					if (map[x][y] == 1) {
						m2.count = count + 1;
					} else {
						m2.count = count;
					}
					qq(m2.x, m2.y, m2.length, m2.count);
				}
			}
			index2++;
			if(index2 > 100){//배열 1000001 해주면 낭비 니까 인덱스 100넘으면 0으로
				index2 =0;
			}
		}
		if(result == false){
			System.out.println("-1");
		}
	}

}
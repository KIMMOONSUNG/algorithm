package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/// q 라이브러리를  -> 배열로 
public class N2178 {
	static int N;
	static int M;
	static int map[][];
	static boolean visit[][];
	static int qx[]; //q x좌표
	static int qy[]; //q y좌표 
	static int ind;  // 인덱스 

	/*// Scanner 사용
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M];
		qx = new int[10000];
		qy = new int[10000];
		ind = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - 48;
			}
		}
		
		BFS();
	}
	*/
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N][M];
		visit= new boolean[N][M];
		qx = new int[10000];
		qy = new int[10000];
		ind =0;
		for(int i =0; i<N; i++){
			char a[] = bf.readLine().toCharArray();
			for(int j=0; j<M; j++){
				map[i][j] = a[j]-48;
			}
		}
		BFS();
	}

	static void arr(int x, int y) {
		ind++;
		qx[ind] = x;
		qy[ind] = y;

	}

	static void BFS() {
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		int x = 0;
		int y = 0;
		int pos = 0;
		visit[x][y] = true;
		while (true) {
			x = qx[pos];
			y = qy[pos];
			if (x == N - 1 && y == M - 1) {
				System.out.println(map[x][y]);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx >= 0 && yy >= 0 && xx < N && yy < M && visit[xx][yy] == false 
						&& map[xx][yy] == 1) {
					
					visit[xx][yy] = true;
					map[xx][yy] = map[x][y] + 1;
					arr(xx, yy);
				}
			}
			pos++;

		}
	}
}

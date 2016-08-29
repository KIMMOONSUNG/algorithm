package SAMSUNG;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
2
8
1 1 1 0 1 1 0 0
0 0 1 0 0 1 1 1
0 1 1 1 0 1 1 0
1 1 1 0 0 1 1 0
0 0 0 0 0 0 0 0
0 1 1 1 1 0 1 1
1 1 1 0 0 1 0 0
1 1 0 0 1 1 1 0
7
1 1 1 0 1 1 0
0 0 1 0 0 1 1
0 1 1 1 0 1 1
1 1 1 0 0 1 1
0 0 0 0 0 0 0
0 1 1 1 1 0 1
1 1 1 0 0 1 0
*/

public class D_2_4_p240 { // 논 그룹묶기
	static int n;
	static int map[][];
	static int count; // 총 논 그룹 수
	static int num; // 그 그룹의 논 개수
	static int result[]; // 인덱스 0 에는 논 그룹수를 넣는다 // 그 후부터 논 개수를 넣는다

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int Case = 1;
		for (int a = 0; a < T; a++) {
			n = sc.nextInt();
			map = new int[n][n];
			result = new int[n * n];
			count = 1;
			num = 0;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
	
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 1) { // 1이면 bfs 호출
						count++; // 2부터 구별할꺼
						bfs(i, j, count); // 거기가 시작점
					}
				}
			}

			result[0] = count - 1; // 인덱스 0 에는 논 그룹수를 넣음

			System.out.print("#" + Case + " ");
			System.out.println(result[0] + " ");
			for (int i = 1; i < n * n; i++) {

				if (result[i] == 0) { // 0 이면 안들어간거 끝난거 그래서 break;
					break;
				}

				System.out.print(result[i] + " ");
			}

			Case++;
		}

	}

	static void bfs(int a, int b, int c) {
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		boolean visit[][] = new boolean[n][n];
		int x = a;
		int y = b;
		int cc = c;
		qx.offer(x);
		qy.offer(y);
		visit[x][y] = true;
		map[x][y] = cc;
		num = 1; // 자기 자신도 개수 포함

		while (!qx.isEmpty() || !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			for (int i = 0; i < 4; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if (xx >= 0 && yy >= 0 && xx < n && yy < n && visit[xx][yy] == false && map[xx][yy] == 1) { // 인접한게
																											// 1이냐
					visit[xx][yy] = true;
					map[xx][yy] = cc; // 그 인접한곳 cc로 채움 2로 쭉 3으로 쭉 ....
					num++; // 논의 개수 올리고
					qx.offer(xx);
					qy.offer(yy);
				}
			}
		}

		result[cc - 1] = num; // cc가 2부터니까 인덱스 1부터 논 개수를 채우는게 될거
								// 인덱스 0 은 위에서count 즉 논 그룹 수 를 넣어놓음

	}
}

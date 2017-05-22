
package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_3055 {
	static int R;
	static int C;
	static int map[][];
	static int number[][];
	static int water[][];
	static int now1;
	static int now2;
	static int arrive1;
	static int arrive2;
	static int waternumber ;
	static int waternum1[];
	static int waternum2[];
	static boolean visit[][];
	static boolean visit2[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt(); // R행 C열
		map = new int[R][C];
		number = new int[R][C];
		water = new int[R][C];
		visit = new boolean[R][C];
		visit2 = new boolean[R][C];
		waternum1 = new int[R * C];
		waternum2 = new int[R * C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				char a = str.charAt(j);
				if (a == 'D') {// 비버의굴
					map[i][j] = 80000;  // 8하면안되고 80000으로 해줘야함 50*50 배열이 제한이니 2500은 넘어야해서 ?
					arrive1 = i; // 도착지점 앞좌표
					arrive2 = j; // 도착지점 뒤좌표

				} else if (a == '.') { // 비어있는곳
					map[i][j] = 10000;
				} else if (a == '*') {// 물이차있는곳
					map[i][j] = 20000;
					waternum1[waternumber] = i; // 물들의 x좌표와 y좌표를 알아서 1차원배열에넣는당
					waternum2[waternumber] = j;
					waternumber++;
				} else if (a == 'X') {// 돌
					map[i][j] = 4000;
				} else if (a == 'S') {// 고슴도치위치
					map[i][j] = 7000;
					now1 = i; // 현위치 앞좌표
					now2 = j; // 현위치 뒤좌표
				}
			}
		}

		Waterplus();
		BFS();
	}

	static void BFS() {

		Queue<Integer> x_q = new LinkedList<Integer>();
		Queue<Integer> y_q = new LinkedList<Integer>();
        
		int x = now1;
		int y = now2;
		x_q.offer(x);
		y_q.offer(y);

		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };

		while (!x_q.isEmpty() || !y_q.isEmpty()) {
			x = x_q.poll();
			y = y_q.poll();

			for (int i = 0; i < 4; i++) {
				if ((x + d1[i]) >= 0 && (y + d2[i]) >= 0 && (x + d1[i]) < R && (y + d2[i]) < C
						&& (map[(x + d1[i])][(y + d2[i])] == 10000 || (map[(x + d1[i])][(y + d2[i])] == 80000))
						&& map[(x + d1[i])][(y + d2[i])] != 40000 && visit[(x + d1[i])][(y + d2[i])] == false) {

					visit[x + d1[i]][y + d2[i]] = true;
					number[x + d1[i]][y + d2[i]] = number[x][y] + 1;
					if ((water[(x + d1[i])][(y + d2[i])] == number[(x + d1[i])][(y + d2[i])])) { //다음순서로 갈 부분이 물이있나없나 
                        
					} else {
						x_q.offer((x + d1[i]));
						y_q.offer((y + d2[i]));
					}

					for (int f = 0; f < R; f++) {
						for (int g = 0; g < C; g++) {
							if (water[f][g]!=8&&water[f][g]!=0&&water[f][g]!=4 && water[f][g] == number[x + d1[i]][y + d2[i]]) { 
								// 1회 갔으면 water 1간만큼 map에ㅔ 2로 물을 표시해줌 
								map[f][g] = 20000;
								
							}
						}
					}
				}
			}

		}
		if (number[arrive1][arrive2]!=0) {
			System.out.println(number[arrive1][arrive2]);
		} else {
			System.out.println("KAKTUS");
		}
	}

	static void Waterplus() {

		Queue<Integer> x_w = new LinkedList<Integer>();
		Queue<Integer> y_w = new LinkedList<Integer>();

		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
		water[arrive1][arrive2] = 8;
		int x = 0;
		int y = 0;

		for (int i = 0; i < waternumber; i++) { // 물 초기값들을 큐에넣는다. **

			x_w.offer(waternum1[i]);
			y_w.offer(waternum2[i]);

		}

		while (!x_w.isEmpty() || !y_w.isEmpty()) {

			x = x_w.poll();
			y = y_w.poll();

			for (int k = 0; k < 4; k++) {
				if ((x + d1[k]) >= 0 && (y + d2[k]) >= 0 && (x + d1[k]) < R && (y + d2[k]) < C
						&& water[x + d1[k]][y + d2[k]] == 0 && water[x + d1[k]][y + d2[k]] != 8
						&& visit2[x + d1[k]][y + d2[k]] == false && map[x + d1[k]][y + d2[k]] != 20000
						&& map[x + d1[k]][y + d2[k]] != 40000) {
					x_w.offer(x + d1[k]);
					y_w.offer(y + d2[k]);
					visit2[x + d1[k]][y + d2[k]] = true;
					water[x + d1[k]][y + d2[k]] = water[x][y] + 1;
				}
			}

		}

	}

}

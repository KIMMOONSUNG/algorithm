package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_2178_queue { // 미로찾기 (큐)로 짬
	static int map[][]; // 맵
	static boolean visit[][]; // 방문했는지 안했는지 중복 막기위함
	static int X, Y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
	
		map = new int[X][Y];
		visit = new boolean[X][Y]; // false로 전부 초기화됨
		for (int a = 0; a < X; a++) {
			String str = sc.next();
			for (int b = 0; b < Y; b++) {
				map[a][b] = str.charAt(b) - 48;
			}
		}

		fun();

	}

	static void fun() {
		Queue<Integer> x_q = new LinkedList<Integer>();
		Queue<Integer> y_q = new LinkedList<Integer>();
		//Queue<Integer> c_q = new LinkedList<Integer>();
		int x = 0;
		int y = 0;
		if (map[0][0] == 1) {
			x_q.offer(0);
			y_q.offer(0);
		}
		int d1[] = { 1, -1, 0, 0 };
		int d2[] = { 0, 0, 1, -1 };
		/*
		 * 이거로해도 상관없음 int d1[] = {1,0,-1,0}; 
		 *             int d2[] = {0,1,0,-1};
		 */
		while (x != (X - 1) || y != (Y - 1)) {
			x = x_q.poll();
			y = y_q.poll();
			//visit[x][y] = true; // 중복된곳은 검사 안하려고 그니까 한번 검사한곳은 다시 안검사하려고
								// 위에서 poll로 뺴면서 이미 검사한곳이다라고 true로 바꾸는거임

			for (int i = 0; i < 4; i++) { // 현위치서 방향검사한다 (4방향)
				if ((x + d1[i]) < X && (y + d2[i]) < Y && (x + d1[i]) >= 0 && (y + d2[i]) >= 0
						&& visit[x + d1[i]][y + d2[i]] == false && map[x + d1[i]][y + d2[i]] == 1){
					// 각 이동 할때 현위치가 0보다 같거나 크고 ,, 배열크기보다 작아야하며 ,, 방문하지않은
					// false이어야하고 ,, 이동할수있는 배열 값이 1이여야 함
					x_q.offer((x + d1[i]));
					y_q.offer((y + d2[i]));
					
					 visit[x+d1[i]][y+d2[i]] = true;// 중복된곳은 검사 안하려고 그니까 한번 검사한곳은 다시 안검사하려고
						// 위에서 poll로 뺴면서 이미 검사한곳이다라고 true로 바꾸는거임
					
					map[(x + d1[i])][y + d2[i]] = map[x][y] + 1; // 원래값에 지나온값들
																// 1씩더해
																// 출력하는거니까
				}
			}
		}
		System.out.println(map[X - 1][Y - 1]); // 마지막 값을 답으로

	}
}

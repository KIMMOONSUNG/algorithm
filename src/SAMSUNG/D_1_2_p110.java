package SAMSUNG;

import java.util.Scanner;

public class D_1_2_p110 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcase = sc.nextInt();
		int Case = 1;
		int dx[] = { 1, -1, 0, 0, -1, -1, 1, 1, 2, -2, 0, 0, -2, -2, 2, 2, 3, -3, 0, 0, -3, -3, 3, 3 }; // 아,위,오,왼,왼위대,오위대,왼아대,오아대,
		int dy[] = { 0, 0, 1, -1, -1, 1, -1, 1, 0, 0, 2, -2, -2, 2, -2, 2, 0, 0, 3, -3, -3, 3, -3, 3 };

		for (int a = 0; a < testcase; a++) {
			int size = sc.nextInt();
			int map[][] = new int[size][size];
			int king[][] = new int[3][50*50]; // 문제에는없지만 2차원배열크기 50으로 제한이라생각하고 범위제한없으면 [6][50]으로해서 이중포문해서 x랑y따로  
			String str = sc.next();
			for (int i = 0; i < 3; i++) {
				String k = str.split(",")[i]; // ,를구분해잘라
				for (int j = 0; j < k.length(); j++) { // 자른길이만큼
					king[i][j] = k.charAt(j) - 48; // 인덱스에넣고
				}
				for (int j = 0; j < k.length(); j += 2) { // x,y를 구분해서 map에 넣는다
					map[king[i][j]][king[i][j + 1]] = i + 1; // a퀸은 1 b퀸은 2 c퀸은 3
				}
			}
			int number = 8;
			for (int count = 1; count < 4; count++) { // a,b,c찾기위해
				for (int b = 0; b < size; b++) {
					for (int c = 0; c < size; c++) {
						if (map[b][c] == count) { // 1,2,3일때
							for (int d = 0; d < number; d++){
								if (b + dx[d] >= 0 && c + dy[d] >= 0 && b + dx[d] < size && c + dy[d] < size
										&& map[b + dx[d]][c + dy[d]] != 1 && map[b + dx[d]][c + dy[d]] != 2
										&& map[b + dx[d]][c + dy[d]] != 3) {
									map[b + dx[d]][c + dy[d]] = -1;
								}
							}
						}
					}
				}
				number += 8;
			}
			int cnt = 0;
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (map[i][j] == 0) {
						cnt++;
					}
				}
			}
			System.out.println("#" + Case + " " + cnt);
			Case++;
		}

	}
}

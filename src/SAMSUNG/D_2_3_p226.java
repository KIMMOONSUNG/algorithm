package SAMSUNG;

import java.util.Scanner;

public class D_2_3_p226 { // 탱크게임 
	/*
	  
2
7
E 0 T 0 E E 0
0 B B 0 B 0 0
E B E 0 B T E
B B 0 T B 0 E
E T E 0 B 0 0
0 E 0 E B 0 T
0 0 B B B B E
5
E 0 T 0 E
0 B B 0 B
E B E 0 B
B B 0 T B
E T E 0 B

	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt();// 테스트케이스
		int Case = 1;
		for (int a = 0; a < Testcase; a++) {
			int n = sc.nextInt(); // 지도의크기
			int map[][] = new int[n][n];
			String str = "";
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					str = sc.next();
					switch (str) {
					case "T": // 아군탱크
						map[i][j] = -1;
						break;
					case "E": // 적군탱크
						map[i][j] = -2;
						break;
					case "B": // 건물
						map[i][j] = -3;
						break;
					default:
						break;
					}
				}
			}
			int dx[] = { 0, 0, 1, -1 };
			int dy[] = { 1, -1, 0, 0 };
			int count =0; // 폭팔시킨 적군 탱크 
			boolean visit[][] = new boolean[n][n]; // 탱크공격한경우
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					
					if (map[i][j] == -1) { // 아군탱크일경우
						
						for (int k = 0; k < 4; k++) { // 4방향을 검사한다 .
							int gob =1;
							while (true) {
								if (i + (dx[k]*gob) >= 0 && j + (dy[k]*gob) >= 0 && i + (dx[k]*gob) < n && j + (dy[k]*gob) < n){
									if(visit[(i + (dx[k]*gob))][(j + (dy[k]*gob))] == true){
										break;
									}
									if(map[(i + (dx[k]*gob))][(j + (dy[k]*gob))] == -3){ //건물이면 그쪽방향은 더이상못감
									  break;
									}
									if(map[(i + (dx[k]*gob))][(j + (dy[k]*gob))] == -2){ //적군 만나면 폭파시킴
									  count++; // 폭팔시킨 탱크 수 증가
									  visit[(i + (dx[k]*gob))][(j + (dy[k]*gob))] = true; // 다시폭파못시키게
									  break; 	
									}
									if(map[(i + (dx[k]*gob))][(j + (dy[k]*gob))] == -2){ // 아군탱크만나면 그냥 끝
										break;
									}
								}
								else{ //★ 배열 크기 벗어나면 break ★
									break;
								}
								gob++;
							}
						}
					}
				}
			}
			System.out.println("#"+Case+" "+count);
			Case++;

		}

	}
}

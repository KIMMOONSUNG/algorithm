import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_2344 {
	static int map[][] ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N + 2][M + 2];
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(bf.readLine().trim());
			for (int j = 1; j < M + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 시작지점이 반시계방향도니까 아래로 ->오른쪽으로 ->위로 ->왼쪽으로 이니까
				int startturnx[] = { 1, 0, -1, 0 };
				int startturny[] = { 0, 1, 0, -1 };
				int tx = 0;
				int ty = 0;
				int count = 1;
				for (int i = 0; i < 4; i++) { // 반사된 마지막곳 위치에 번호를넣음 
					tx = tx + startturnx[i];
					ty = ty + startturny[i];
					while (tx >= 0 && ty >= 0 && tx < N + 2 && ty < M + 2) {
						if ((tx == 0 && ty == 0) || (tx == N + 1 && ty == M + 1) || (tx == 0 && ty == M + 1)
								|| (tx == N + 1 && ty == 0)) {
							map[tx][ty] = -1;
							break;
						}
						map[tx][ty] = count;
						count++;
						tx = tx + startturnx[i];
						ty = ty + startturny[i];
					}
				}
				
				int x = 0; // 이동
				int y = 0;
				int s_x = 1;// 시작위치
				int s_y = 1;
				
				int dx[] = { 1, -1, 0, 0 }; //방향
				int dy[] = { 0, 0, 1, -1 };
				int dir = 2; // 첫방향
				int direc[] = { 2, 1, 3, 0 };// 근데 방향은 오른쪽으로 -> 위로-> 왼쪽으로 -> 아래로 니까 2 ->1-3-0
				StringBuilder sb= new StringBuilder();
				 for (int i = 0; i < 4; i++) {// 시작위치를 변화시킬것 시작위치의 방향이바뀌면 진행 방향도바뀜★
					while (s_x >= 1 && s_y >= 1 && s_x < N + 1 && s_y < M + 1) { // 시작위치가 범위벗어났을시에 끝
						x = s_x; // 처음은 1,1에서시작
						y = s_y; // 처음은 1,1에서시작

						dir = direc[i]; //방향
						while (x >= 1 && y >= 1 && x < N + 1 && y < M + 1) { // 반사되서쭉가다나감 끝
							if (map[x][y] == 1) {// 거울일때
								dir = direction(dir); // 메소드호출해서 반사로 방향바꿔줌
							}
							x = x + dx[dir];
							y = y + dy[dir];
						}
						sb.append(map[x][y]+" ");
						s_x = s_x + startturnx[i]; // 시작위치변화
						s_y = s_y + startturny[i];
					}
					s_x = s_x - startturnx[i];// 시작위치가 범위벗어났으니 그 이전위치를 시작위치로하고
												// 방향만바뀌어야하니까 시작위치를 이전꺼로
					s_y = s_y - startturny[i];
				}
				 System.out.println(sb);
			}

			static int direction(int dir) {
				return 3 - dir;
			}
			
}

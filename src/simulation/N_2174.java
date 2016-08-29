package simulation;

import java.util.Scanner;

public class N_2174 { // 어려워서 실패 
	// 배열이 뒤집힌것도짜증  1,1이 밑에있는것도 짜증
	// 방향에따라 dx dy를 해준것은 이득 
	
	
	
	static int a;
	static int b;
	static int n;
	static int m;
	static int map[][];
	static int order[][];
	static String orderdir[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt(); // b*a map
		b = sc.nextInt();
		
		map = new int[b + 1][a + 1];
		n = sc.nextInt(); // n개의 로봇
		m = sc.nextInt(); // m개의 명령
		int nowrobot[][] = new int[n + 1][3]; // 로봇초기 xy위치 ,방향저장
		String nowrobotdir[] = new String[n]; // 로봇 초기 방향저장
		order = new int[n + 1][2]; // 몇번로봇에게 오더할건지와 몇번반복할건지 저장
		orderdir = new String[n + 1]; // 오더방향저장
		/*
		 * int nowx=0; int nowy=0; String nowdir="";
		 */
		int cnt = 0;
		for (int i = 1; i <= n; i++) { // n개 로봇 초기위치와 방향
			nowrobot[i][0] = sc.nextInt(); // 초기x
			nowrobot[i][1] = sc.nextInt(); // 초기y
			cnt++;
			map[nowrobot[i][1]][nowrobot[i][0]] = cnt;
			String str = sc.next();
			if (str == "N") {
				nowrobot[i][2] = 3; // 초기방향
			}
			if (str == "W") {
				nowrobot[i][2] = 9; // 초기방향
			}
			if (str == "E") {
				nowrobot[i][2] = 0; // 초기방향

			}
			if (str == "S") {
				nowrobot[i][2] = 6; // 초기방향
			}
		}

		int robotnum = 0;
		String robotdir = "";
		int robotcount = 0;

		// 초기방향 E일때 (오) 0,1,2// N일때 3,4,5// S일때 6,7,8 // W일때 9,10,11
		int dx[] = { 0, -1, 1, 1, 0, 0, -1, 0, 0, 0, 1, -1 }; // 036->앞으로
																// 147->오른쪽
																// 358->왼 //
		int dy[] = { 1, 0, 0, 0, 1, -1, 0, -1, 1, -1, 0, 0 }; //

		
		for (int i = 1; i <= m; i++) { // 몇번로봇에게 m번의명령내린다
			// order[i][0] = sc.nextInt(); // 몇번 로봇에게
			// orderdir[i] = sc.next(); // 무슨 방향으로
			// order[i][1] = sc.nextInt(); // 몇번 반복

			robotnum = sc.nextInt(); // 명령내릴 로봇번호
			robotdir = sc.next();
			robotcount = sc.nextInt();

			int x = nowrobot[robotnum][0]; // 초기x좌표
			int y = nowrobot[robotnum][1]; // 초기y좌표
			int nowdir = nowrobot[robotnum][2]; // 초기 방향 인덱스

			if (robotdir == "F") { // 앞으로
				// nowdir = nowdir;
			}
			if (robotdir == "R") { // 오른쪽으로
				nowdir = nowdir + 1;
			}
			if (robotdir == "L") { // 왼쪽으로
				nowdir = nowdir + 2;
			}

			boolean result = false; // 한 로봇에 문제가 생길시 true로

			for (int k = 0; k < robotcount; k++) {
				int xx = x + dx[nowdir];
				int yy = y + dy[nowdir];
				
				if (xx > 0 && yy > 0 && xx <=b && yy <=a) { // 범위안에
					if (map[xx][yy] != 0) {
						// 다른로봇과충돌한것.
						System.out.println("Robot " + robotnum + " crashes into robot " + map[xx][yy]);
						result = true;
						break;
					} else {
						x = xx;
						y = yy;
					}
				} else { // 범위벗어난거
					System.out.println("Robot " + robotnum + " crashes into the wall");
					result = true;
					break;
				}
			}
			
           if(result == true){
        	   break;
           }
           
           if(i==m && result ==false){
        	   System.out.println("OK");
           }
		}
		
	}

}

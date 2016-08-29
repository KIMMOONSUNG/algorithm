package SAMSUNG;

import java.util.Scanner;

public class D_2_1_p204 {
	/*
E3 S2 S4 S5 E2 S1 S5
N2 S3 S2 E1 N3 W4 N1
W1 N1 E3 W3 S3 W1 S3
E3 S2 N2 S2 E1 N2 W3
N3 E3 S1 N1 W3 E1 W1
E1 N2 W1 N3 S2 N3 W5
N5 E1 N4 W3 N5 W1 S1
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int cnt = sc.nextInt();
		int count[][] = new int[t][t]; // 이동할길이
		char dir[][] = new char[t][t]; // 동서남북방향
		int Case = 1;

		for (int i = 0; i < t; i++) {
			for (int j = 0; j < t; j++) {
				String a = sc.next();
				int num = Integer.parseInt(a.substring(1, a.length())); // 1부터
																		// 그길이까지문자열을int형으로변환(숫자구하기위함)
				char chr = a.charAt(0); // 맨앞에 방향을구함 동서남북
				count[i][j] = num;
				dir[i][j] = chr;
			}
		}
		int dx[] = { 1, -1, 0, 0 };// 아래 S/ 위 N / 오 E / 왼W
		int dy[] = { 0, 0, 1, -1 };

		for (int i = 0; i < cnt; i++) {
			int x = sc.nextInt()-1; //배열이 1부터가 아닌 0부터로 해서 
			int y = sc.nextInt()-1;
			int move = sc.nextInt(); //이동횟수
			int dnum = 0; // x와 y 인덱스 
			int countnum = count[x][y]; // 이동길이 인덱스값에 곱해주면된다 
			char direct = dir[x][y]; // 방향 
			int money = 0; // 돈
			int x2=0; 
			int y2=0;
			while (move != 0) { //이동횟수 0이면 반복종료 
				
				switch (direct) { 
				case 'S':
					dnum = 0;
					break;
				case 'N':
					dnum = 1;
					break;
				case 'E':
					dnum = 2;
					break;
				case 'W':
					dnum = 3;
					break;
					default :break;
				}
				
				if ((x + (dx[dnum] * countnum)) < 0 || (y + (dy[dnum] * countnum)) < 0 
						|| (x + (dx[dnum] * countnum)) >= t || (y + (dy[dnum] * countnum)) >= t) { // 범위벗어나면 10000원 출력 끝 
					money = 10000;
					break;
				}

					direct = dir[x + (dx[dnum] * countnum)][y + (dy[dnum] * countnum)]; // 지금위치에 dx와dy에 이동길이를 곱해준걸 더함
					x2=x + (dx[dnum] * countnum); //바뀔현재위치
					y2=y + (dy[dnum] * countnum);//바뀔현재위치 
					countnum = count[x + (dx[dnum] * countnum)][y + (dy[dnum] * countnum)]; //이동길이도 바꿔준다 
					x =x2; //x에 바뀔위치를
					y=y2;  //y에 바뀔위치를 
					move--; // 이동횟수 감소 
					
                   money = countnum*1000; // 마지막 이동길이 * 1000원		
 
			}
			System.out.println("#"+Case+" "+money);
			Case++;
		}

	}
}

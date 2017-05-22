package simulation;

import java.util.Scanner;

public class N_2980 { 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 신호등의 개수
		int L = sc.nextInt(); // 도로의길이
		int imp[][] = new int[N][3];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				imp[i][j] = sc.nextInt();
				// 신호등위치, 빨간지속시간, 초록지속시간
			}
		}
		sc.close();
		int time = 0; // 걸린 시간
		int a = 0; // 내 위치
		for (int i = 1; i <= L; i++) {
			time++;
			if (a < N) // 신호등개수 딱맞게  
			{
				if (imp[a][0] == i) {// 도착한곳에 신호등이있을시에 //
					while (true) {
						if (time % (imp[a][1] + imp[a][2]) < imp[a][1]) {
							time += (imp[a][1] - (time % (imp[a][1] + imp[a][2])));
						} else{
							break;
						}
					}
					a++;
				}
			}
		}
		System.out.println(time);
	}
}
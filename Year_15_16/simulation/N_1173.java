package simulation;

import java.util.Scanner;

public class N_1173 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 해야하는운동시간
		int m = sc.nextInt(); // 현재 맥박 // 최소 맥박 계산중에서 더 내려가면 m으로 바뀜
		int M = sc.nextInt(); // 최대 맥박으로 넘을수 없다
		int T = sc.nextInt(); // 운동시 증가량
		int R = sc.nextInt(); // 휴식시 감소량
		int time = 0; // 시간
		int heart = m; // 때마다 영식이 맥박
		int workout = 0; // 운동 량

		if ((m + T) > M) { // 1번 운동 그니까 1분 운동후 맥박이 최대 치를 넘게되면 -1출력
			System.out.println(-1);
		} else {
			while (true) {
				time++;
				// 운동
				if ((heart + T) <= M) { // 운동후 최대 맥박 넘지않는다면 운동을한다
					heart = heart + T;
					workout++;
				}
				// 그렇지 않으면 휴식
				else {
					if ((heart - R) < m) { // 조건에 있듯이 휴식후 맥박감소가 최소 맥박보다 적으면
											// 최소맥박으로 바꿔준다 .
						heart = m;
					} else {
						heart = (heart - R);
					}
				}
				if (workout == N) {
					// 운동하려는 횟수 채우면 끝
					break;
				}
			}
			System.out.println(time);
		}
	}
}

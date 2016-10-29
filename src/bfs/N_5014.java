package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_5014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt(); // 총층
		int S = sc.nextInt(); // 현재위치
		int G = sc.nextInt(); // 스타트링크 층
		int U = sc.nextInt(); // 위 건너뛰는 층수
		int D = sc.nextInt(); // 아래 건너뛰는 층수
        sc.close();
		int map[] = new int[F + 1]; // 0층은 제외라고 생각

		boolean visit[] = new boolean[F + 1]; //방문 중복 방지
		Queue<Integer> q = new LinkedList<Integer>(); 
		q.offer(S); 
		visit[S] = true; 
		int d[] = { U, -D }; // 위층 아래층 
		int now1 = 0; // 큐에서빠진값 넣음
		int count = 0; // 도착했을때 값 넣음.
		int num = F + 1; // 도착했을때 값들 비교하기위한 변수 
		boolean result = false; // 도착 유무 
		
		while (!q.isEmpty()) {
			now1 = q.poll();
			for (int i = 0; i < 2; i++) {
				int now2 = now1 + d[i];
				if (now2 > 0 && now2 <= F && visit[now2] == false) {
					visit[now2] = true;
					q.offer(now2);
					map[now2] = map[now1] + 1;
				}
			}
			if (now1 == G) { // 만일 도착을하면 
				result = true;
				count = map[G]; // 버튼 누른 총 수를 count에 넣고 
				if (num > count) { //그때그때 비교 (최소값)
					num = count;
				}
			}
		}
		if (result == false) // 도착못했을시 
			System.out.println("use the stairs");
		else // 도착
			System.out.println(num);
	}
}

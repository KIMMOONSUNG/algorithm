package bfs;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class mv {
	int x;
	int y;
	int watercount;
}

public class N_3055_3 {
	static int map[][]; // 맵저장변수
	static int watermap[][]; // 물 경로 저장변수 
	static boolean visit[][];
	static int N;
	static int M;
	static int s_x; // 고슴도치 시작점
	static int s_y;
	static int s_wx;// 물의 시작점
	static int s_wy;
	static mv w; 
    static Queue<mv> waterq = new LinkedList<mv>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		watermap = new int[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				str.charAt(j);
				if (str.charAt(j) == 'D') {
					map[i][j] = -1; // 도착
					
				} else if (str.charAt(j) == '.') {
					map[i][j] = 0; // 이동가능
				} else if (str.charAt(j) == '*') {
					map[i][j] = -2; // 물 -> 이동못하고 증가함.
					s_wx = i;
					s_wy = j;

					w = new mv();
					w.x = s_wx;
					w.y = s_wy;
					waterq.offer(w);
					
					
				} else if (str.charAt(j) == 'S') {
					map[i][j] = -10; // 시작
					s_x = i;
					s_y = j;
				} else if (str.charAt(j) == 'X') {
					map[i][j] = -3; // 돌이라못감
				}
			}
		}
		waterfunc();
		bfs(s_x, s_y);
	}

	static void waterfunc() { // 물의 각 위치값에다가 최단 경로 저장 .
		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
        mv g = new mv();
		while (!waterq.isEmpty()) {
			 g = waterq.poll();
			for (int i = 0; i < 4; i++) {
              int x = g.x+d1[i];
              int y = g.y+d2[i];
              int count = g.watercount+1;
              if(x>=0 && y>=0 && x<N && y<M 
            		  && watermap[x][y]==0 &&(map[x][y] == 0 || map[x][y] == -10)){
            	  
            	  
            	  watermap[x][y] = count;
            	  mv a = new mv();
            	  a.x = x;
            	  a.y = y;
            	  a.watercount = count;
            	  waterq.offer(a);
              }
			}
		}
   }
	static void bfs(int a, int b) { // 그래서 물보다 먼저 굴에 도착해야 함.
		Queue<mv> q = new LinkedList<mv>();
		mv m = new mv();
		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
		m.x = a;
		m.y = b;
		q.offer(m);
		boolean result = false;
		
		while (!q.isEmpty()) {
			m = q.poll();
			if (map[m.x][m.y] == -1) { // -1인곳 즉 s인곳에 도착했으면 result true 그리고 끝.
				result = true;
				System.out.println(m.watercount);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int x = m.x + d1[i];
				int y = m.y + d2[i];
				int count = m.watercount +1;
				if (x >= 0 && y >= 0 && x < N && y < M && visit[x][y] == false 
						&& (watermap[x][y]>count|| watermap[x][y] ==0) 
						&& (map[x][y] == 0 || map[x][y] == -1)) {
					
					visit[x][y] = true;
					mv m2 = new mv();
					m2.x = x;
					m2.y = y;
					m2.watercount = count;
					q.offer(m2);
				}
			}
		}
		if (result == false) {
			System.out.println("KAKTUS");
		}
	}

}
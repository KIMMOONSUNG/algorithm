package bfs;

import java.util.PriorityQueue;
import java.util.Scanner;

class ele implements Comparable<ele> {
	int x;
	int y;
	int dir;
	int cnt;
	ele(int x, int y, int dir, int cnt){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.cnt = cnt;
	}
	public int compareTo(ele e){
		if(this.cnt > e.cnt){
			return 1;
		}
		else if(this.cnt <e.cnt){
			return -1;
		}
		else{
			return 0;
		}
	}
}

public class N_1726 {
	static int m;
	static int n;
	static int map[][];
	static boolean visit[][][];
	static int sx;
	static int sy;
	static int sdir;
	static int ex;
	static int ey;
	static int edir;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		map = new int[m + 1][n + 1];
		visit = new boolean[m + 1][n + 1][5];
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		sx = sc.nextInt();
		sy = sc.nextInt();
		sdir = sc.nextInt();
		ex = sc.nextInt();
		ey = sc.nextInt();
		edir = sc.nextInt();

		int dx[] = { 0, 0, 0, 1, -1 }; // 동 서 남 북
		int dy[] = { 0, 1, -1, 0, 0 };

		PriorityQueue<ele> q = new PriorityQueue<ele>();
		q.offer(new ele(sx,sy,sdir,0));
	
		// 시작점 넣는다.
		visit[sx][sy][sdir] = true;
		
		while (!q.isEmpty()) {
		    ele e2 = q.poll();
			System.out.println(e2.x + "/" + e2.y + "/" + e2.dir + "/" + e2.cnt);
			if (e2.x == ex && e2.y == ey && e2.dir == edir) {
				System.out.println(e2.cnt);
				break;
			}
			
			/*
			for (int i = 1; i <= 3; i++){ // 현재 방향대로 1~3 칸으로
				int x = x1 + dx[dir] * i;
				int y = y1 + dy[dir] * i;
				if (x > 0 && y > 0 && x <= m && y <= n && map[x][y] != 1 && visit[x][y][dir] == false) {
				}
			}
			*/
			
			for(int i =1; i<=4; i++){
				int x = e2.x+dx[i];
				int y = e2.y+dy[i];
				int dir = e2.dir;
				int cnt = e2.cnt;
				if(x>0 && y>0 && x<=m && y<=n ){
                  					
				}
			}		
		}
	}
}

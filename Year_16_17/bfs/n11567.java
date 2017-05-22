package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_11567 {
	int x, y;

	n_11567(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class n11567 { // 선진이의 겨울왕국
	static int n;
	static int m;
	static char map[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int sx, sy, ex, ey;
	static boolean result;
	static boolean result2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		st = new StringTokenizer(bf.readLine());
		sx = Integer.parseInt(st.nextToken()) - 1;
		sy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(bf.readLine());
		ex = Integer.parseInt(st.nextToken()) - 1;
		ey = Integer.parseInt(st.nextToken()) - 1;

		if (map[ex][ey] == 'X') {  //도착지점 X인 경우 
			func2(sx, sy);
			if (result == true) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		} else { // 도착지점이 .인 경우 
			func(sx, sy);
			if (result2 == false) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
	 
	}

	static void func(int a, int b) { // 백트래킹 
		if (result2 == true) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			
			if (result2 == true) {
				return;
			}
			
			int x = a + dx[i];
			int y = b + dy[i];
			
			if (x >= 0 && y >= 0 && x < n && y < m) {
				if (x == ex && y == ey) {
					if(map[ex][ey]=='X'){
						result2 = true;
						return;
					}
					if(map[ex][ey]=='.') {
						map[ex][ey] = 'X';
						func(x, y);
						if (result2 == false) {
							map[ex][ey] = '.';
						}
						return;
					}
				} else {
					if (map[x][y] == '.') {
						map[x][y] = 'X';
						func(x, y);
						map[x][y] = '.';
					}
				}
			}
			
		}

	}
	
	static void func2(int a, int b) { // BFS
		
		Queue<n_11567> q = new LinkedList<>();
		q.offer(new n_11567(sx, sy));
		while (!q.isEmpty()) {
			n_11567 p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if (x >= 0 && y >= 0 && x < n && y < m) {
					if (x == ex && y == ey) {
						result = true;
						return;
					} else if (map[x][y] == '.') {
						map[x][y] = 'X';
						q.offer(new n_11567(x, y));
					}
				}
			}
			
			if(result==true){
				return;
			}
		}	
	}
    
	static void fucn3(){
		Queue<n_11567> q = new LinkedList<>();
		q.offer(new n_11567(sx,sy));
		while(!q.isEmpty()){
			n_11567 p = q.poll();
			for(int i =0; i<4; i++){
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				if(x>=0 && y>+0 && x<n && y<m){
					if(x == ex && y== ey){
						
					}
				}
			}
		}
	}

	
}

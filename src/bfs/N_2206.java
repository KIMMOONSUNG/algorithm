package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MS {
	int x;
	int y;
	int l;
	int count;
}

public class N_2206 {  //기본적인 q에 클래스 객체 넣어서 하는방법 
	static int map[][];
	static int N;
	static int M;
	static boolean visit[][][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visit = new boolean[N][M][2];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - 48;
			}
		}
		bfs();
	}

	static void bfs() {
		
		System.out.println(N);
		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
		Queue<MS> q = new LinkedList<MS>();
		MS m = new MS();
		m.x = 0;
		m.y = 0;
		m.l = 1; // ★길이를 출발점도 포함해야해서 1부터 시작
		m.count = 0;
		visit[m.x][m.y][m.count] = true;
		q.offer(m);
		boolean result = false;
		
		while(!q.isEmpty()){
		 m = q.poll();
		 if(m.x == N-1 && m.y == M-1){ // 도착했다면 
			 result = true;
			 System.out.println(m.l);
			 break;
		 }
		 for(int i=0; i<4; i++) {
			int x = m.x + d1[i];
			int y = m.y + d2[i];
			int l = m.l +1;
			int count = m.count;
			
			if(x>=0 && y>=0 && x<N && y<M && visit[x][y][count] == false
					&&( map[x][y]==0 || (map[x][y]==1 && count==0)) ){				
				visit[x][y][count] = true;
				MS m2 = new MS();
				m2.x = x;
				m2.y = y;
				m2.l = l;
				//*******************************//
				if(map[x][y]==0){
					m2.count = count;
				}
				else{ //1일때
				    m2.count = count+1;
				}
				//*******************************//
				q.offer(m2);
				
			}
		  }
		}
		
		if(result == false){
			System.out.println("-1");
		}	
	}
	
}
package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MMM2{
	int x ;
	int y ;
	int l ;
	int count;
}
public class N_2206_3 {     //  큐 4개 써서 하는법.
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
		
		
		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		Queue<Integer> ql = new LinkedList<Integer>();
		Queue<Integer> qcount = new LinkedList<Integer>();
		
		MMM2 m = new MMM2();
		
		m.x = 0;
		m.y = 0;
		m.l = 1; // ★q4개쓰는방법ㅇ서 길이를 출발점도 포함해야해서 1부터 시작 해도 밑에서 poll할때
		          //첨에 0000값ㅇ 들어가기때문에 밑에서 결과에 +1해줘야함 
		m.count = 0;
		
		visit[m.x][m.y][m.count] = true;
		qx.offer(m.x);
		qy.offer(m.y);
		ql.offer(m.l);
		qcount.offer(m.count);
		boolean result = false;
		
		while(!qx.isEmpty()||!qy.isEmpty()){
			 m.x = qx.poll();
			 m.y = qy.poll();
			 m.l = ql.poll();
			 m.count= qcount.poll();	 
		 
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
				MMM2 m2 = new MMM2();
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
				qx.offer(m2.x);
				qy.offer(m2.y);
				ql.offer(m2.l);
				qcount.offer(m2.count);
			}
		  }
		}
		
		if(result == false){
			System.out.println("-1");
		}	
	}
	
}

package bfs;
                                 //실패
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class out implements Comparable<out> { 
	int x;
	int y;
	int count;

	out(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

	public int compareTo(out o) {
		if (this.count > o.count) {
			return 1;
		} else if (this.count < o.count) {
			return -1;
		} else {
			return 0;
		}
	}
}

public class N_9376 {
	static int n;
	static int m;
	static int map[][];
	static int result;
	static boolean meet[][];
	static int number[][]; 

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();// 테스트케이스
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		meet = new boolean[n][m];
		number =new int[n][m];
		int man[][] = new int[2][2];
		int a=0;
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				if (str.charAt(j) == '*') { // 벽
					map[i][j] = -1;
				}
				if (str.charAt(j) == '#') { // 문
					map[i][j] = 1;
				}
				if (str.charAt(j) == '$') { // 범죄자위치
					map[i][j] = -7;
                   man[a][0] = i;
                   man[a][1] = j;
                   a++;
				}
			}
		}
		
		bfs(man[0][0],man[0][1]);
		/*
		for(int i =0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(meet[i][j]+"  ");
			}
			System.out.println();
		}*/
		
		bfs2(man[1][0],man[1][1]);
		
		/*
		for(int i =0; i<n; i++){
			for(int j=0; j<m; j++){
				System.out.print(meet[i][j]+"  ");
			}
			System.out.println();
		}
		*/
		System.out.println(result);

	}

	

	static void bfs(int a, int b) {
		boolean visit[][] = new boolean[n][m];
		PriorityQueue<out> q = new PriorityQueue<out>();
		q.offer(new out(a, b, 0));
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		visit[a][b] = true;
		meet[a][b] = true;
		
		boolean check = false;
		while (!q.isEmpty()) {
			out qq = q.poll();
			
			//if (check == false) {
				for (int i = 0; i < 4; i++) {
					int x = qq.x + dx[i];
					int y = qq.y + dy[i];
					int cnt = qq.count;
					if ((x < 0 || y < 0 || x >= n || y > m)) { // 범위벗어났을시 탈옥
						
						//check = true;
						result += cnt;
						System.out.println("ㅎ"+cnt);
						//continue;
					}
					else if (x >= 0 && y >= 0 && x < n && y < m && visit[x][y] == false
							&& (map[x][y] == 1 || map[x][y] == 0)) {

						if (map[x][y] == 0) {
							q.offer(new out(x, y, cnt));
							//meet[x][y]=true;
						}

						else if (map[x][y] == 1) {
							if (meet[x][y] == false) {
								q.offer(new out(x, y, cnt + 1));
								meet[x][y] = true;
							} else {
								q.offer(new out(x, y, cnt));
							}
							// 문을 열었으니 원래맵1 에서 0 으로바꿔줘야하는데

						}

						visit[x][y] = true;
					}
					
					//else if(cccc==1){
				//	meet[x][y] = false;
					//}
				}
			//}
				/*
			if(check == true && meet[qq.x][qq.y] == true){
				meet[qq.x][qq.y] = false;
			}
			*/
		
		}
		

	}
	
	
	static void bfs2(int a, int b) {
		boolean visit[][] = new boolean[n][m];
		PriorityQueue<out> q = new PriorityQueue<out>();
		q.offer(new out(a, b, 0));
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		visit[a][b] = true;
	
		while (!q.isEmpty()) {
			out qq = q.poll();
			
			
				for (int i = 0; i < 4; i++) {
					int x = qq.x + dx[i];
					int y = qq.y + dy[i];
					int cnt = qq.count;
					if ((x < 0 || y < 0 || x >= n || y > m)) { // 범위벗어났을시 탈옥
						
						
						result += cnt;
						System.out.println("ㅎ"+cnt);
						break;
					}
					else if (x >= 0 && y >= 0 && x < n && y < m && visit[x][y] == false
							&& (map[x][y] == 1 || map[x][y] == 0)) {

						if (map[x][y] == 0) {
							q.offer(new out(x, y, cnt));
							//meet[x][y]=true;
						}

						else if (map[x][y] == 1) {
							if (meet[x][y] == false) {
								q.offer(new out(x, y, cnt + 1));
								meet[x][y] = true;
							} else {
								q.offer(new out(x, y, cnt));
							}
							// 문을 열었으니 원래맵1 에서 0 으로바꿔줘야하는데

						}

						visit[x][y] = true;
					}
			
				}

		}
		

	}
	
}

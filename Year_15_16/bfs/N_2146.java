package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_2146 {
	static int n; //전체 맵 크기 n*n
	static int map[][];
	static boolean mapvisit[][]; // 맵 방문확인 
	static int count; // 섬들을  숫자로 구분하기 위함 
	static int number; // 다리놓는 최소 칸
	static boolean alone ; //

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		mapvisit = new boolean[n][n];
		count = 1; // 섬 숫자로 구분하기 위해
		number = 10000000;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < n; i++) { // 섬 숫자로 구분
			for (int j = 0; j < n; j++) {
				if (map[i][j] != 0 && mapvisit[i][j] == false) { //0이아니네 그러면 이제 섬을 번호매기기위해 bfs호출
					count++;
					Mapbfs(i, j);
				}
			}
		}
		
		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
		
		for (int a = 2; a <=count; a++) { //섬끼리 거리구하려고 

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					for (int k = 0; k < 4; k++) {
						if ((i + d1[k])>=0 && j + d2[k]>=0 && (j + d2[k])<n && (i + d1[k])<n          
								&& map[i][j] == a && map[i + d1[k]][j + d2[k]] == 0){    //범위넘지않고  자기 섬일때 4방향중 하나가 0인경우
							
							 confbfs(i + d1[k], j + d2[k],a); //다름섬과의 거리를 구하기위해 호출
						}
					}
				}
			}
		}
       if(alone==true){ //밑에서 다른섬에 도착한 경우 
		System.out.println(number);
       }
       else{
    	   System.out.println("0");
       }
	}

	static void Mapbfs(int a, int b) { // 섬 들을 숫자로 구분한다 첫 섬은 2부터 
                                	   // 방문한적없고 0이아닌곳찾아 거길시작으로 쫙 BFS 한곳이 자기섬임
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		int x = a;
		int y = b;
		map[x][y] = count;
		mapvisit[x][y] = true;
		qx.offer(x);
		qy.offer(y);
		while (!qx.isEmpty() || !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < n && y + dy[i] < n
						&& mapvisit[x + dx[i]][y + dy[i]] == false && map[x + dx[i]][y + dy[i]] != 0) { 

					mapvisit[x + dx[i]][y + dy[i]] = true;
					map[x + dx[i]][y + dy[i]] = count;
					qx.offer(x + dx[i]);
					qy.offer(y + dy[i]);
				}
			}
		}
	}

	static void confbfs(int a, int b,int c) { // 섬끼리 최소거리를 구하기위함 (다리놓기위해 )
		                                      // 출발점에서 bfs를하는데 0일때만 지나가고 그러다가 자기자신인 2가아니라 다른거만나면 break
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		boolean confvisit[][] = new boolean[n][n];
		int mapcount[][] = new int[n][n];
		int dx[] = { 0, 0, 1, -1 };
		int dy[] = { 1, -1, 0, 0 };
		int x = a;
		int y = b;
		int num = 0;
		qx.offer(x);
		qy.offer(y);
        boolean result = false;
		while (!qx.isEmpty() || !qy.isEmpty()) {
			x = qx.poll();
			y = qy.poll();
			
			for (int i = 0; i < 4; i++) {
				if (x + dx[i] >= 0 && y + dy[i] >= 0 && x + dx[i] < n && y + dy[i] < n
						&& confvisit[x + dx[i]][y + dy[i]] == false
								&& map[x + dx[i]][y + dy[i]] != c) {
					confvisit[x + dx[i]][y + dy[i]] = true;
					mapcount[x + dx[i]][y + dy[i]] = mapcount[x][y] + 1;
					num = mapcount[x + dx[i]][y + dy[i]];
					qx.offer((x + dx[i]));
					qy.offer((y + dy[i]));
					
					if (map[(x+dx[i])][(y+dy[i])] != c && map[(x+dx[i])][(y+dy[i])]!=0){ //다음 갈 곳이 0 도 아니고 자기자신도아닌 곳이면 다른 섬도착한것 for문 break 
			               result = true;
							break;
				    }
				}
			}
			
			if(result==true){ //다른섬 도착했으면 while문 break
				break;
			}
			// 아무대나 자기자신숫자가아니고 0이아닌곳에 도착했으면 break 왜냐하면
			// 그게 가장 빠른경로니까 //
			// 그래서 그 count를 센다 .
		}
		
       if( result == true){ // 큐가 다 빠질때까지 while문 도는데 다 빠지기 전에 섬에도착한거면  
    	   alone = true;  //alone을 true로 그렇지 않고 큐 다빠졌는데도 섬에 도착하지않은것은 
    	                  //11111
    	                  //10001
                          //10001
    	                  //11111 보통 이런경우 이다 .
    	   if (number > num){  //그때그때 거리를 구해서 최소거리를 number에 넣는다  
   			number = num;
   		   }
    	   
       }
	}

}

package bfs;

import java.util.*;

public class N_1389 {
	static int map[][];
	// static int visit2[];
	static boolean visit[];
	static int check[];
	static int relation;
	static int user;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		user = sc.nextInt(); // 유저 수
		relation = sc.nextInt(); // 친구관계 수
		map = new int[user + 1][user + 1];
		// visit2 = new int[user + 1];
		visit = new boolean[user + 1];
		check = new int[user + 1];
		int minVal = 101;
		int PeopleNum = 0;
		int v1, v2 = 0;
		
		for (int i = 1; i <= relation; i++) {
			v1 = sc.nextInt();
			v2 = sc.nextInt();
			map[v1][v2] = map[v2][v1] = 1;
		}
		
		for (int i = 1; i <= user; i++){ // 사람번호 1~user//
			int num = BFS(i); //i 즉 사람번호를 받아서 BFS호출 //케빈베이컨의 수가 리턴되서 count에저장
			if (num < minVal) { // 가장작은케빈베이컨수가 가진 사람번호를구하는거
				minVal = num; // 케빈베이컨의수
				PeopleNum = i; // 그때의 사람번호 
				// 케빈베이컨의 수가 같을시에는 어차피 스타트가 작은수부터 가는거니까 케빈베이컨수가같아도 
				//사람번호가작은수가 넣어지게 되어있다.
			}
			// Arrays.fill(visit2, 0);
			Arrays.fill(visit, false); // visit 배열을 다 false로 채움
		}
		System.out.println(PeopleNum);
	}

	static int BFS(int start) {
		
		int number = 0; // 리턴될 케빈베이컨의 수
		// visit2[start] = 1; // 시작점 방문해서 1로놓음
		visit[start] = true;// 시작점 방문해서 
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		check[start] = 0;
		while (!q.isEmpty()) {
			start = q.poll();// 큐에서 빠진 값을 넣고
			for (int i = 1; i <= user; i++) {// 위에서 받아온 start는 [x][y] 에서 x이고 //이 for문은 y  
				if (map[start][i] == 1 && visit[i] == false) { // 그때의 값이 1이냐 즉 연결되어있는 관계냐 ?
					//visit [i] 를 true해줘서 1,3 에서 1일때 들어온후 다시 3,1에서 들어오는일이없게 막음 
					System.out.println("스타트는:"+start+"I값:"+i);
					// visit2[i] = 1;
					visit[i] = true; 
					q.offer(i);
				
					check[i] = start; 
					int k = i; // k에는 유저 번호가 넣어질것이고
					
					while (check[k] != 0) {
						System.out.println("check[k]값이0이아닐시의check[k]: " + check[k]);
						k = check[k]; // 그값을 k에 넣고 다시 인덱스로 넣어 while돌림 
						number++;
					}
				}
			}
		}
		System.out.println("return되는 값 즉 :~의 케빈베이컨의 수 :"+number);
		return number;
	}
}

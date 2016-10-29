package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_1389_2 {  // 케빈베이컨의 6단계 
	                     // 유저번호 1일때 몇 2일때 몇 해서 
	                     // 최소 케빈베이컨의 수일때의 유저번호를 구하는것 
	static int n;
	static int m;
	static int map[][];
	static boolean visit[];
	static int check[];
	static int min;
	static int people;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		n = Integer.parseInt(str[0]); // 유저의 수
		m = Integer.parseInt(str[1]); // 친구관계 수
		map = new int[n + 1][n + 1]; // n*n으로 배열만든다 
		
		int a = 0;
		int b = 0;
		min = 101;  // 최소값 
		
		for (int i = 1; i <= m; i++) {
			String str2[] = bf.readLine().split(" ");
			a = Integer.parseInt(str2[0]);
			b = Integer.parseInt(str2[1]);
			map[a][b] = map[b][a] = 1; // 예로 3,1이면 (1,3)(3,1) 둘다 1로 해준다 
		}
		for (int i = 1; i <= n; i++) {  
			bfs(i);  // 유저번호 를 bfs로 넘김 1~n // 이거는 [x][y]에서 x라생각 
		}
		System.out.println(people); //케빈베이컨의 수가 가장 적을때의 유저번호를 출력함.
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<Integer>();
		visit = new boolean[n + 1];
		check = new int[n + 1];
		
		int number = 0; 
		int peoplenumber = s;
		visit[s] = true; //받은 유저번호 true로 
		q.offer(s);
		while (!q.isEmpty()) {
			s = q.poll();
			for (int i = 1; i <= n; i++) { //[x][y] 에서 y라 생각  
				if (map[s][i] == 1 && visit[i] == false) { //1이면 연결되있는것 
					visit[i] = true;
					q.offer(i);
					/////////////핵심////////////// 
					check[i] = s;
					int k = i;
					while (check[k] != 0) { // 케빈베이컨 수 구하는 것으로 
						                    // 연결되어있는곳으로 가면서 케빈베이컨수 증가 시킴
						k = check[k];
						number++;
					}
					//////////////////////////////
				}
			}
		}
		if (number < min) {
			min = number; // 최소 케빈베이컨의수 가 저장되는데 
			people = peoplenumber; // 그때의 유저 넘버를 people에 저장
		}
	}
	
}

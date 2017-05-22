package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class n_13549 implements Comparable<n_13549> {
	int x, cnt;

	n_13549(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}

	public int compareTo(n_13549 c) {
		if (this.cnt > c.cnt) {
			return 1;
		} else if (this.cnt == c.cnt) {
			return 0;
		} else {
			return -1;
		}
	}
}

public class n13549 { // 숨바꼭질 3 - > 2배가는것이 0초이기 때문에 우선으로 해줘야 해서 우선순위 큐를 써야한다
	                  // 아니면 그냥 큐 쓰려면 2배가는거를 우선으로 먼저 다 해주고 그다음 양옆 이동을  해야함
	static int dx[] = { 1, -1, 2 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int subin = Integer.parseInt(st.nextToken());
		int bro = Integer.parseInt(st.nextToken());
		int d[] = new int[100001]; // 시간초과나니까 메모이제이션 필요함
		 
		Arrays.fill(d, -1);
		PriorityQueue<n_13549> pq = new PriorityQueue<>();
		pq.offer(new n_13549(subin, 0));
		
		while (!pq.isEmpty()){
			n_13549 p = pq.poll();
			if (d[p.x] != -1) { 
				continue;
			}
			//d[p.x] = p.cnt;
			if (p.x == bro) {
				System.out.println(p.cnt);
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				int x;
				if (i == 2) {
					x = p.x * dx[i];
				} else {
					x = p.x + dx[i];
				}
				int cnt = p.cnt;
				
				if (x >= 0 && x < 100001 && d[x] == -1) {
					if (i == 2) {
						pq.offer(new n_13549(x, cnt));
					   d[p.x] = cnt;
					} else {
						pq.offer(new n_13549(x, cnt + 1));
						d[p.x] = cnt+1;
					}
				}

			}
			
		}

	}

}

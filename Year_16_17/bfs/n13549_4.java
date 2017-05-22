package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class n_13549_4 implements Comparable<n_13549_4> {
	int x, cnt;

	n_13549_4(int x, int cnt) {
		this.x = x;
		this.cnt = cnt;
	}

	public int compareTo(n_13549_4 c) {
		if (this.cnt > c.cnt) {
			return 1;
		} else if (this.cnt == c.cnt) {
			return 0;
		} else {
			return -1;
		}
	}
}

public class n13549_4 {  //이유모를 실패임 
	                 
	static int dx[] = {2,1,-1};
    static int subin;
    static int bro;
    static boolean visit[];
    
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		subin = Integer.parseInt(st.nextToken());
		bro = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
	
		PriorityQueue<n_13549_4> pq = new PriorityQueue<>();
		pq.offer(new n_13549_4(subin, 0));
	
		while (!pq.isEmpty()){
			n_13549_4 p = pq.poll();
			
			if (p.x == bro) {
				System.out.println(p.cnt);
				break;
			}
			
			for (int i = 0; i < 3; i++) {
				int x=0;
				if (i == 0) {
					x = p.x * dx[i];
				} else {
					x = p.x + dx[i];
				}
				int cnt = p.cnt;
				
				if (x >= 0 && x < 100001 && visit[x]==false) {
					
					visit[x] = true;
					  if (i == 0) {
						   pq.offer(new n_13549_4(x, cnt));
					     
					   } else {
						   pq.offer(new n_13549_4(x, cnt+1));
					   }
					
					
				}

			}
			
		}

	}

}


package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class N_1697_c{
	int now ;
	int time;
}

public class N_1697_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int map[] = new int[100001];
		boolean visit[] = new boolean[100001];
		Queue<N_1697_c> q =  new LinkedList<N_1697_c>();
		N_1697_c c = new N_1697_c();
		c.now = n;
		c.time = 0;
		q.offer(c);
		int dx[] = {-1,1,2};
		while(true){
			c = q.poll();
			if(c.now == k){
				System.out.println(c.time);
				break;
			}
			for(int i=0; i<3; i++){
				int now ;
				if(i ==2){
					now = c.now*dx[i];
				}
				else{
					now= c.now+dx[i];	
				}
				int time = c.time+1;
				if(now>=0&& now<100001&& visit[now]==false){
					visit[now] = true;
					N_1697_c c2 = new N_1697_c();
					c2.now = now;
					c2.time = time;
					q.offer(c2);
				}
			}
		}
		
	}
}

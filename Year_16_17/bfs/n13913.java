package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_13913{
	int now, cnt;
	n_13913(int now, int cnt) {
		this.now = now;
		this.cnt = cnt;
	}
}

public class n13913 { // 숨바꼭질 4 -> // 
	static int subin;
	static int bro;
	static boolean visit[];
	static int dx[] = { 1, -1, 2 };
    static int from [] ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		subin = Integer.parseInt(st.nextToken());
		bro = Integer.parseInt(st.nextToken());
		visit = new boolean[100001];
		from = new int [1000001];
        StringBuilder s = new StringBuilder();
        s.append(subin+" ");
		Queue<n_13913> q = new LinkedList<>();
		q.offer(new n_13913(subin, 0));

		while (!q.isEmpty()) {
			n_13913 p = q.poll();
			if(p.now == bro){
				System.out.println(p.cnt);
				break;
			}
			int next = 0;
			for (int i = 0; i < 3; i++) {
				if (i == 2) {
					next = p.now * dx[i];
				} else {	
					next = p.now + dx[i];
				}
                int cnt = p.cnt;
                
                if(next>=0 && next<100001 ){
                	if(visit[next] == false){
                		visit[next] = true;                		
                	    from[next] = p.now;
                		q.offer(new n_13913(next,cnt+1));
                	}
                }
                
			}
		}
		
		print(from,subin,bro);

	}
	
	static void print(int f[] ,int s, int b){
		if(s!=b){
			print(f,s,f[b]);
		}
		System.out.print(b+" ");
	}
	
}

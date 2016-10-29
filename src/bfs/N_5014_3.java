package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N_5014_c{
	int now;
	int cnt;
}
public class N_5014_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int F = Integer.parseInt(st.nextToken()); // 총 층
		int S = Integer.parseInt(st.nextToken()); //강호위치
		int G = Integer.parseInt(st.nextToken()); //도착
		int U = Integer.parseInt(st.nextToken()); // 위버튼
		int D = Integer.parseInt(st.nextToken()); // 아래버튼
		boolean visit[] = new boolean[1000001];
		Queue<N_5014_c> q = new LinkedList<N_5014_c>();
		N_5014_c p = new N_5014_c();
		p.now = S;
		p.cnt =0;
		visit[S] = true;
		q.offer(p);
		int d[] = {U,-D};
		boolean result = false;
		while(!q.isEmpty()){
			p = q.poll();
			if(p.now == G){
				result = true;
				System.out.println(p.cnt);
				break;
			}
			for(int i =0; i<2; i++){
				int x = p.now + d[i];
				int cnt = p.cnt;
				if(x>0 && x<=F && visit[x] == false){
					visit[x]=true;
					N_5014_c p2 = new N_5014_c();
					p2.now = x;
					p2.cnt = cnt+1;
					q.offer(p2);
				}
			}
		}
		if(result==false){
			System.out.println("use the stairs");
		}
	}
}

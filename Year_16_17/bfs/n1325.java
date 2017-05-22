package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_1325 {
	int num, cnt;

	n_1325(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}
}

public class n1325 { // 효율적인해킹 -> 시간초과
	static int n;
	static int m;
	static boolean map[][];
	static boolean visit[];
	static int Maxnum;
	static int maxresult[];
	static int index ;
	static Queue<Integer> number = new LinkedList<Integer>();

		public static void main(String[] args) throws IOException {
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			map = new boolean[n + 1][n + 1];
			visit = new boolean[n + 1];
			maxresult = new int[ n + 1 ];
			
				for (int j = 1; j <= m; j++) {
					st = new StringTokenizer(bf.readLine());
					int a = Integer.parseInt(st.nextToken());
					int b = Integer.parseInt(st.nextToken());
					map[a][b] = true;
					map[b][a] = true;
					if(visit[b]==false){
						visit[b] = true;
					number.offer(b);
					}
				}
	       
		    Arrays.fill(visit, false);
		    
			while(!number.isEmpty()){
	            int num = number.poll();
	            if(visit[num]==false){
	            	visit[num] = true;
	            	func(num);   
	            }
			}
	        Arrays.sort(maxresult);
			for(int i = maxresult.length-index; i<maxresult.length ; i++){
				System.out.print(maxresult[i]+" ");
			}
		}
		
		static void func(int b) {
			
			boolean check[] = new boolean[n + 1];
			Queue<n_1325> q = new LinkedList<>();
			q.offer(new n_1325(b,0));
			check[b] = true;
			int result =0;
			while (!q.isEmpty()) {
				n_1325 p = q.poll();
	            for(int i=1; i<=n; i++){
	            	if(map[i][p.num]==true && check[i] == false){
	            		check[i] = true;
	            		q.offer(new n_1325(i,p.cnt+1));
	            		result = Math.max(result, p.cnt+1);
	            	}
	            }
			}
			
			if(Maxnum < result){
			   index =0;
			   Maxnum = result;
			   maxresult[index++] = b;
			}
			
			else if(Maxnum==result){
				Maxnum = result;
				maxresult[index++] = b;
			}
			
		}
}

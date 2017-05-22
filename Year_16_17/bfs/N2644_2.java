package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class nn{
	int num, cnt;
	nn(int num, int cnt){
		this.num = num;
		this.cnt = cnt;
	}
}
public class N2644_2 { // 촌수계산 2번째 풀이 bfs 로   == 11724  
 public static void main(String[] args) throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(bf.readLine());
	 boolean map [][] = new boolean[n+1][n+1];
	 boolean visit[] = new boolean [n+1];
	 StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	 int man1 = Integer.parseInt(st.nextToken());
	 int man2 = Integer.parseInt(st.nextToken());
	 
	 int k = Integer.parseInt(bf.readLine());
	 
	 for(int i =0; i<k; i++){
		 st = new StringTokenizer(bf.readLine());
		 int x = Integer.parseInt(st.nextToken());
		 int y = Integer.parseInt(st.nextToken());
		 map[x][y] = true;
		 map[y][x] = true;
	 }
	 
	 Queue<nn> q = new LinkedList<nn>();
	 q.offer(new nn(man1,0));
	 visit[man1] = true;
	 boolean result = false;
	 while(!q.isEmpty()){
		 nn p = q.poll();
		 if(p.num == man2){
			 result = true;
			 System.out.println(p.cnt);
			 break;
		 }
		 for(int i =1; i<=n; i++){
			 if(map[p.num][i]==true && visit[i] == false){
				 visit[i] = true;
				 q.offer(new nn(i,(p.cnt+1)));
			 }
		 }
	 }
	 
	 if(result==false){
		 System.out.println("-1");
	 }
 }
}

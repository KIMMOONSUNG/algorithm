package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class N_2644 { // map으로도  bfs로도 풀이가능 
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		 int kk = Integer.parseInt(bf.readLine());
		 boolean visit [] = new boolean[kk+1];
		 boolean connected [][] = new boolean[kk+1][kk+1];
		 int dis[] = new int[kk+1];
		 
		 StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		 int man1 = Integer.parseInt(st.nextToken());
		 int man2 = Integer.parseInt(st.nextToken());
		 int num = Integer.parseInt(bf.readLine());
	     
		 for(int i =0; i<num; i++){
			 st = new StringTokenizer(bf.readLine());
			 int e1 = Integer.parseInt(st.nextToken()); 
			 int e2 = Integer.parseInt(st.nextToken());
			 connected[e1][e2] = true;
			 connected[e2][e1] = true;
		 }
		 Queue<Integer> q = new LinkedList<Integer>();
		 q.offer(man1);
		 visit[man1] = true;
		 boolean result = false;
		 
		 while(!q.isEmpty()){
			 int p = q.poll();
			 if(p == man2){ 
				 System.out.println(dis[p]);
				 result = true;
				 break;
			 }
			 for(int i =1; i<=kk; i++){
				 if(connected[p][i]== true && visit[i]==false){
					 visit[i] = true;
					 dis[i] = dis[p] +1;
					 q.offer(i);
				 }
			 }
		 }
		 if(result==false){
			 System.out.println(-1);
		 }
	 }
}

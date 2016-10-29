package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_5014_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int F = sc.nextInt(); //총 층
		int S = sc.nextInt(); // 강호의 위치
		int G = sc.nextInt(); //스타트링크 위치
		int U = sc.nextInt(); // 위로 U층간다
		int D = sc.nextInt(); // 아래로 D층 간다.
		//U와 D가 범위넘으면 엘베 안움직인다.
		int count[] = new int[1000001];
		boolean visit[] = new boolean[1000001];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(S);
        visit[S] = true; // 강호의 위치 막음 
        boolean result = false;
        int dx[] = {U,-D};
        
        while(!q.isEmpty()){
         int n = q.poll();       
         if(n == G){
        	 result =true;
        	 System.out.println(count[G]);
        	 break;
         }
         for(int i =0; i<2; i++){
          	 int now = n+dx[i];
          	 if(now>0 && now<=F && visit[now] ==false){
          		 visit[now] = true;
          		 count[now] = count[n]+1;
                 q.offer(now);
          	 }
         }
        }
        if(result==false){
        	System.out.println("use the stairs");
        }
	}
}

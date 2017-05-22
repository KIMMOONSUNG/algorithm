package scpc;

import java.util.Scanner;

public class somam_1 {
	static int inf = 100000001;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test_case =sc.nextInt();	
		for(int t =1; t<=test_case; t++){
	      
		  int N=sc.nextInt();//정거장 수
		  int M=sc.nextInt();//철로 수
		  int K=sc.nextInt();//할인가격		  
		  int map[][] = new int[N+1][N+1];
		  
		  for(int i =1; i<=N; i++){
			  for(int j =1; j<=N; j++){
				  map[i][j] = inf;
			  }
		  }
		  
		  for(int a=1; a<=M; a++){
			  int A =sc.nextInt();
			  int B =sc.nextInt();
			  int C =sc.nextInt();//A -> B 가격
			  ////////////////////////
			  if(map[A][B]<0){
				  map[A][B] = C;
				  map[B][A] = C;
			  }
			  else if(map[A][B]>C){
				  map[A][B] = C;
				  map[B][A] = C;
			  }
			  ///////////////////////
		  }

		  int p = sc.nextInt();
		  int total = 0;
		  /*
		  for(int a=0; a<p; a++){
			  int s = sc.nextInt();//시작지점
			  int f = sc.nextInt();//종료지점
			  if(map[s][f]!=0 || map[f][s]!=0){//즉각경로있을시.
				  if(map[s][f]>K){
					  result+=1;//할인권사용
				  }
			  }
			  else{//즉각경로없을시
				  
			  }
		  }
		  */
		  for(int i =1; i<=p; i++){
			int start = sc.nextInt();
			int end = sc.nextInt();
			int dist= dikstra(map,start,N)[end];
			total = K>=dist ? total : total +1;
		  }
		  System.out.println("Case #"+t);
		  System.out.println(total);
		}

	}
	
	 static int[] dikstra(int map[][], int start, int N){
		 boolean[] visited = new boolean[N+1];
			int dist[] = new int[N+1];
			int nextVertex = start;
			int min = inf;
			for (int i = 1; i <= N; i++)
				dist[i] = inf;
			dist[start] = 0;
			
			while(true)
			{
				min = inf;
				for (int j = 1; j <= N; j++)
				{
					if (!visited[j] && dist[j] < min)
					{
						nextVertex = j;
						min = dist[j];
					}
				}
				
				if (min == inf) break;
				visited[nextVertex] = true;
				
				for (int j = 1; j <= N; j++)
				{
					int distanceVertex = dist[nextVertex] + map[nextVertex][j];
					if (dist[j] > distanceVertex)
						dist[j] = distanceVertex;
				}
			}
			return dist; 
	 }
}

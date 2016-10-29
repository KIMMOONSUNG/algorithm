package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1260 { //인접리스트 // 양방향 
	//bfs는 큐를이용 //dfs는 재귀호출 이용
	static int n ;
	static boolean visit[];
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());//정점의개수
	int m = Integer.parseInt(st.nextToken());//간선의 개수
	int start = Integer.parseInt(st.nextToken()); //탐색시작정점
	ArrayList<Integer>[] a= (ArrayList<Integer>[]) new ArrayList[n+1];
	for(int i =1; i<=n; i++){
		a[i] = new ArrayList<Integer>(); // a 리스트 배열을 정점 n개만들고 
	}
	for(int i =0; i<m;i++){
		st = new StringTokenizer(bf.readLine());
		int u = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		a[u].add(v);
		a[v].add(u);
	}
	for(int i =1; i<=n; i++){
		Collections.sort(a[i]);
	}
	visit = new boolean[n+1];
	dfs(a,visit,start);
	System.out.println();
	bfs(a,start);
	System.out.println();
}
 static void dfs(ArrayList<Integer> a[],boolean visit[], int x){
	 if(visit[x]==true){
		 return;
	 }
	  visit[x] =true;
	  System.out.print(x+" ");
	  for (int y :a[x]) {
		  if(visit[y]==false){
			  dfs(a,visit,y);
		  }
	  }
 }
 
 static void bfs(ArrayList<Integer> a[], int start){
	 
	 visit = new boolean[n+1];
	 Queue<Integer> q = new LinkedList<Integer>();
	 q.offer(start);
	 visit[start] = true;
	 while(!q.isEmpty()){
		 int x = q.poll();
		 System.out.print(x+" ");
		 for(int y : a[x]){
			 if(visit[y] == false){
				 visit[y] = true;
				 q.offer(y);
			 }
		 }
	 }
 }
 
}

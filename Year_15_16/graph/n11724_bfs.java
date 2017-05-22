package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n11724_bfs {
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> al[] = (ArrayList<Integer>[]) new ArrayList[n+1];
		for(int i =1; i<=n; i++){
			al[i] = new ArrayList<Integer>();
		}
		for(int i =0; i<m; i++){
			st = new StringTokenizer(bf.readLine()); 
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			al[u].add(v);
			al[v].add(u);
		}
		boolean visit[] = new boolean[n+1];
		int result = 0;
		for(int i =1; i<=n; i++){//1부터 n까지 있으니까 
			if(visit[i]==false){
				result++;
				bfs(al,visit,i);
			}
		}
		System.out.println(result);
		
	}
	 static void bfs(ArrayList<Integer> al[], boolean visit[] , int start){
		 Queue<Integer> q= new LinkedList<Integer>();
		 visit[start] = true;
		 q.offer(start);
		 while(!q.isEmpty()){
			 int x = q.poll();
			 for(int y : al[x]){
				 if(visit[y]==false){
					 visit[y]= true;
					 q.offer(y);
				 }
			 }
		 }
	 }
}

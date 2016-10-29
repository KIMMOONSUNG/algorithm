package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//연결요소 -> 떨어져있는 그래프 몇개 인지
// 이미방문한거는 넘김으로 그래프 몇개인지 알수 있다. //
// dfs로 품
public class n11724 {
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
		for(int i =1; i<=n; i++){
			if(visit[i]==false){
				result++;
				dfs(al,visit,i);
			}
		}
		System.out.println(result);
		
	}
	 static void dfs(ArrayList<Integer> al[], boolean visit[] , int x){
		 if(visit[x] ==true){
			 return;
		 }
		 visit[x] = true;
		 for(int y : al[x]){
			 if(visit[y] ==false){
				 dfs(al,visit,y);
			 }
		 }
	 }
}

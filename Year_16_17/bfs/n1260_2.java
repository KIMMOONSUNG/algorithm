package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class n1260_2 {
	static int n;//정점개수 
	static int m; // 간선개수 
	static int k; // 시작 
	static boolean map[][];
	static boolean visit[];
    static StringBuilder sb ;
 public static void main(String[] args) throws IOException{
	 
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());  
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    map = new boolean[n+1][n+1];
    
    for(int i =0; i<m; i++){
    	
    	st = new StringTokenizer(bf.readLine());
    	int a = Integer.parseInt(st.nextToken());
    	int b = Integer.parseInt(st.nextToken());
    	map[a][b] = true;
    	map[b][a] = true;
    	
    }
    
    sb = new StringBuilder();
    visit = new boolean[n+1];
    
    dfs(k);
    System.out.println(sb.toString());
    
    bfs();
    
}
 
 static void bfs(){
	 
	 sb=  new StringBuilder();
	 Queue<Integer> q = new LinkedList<>();
	 visit = new boolean[n+1];
	 q.offer(k);
	 sb.append(k+" ");
	 visit[k] = true;
	 while(!q.isEmpty()){
		 int p = q.poll();
		 for(int i =1; i<=n; i++){
			 if(map[p][i]==true && visit[i] == false){
				 visit[i] = true;
				 sb.append(i+" ");
				 q.offer(i);
			 }
		 }
	 }
	 
	 System.out.println(sb.toString());
	 
 }
 
 static void dfs(int num){
	 
	 visit[num] = true;
	 sb.append(num+" ");
	 for(int i=1; i<=n; i++){
		 if(visit[i] ==false && map[num][i]== true){
			 dfs(i);
		 }
	 }
	 
 }
 
}

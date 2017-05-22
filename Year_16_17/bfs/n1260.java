package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_1260{
	int num;
	n_1260(int num){
		this.num= num;
	}
}
public class n1260 { //  DFS 와 BFS ->>인접행렬 풀이  
	static int n;
	static int m;
	static int s;
	static boolean map[][] ;
	static boolean visit[];
	static StringBuilder sb1,sb2;
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m =Integer.parseInt(st.nextToken());
	s =Integer.parseInt(st.nextToken());
	 map= new boolean[n+1][n+1];
	 sb1 = new StringBuilder();
	 visit=  new boolean[n+1];
	 
	for(int i =1; i<=m; i++){
		st = new StringTokenizer(bf.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		map[x][y] = true;
		map[y][x] = true;
	}
    
	dfs(s);
	bfs();
	System.out.println(sb1);
	System.out.println(sb2);
	
}

 static void dfs(int cnt){
	 visit[cnt] = true;
	 sb1.append(cnt+" ");
	  for(int i =1; i<=n; i++){
		  if(map[cnt][i]==true && visit[i]==false){
			  dfs(i);
		  }
	  }
 }
 
 static void bfs(){
	 visit = new boolean[n+1];
	  sb2= new StringBuilder();
	 sb2.append(s+" ");
	 Queue<n_1260> q = new LinkedList<>();
		q.offer(new n_1260(s));
	    visit[s] = true;
		while(!q.isEmpty()){
			n_1260 p = q.poll();
			for(int i =1; i<=n; i++){
		      if(map[p.num][i] == true && visit[i] == false){
		    	  q.offer(new n_1260(i));
		    	  visit[i] = true;
		    	  sb2.append(i+" ");
		      }
			}
		}	
 }

 
}

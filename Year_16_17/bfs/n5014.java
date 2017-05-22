package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_5014{
	int stair,cnt;
	n_5014(int stair, int cnt){
		this.stair = stair;
		this.cnt = cnt;
	}
}
public class n5014 { // 스타트링크  
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int f = Integer.parseInt(st.nextToken()); // 총 층수   
	int s = Integer.parseInt(st.nextToken()); // 강호위치
	int g = Integer.parseInt(st.nextToken()); // 스타트링크 위치  
	int u = Integer.parseInt(st.nextToken()); // 위층점프   
	int d = Integer.parseInt(st.nextToken()); // 아래층점프  
	
	int dir[] = {u,-d}; // 방향 
	 
	boolean visit[] = new boolean[f+1];
	Queue<n_5014> q = new LinkedList<>();
	q.offer(new n_5014(s,0));
	
	boolean result = false;
	
	visit[s] = true;
	
	while(!q.isEmpty()){
	  n_5014 p = q.poll();
	  if(p.stair == g){
		  System.out.println(p.cnt);
		  result =true;
		  break;
	  }
	  for(int i =0; i<2; i++){
		  int stair = p.stair+dir[i];
		  if(stair>0 && stair<=f){
			  if(visit[stair]==false){
				  visit[stair] = true;
				  q.offer(new n_5014(stair,p.cnt+1));
			  }
		  }
	  }
	  
	}
	
	if(result ==false){
		System.out.println("use the stairs");
	}
}
}

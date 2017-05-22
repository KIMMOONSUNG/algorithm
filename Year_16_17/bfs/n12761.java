package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_12761{
	int now,len ;
	n_12761(int now, int len){
		this.now = now;
		this.len = len;
	}
}

public class n12761 { // 돌 다리 
	static int force1;
	static int force2;
	static int man;
	static int girl;
    static boolean visit[];
	
public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	force1 = Integer.parseInt(st.nextToken());
	force2 = Integer.parseInt(st.nextToken());
	man = Integer.parseInt(st.nextToken());
	girl = Integer.parseInt(st.nextToken());
	int dx[] = {1,-1,force1,-force1,force2,-force2,force1,force2};
	visit = new boolean[100001];
	Queue<n_12761> q = new LinkedList<>();
	q.offer(new n_12761(man,0));
	
	while(!q.isEmpty()){
		n_12761 p = q.poll();
		if(p.now == girl){
			System.out.println(p.len);
			break;
		}
		int x;
		for(int i =0; i<8; i++){
			if(i>=6){
				x = p.now * dx[i];
			}
			else{
				x= p.now + dx[i];
			}
			int len = p.len;
			
		  if(x>=0 && x<100001 ){
			  if(visit[x]==false){
				  visit[x]=true;
				  q.offer(new n_12761(x,(len+1)));
			  }
		  }
		  
		}
		
	}
	
	
 }
}

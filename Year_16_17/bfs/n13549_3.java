package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class n_13549_3{
	int now , time;
	n_13549_3(int now,int time){
		this.now = now;
		this.time = time;
	}
}
public class n13549_3{ // 덱 풀이 ( 2,1,-1 순서로해줘야함 0초부터 넣어줘야 ~)
	static int subin;
	static int bro;
	static boolean visit[];
	static int dx[] = {2,1,-1};	
 public static void main(String[] args) throws IOException{
	 
	BufferedReader  bf=  new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    subin = Integer.parseInt(st.nextToken());
    bro = Integer.parseInt(st.nextToken());
    visit=  new boolean[100001];
    visit[subin] = true;
    ArrayDeque<n_13549_3> dq = new ArrayDeque<>();
    dq.offer(new n_13549_3(subin,0));
    while(!dq.isEmpty()){
    	n_13549_3 p = dq.poll();
    	if(p.now == bro){
    		System.out.println(p.time);
    		break;
    	}
    	for(int i =0; i<3; i++){
    		int x =0;
    		if(i==0){
    			x = p.now * dx[i];
    		}
    		else{
    			x = p.now + dx[i];
    		}	
    		int time = p.time;
    		if(x>=0 && x<100001){
    			
    			if(visit[x]==false){ 
    			  visit[x] = true;
        		   if(i==0){
        			   dq.addFirst(new n_13549_3(x,time));
        		   }
        		   else{
        			   dq.addLast(new n_13549_3(x,time+1));   
        		   }
    			}
    			
        	}
    	}
    	
    }
    
    
   
 }
}

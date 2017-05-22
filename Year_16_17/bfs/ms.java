package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
class mm{
	int now , time;
	mm(int now,int time){
		this.now = now;
		this.time = time;
	}
}
public class ms {
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
    
    Deque<mm> dq = new LinkedList();
    dq.offer(new mm(subin,0));
    while(!dq.isEmpty()){
    	mm p = dq.poll();
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
        			   dq.addFirst(new mm(x,time));
        		   }
        		   else{
        			   dq.addLast(new mm(x,time+1));   
        		   }
    			}
    			
        	}
    	}
    	
    }
    
    
   
 }
}

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class n_13549_2{
	int now,time;
	n_13549_2(int now,int time){
		this.now = now;
		this.time = time;
	}
}
public class n13549_2 { // 우선순위 아닌 덱 
	static int subin;
	static int bro;
	static int d[];
	static int dx[] = {1,-1,2};	
 public static void main(String[] args) throws IOException{
	 
	BufferedReader  bf=  new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st= new StringTokenizer(bf.readLine());
    subin = Integer.parseInt(st.nextToken());
    bro = Integer.parseInt(st.nextToken());
    d = new int [100001];
    Arrays.fill(d, -1);
    ArrayDeque<n_13549_2> dq = new ArrayDeque<>();
    dq.offer(new n_13549_2(subin,0));
    while(!dq.isEmpty()){
    	n_13549_2 p = dq.poll();
    	if(d[p.now] != -1){
    		continue;
    	}
    	d[p.now] = p.time;
    	if(p.now == bro){
    		System.out.println(p.time);
    		break;
    	}
    	for(int i =0; i<3; i++){
    		int x =0;
    		if(i==2){
    			x = p.now *dx[i];
    		}
    		else{
    			x = p.now+dx[i];
    		}
    		int time = p.time;
    		
    		if(x>=0 && x<100001 && d[x] == -1){
        	 
        		   if(i==2){
        			   dq.addFirst(new n_13549_2(x,time));
        		   }
        		   else{
        			   dq.addLast(new n_13549_2(x,time+1));   
        		   }
        	   
        	}
    	}
    	
    }
    
   
 }
}

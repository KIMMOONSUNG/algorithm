package bfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class asdf {
 static BufferedReader bf;
 static BufferedWriter bw;
 static StringTokenizer st;
 static final int n = 3;
 static int map[][];
 static HashSet<Integer> hs ;
 static int dx[] = {0,0,1,-1};
 static int dy[] = {1,-1,0,0};
 static int ans =1000000;
 
 static class n3{
	 int x,y,cnt;
	 int m[][];
	 n3(int x, int y,int cnt, int m[][]){
		 this.x = x;
		 this.y= y;
		 this.cnt = cnt;
		 this.m = m;
	 }
 }
 
    public static void main(String args[]) throws IOException {
    	
    	bf= new BufferedReader(new InputStreamReader(System.in));
    	bw = new BufferedWriter(new OutputStreamWriter(System.out));
    	map = new int[n+1][n+1];
    	Queue<n3> q = new LinkedList<>();
    	hs = new HashSet<>();
    	int number =0;
    	for(int i =1; i<=n; i++){
    		st = new StringTokenizer(bf.readLine());
    		for(int j =1; j<=n; j++){
    			map[i][j] = Integer.parseInt(st.nextToken());
    			if(map[i][j] ==0){
    				q.offer(new n3(i,j,0,map));    				
    			}
    			int k = map[i][j];
    			number = number*10+k;
    		}
    	}
    	
    	boolean finish = false;
    	hs.add(number);
    	
    	if(hs.contains(123456780)){
    		ans= 0;
    	}
    	else{
    	while(!q.isEmpty()){
    		n3 p = q.poll();
    		for(int i =0; i<4; i++){
    			int x= p.x+dx[i];
    			int y = p.y+dy[i];
    			int cnt = p.cnt;
    			int m[][] = new int [n+1][n+1];
    			for(int a =1 ; a<=n; a++){
    				for(int b=1;b<=n; b++){
    					m[a][b] = p.m[a][b]; 
    				}
    			}
    			
    		 if(x>=1 && y>=1 && x<=n && y<=n){
    			 int temp = m[x][y];
    			 m[x][y] = m[p.x][p.y];
    			 m[p.x][p.y] = temp;
    			 int num =0;
    			 for(int a =1 ; a<=n; a++){
     				for(int b=1;b<=n; b++){
     					int k = m[a][b];
     					num = num*10+k;
     				}
     			 }
    			 
    			 if(!hs.contains(num)){
    				 hs.add(num);
    				 q.offer(new n3(x,y,cnt+1,m));
    			 }
    			 if(hs.contains(123456780)){
    				 ans = cnt+1;
    				 finish = true;
    				 break;
    			 }
    			 
    		  }
    		 
    		}
    		if(finish == true){
    			break;
    		}
    	 }
    	
    	    if(finish==false){
    		   ans =-1;
        	}
    	    
    	}
    	
    	
    	
    	
    	bw.write(Integer.toString(ans));
    	bf.close();
    	bw.close();
    }
    
}
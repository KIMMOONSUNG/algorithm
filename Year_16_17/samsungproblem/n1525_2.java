package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class c1525{
	int x, y,cnt;
	int m[][];
	c1525(int x, int y,int cnt,int m[][]){
		this.x =x ;
		this.y = y;
		this.cnt = cnt;
		this.m = m;
	}
}

public class n1525_2 {
	static final int n = 3;
	static int map [][];
	static int result[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int ex = 2, ey=2;
	static boolean finish;
	static int ans= 1000000;
	static Queue<c1525> q ;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	map = new int[n][n];
	result = new int[n][n];
	StringTokenizer st ;
	int sx=0;
	int sy=0;
	int count=1;
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++){
			if(count==9){
				count=0;
			}
			result[i][j] = count;
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j] ==0){
				sx = i;
				sy = j;
			}
			count++;
		}
	}
	int c=0;
	HashSet<Integer> hs = new HashSet<>();
     q= new LinkedList<>();
    for(int i =0; i<n; i++){
    	for(int j=0; j<n; j++){
    	    int k = map[i][j];
    	  c = c*10+k;  
    	}
    }
    hs.add(c);
    
    if(hs.contains(123456780)){
    	System.out.println(0);
    }
    else{
    q.offer(new c1525(sx,sy,0,map));
	 
    while(!q.isEmpty()){
    	c1525 p = q.poll();
    	int x = 0;
    	int y =0;
        for(int i =0; i<4; i++){

        	 x =p.x+dx[i];
        	 y =p.y+dy[i];
        	int cnt = p.cnt;
        	int arr [][] = new int[n][n];
        	for(int k =0; k<n; k++){
        		for(int j=0; j<n; j++){
        			arr[k][j] = p.m[k][j];
        		}
        	}
        	
        	if(x>=0 && y>=0 && x<n && y<n){
        	    int temp = arr[x][y];
        	    arr[x][y] = arr[p.x][p.y];
        	    arr[p.x][p.y] = temp;
        	    
        	    int h =0;
        		for(int k=0; k<n; k++){
        			for(int j=0; j<n; j++){
        				int tt = arr[k][j];
        				h = h *10 +tt;
        			}
        		}
        		
        		if(!hs.contains(h)){
        			hs.add(h);
        			q.offer(new c1525(x,y,cnt+1,arr));
        		}
        		if(hs.contains(123456780)){
        			
        			finish = true;
        			ans = Math.min(ans, cnt+1);
        		}
        	}
        	
        }
    }
    
    if(finish == true){
    	System.out.println(ans);
    }
    else{
    	System.out.println(-1);
    }
    }	
	
 }

}

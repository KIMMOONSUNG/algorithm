package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_1857{
	int x,y;
	long cnt,dist;
	n_1857(int x, int y, long cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class n1857 {
	static int n;
	static int m;
	static int map[][];
	
	static boolean c[][];
	static int dx[]= {-1,1, -1,1 ,  2,2,  -2,-2};
	static int dy[]= {2 ,2, -2,-2, -1,1,  -1,1 };
	static int min = 1000000;
	static long d[][];
	static ArrayList<n_1857> al [][] ;
	static Queue<n_1857> q;
 public static void main(String[] args) throws IOException {

	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int [n][m];
	c = new boolean[n][m];
	d = new long[n][m];
	al = new ArrayList[n][m];
	
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j] == 3){
				q.offer(new n_1857(i,j,0));
				
			}
		}
	}
	int sx=0,sy=0;
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			if(map[i][j] !=2){
				func(i,j);
			}
			if(map[i][j] == 3){
				sx = i;
				sy = j;
			}
		}
	}
	
	for(int i =0; i<n; i++){
	  Arrays.fill(d[i], -1);
	}
	d[sx][sy] = 0;
	q = new LinkedList<>();
	q.offer(new n_1857(sx,sy,0));
	while(!q.isEmpty()){
		n_1857 p = q.poll();
		
	}
}
 
 static void func(int sx, int sy){
	 for(int i =0; i<n; i++){
		 Arrays.fill(c[i], false);
	 }
	 q = new LinkedList<>();
	 q.offer(new n_1857(sx,sy,0));
	 
	 while(!q.isEmpty()){
		 n_1857 p = q.poll();
		 if(map[p.x][p.y]!=1 && !(sx==p.x && sy==p.y)){
			 al[sx][sy].add(new n_1857(p.x,p.y,0));
		 }
		 else{
			 
		  for(int i =0; i<8; i++){
			 int x = p.x+dx[i];
			 int y= p.y+dy[i];
			 if(x>=0 && y>=0 && x<n && y<m){				 
				 if(c[x][y] ==false){
					 c[x][y] = true;
					 if(map[x][y] !=2){
						 q.offer(new n_1857(x,y,0));
					 }
				 }
			 }
		  }
		  
		 }
	 }
	 
 }

}

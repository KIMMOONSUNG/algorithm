package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2468 { //안전영역 DFS 
	static int n;
	static int map[][];
	static int d[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static boolean visit[][];
	static int count;
	static int max=-999;
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map = new int [n][n];
	d = new int[n][n];
	visit = new boolean[n][n];
	StringTokenizer st;
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			d[i][j] = map[i][j];
		}
	}
	mm();
System.out.println(max);

 }
 static void mm(){
	 int k =0;
	 for(int t =0 ; t<101; t++){
		 
		 for(int i =0; i<n; i++){
			 for(int j=0; j<n; j++){
				 d[i][j] = map[i][j];
			 }
		 }
		 count =0 ;
		 visit = new boolean[n][n];
		 if(map[0][0] <=k){
			 d[0][0] =101;
		 }
	     func(0,0,k);
	     k++;
	     for(int i =0; i<n; i++){
	    	for(int j=0; j<n; j++){
	    		if(d[i][j] !=101){
	    			d[i][j] = 101;
	    			count++;
	    			func2(i,j);
	    		}
	    	}
	    	
	    }
	    
	     max = Math.max(count, max);
	     
	     
	 }
 }
 
 static void func(int a, int b,int c){
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<n){
			if(visit[x][y] == false){
				visit[x][y] = true;
				if(d[x][y] <=c){
					d[x][y] =101;
				}
				func(x,y,c);
			}
		 }
	 }
 }
 
 static void func2(int a, int b){
	for(int i =0; i<4; i++){
		int x = a+dx[i];
		int y =b+dy[i];
		if(x>=0 && y>=0 && x<n && y<n){
			if(d[x][y] !=101){
				d[x][y] = 101;
				func2(x,y);
			}
		}
	}
 }
 
}

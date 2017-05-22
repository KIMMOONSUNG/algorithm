package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S5913 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static final int n = 5;
	static final int m = 5;
	static int k ;
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int count=0;
	
	
 public static void main(String[] args) throws IOException{
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	k = Integer.parseInt(bf.readLine());
	visit = new boolean[n+1][m+1];	
	for(int i =0; i<k; i++){
	 st = new StringTokenizer(bf.readLine());
	 int a = Integer.parseInt(st.nextToken());
	 int b = Integer.parseInt(st.nextToken());
	 visit[a][b] = true;
	}
	visit[1][1] = true;
	visit[5][5] = true;
	dfs(1,1,5,5);
	bw.write(Integer.toString(count));
	bf.close();
	bw.close();
 }
 static void dfs(int ax, int ay, int bx, int by){
	 for(int i=0; i<4; i++){
		 int x = ax+dx[i];
		 int y = ay+dy[i];
		 if(x>=1 && y>=1 && x<=n && y<=m){
			 if(visit[x][y] == false){
			
				 visit[x][y] =true;
				 for(int i2 =0; i2<4; i2++){
					 int x2= bx+dx[i2];
					 int y2= by+dy[i2];
					 if(x2>=1 && y2>=1 && x2<=n && y2<=m){
						 if(x==x2 && y==y2){
							 boolean check =false;
							 for(int k =1; k<=n; k++){
								 for(int j=1; j<=m; j++){
									 if(visit[k][j] == false){
										 check= true;
									 }
								 }
							 }
							 if(check==false){
							     count++;
							     visit[x][y] = false;
								 return;
							 } 
							 
						 }
						 if(visit[x2][y2]==false){
							 visit[x2][y2]=true;
							 dfs(x,y,x2,y2);
							 visit[x2][y2]=false;
						 }
					 }
				 }
				 visit[x][y] = false;
			 }
			 
		 }
	 }
 }
}

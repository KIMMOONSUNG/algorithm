package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3109_backtracking { // 빵집  -> 방향 순서 중요 
	static int n;
	static int m;
	static char map[][];
	static boolean visit[][];
	static int dx[] = {-1,0,1}; // 순서가 중요 오른쪽위 대각선, 오른쪽 , 오른쪽아래 대각선 !!
	static int dy[] = {1,1,1};
	static int result =0;
	static boolean finish;
 public static void main(String[] args) throws IOException{
	 
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
    map= new char [n][m];
    visit = new boolean[n][m];
    for(int i =0; i<n; i++){
    	String str= bf.readLine();
    	for(int j =0; j<m; j++){
    		map[i][j] = str.charAt(j);
    	}
    }
    
   for(int i =0; i<n; i++){
    	/*
	   if(dfs(i,0)==true){
    		result++;
    	}
    	*/
	   finish = false;
	   func(i,0);
	   if(finish == true){
		   result ++;
	   }
   }
    
    System.out.println(result);
}
 /*
 static boolean dfs(int x,int y) {
	 
     visit[x][y]=true;
     if(y==m-1) return true;
     for(int i=0;i<3;++i){
         int nx=x+dx[i];
         int ny=y+dy[i];
         if(nx<0||nx>=n||visit[nx][ny]||map[nx][ny]=='x') continue;
         if(dfs(nx,ny)) return true;
     }
     return false;

 }*/
 static void func(int a, int b){
	 if(b==m-1){
		 finish = true;
		 return;
	 }
	 for(int i =0; i<3; i++){
		 int x= a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && x<n){
			 if(visit[x][y] == false && map[x][y] !='x'){
				 visit[x][y] = true;
				 func(x,y);
			 }
		 }
		 if(finish==true){
			 return;
		 }
	 }
 }


}

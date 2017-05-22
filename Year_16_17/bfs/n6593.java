package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_6593{
	int h, x, y, cnt;
	n_6593(int h, int x, int y, int cnt){
		this.h = h;
		this.x = x;
		this.y= y;
		this.cnt = cnt;
	}
}

public class n6593 { // 상범빌딩 ! ->> 토마토보다 쉬움 
	static int dx[] = {0,0,1,-1,0,0};
	static int dy[] = {1,-1,0,0,0,0};
	static int dh[] = {0,0,0,0,1,-1};
 public static void main(String[] args) throws IOException{
	 BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	 while(true){
		 
     StringTokenizer st=  new StringTokenizer(bf.readLine());
	 int L = Integer.parseInt(st.nextToken()); //층수 
	 int n = Integer.parseInt(st.nextToken()); 
	 int m = Integer.parseInt(st.nextToken());
	 if(L==0 && n==0 && m==0){
		 break;
	 }
	 char map [][][] = new char[L][n][m];
	 Queue<n_6593> q = new LinkedList<>();
	 boolean visited[][][] = new boolean [L][n][m];
	 for(int a=0; a<L; a++){
		 for(int i=0; i<n; i++){
			String str = bf.readLine();
			 for(int j =0; j<m; j++){
				map[a][i][j] = str.charAt(j);
				 if(map[a][i][j] == 'S'){
					 q.offer(new n_6593(a,i,j,0));
					 visited[a][i][j]=  true;
				 }
			 }
		 }
		String sss = bf.readLine(); // 빈
	 }
	 
	 boolean result = false;
	 while(!q.isEmpty()){
		 n_6593 p = q.poll();
		 if(map[p.h][p.x][p.y] == 'E'){
			 result = true;
			 System.out.println("Escaped in "+p.cnt+" minute(s).");
			 break;
		 }
		 for(int i =0; i<6; i++){
			 int h = p.h+dh[i];
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 int cnt = p.cnt;
			 if(x>=0 &&y>=0 && x<n && y<m && h>=0 && h<L && map[h][x][y]!='#'){
				 if(visited[h][x][y] == false){
					 visited[h][x][y] = true;
					 q.offer(new n_6593(h,x,y,cnt+1));
				 }
			 }
		 }
		 
	 }
	 
	 if(result == false){
		 System.out.println("Trapped!");
	 }
	
   }
 }
}

package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1520_2 { // 내리막길 -> 메모이제이션안하는 그냥 dfs방법임..
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int result ;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int [n][m];
		visit = new boolean[n][m];
		result =0;
		for(int i =0; i<n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j =0; j<m; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		func(0,0);
		visit[0][0] = true;
		System.out.println(result);
		
	}
   static void func(int a, int b){
	   if(a==n-1 && b==m-1){
		   result++;
		   return;
	   }
	   
	   for(int i =0; i<4; i++){
		   int x = a+dx[i];
		   int y = b+dy[i];
		   if(x>=0 && y>=0 && x<n && y<m &&(map[x][y] < map[a][b])){ //백트래킹 핵심 부분 
			   if(visit[x][y] == false){ //
				   visit[x][y] = true;//
				   func(x,y);//
				   visit[x][y] = false;//
			   }
		   }
	   }
   }
}

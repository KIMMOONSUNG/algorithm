package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
class n_2583 {
	int x,y;
	n_2583(int x, int y){
		this.x =x ;
		this.y= y;
	}
}
public class n2583 { // 영역구하기 dfs 
	static int n;
	static int m;
	static int k;
	static int map[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int sx=0,sy=0,ex=0,ey=0;
	static int number=1;
	static int count =0;
	static boolean visit[][];
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
	map = new int [n][m];
	visit = new boolean[n][m];
	for(int i =0; i<k; i++){
		st = new StringTokenizer(bf.readLine());
		sy = Integer.parseInt(st.nextToken());
		sx = Integer.parseInt(st.nextToken());
		ey = Integer.parseInt(st.nextToken())-1;
		ex= Integer.parseInt(st.nextToken())-1;
	    map[sx][sy] = 1;
	    visit = new boolean[n+1][m+1];
         func(sx,sy);
         
	}
	
	int ans [] = new int[1002];
	Arrays.fill(ans, 1000000);
	StringBuilder sb = new StringBuilder();
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			if(map[i][j] ==0){
				count=0;
				map[i][j] = number;
				count++;
				func2(i,j);
				ans[number-1] = count;
				number++;
			}
		}
	}
	
	Arrays.sort(ans);
	System.out.println(number-1);
	for(int i =0; i<1002; i++){
		if(ans[i]==1000000){
			break;
		}
		else{
			sb.append(ans[i]+" ");
		}
	}
	
	System.out.println(sb.toString());
	
}
 
 static void func(int a, int b) {
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=sx && y>=sy && x<=ex && y<=ey){
			 if(visit[x][y] == false){
				 visit[x][y] = true;
			  if(map[x][y] ==0 ){
				 map[x][y] = 1;
			  }
			 func(x,y);
			 }
		 }
	 }
 }
 
 static void func2(int a, int b) {
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 if(map[x][y] == 0){
				 map[x][y] = number;
				 count++;
				 func2(x,y);
			 }
		 }
	 }
 }
 
}

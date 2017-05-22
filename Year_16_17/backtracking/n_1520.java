package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_1520 { // 1890 이랑 비슷한 문제 
	static int n;
	static int m;
	static int map[][];
	static int num[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
 public static void main(String[] args) throws IOException{ // 내리막길
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int [n][m];
	num = new int [n][m];
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine().trim());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			num[i][j] = -1;
		}
	}
	System.out.println(func(0,0));
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			System.out.print(num[i][j]+"/");
		}
		System.out.println();
	}
 }
 
 static int func(int a, int b){
	 if(a==n-1 && b==m-1){
		 return 1;
	 }
     if(num[a][b] != -1){
    	 return num[a][b];
     }
     num[a][b] = 0; //0으로 초기화했었을때 필요없지만 -1로 초기화 했었으니 꼭 필요 
                   
		 for(int i =0; i<4; i++){
			 int x = a+dx[i];
			 int y = b+dy[i];
			 if(x>=0 && y>=0 && x<n && y<m && map[x][y] <map[a][b] ){
				 
				  num[a][b]+=func(x,y);
				 
			 }
		 }
	
	 return num[a][b];
 }
 
 
}

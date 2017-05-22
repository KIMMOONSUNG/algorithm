package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G1189 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static int k;
	static boolean visit[][];
	static int dx[] ={0,0,1,-1};
	static int dy[] ={1,-1,0,0};
	static int count;
 public static void main(String[] args) throws IOException{
	 bf= new BufferedReader(new InputStreamReader(System.in));
	 bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 st = new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 k = Integer.parseInt(st.nextToken());
	 visit = new boolean[n+1][m+1];
	 for(int i =1; i<=n; i++){
		 String str= bf.readLine();
		 for(int j=1; j<=m; j++){
			 if(str.charAt(j-1)=='T'){
				 visit[i][j] = true;
			 }
		 }
	 }
	visit[n][1] = true;
	func(n,1,1);
	bw.write(Integer.toString(count));
	bf.close();
	bw.close();
}
 static void func(int a, int b,int cnt){
	 if(a==1 && b==m && cnt==k){
		 count++;
		 return;
	 }
	for(int i =0; i<4; i++){
		int x = a+dx[i];
		int y =b+dy[i];
		if(x>=1 && y>=1 && x<=n && y<=m){
			if(visit[x][y] ==false){
				visit[x][y]= true;
				func(x,y,cnt+1);
				visit[x][y] = false;
			}
		}
	}
 }
}

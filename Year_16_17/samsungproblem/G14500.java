package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G14500 { //삼성전자 푼방법
	static BufferedReader bf ;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int result =0;
	static int result2= 0;
 public static void main(String[] args) throws IOException{
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n][m];
	visit=  new boolean[n][m];
	
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	for(int i =0; i<n; i++) {
		for(int j =0; j<m; j++) {
			visit[i][j] = true;
			func(i,j,1,map[i][j]);
			func2(i,j,map[i][j],1);
			visit[i][j] = false;
		}
	}
	
	result = Math.max(result2,result);
	bw.write(Integer.toString(result));
	bf.close();
	bw.close();
 }
 
 static void func(int a, int b, int count , int sum) {

	 if(count >=4){
		 result = Math.max(result, sum);
		 return;
	 }
	 
   for(int i =0; i<4; i++){
	  int x= a+dx[i];
	  int y= b+dy[i];
	  if(x>=0 && y>=0 && x<n && y<m){
		  if(visit[x][y] ==false){
			  visit[x][y] = true;
			  func(x,y,count+1,sum+map[x][y]);
			  visit[x][y] = false;
		  }
	  }
   }
   
 }
 
 static void func2(int a, int b,int sum,int count){
	 int ans = sum;
	 int cnt = count;
	 for(int i =0; i<4; i++){
		 if(i==0){
			 continue;
		 }
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 ans += map[x][y];
			 cnt++;
		 }
		 if(cnt==4){
			 result2 = Math.max(result2, ans);
		 }
	 }
	 ans = sum;
	 cnt = count;
	 for(int i =0; i<4; i++){
		 if(i==1){
			 continue;
		 }
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 ans += map[x][y];
			 cnt++;
		 }
		 if(cnt==4){
			 result2 = Math.max(result2, ans);
		 }
	 }
	 ans = sum;
	 cnt = count;
	 for(int i =0; i<4; i++){
		 if(i==2){
			 continue;
		 }
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 ans += map[x][y];
			 cnt++;
		 }
		 if(cnt==4){
			 result2 = Math.max(result2, ans);
		 }
	 }
	 ans = sum;
	 cnt = count;
	 for(int i =0; i<4; i++){
		 if(i==3){
			 continue;
		 }
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 ans += map[x][y];
			 cnt++;
		 }
		 if(cnt==4){
			 result2 = Math.max(result2, ans);
		 }
	 }
	 
 }
 
}

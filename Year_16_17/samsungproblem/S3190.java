package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3190 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int k;
	static int L;
	static int map[][];
	static int mapcnt[][];
	static boolean visit[][][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int result =0;
	static class ss{
		int x, y,cnt,dir,num;
		ss(int x, int y, int cnt , int dir ,int num){
			this.x = x;
			this.y =y ;
			this.cnt = cnt;
			this.dir = dir;
			this.num = num;
		}
	}
 public static void main(String[] args) throws IOException{
	 bf = new BufferedReader(new InputStreamReader(System.in));
	 bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 n = Integer.parseInt(bf.readLine());
	 map = new int[n][n];
	 mapcnt = new int[n][n];
	 k = Integer.parseInt(bf.readLine());
	 
	 for(int i =0; i<k; i++){
		 st = new StringTokenizer(bf.readLine());
		 int a= Integer.parseInt(st.nextToken());
		 int b= Integer.parseInt(st.nextToken());
		 map[a-1][b-1] = 1;
	 }
	 L = Integer.parseInt(bf.readLine());
	 Queue<ss> q = new LinkedList<>();
	 q.offer(new ss(0,0,1,0,0));
	 int order[]= new int[10001];
	 for(int i=0; i<L; i++){
		 st = new StringTokenizer(bf.readLine());
		 int time = Integer.parseInt(st.nextToken());
		 String dir = st.nextToken();
		 if(dir.equals("L")){
		  order[time] = 1;
		 }
		 else if(dir.equals("D")){
			 order[time] =2;
		 }
	 }
	 mapcnt[0][0] = 1;
	 while(!q.isEmpty()){
		 ss p = q.poll();
		 int cnt = p.cnt;
		 int dir = p.dir;
		 int num =p.num;
		 int x=p.x+dx[dir];
		 int y=p.y+dy[dir];
		 if(x>=0 && y>=0  && x<n && y<n){
			 if( mapcnt[x][y]>= (cnt)-num ){
				 result = cnt;
				 break;
			 }
			 if(order[cnt]!=0){
				 dir = func(dir,order[cnt]);
			 }
			 if(map[x][y] ==1){
				 map[x][y] =0;
				 num = num+1;
			 }
			 mapcnt[x][y] = cnt+1;
			 q.offer(new ss(x,y,cnt+1,dir,num));
		 }
		 else{ // 끝 
			result = cnt;
			 break;
		 }
	 }
	 bw.write(Integer.toString(result));
	 bf.close();
	 bw.close();
	 
	 
  }
 static int func(int dir, int k){
	 if(dir==0){
		 if(k==2){
			 return 2;
		 }
		 else if(k==1){
			 return 3;
		 }
		 else return -999;
	 }
	 else if(dir==1){
		 if(k==2){
			 return 3;
		 }
		 else if(k==1){
			 return 2;
		 }
		 else return -999;
	 }
	 else if(dir==2){
		 if(k==2){
			 return 1;
		 }
		 else if(k==1){
			 return 0;
		 }
		 else return -999;
	 }
	 else if(dir==3){
		 if(k==2){
			 return 0;
		 }
		 else if(k==1){
			 return 1;
		 }
		 else return -999;
	 }
	 else{
		 return -9999;
	 }
 }
}

package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S14499 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static int sx;
	static int sy;
	static int k;
	static int arr[][] ;
	static int dx[] = {0,0,0,-1,1};
	static int dy[] = {0,1,-1,0,0};
	static int rl[] = new int[4];
	static int ud[] = new int[4];
 public static void main(String[] args) throws IOException {
	 
	 bf = new BufferedReader(new InputStreamReader(System.in));
	 bw = new BufferedWriter(new OutputStreamWriter(System.out));
	 st = new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 sx = Integer.parseInt(st.nextToken());
	 sy = Integer.parseInt(st.nextToken());
	 k = Integer.parseInt(st.nextToken());	 
	 arr = new int[n][m];
	 for(int i =0; i<n; i++){
		 st = new StringTokenizer(bf.readLine());
		 for(int j =0; j<m; j++){
			 arr[i][j] =  Integer.parseInt(st.nextToken());
		 }
	 }
	 
	 Queue<Integer> order = new LinkedList<>();
	 
	 st = new StringTokenizer(bf.readLine());
	 for(int i=0; i<k; i++){
		 int dir = Integer.parseInt(st.nextToken());
		order.offer(dir);
	 }
     
	 while(!order.isEmpty()) {
		 
		 int p = order.poll(); 
		 sx= sx+dx[p];
		 sy = sy+dy[p];
		 if(sx>=0 && sy>=0 && sx<n && sy<m){
			 
			 func(p);
			 
			 if(arr[sx][sy]==0){ // 0이면 주사위 밑면이복사
				 if(p==1 || p==2){
					 arr[sx][sy] = rl[3];
				 }
				 
				 else{
					 arr[sx][sy] = ud[3];
				 }
				 
			 }
			 else if(arr[sx][sy]!=0){ // 바닥면이 주사위에 복사 
				 if(p==1 || p==2){
					 rl[3] = arr[sx][sy];
					 
				 }
				 else{
					 ud[3] = arr[sx][sy];
					 
				 }
				 arr[sx][sy] = 0; //바닥면은 0 이된다 
			 }
			 
			 if(p==1 || p==2){
				 ud[1] = rl[1];
				 ud[3] = rl[3];
			 }
			 
			 else if (p==3 || p==4){
				 rl[1] = ud[1];
				 rl[3] = ud[3];
			 }
			 
			 bw.write(Integer.toString(ud[1])+"\n");
		 }
		 
		 else{ // 그렇지않은경우 안가야함 
			 sx =sx-dx[p];
			 sy = sy-dy[p];
		 }
	 }
	 
	 bw.close();
	 bf.close();
	 
 }
 
 static void func(int dir){
	 
	 if(dir==1){ // 동  
		 int mid = rl[1];
		 int mid2= rl[2];
		 int last = rl[3];
		 rl[1] = rl[0];
		 rl[2] = mid;
		 rl[3] = mid2;
		 rl[0] = last;
	 }
	 else if(dir==2){ // 서 
		 int mid = rl[2];
		 int mid2= rl[1];
		 int last = rl[0];
		 rl[2] = rl[3] ;
		 rl[1] = mid;
		 rl[0] = mid2;
		 rl[3] = last;
	 }
	 else if(dir==3){ // 북 
		 int mid = ud[2];
		 int mid2= ud[1];
		 int last = ud[0];
		 ud[2] = ud[3];
		 ud[1] = mid;
		 ud[0] = mid2;
		 ud[3] = last;
	 }
	 else if(dir==4){// 남
		 int mid = ud[1];
		 int mid2= ud[2];
		 int last = ud[3];
		 ud[1] = ud[0];
		 ud[2] = mid;
		 ud[3] = mid2;
		 ud[0] = last;
		 
	 }
 }
 
}

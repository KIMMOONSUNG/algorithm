package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1890 { // 점프 
	static int n ;
	static long d[][];
	static int map[][];
	static int dx[] = {0,1};
	static int dy[] = {1,0};
	
 public static void main(String[] args) throws IOException{
	 BufferedReader bf= new BufferedReader(new InputStreamReader((System.in)));
	 n = Integer.parseInt(bf.readLine());
	 map = new int[n][n];
	 d = new long[n][n];
	 StringTokenizer st;
	 for(int i =0; i<n; i++){
		 st = new StringTokenizer(bf.readLine());
		 for(int j =0; j<n; j++){
			 map[i][j]= Integer.parseInt(st.nextToken());
		 }
	 }
	System.out.println(func(0,0));
}
 
 static long func(int a , int b){
	 if(map[a][b]==0 && a==n-1 && b==n-1){ // 도착 
		 return 1;
	 }
	 else if(map[a][b]==0){ // 진행막아 
		 return 0;
	 }
	 if(d[a][b]==0){ // 간적 없는 곳 
	  for(int i =0; i<2; i++){
		  //  칸만큼 점프 
		 int x = a+ dx[i]*map[a][b];
		 int y = b+ dy[i]*map[a][b]; 
		 
		 if(x>=0 && y>=0 && x<n && y<n ){

				 d[a][b] += func(x,y);
		 }
	  }
	 }
	 
	 // d[a][b] !=0 ->>> 경로가 저장되있는 곳 (갔던 곳)
	 
	 return d[a][b]; // -> 리턴 
 }
 
}

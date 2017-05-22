package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class N_2146{
	int x , y , len;
	N_2146(int x, int y , int len){
		this.x = x;
		this.y = y;
		this.len = len;
	}
}
public class N2146 { // 다리만들기 
	static int n ;
	static int map[][];
	static int mapcnt[][];
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int cnt =2;
	
 public static void main(String[] args) throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 n = Integer.parseInt(bf.readLine());
	 map = new int [n][n];
	 visit = new boolean [n][n];
	 for(int i =0; i<n; i++){
		 StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		 for(int j =0; j<n; j++){
			 map[i][j] = Integer.parseInt(st.nextToken());
		 }
	 }
	 for(int i =0; i<n; i++){
		 for(int j =0; j<n; j++){
			 if(map[i][j] == 1){
				 mapcount(i,j);
				 cnt ++;
			 }
		 }
	 }
	 
	 int result =99999999;
	 
	 for(int i =0; i<n; i++){
		 for(int j =0; j<n; j++){
			 if(map[i][j]!=0 ){
				 for(int k=0; k<4; k++){
					 int x = i+dx[k];
					 int y = j+dy[k];
					 if(x>=0 && y>=0 && x<n && y<n && map[x][y] == 0){
			           result = Math.min(result, minlength(i,j,map[i][j]));
                       //break -> break 안거는게 에러안남 
					 }
				 }
			 }
		 }
	 }

	 
	 
	 System.out.println(result);
 
}
 
 static void mapcount(int a, int b){ // 섬 구분 
     visit = new boolean[n][n];
	 Queue<N_2146> q = new LinkedList<N_2146>();
	 q.offer(new N_2146(a,b,0));
	 visit[a][b] = true;
	 map[a][b] = cnt;
	 while(!q.isEmpty()){
		 N_2146 p = q.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 if(x>=0 && y>=0 && x<n && y<n && map[x][y] ==1 && visit[x][y] == false){
	
				 visit[x][y] = true;
				 map[x][y]= cnt;
				 q.offer(new N_2146(x,y,0));
			 }
		 }
	 }
 }
 
 static int minlength(int a, int b , int num){ // 옆에 0 이 있다면 호출 
	 int number = num;
	 visit = new boolean[n][n];
	 Queue<N_2146> q = new LinkedList<N_2146>();
	 q.offer(new N_2146(a,b,0));
	 visit[a][b] = true;
	 while(!q.isEmpty()){
		 N_2146 p = q.poll();
		 
		 for(int i =0; i<4 ; i++){
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 int len = p.len;
			 if(x>=0 && y>=0 && x<n && y<n && visit[x][y] == false && map[x][y]!=number){
				 visit[x][y] = true;
				 q.offer(new N_2146(x,y,len+1));
				 
				 if(map[x][y] !=0 && map[x][y] !=number){
					 return len;
				 }
			 }
			 
		 }
	 }
	 return 999999999; // 최대로설정해야함 !
 }
 
}

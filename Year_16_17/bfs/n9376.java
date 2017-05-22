package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class n_9376{
	int x,y,cnt;
	n_9376(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}

public class n9376 { // 탈옥 
	static int n;
	static int m;
	static char map[][];
	static int d[][][]; // 0 -> 바깥 // 1-> 죄수 1 //2 -> 죄수 2 
	static boolean visit[][];
	static ArrayDeque<n_9376> ad ;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	StringTokenizer st; 
	for(int t=  1; t<=testcase ; t++){
	 st= new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 map = new char[n+2][m+2];
	 d = new int [3][n+2][m+2];
	 String str ="";
	 for(int i =0; i<n+2; i++){
		 if(i!=0 && i!=n+1){
			 str = bf.readLine();
		 }
		 for(int j =0; j<m+2; j++){
			 if(i!=0 && i!=n+1){
				 if(j!=0 && j!=m+1){
					 map[i][j] = str.charAt(j-1);
				 }
				 else{
					 map[i][j] = '.';
				 }
			 }
			 else{
				 map[i][j] = '.';
			 }
		 }
	 }
	 ad= new ArrayDeque<>();
	 ad.offer(new n_9376(0,0,0));
	 int k =0;
	 func(k++);
	 
	 boolean first = false;
	 for(int i =0; i<n+2; i++){
		 for(int j =0; j<m+2; j++){
			 if(map[i][j] == '$'){
				 if(first == false){
					 first = true;
					 ad.offer(new n_9376(i,j,0)); // 죄수 1
					 func(k++);
				 }
				 else{
					 ad.offer(new n_9376(i,j,0)); // 죄수 2
					 func(k++);
				 }
			 }
		 }
	 }
	 int ans = 10000000;
	 for(int i =0; i<n+2; i++){
		 for(int j =0; j<m+2; j++){
			 if(map[i][j] =='*'){
				 continue;
			 }
			 int cur = d[0][i][j]+d[1][i][j]+d[2][i][j]; //만나는 점 카운트 다 더해
			 if(map[i][j] == '#'){ // 셋이서 만나는 점이 벽이라면  온길 2개는 뺴줘야하니 
				 cur -=2;
			 }
			 if(ans >cur){ 
				 ans = cur;
			 }
		 }
	 }
	 System.out.println(ans);
	 
	 
	
	}
 }
 
 static void func(int num){
	 visit = new boolean[n+2][m+2];
	 while(!ad.isEmpty()){
		 n_9376 p = ad.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x+dx[i];
			 int y = p.y+dy[i];
			 int cnt = p.cnt;
			 if(x>=0 & y>=0 && x<n+2 && y<m+2 && map[x][y] !='*'){
				 if(visit[x][y] == false){
					 visit[x][y] = true;
					 if(map[x][y] == '#'){
						 ad.addLast(new n_9376(x,y,cnt+1));
						 d[num][x][y] = cnt+1;
					 }
					 else{
						 ad.addFirst(new n_9376(x,y,cnt));
						 d[num][x][y] = cnt;
					 }
				 }
			 }
		 }
	 }
 }
 
}

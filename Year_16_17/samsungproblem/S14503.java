package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class S14503 {
	static BufferedReader bf;
	static BufferedWriter bw;
	static StringTokenizer st;
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][];
	static int sx,sy,sdir;
	static int result =0;
	static boolean finish ;
	
	static int dx[] = {-1,0,1,0}; // 북 동 남 서 
	static int dy[] = {0,1,0,-1};
	// 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. 
	// d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽바라 봄 
	
	static class SSS{
		int x,y,dir,clean;
		SSS(int x, int y, int dir, int clean){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.clean = clean;
			
		}
	}
	
 public static void main(String[] args) throws IOException{
	 
	bf = new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int[n+1][m+1];
	visit=  new boolean[n+1][m+1];
	
	st = new StringTokenizer(bf.readLine());
	
	sx = Integer.parseInt(st.nextToken())+1; // 벽 빼고 시작위치를 세야함 ㅅㅂ 
	sy = Integer.parseInt(st.nextToken())+1;
	sdir = Integer.parseInt(st.nextToken());
	
	for(int i =1; i<=n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =1; j<=m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	
	/*
	1) 현재 위치를 청소한다.
	2) 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
	   1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	   2. 왼쪽 방향에 청소할 방향이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	   3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	   4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
	   
	   //로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
	   
	*/
	
	//bfs 
	/*
    Queue<SSS> q=  new LinkedList<>();
    q.offer(new SSS(sx,sy,sdir,1));
	visit[sx][sy] = true;	
	
	while(!q.isEmpty()) {
		
		SSS p = q.poll();
		boolean check = false;
		int d = p.dir;
		for(int i =0; i<4; i++) { //4방향 check
			d = left(d);
			int x = p.x+dx[d];
			int y= p.y+dy[d];
			
			if(visit[x][y]==false && map[x][y]==0) {
				visit[x][y] = true;
				q.offer(new SSS(x,y,d,(p.clean+1)));
			    check = true;
			    break;
			}
			
		}
		
		if(check==false){
		  	d = reverse(p.dir);
		  	int x= p.x+dx[d];
		  	int y= p.y+dy[d];
		  	if(map[x][y]==0) { // 후방이 벽이아닐때 
		  		q.offer(new SSS(x,y,p.dir,(p.clean))); 
		  	}
		  	else if(map[x][y]==1){ // 후방이 벽일때 
		  		finish = true;
		  		result = p.clean;
		  		break;
		  	}
		}

	}
	*/
	
	//dfs
	visit[sx][sy] = true;
	dfs(sx,sy,sdir,1);
	
	String ans = Integer.toString(result);
	bw.write(ans);
	bf.close();
	bw.close();
	
	
 }
 
 /*
	1) 현재 위치를 청소한다.
	2) 현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
	   1. 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
	   2. 왼쪽 방향에 청소할 방향이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
	   3. 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
	   4. 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
	   
	   //로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
	   
	*/
 
 static void dfs(int a, int b, int dir, int cnt ) {
	 if(finish==true){
		 return;
	 }
	 
	int d = dir;
	boolean check = false;
	for(int i =0; i<4; i++){
		d= left(d);
		int x= a+dx[d];
		int y= b+dy[d];
		if(map[x][y] == 0 && visit[x][y] == false){
			visit[x][y] = true;
			check = true;
			dfs(x,y,d,cnt+1);
			break;
		}
	}
   
	if(check == true){
		return;
	}
     
	else if(check == false){
		d = reverse(dir);
		int x= a+dx[d];
		int y= b+dy[d];
		if(map[x][y] ==0){
			dfs(x,y,dir,cnt);
		}
		else if(map[x][y] ==1){
			result = cnt;
			finish = true;
			return;
		}
	}
	
 }
 
 static int left(int dir){
	 
	 //왼쪽 회전 
	 if(dir==0){ //북 
		 return 3; // 서 
	 }
	 else if(dir==1){ //동 
		return 0; // 북 
	 }
	 else if(dir==2){ // 남 
		 return 1; // 동 
	 }
	 else if(dir==3){ // 서 
		 return 2; // 남 
	 }
	 else{
		 return -9999;
	 }
	 
 }
 
 static int reverse(int dir){ //후진 
	 
	  if(dir==0){
		   return 2;
	  }
	  else if(dir==1){
		  return 3;
	  }
	  else if(dir==2){
		  return 0;
	  }
	  else if(dir==3){
		  return 1;
	  }
	  else{
		  return -999;
	  }
	  
 }
 
}

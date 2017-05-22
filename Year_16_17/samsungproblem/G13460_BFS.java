package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
package 삼성 ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class practice { // 13460 bfs 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=  new StringTokenizer(bf.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Pair balls = null;
		balls = new Pair(0,0,0,0,1,0);
		int ox = 0,oy = 0;
		char[][] map = new char[n+3][m+3];
		for(int i = 1; i < n+1; i++){
			char[] arr = bf.readLine().toCharArray();
			for(int j = 1; j < m+1; j++){
				map[i][j] = arr[j-1];
				if(map[i][j] == 'R'){
					balls.rx = i;
					balls.ry = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'B'){
					balls.bx = i;
					balls.by = j;
					map[i][j] = '.';
				}else if(map[i][j] == 'O'){
					ox = i;
					oy = j;
					map[i][j] = '.';
				}
			}
		}
		
		int result = 0;
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int[][][][][] visited =  new int[n+2][m+2][n+2][m+2][5];
		Queue<Pair> q = new LinkedList<Pair>();
		q.add(balls);
		q.add(new Pair(balls.rx,balls.ry,balls.bx,balls.by,1,1));
		q.add(new Pair(balls.rx,balls.ry,balls.bx,balls.by,1,2));
		q.add(new Pair(balls.rx,balls.ry,balls.bx,balls.by,1,3));
		
		while(!q.isEmpty()){
			
			Pair p = q.poll();
			int rx = p.rx, ry = p.ry, bx = p.bx, by = p.by, count = p.count, dir = p.dir;
			if(visited[rx][ry][bx][by][dir] == 1) continue;
			visited[rx][ry][bx][by][dir] = 1;
			if((result > 0 && result < 11) || count>10 )break;
			
			int x1=rx,y1=ry,x2=bx,y2=by;
			int r=0,b=0;
			
			while(true){
				int nextRx = x1+dx[dir];
				int nextRy = y1+dy[dir];
				int nextBx = x2+dx[dir];
				int nextBy = y2+dy[dir];
				//빨간색공이 앞에 있는 경우
				if((dir == 0 && y1 > y2) || (dir == 1 && x1 > x2) || (dir == 2 && y1 < y2) || (dir == 3 && x1 < x2)){
					if(nextRx==ox && nextRy == oy ) {
						result = count;
						r++;
						x1 = n+1;
						y1 = m+1;
					}
					if(nextBx==ox && nextBy == oy){
						result = 0;
						b = -1;
						break;
					}
					if(map[nextRx][nextRy] != '.') r++;
					if(r == 0) {
						x1 = nextRx;
						y1 = nextRy;
					}
					
					if(map[nextBx][nextBy] != '.' || (nextBx == x1 && nextBy == y1) ) b++;
					if(b == 0){
						x2 = nextBx;
						y2 = nextBy;
					}
					
					if(r > 0 && b > 0) break;
				} else { //파란공이 앞에 있는 경우
					if(nextBx==ox && nextBy == oy){
						result = 0;
						b = -1;
						break;
					}
					if(nextRx==ox && nextRy == oy) {
						result = count;
						r++;
						x1 = n+1;
						y1 = m+1;
					}
					if(map[nextBx][nextBy] != '.') b++;
					if(b == 0){
						x2 = nextBx;
						y2 = nextBy;
					}
					if(map[nextRx][nextRy] != '.' || (nextRx == x2 && nextRy == y2)) r++;
					if(r == 0){
						x1 = nextRx;
						y1 = nextRy;
					}
				}
				if(r > 0 && b > 0) break; //두 공이 모두 멈춘경우
			}
			
			if(b == -1) continue; //파란공이 탈출한경우
			if(result == 0 ){
				count++;
				for(int i = 0; i < 4; i ++){
					if(dir != i) q.add(new Pair(x1,y1,x2,y2,count,i));
				}
				
			}
		}
		
		if(result == 0 ) result = -1;
		System.out.println(result);
		
	}

	static class Pair{
		int rx, ry, bx, by, count, dir;
		public Pair(int ra, int rb, int ba, int bb, int c, int d){
			rx = ra; ry = rb; bx = ba; by = bb; count = c; dir = d;
		}
	}
	
}

*/
class G6{ // 실패 
	int rx,ry,bx,by,count,dir;
	G6(int rx, int ry, int bx, int by, int count , int dir){
		this.rx = rx;
		this.ry = ry;
		this.bx = bx;
		this.by = by;
		this.count = count;
		this.dir = dir;
	}
}
public class G13460_BFS {
	static int n;
	static int m;
	static char map [][];
	static boolean visit[][][][][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int rx,ry,bx,by,ox,oy;
	
	static int result = 1000000 ;
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 map = new char[n][m];
	 visit= new boolean[n][m][n][m][5];
	 for(int i =0; i<n; i++){
		 String str=  bf.readLine();
		 for(int j =0; j<m; j++){
			 map[i][j] = str.charAt(j);
			 if(map[i][j] == 'R'){
				 rx = i;
				 ry = j;
				 map[i][j] = '.';
			 }
			 else if(map[i][j] == 'B'){
				 bx = i;
				 by = i;
				 map[i][j] = '.';
			 }
			 else if(map[i][j] == 'O'){
				 ox = i;
				 oy = j;
				 map[i][j] = '.';
			 }
		 }
	 }
	 
	 Queue<G6> q = new LinkedList<>();
	 q.offer(new G6(rx,ry,bx,by,1,0));
	 q.offer(new G6(rx,ry,bx,by,1,1));
	 q.offer(new G6(rx,ry,bx,by,1,2));
	 q.offer(new G6(rx,ry,bx,by,1,3));
	 boolean r = false;
	 boolean b = false;
	 boolean finish = false;
	 
	 int result = 0;
	 while(!q.isEmpty()){
		 
		 G6 p = q.poll();
		 if(finish == true){
			 break;
		 }
		 if(p.count>10){
			 break;
		 }
		 
		 for(int i =0; i<4; i++){
			 int rx1=p.rx,ry1=p.ry,bx1=p.bx,by1=p.by;
			 int count = p.count;
			 int dir = p.dir;
			 int rx=0,ry=0,bx=0,by=0;
			 boolean red =false;
			 boolean blue = false;
			
			 int r1 =0;
			 int b1 =0;
			 
			 for(int k=1; k<10; k++){
				 
				 rx = p.rx+dx[i]*k;
				 ry = p.ry+dy[i]*k;
				 bx = p.bx+dx[i]*k;
				 by = p.by+dy[i]*k;
				 
				 //빨간 공이 앞에 있는 경우 
				 if((i==0 && p.rx>p.bx) || (i==1 && p.rx<p.bx) || (i==2 && p.ry >p.by) || (i==3 && p.ry<p.by) ){
					 if(rx == ox && ry == oy){
						 result = count;
						 red = true;
						r1++;
					 }
					 if(bx == ox && by == oy){
						 result = 0;
						 blue=true;
						 break;
					 }
					 if(r1 == 0 && map[rx][ry]!='.'){
						 if(r1==0){
							 r1++;
							 rx1 = rx;
							 ry1 = ry;
						 }
					 }
					 if( map[bx][by]!='.' || (bx == rx1 && by == ry1)){
						 if(b1==0){
							 b1++;
							 bx1 = bx;
							 by1 = by;
						 }
					 }
					 if(r1>0 && b1>0){
						 break;
					 }
						 
				 }
				 // 파란공 앞에 있는 경우 
				 else{
					 if(bx == ox && by == oy){
						 result =0;
						 blue=true;
						 break;
					 }
					 
					 if(rx == ox && ry == oy){
						 result = count;
						 red = true;
						r1++;
					 }
					
					 if(b1==0 &&map[bx][by]!='.'){
						 if(b1==0){
							 b1++;
							 bx1 = bx;
							 by1 = by;
						 }
					 }
					 if(r1==0 && map[rx][ry]!='.' || (rx == bx1 && ry == by1)){
						 if(r1==0){
							 r1++;
							 rx1 = rx;
							 ry1 = ry;
						 }
					 }
					 if(r1>0 && b1>0){
						 break;
					 }
					 
				 }
				 
			 }
			 if(red==true && blue== true ){
				 finish= true;
			 }
			 if(visit[rx1][ry1][bx1][by1][dir]==false){
				 visit[rx1][ry1][bx1][by1][dir] = true;
				 q.offer(new G6(rx1,ry1,bx1,by1,(count+1),i));
			 }
			 
		 }
	 }
	 
	 if(result == 0){
		 result= -1;
	 }
	 System.out.println(result);
	
	 
}
 }

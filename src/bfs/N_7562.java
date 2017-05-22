package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n7562{
	int x;
	int y;
	int cnt;
  n7562(int x, int y, int cnt){
	  this.x = x;
	  this.y = y;
	  this.cnt = cnt;
  }
}

public class N_7562 {
	static int dx[] = {-2,-1, 1, 2,-2,-1,1,2};
	static int dy[] = {-1,-2,-2,-1, 1, 2,2,1};
	
 public static void main(String[] args) throws IOException{	 
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int testcase = Integer.parseInt(bf.readLine());
	testcase = Math.abs(testcase);
	for(int a =0; a<testcase; a++){
		int mapsize = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int sx = Integer.parseInt(st.nextToken());
		int sy = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(bf.readLine().trim());
		int ex = Integer.parseInt(st.nextToken());
		int ey = Integer.parseInt(st.nextToken());
		boolean visit[][] = new boolean[mapsize][mapsize];
		Queue<n7562> q = new LinkedList<n7562>();
		q.offer(new n7562(sx,sy,0));
		
		while(!q.isEmpty()){
			n7562 p = q.poll();
			if(p.x == ex && p.y == ey){
				System.out.println(p.cnt);
				break;
			}
			
			for(int i =0; i<8; i++){
				int x = p.x+dx[i];
				int y = p.y+dy[i];
				int cnt =p.cnt ;
				if(x>=0 && y>=0 && x<mapsize && y<mapsize && visit[x][y]==false){
				  visit[x][y] = true;
				  q.offer(new n7562(x,y,cnt+1));				  
				}
			}
			
		}
	
	}
 }
}

package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_7569{
	int x, y, h , len;
	n_7569(int x, int y , int h, int len){
		this.x = x;
		this.y = y ;
		this.h = h;
		this.len = len;
	}
}
public class n7569 { // 토마토 
	static int dx[] = {0,0,1,-1,0,0};
	static int dy[] = {1,-1,0,0,0,0};
	static int dh[] = {0,0,0,0,1,-1};
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int m = Integer.parseInt(st.nextToken());
	int n = Integer.parseInt(st.nextToken());
	int hh = Integer.parseInt(st.nextToken());
	int map[][][] = new int[n][m][hh];
	boolean visit[][][]= new boolean [n][m][hh];
	Queue<n_7569> q = new LinkedList<>();
	for(int a=0; a<hh; a++){
		for(int i=0; i<n; i++){
			st = new StringTokenizer(bf.readLine());
			for(int j =0;j <m; j++){
				map[i][j][a] = Integer.parseInt(st.nextToken());
				if(map[i][j][a] == 1){
					q.offer(new n_7569(i,j,a,0));
				}
			}
		}
	}
	int result =0 ;
	while(!q.isEmpty()){
		n_7569 p = q.poll();
		for(int i =0; i<6; i++){
			int x = p.x+dx[i];
			int y = p.y + dy[i];
			int h = p.h +dh[i];
			int len = p.len ;
			if(x>=0 && y>=0 && x<n && y<m && h>=0 && h<hh && map[x][y][h] == 0){
				if(visit[x][y][h]==false){
			
					visit[x][y][h]=true;
				  q.offer(new n_7569(x,y,h,len+1));
			      result =Math.max(result, len+1);
				}
			}
		}
	}
	for(int a = 0; a<hh; a++){
		for(int i =0; i<n; i++){
			for(int j =0; j<m ; j++){
				if(map[i][j][a]==0 && visit[i][j][a]==false){
					result = -1;
					break;
				}
			}
		}
	}
	
	System.out.println(result);
	
  }
}

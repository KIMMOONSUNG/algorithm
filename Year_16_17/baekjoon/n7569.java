package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n7 {
	int x, y, h, cnt;

	n7(int x, int y, int h, int cnt) {
		this.x = x;
		this.y = y;
		this.h = h;
		this.cnt = cnt;
	}
}

public class n7569 {//가장오래걸리는시간.
	static int m;
	static int n;
	static int hh;
	static int map[][][];
	static boolean visit[][][];
    static int dx[] = {0,0,1,-1,0,0};
    static int dy[] = {1,-1,0,0,0,0};
    static int dh[] = {0,0,0,0,1,-1};
    static int time =0;
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	m = Integer.parseInt(st.nextToken());
	n = Integer.parseInt(st.nextToken());
	hh = Integer.parseInt(st.nextToken());
	map = new int[n][m][hh];
	visit= new boolean[n][m][hh];
	Queue<n7> q = new LinkedList<n7>();
	for(int a =0; a<hh; a++){
 	 for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine().trim());
		for(int j =0; j<m; j++){
			map[i][j][a] = Integer.parseInt(st.nextToken());
			if(map[i][j][a] == 1){
				q.offer(new n7(i,j,a,0));
			}
		}
	 } 
	}

	
	while(!q.isEmpty()){
		n7 p = q.poll();
		for(int i =0; i<6; i++){
			int x= p.x+dx[i];
			int y =p.y+dy[i];
			int h =p.h+dh[i];
			int cnt = p.cnt;
			if(x>=0 && y>=0 && x<n && y<m && h>=0 && h<hh && map[x][y][h]!=-1){
				if(visit[x][y][h]==false){
					visit[x][y][h] = true;
					time= Math.max(time, cnt+1);
					q.offer(new n7(x,y,h,cnt+1));
				}
			}
		}
	}
	for(int a=0; a<hh; a++){
		for(int i=0; i<n; i++){
			for(int j =0; j<m; j++){
				if(map[i][j][a] == 0 && visit[i][j][a]==false){
					time = -1;
					break;
				}
			}
		}
	}
	
		System.out.println(time);
	
	
 }
}

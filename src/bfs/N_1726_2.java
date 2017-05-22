package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n1726_2{
	int x;
	int y;
	int dir;
	int count;
	n1726_2(int x, int y, int dir, int count){
		this.x =x;
		this.y = y;
		this.dir = dir;
		this.count = count;
	}
}
public class N_1726_2 { 
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][][];
	static int dx[] = {0,0,0,1,-1};
	static int dy[] = {0,1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 map = new int[n][m];
	 visit = new boolean[n][m][5];
	
	 for(int i =0; i<n; i++){
		 st = new StringTokenizer(bf.readLine().trim());
		 for(int j=0; j<m; j++){
			 map[i][j] = Integer.parseInt(st.nextToken());
		 }
	 }
	 st = new StringTokenizer(bf.readLine().trim());
	 int sx = Integer.parseInt(st.nextToken())-1;
	 int sy = Integer.parseInt(st.nextToken())-1;
	 int sdir = Integer.parseInt(st.nextToken());
	 st = new StringTokenizer(bf.readLine().trim());
	 int ex = Integer.parseInt(st.nextToken())-1;
	 int ey = Integer.parseInt(st.nextToken())-1;
	 int edir = Integer.parseInt(st.nextToken());
	 
	 Queue<n1726_2> q = new LinkedList<n1726_2>();
	 q.offer(new n1726_2(sx,sy,sdir,0));
	 visit[sx][sy][sdir] = true;
	 
	 while(!q.isEmpty()){
		 n1726_2 p = q.poll();
		 int nowx = p.x;
		 int nowy = p.y;
		 int nowdir=  p.dir;
		 int nowcount = p.count;
		 
		 if(nowx==ex && nowy==ey && nowdir==edir){
			 System.out.println(nowcount);
			 break;
		 }
		 for(int i =1; i<=3; i++){ //거리
		   int nextx= nowx+dx[nowdir]*i;
		   int nexty= nowy+dy[nowdir]*i;
		   if(nextx>=0 && nexty>=0 && nextx<n && nexty<m && map[nextx][nexty]!=1){
			   if(visit[nextx][nexty][nowdir]==false){
				   visit[nextx][nexty][nowdir] = true;
				   q.offer(new n1726_2(nextx,nexty,nowdir,nowcount+1));
			   }
		   }
		   else{
			   break;
		   }
		 }
		 
		 for(int i =1; i<=4; i++){
			if(i!=nowdir && i!=reverse(nowdir)&& visit[nowx][nowy][i]==false){
				visit[nowx][nowy][i] =true;
				q.offer(new n1726_2(nowx,nowy,i,nowcount+1));
			}
		 }
	 }
	 
 }
 static int reverse(int dir){
	 if(dir ==1) return 2;
	 else if(dir==2) return 1;
	 else if(dir==3) return 4;
	 else if(dir==4) return 3;
	 else{
		 return -999;
	 }
 }
}


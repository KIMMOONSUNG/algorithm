package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n2206{
	int x,y,len,cnt;
	n2206(int x,int y, int len, int cnt){
		this.x = x;
		this.y = y;
		this.len = len;
		this.cnt = cnt;
	}
}
public class N_2206 { //벽부수고 이동하기 
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new int [n][m];
	visit = new boolean[n][m][2];
	for(int i =0; i<n; i++){
		String str= bf.readLine();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j)-48;
		}
	}
	Queue<n2206 > q = new LinkedList<>();
	q.offer(new n2206(0,0,1,0));
	while(!q.isEmpty()){
		n2206 p = q.poll();

		if(p.x==n-1 && p.y==m-1){
			System.out.println(p.len);
			break;
		}
	    for(int i =0; i<4; i++){
	    	int x = p.x+dx[i];
	    	int y = p.y+dy[i];
	    	int len = p.len;
	    	int cnt = p.cnt;
	    	if(x>=0 && y>=0 && x<n && y<m && visit[x][y][cnt]==false && ((map[x][y]==1&&cnt==0) || map[x][y]==0)){
	    		visit[x][y][cnt] = true;
	    		if(map[x][y]==1){
	    			cnt = cnt+1;
	    		}
	    		q.offer(new n2206(x,y,len+1,cnt));
	    	}
	    }
	}
 }
}

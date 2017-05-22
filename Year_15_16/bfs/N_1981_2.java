package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class a99 implements Comparable<a99> {
	int x;
	int y;
	int max;
	int min;
	int cnt;

	a99(int x, int y,int max,int min, int cnt){
		this.x =x;
		this.y =y;
		this.max = max;
		this.min = min;
		this.cnt = cnt;
	}
	public int compareTo(a99 c){
		if(this.cnt > c.cnt){
			return 1;
		}
		else if(this.cnt==c.cnt){
			return 0;
		}
		else{
			return -1;
		}
	}
}
public class N_1981_2 { //실패
	static int n;
	static int map[][];
	static int wmap[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
  public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map = new int[n][n];
	wmap = new int[n][n];
	boolean visit[][] = new boolean[n][n];
	for(int i =0; i<n; i++){
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		for(int j =0; j<n; j++){
			map[i][j] = Integer.valueOf(st.nextToken());
		}
	}
	PriorityQueue<a99> pq = new PriorityQueue<a99>();
	
	 pq.offer(new a99(0,0,map[0][0],map[0][0],map[0][0]));
	while(!pq.isEmpty()){
		a99 p = pq.poll();
		if(p.x == n-1 && p.y ==n-1){
			System.out.println(p.cnt);
		}
		for(int i =0; i<4; i++){
		 int x = p.x+dx[i];
		 int y = p.y+dy[i];
		 int cnt= p.cnt;
		 int min = p.min;
		 int max = p.max;
		 
		 if(x>=0 && y>=0 && x<n && y<n && visit[x][y]==false){
			 visit[x][y] =true;
			 max =Math.max(map[x][y], max);
			 min =Math.min(map[x][y], min);
			 cnt = max - min; 
			 pq.offer(new a99(x,y,max,min,cnt));
			}
		 
	  }
	}
	
 }

}

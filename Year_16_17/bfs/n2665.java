package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
class n_2665 implements Comparable<n_2665>{
	int x,y,cnt;
	n_2665(int x, int y, int cnt){
	this.x = x; 
	this.y= y;
	this.cnt = cnt;
	}
	public int compareTo(n_2665 c){
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
public class n2665 { // 미로만들기   
	static int n;
	static int map[][];
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	
	n = Integer.parseInt(bf.readLine());
	map = new int [n][n];
	visit = new boolean[n][n];
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		for(int j =0; j<n; j++){
			map[i][j] = str.charAt(j)-48;
		}
	}

	
	PriorityQueue<n_2665> pq = new PriorityQueue<>();
	pq.offer(new n_2665(0,0,0));
	visit[0][0] = true; 
	while(!pq.isEmpty()){
	    n_2665 p = pq.poll();
	    
		if(p.x==n-1 && p.y==n-1){
			
			System.out.println(p.cnt);
			break;
			
		}
		for(int i =0; i<4; i++){
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			int cnt = p.cnt;
			if(x>=0 && y>=0 && x<n && y<n ){
				
				if(visit[x][y] == false){
					visit[x][y] = true;
					if(map[x][y] ==1){
						pq.offer(new n_2665(x,y,cnt));
					}
					if(map[x][y]==0){
						pq.offer(new n_2665(x,y,(cnt+1)));
					}
				}
			}
		}
	}
 }
}

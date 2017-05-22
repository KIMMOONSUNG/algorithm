package bfs;


import java.util.PriorityQueue;
import java.util.Scanner;

class abc implements Comparable<abc>{
	int x ;
	int y ;
	int cnt;
	abc(int x, int y, int cnt){
		this.x =x;
		this.y = y;
		this.cnt = cnt;
	}
	public int compareTo(abc c){
		if(this.cnt > c.cnt){
			return 1;
		}
		else if(this.cnt < c.cnt){
			return -1;
		}
		else{
		    return 0;
		}
	}
	
}
public class N_1261_1 {

 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt();
	int n = sc.nextInt();
	int map[][] = new int[n][m];
	boolean visit[][] = new boolean[n][m];
	for(int i =0; i<n; i++){
		String str = sc.next();
		for(int j =0; j<m; j++){
		  map[i][j] = str.charAt(j)-48;
		}
	}
	
	PriorityQueue<abc> pq = new PriorityQueue<abc>();
	int dx[] = {0,0,1,-1};
	int dy[] = {1,-1,0,0};
	 pq.offer(new abc(0,0,0));
	while(!pq.isEmpty()){
	   abc p = pq.poll();
	   if(p.x == n-1 && p.y ==m-1){
		   System.out.println(p.cnt);
		   break;
	   }
	   for(int i =0; i<4; i++){
		   int x = p.x+dx[i];
		   int y = p.y+dy[i];
		   int cnt = p.cnt;
		   if(x>=0 && y>=0 && x<n && y<m && visit[x][y] == false){
			   visit[x][y] = true;
			   
			   if(map[x][y] == 1){//벽O 
				pq.offer(new abc(x,y,cnt+1));   
			   }
			   else{ // 벽X 
				   pq.offer(new abc(x,y,cnt));   
			   }
		   }
	   }
	}
 }
}

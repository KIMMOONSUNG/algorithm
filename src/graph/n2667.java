package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class n_2667{
	int x;
	int y;
}
public class n2667 {
	static int n ;
	static int map[][];
	static int count;
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
  public static void main(String[] args) throws IOException{
	  BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	  n = Integer.parseInt(bf.readLine());
	  map = new int[n][n];
	  count =0;
	  visit = new boolean[n][n];
	  for(int i =0; i<n; i++){
		  String str = bf.readLine();
		  for(int j=0; j<n; j++){
			  map[i][j] = str.charAt(j)-48;
		  }
	  }
	  
	  for(int i =0; i<n; i++){
		  for(int j=0; j<n; j++){
			  if(visit[i][j]==false && map[i][j]==1){
				  count++;
				  bfs(i,j);
				  
			  }
		  }
	  }
	   int cnt[] = new int[count+1];
	   
	  for(int i=0; i<n; i++){
		  for(int j=0; j<n; j++){
			  if(map[i][j]!=0){
				  cnt[map[i][j]] +=1;
			  }
		  }
	  }
	  
	  Arrays.sort(cnt);
	  
	  System.out.println(count);
	  
	  for(int i =1; i<cnt.length; i++){
		  System.out.println(cnt[i]);
	  }
	  
	  
 }
  static void bfs(int a, int b){
	  Queue<n_2667> q = new LinkedList<n_2667>();
	  n_2667 p = new n_2667();
	  p.x = a;
	  p.y = b;
	  q.offer(p);
	  visit[a][b]=true;
	  map[a][b]= count;
	  
      while(!q.isEmpty()){
    	  p = q.poll();
          for(int i =0; i<4; i++){
        	  int x = p.x+dx[i];
        	  int y = p.y+dy[i];
        	  if(x>=0 && y>=0 && x<n && y<n && map[x][y]!=0 && visit[x][y] ==false){
        		  visit[x][y] =true;
        		  map[x][y]=count;
        		  n_2667 p2 = new n_2667();
        		  p2.x = x;
        		  p2.y = y;
        		  q.offer(p2);
        	  }
          }
      }
  }
}

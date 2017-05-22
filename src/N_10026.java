import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class n10026{
	int x;
	int y;
	n10026(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class N_10026 {
	static int n ;
	static char map[][];
	static boolean manmap[][];
	static boolean nomanmap[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int mancount;
	static int nomancount;
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map = new char [n][n];
	manmap = new boolean [n][n];
	nomanmap = new boolean[n][n];
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		for(int j =0; j<n; j++){
			map[i][j] = str.charAt(j);
		}
	}
	
	for(int i =0; i<n; i++){
		for(int j =0; j<n; j++){
		 if(manmap[i][j] ==false ){
			 man(i,j,map[i][j]);
		 }
		 if(nomanmap[i][j] == false){
		     noman(i,j,map[i][j]);	 
		 }
		}
	}
	System.out.println(mancount+" "+nomancount);
	
 }
 
 static void man(int a, int b, char ch){
	 mancount++;
  Queue<n10026> q = new LinkedList<n10026>();	
  boolean visit[][] = new boolean[n][n];
  q.offer(new n10026(a,b));
  manmap[a][b] = true;
  while(!q.isEmpty()){
	  n10026 p = q.poll();
	  for(int i =0; i<4; i++){
		  int x = p.x + dx[i];
		  int y = p.y + dy[i];
		  if(x>=0 && y>=0 && x<n && y<n && visit[x][y]==false && map[x][y]==ch){
			 visit[x][y] =true;
			 q.offer(new n10026(x,y));
			 manmap[x][y] = true;
		  }
		  
	  }
  }
 }
 
 static void noman(int a, int b,char ch){
	 nomancount++;
	 Queue<n10026> q = new LinkedList<n10026>();
	 q.offer(new n10026(a,b));
	 boolean visit[][] = new boolean[n][n];
	 nomanmap[a][b] = true;
	 while(!q.isEmpty()){
		 n10026 p = q.poll();
		 for(int i =0; i<4; i++){
			 int x = p.x + dx[i];
			 int y = p.y + dy[i];
			if(x>=0 && y>=0 && x<n && y<n && visit[x][y]==false){
				visit[x][y] = true;
				if((ch=='R'|| ch=='G') && (map[x][y]=='R' || map[x][y]=='G')){
				 q.offer(new n10026(x,y));
				nomanmap[x][y] = true;
				}
				else{
					if(map[x][y]==ch){
					q.offer(new n10026(x,y));
					nomanmap[x][y] = true;
					}
				}
				
			}
			
		 }
	 }
 }
}

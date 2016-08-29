package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_2178_3 {
	static int N;
	static int M;
	static int map[][];
	static boolean visit[][];
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" ");
	N = Integer.parseInt(str[0]);
	M = Integer.parseInt(str[1]);
	map = new int[N][M];
	visit = new boolean[N][M];
	for(int i =0; i<N; i++){
	 char a[] = bf.readLine().toCharArray();
	 for(int j=0; j<M; j++){
		 map[i][j] =(a[j]-48);
	 }
	}
	BFS();

}
 static void BFS(){
	 Queue<Integer> qx = new LinkedList<Integer>();
	 Queue<Integer> qy= new LinkedList<Integer>();
	 int x =0;
	 int y =0;
	 visit[x][y] = true;
     int dx[] = {0,0,1,-1};
     int dy[] = {1,-1,0,0};
     qx.offer(x);
     qy.offer(y);
     while(!qx.isEmpty() || !qy.isEmpty()){
    	 x = qx.poll();
    	 y = qy.poll();
    	 if(x==N-1 && y==M-1){
    		 System.out.println(map[x][y]);
    		 break;
    	 }
    	 for(int i =0; i<4; i++){
    		 int xx = x+dx[i];
    		 int yy = y+dy[i];
    		if(xx>=0 && yy >=0 && xx<N && yy<M && visit[xx][yy] ==false
    				&& map[xx][yy] ==1){
    			visit[xx][yy] = true;
    			map[xx][yy] = map[x][y] +1;
    			qx.offer(xx);
    			qy.offer(yy);
    		}
    	 }
     }
     
 }
}

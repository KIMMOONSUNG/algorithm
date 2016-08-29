package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2178_5_arrayq {
	static int n;
	static int m;
	static int map[][];
	static boolean visit[][];
	static int qx[];
	static int qy[];
	static int ql[];
	static int count;
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str []  = bf.readLine().split(" ");
	 n = Integer.parseInt(str[0]);
	 m = Integer.parseInt(str[1]);
	 map = new int[n][m];
	 visit = new boolean[n][m];
	 for(int i =0; i<n; i++){
		 char ch [] = bf.readLine().toCharArray();
		 for(int j=0; j<m; j++){
			 map[i][j] = ch[j]-48;
		 }
	 }
	 qx = new int[10001];
	 qy = new int[10001];
	 ql = new int[10001];
	 count =0;
	 BFS();
}
 
 static void q(int x,int y, int l){
 	 qx[count] =x;
 	 qy[count] =y;
 	 ql[count] =l;
 	 count++;
 }
 
 static void BFS(){
	 
	    q(0,0,1);
		int x=0;
		int y=0;
		int len =0;
		int index =0;
		int dx[] = {0,0,1,-1};
		int dy[] = {1,-1,0,0};
		
	 while(true){
	   	 x= qx[index];
	   	 y= qy[index];
	   	 len = ql[index];
	   	 if(x==n-1 && y == m-1){
	   		 System.out.println(len);
	   		 break;
	   	 }
	   	 for(int i =0; i<4; i++){
	   		 int xx = x+dx[i];
	   		 int yy = y+dy[i];
             int l = len;
             if(xx>=0 && yy>=0 && xx<n && yy<m && visit[xx][yy]==false
            		 && map[xx][yy] ==1){
            	 visit[xx][yy] = true;
            	 q(xx,yy,l+1);
             }
	   	 }
	   	index++; 
	 }
 }
}

package dfs;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N_1261 { //알고스팟  - dfs
	static int n;
	static int m;
	static int map[][];
	static int wmap[][];
	
	
public static void main(String[] args)throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" ");
	m = Integer.valueOf(str[0]);
	n = Integer.valueOf(str[1]);
	map= new int[n][m];
	wmap= new int[n][m];
	
	for(int i =0; i<n; i++){
		char ch [] = bf.readLine().toCharArray();
		for(int j =0; j<m; j++){
			map[i][j] = ch[j]-48;
			wmap[i][j] =10001;
		}
	}
    Stack<Point> stk = new Stack<Point>();
    wmap[0][0] = 0;
	stk.push(new Point(0,0));
	int dx[] = {0,0,1,-1};
	int dy[] = {1,-1,0,0};
	while(!stk.isEmpty()){
		Point now = stk.pop();
		if(now.x == n-1 && now.y == m-1){
			continue;
		}		
		for(int i =0; i<4; i++){
			int x = now.x+dx[i];
			int y = now.y+dy[i];
			if(x>=0 && y>=0 && x<n && y<m){
				if(wmap[x][y] > wmap[now.x][now.y] + map[x][y]){
					wmap[x][y] = wmap[now.x][now.y] + map[x][y];
					stk.push(new Point(x,y));
				}
			}
		}
	}
	System.out.println(wmap[n-1][m-1]);
 }
}

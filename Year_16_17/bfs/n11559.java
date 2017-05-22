package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class cl{
	int x, y, cnt;
	cl(int x,int y,int cnt){
		this.x = x;
		this.y = y ;
		this.cnt = cnt;
	}
}
public class n11559 {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static char map[][] = new char[12][6];
	static boolean visit[][] = new boolean[12][16];
	
public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	for(int i =0; i<12; i++){
		String str = bf.readLine();
		for(int j =0; j<6; j++){
			map[i][j] = str.charAt(j);
		}
	}
	Queue<cl> q = new LinkedList<>();
	for(int i =0; i<12; i++){
		for(int j =0; j<6; j++){
			if(map[i][j]!='.'){
				q.offer(new cl(i,j,0));
			}
		}
	}	
}

}

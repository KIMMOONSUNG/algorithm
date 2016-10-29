package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class aaaaa_1{
	int x; 
	int y; 
	int cnt;
}
public class aaaaa { 
	static int map[][];
	static boolean visit[][]; 
	static int X, Y;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		X = sc.nextInt();
		Y = sc.nextInt();
		map = new int[X][Y];
		visit = new boolean[X][Y]; 
		for (int a = 0; a < X; a++) {
			String str = sc.next();
			for (int b = 0; b < Y; b++) {
				map[a][b] = str.charAt(b) - 48;
			}
		}

		fun();
	}
	static void fun() {
	 Queue<aaaaa_1> q=  new LinkedList<aaaaa_1>();
	 aaaaa_1 p = new aaaaa_1();
	 p.x = 0;
	 p.y = 0;
	 p.cnt =1; // 자기 자신도 길 count 포함 
	 q.offer(p);
	 int dx[] = {0,0,1,-1};
	 int dy[] = {1,-1,0,0};
	 while(!q.isEmpty()){
		 p = q.poll();
		 if(p.x == X-1 && p.y==Y-1){
			 System.out.println(p.cnt);
			 break;
		 }
		 for(int i =0; i<4; i++){
			 int x = p.x +dx[i];
			 int y = p.y +dy[i];
			 int cnt = p.cnt;
			 if(x>=0 && y>=0 && x<X && y<Y && visit[x][y] == false 
					 && map[x][y] == 1){
				 visit[x][y] = true;
				 aaaaa_1 p2 = new aaaaa_1();
				 p2.x = x;
				 p2.y = y;
				 p2.cnt = cnt +1;
				 q.offer(p2);
			 }
		 }
	 }
	}
}

package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D_10472 {
	static int test;
	static int map[][];
	static int change[][];	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		test = sc.nextInt();
		map = new int[3][3];

		for (int a = 0; a < test; a++) {
		 change = new int[3][3];
			for (int i = 0; i < 3; i++) {
				String str = sc.next();
				for (int j = 0; j < 3; j++) {
					char ch = str.charAt(j);
					if (ch == '*') {
						change[i][j] = 1;
					}
					if (ch == '.') {
						change[i][j] = 0;
					}
				}
			}
			for( int i=0; i<3; i++){
				for(int j=0; j<3; j++){
                  
				}
			}
			bfs();
		}

	}

	static void bfs() {
		Queue<Integer> q_x = new LinkedList<Integer>();
		Queue<Integer> q_y = new LinkedList<Integer>();
		boolean visit[][]  = new boolean[3][3];
		int x = 0;
		int y = 0;
		q_x.offer(0);
		q_y.offer(0);
		int d1[] = { 0, 0, 1, -1 };
		int d2[] = { 1, -1, 0, 0 };
		while (!q_x.isEmpty() || !q_y.isEmpty()) {
			for (int i = 0; i < 4; i++) {
				if ((x + d1[i]) >= 0 && (y + d2[i]) >= 0 && (x + d1[i]) < 3 && (y + d2[i]) < 3
						&& visit[(x + d1[i])][(y + d2[i])] == false) {
					if(change[(x + d1[i])][(y + d2[i])]==1){
					  
					}
				}
			}
		}
	}
}

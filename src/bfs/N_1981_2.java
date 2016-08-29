package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1981_2 {
	static int n;
	static int map[][];
	static boolean visit[][];
    static int K;
    static int gap ;
    static int dx[]={0,0,1,-1} ;
    static int dy[]={1,-1,0,0} ;
    static int min;
    static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(bf.readLine());
		map = new int[n][n];
		visit = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String str[] = bf.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.valueOf(str[j]);
			}
		}
		gap = 201;
		min =201;
		max =01;
		BFS();
	}

	static void BFS() {
         
	}
}

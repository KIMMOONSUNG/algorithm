package dfs;

import java.util.Scanner;

public class N_1520 { //내리막길 
	 // 재귀문제임. 
	//bfs X , dfs X , stack으로 4방향보는것도 시간초과남
	
	static int n;
	static int m;
	static int map[][]; // 맵
	static int number[][]; // 길갯수추가 .
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		number = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(func(0, 0));

	}

	static int func(int a, int b) {
		if (a == n - 1 && b == m - 1) {
			return 1;// 마지막도착했을시에 길이더하는것 길 1 , 길2 이런식
		}
		
	   if(number[a][b] == 0){ // 방문안한곳.
		for(int i =0; i<4; i++){
			int x = a+dx[i];
			int y = b+dy[i];
			if(x>=0 && y>=0 && x<n && y<m && 
					(map[a][b]>map[x][y])){ //현위치값이 더커야함 내리막길이니까
				number[a][b] +=func(x,y);
			}
 		 }
	   }
		return number[a][b];
		
	}
}

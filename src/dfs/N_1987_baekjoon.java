package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N_1987_baekjoon {
	public static int dx[] = {0,0,1,-1};
	public static int dy[] = {1,-1,0,0};
	public static int n;
	public static int m;
	public static void main(String args[]) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st= new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		String[] board = new String[n];
		
		for (int i = 0; i < n; i++) { //  
			board[i] = bf.readLine(); 
		}
		
		boolean[] check = new boolean[26]; // 알파벳상태
		check[board[0].charAt(0) - 'A'] = true; // 지금 현위치 알파벳 상태 바꿈 .
		System.out.println(go(board, check, 0, 0)); 
	}
	
	public static int go(String[] board, boolean[] check, int a, int b) {
		int ans = 0;
		for (int k = 0; k < 4; k++) {
			int x = a + dx[k];
			int y = b + dy[k];
			//board.length길이는 n이고
			//board[].length길이는 m이다.
			//if (x >= 0 && x < board.length && y >= 0 && y < board[0].length()) 
			
			if (x >= 0 && x < n && y >= 0 && y < m) {
				if (check[board[x].charAt(y) - 'A'] == false) {
					check[board[x].charAt(y) - 'A'] = true;
					int next = go(board, check, x, y);
					ans = Math.max(ans, next);
					/*if (ans < next) {
						ans = next;
					}
					*/
					check[board[x].charAt(y) - 'A'] = false; // 한번 go갔다왔으니 상태 다시 false로 
				}
			}
		}
		return ans + 1;
	}

}

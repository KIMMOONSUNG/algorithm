package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1987_ms {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		 n = Integer.parseInt(st.nextToken());
		 m = Integer.parseInt(st.nextToken());
		 char board[][] = new char[n][m];
		 for(int i =0; i<n; i++){
			 String str = bf.readLine();
			 for(int j=0; j<m; j++){
				 board[i][j] = str.charAt(j);
			 }
		 }
		boolean check [] = new boolean [26];
		check[board[0][0]-'A'] = true;
		System.out.println(go(board, check, 0, 0));
	}
	
	static int go(char board[][] , boolean check[], int a, int b){
		int result =0;
		
		for(int k=0; k<4; k++){
			int x= a+dx[k];
			int y =b+dy[k];
			if(x>=0 && y>=0 && x<n && y<m){
				if(check[board[x][y]-'A'] == false){
					check[board[x][y]-'A'] = true;
					int next = go(board,check,x,y);
					result = Math.max(result, next);
					check[board[x][y]-'A'] = false; //dfs니까 다 갔따가 다시돌아올때는  false해줘야해서 
				}
			}
		}
		return result+1;
	}
	
}

/** 이게 더 효율적임 **/
/*
static boolean alpha[];
static int dx[] = {0,0,1,-1};
static int dy[] = {1,-1,0,0};
static int n;
static int m;
static char map[][];
public static void main(String[] args) throws IOException{
BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st = new StringTokenizer(bf.readLine());
n = Integer.parseInt(st.nextToken());
m = Integer.parseInt(st.nextToken());
map = new char[n][m];
alpha = new boolean[26];
for(int i =0; i<n; i++){
	String str = bf.readLine();
	for(int j =0; j<m; j++){
		map[i][j] = str.charAt(j);
	}
}
alpha[map[0][0]-'A']=true;
System.out.println(go(0,0));

}
static int go(int a, int b){
int result =0;
for(int i =0; i<4; i++){
	int x= a+dx[i];
	int y= b+dy[i];
	if(x>=0 && y>=0 && x<n && y<m){
		if(alpha[map[x][y]-'A']==false){
			alpha[map[x][y]-'A'] = true;
			int ans = go(x,y);
			result = Math.max(result, ans);
			alpha[map[x][y]-'A'] = false;
		}
	}
}
return result+1 ;
}*/




package dfs;

import java.util.Scanner;

public class practice {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int n;
	static int m;
  public static void main(String[] args) {
	Scanner sc=  new Scanner(System.in);
	n=sc.nextInt();
	m=sc.nextInt();
	char ch[][] = new char[n][m];
	for(int i =0; i<n; i++){
		String str = sc.next();
		for(int j =0; j<m; j++){
			ch[i][j] = str.charAt(j);
		}
	}
	boolean check[] = new boolean[26];
	check[ch[0][0]-'A'] = true;
	System.out.println(func(ch,check,0,0));
 }
  static int func(char ch[][], boolean check[], int a, int b){
	  int ans =0;
	  for(int i=0; i<4; i++){
		  int x = a+dx[i];
		  int y = b+dy[i];
		  if(x>=0 && y>=0 && x<n && y<m){
			  if(check[ch[x][y]-'A']==false){
				  check[ch[x][y]-'A']=true;
				  int next = func(ch,check,x,y);
				  ans = Math.max(ans, next);
				  check[ch[x][y]-'A'] = false;
			  }
		  }
	  }
	  return ans+1;
  }
}
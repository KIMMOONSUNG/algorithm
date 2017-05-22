package JG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class practice {
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int n;
	static int m;
	static char alpha[][];
	static boolean check[];
 public static void main(String[] args) throws IOException{
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(bf.readLine().trim());
  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());
  alpha = new char[n][m];
  for(int i =0; i<n; i++){
	  String str = bf.readLine();
	  for(int j=0; j<m; j++){
		  alpha[i][j] = str.charAt(j);
	  }
  }
  check = new boolean [26];
  check[alpha[0][0]-'A'] = true;
  System.out.println(go(0,0));
 }
 static int go(int a, int b){
	 int ans = 0;
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){
			 if(check[alpha[x][y]-'A']==false){
				 check[alpha[x][y]-'A']=true;
				 int next = go(x,y);
				 ans = Math.max(ans, next);
				 check[alpha[x][y]-'A'] = false; 
			 }
		 }
	 }
	 return ans+1;
 }
}
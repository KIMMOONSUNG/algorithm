package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_1987_2 { // 알파벳방법2
	static int n;
	static int m;
	static char map[][];
	static boolean alpha[];
	static int result;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new char[n][m];
	alpha = new boolean [26]; 
    
    for(int i=0; i<n; i++){
    	String str =  bf.readLine();
    	for(int j=0; j<m; j++){
    		map[i][j] = str.charAt(j);
    	}
    }
    
    alpha[map[0][0] - 'A'] = true;
    func(0,0,0);  // 호출 
    System.out.println(result +1); 
    
 }
 
 static void func(int a, int b, int count){ // 재귀 
	 for(int i =0; i<4; i++){
		 int x = a+dx[i];
		 int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m){ // 범위 
			 if(alpha[map[x][y] -'A'] == false){
				 alpha[map[x][y]-'A'] = true;
				 func(0,0,count+1);
				 
				 result = Math.max(result, count+1);
				 alpha[map[x][y] -'A'] = false;
			 }
		 }
	 }
 }
 
}

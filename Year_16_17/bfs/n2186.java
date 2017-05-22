package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
2 2 1 
AB
BA
ABA
8
*/
public class n2186 { // 문자판  
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int n;
	static int m;
	static int k;
	static char map[][];
    static int dp[][][];
    static String ans;
	static int len;
	static int result;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	n =Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
    map= new char[n][m];
  

    for(int i =0; i<n; i++){
    	String str = bf.readLine();
    	for(int j=0; j<m; j++){
    		map[i][j] = str.charAt(j);
    	}
    }
    
    
    ans = bf.readLine();
    char first = ans.charAt(0);
    len = ans.length();

    dp = new int [n][m][len]; //len은ans 길이 
    for(int i =0; i<n; i++){
    	for(int j =0; j<m ;j++){
    		for(int c=0 ; c<len; c++){
    			dp[i][j][c] = -1; //-1로 초기
    		}
    	}
    }
   
    result =0;
    for(int i =0; i<n; i++){
    	for(int j=0; j<m; j++){
    		if(map[i][j] == first ){

    			result += func(i,j,0);
    			
    		}
    	}
    }
    System.out.println(result);
    
 }
 
 static int func(int a, int b, int cnt){  // 이 부분은 내리막길과 비슷 
	 
	 if(cnt == len-1){ // 길이가 같아졌다는것은 같다는뜻이니 1리턴 
		 return 1;
	 }
	 if(dp[a][b][cnt] != -1){ // -1 아닌경우이미 경로 있다는것 // 메모이제이션 
		 return dp[a][b][cnt];
	 }
	 dp[a][b][cnt]=0; //중요  
	 
	 for(int i =0 ; i<4; i++){
		 for(int j=1; j<=k; j++){
			 int x = a+dx[i]*j;
			 int y = b+dy[i]*j;
			 if(x>=0 &&y>=0 && x<n && y<m ){
				 char ch = map[x][y] ;
				 if(ch == ans.charAt((cnt+1))){ // 다음 갈 문자가 구하고자 하는 문자의 문와 일치할때 
					
				   dp[a][b][cnt] += func(x,y,(cnt+1)); 
				 }
			 }
		 }
	 }
	 
	 return dp[a][b][cnt]; 
 }

 
}

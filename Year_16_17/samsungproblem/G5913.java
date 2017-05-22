package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G5913 { // 준규와 사과  -> 백트래킹 
	static final int n = 5;
	static int k;
	static boolean visit[][];
	static int jx =1;
	static int jy =1;
	static int hx= 5;
	static int hy= 5;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int count =0;
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
	k = Integer.parseInt(bf.readLine());
	visit = new boolean[n+1][n+1];
    StringTokenizer st ;
    for(int i =0; i<k; i++){
    	st = new StringTokenizer(bf.readLine());
      int x = Integer.parseInt(st.nextToken());
      int y = Integer.parseInt(st.nextToken());
      visit[x][y] = true;
    }
    visit[jx][jy] = true;
   // visit[hx][hy]  =true;
    func(jx,jy);
    
    String str = Integer.toString(count);
    bw.write(str);
    bf.close();
    bw.close();
    
}
 
 static void func(int a1, int b1) {
	 
	 if(a1==hx && b1==hy){
		 boolean k = false;
			for(int h =1; h<=n; h++){
				for(int j=1; j<=n; j++){
					if(visit[h][j] == false){
						k = true;
					}
				}
			}
			
			if(k==false){
				count++;
				return;
			}
	 }
	 
   for(int i =0; i<4; i++){
	   int x1 = a1+dx[i];
	   int y1 = b1+dy[i];
	   
	   if(x1>0 && y1>0 && x1<=n && y1<=n){
		   
		   if(visit[x1][y1]==false){
				visit[x1][y1] = true;				   
			     func(x1,y1);
			    visit[x1][y1] = false;
		   }
		   
	   }
   }
   
 }
 
}

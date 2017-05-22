package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N3108_2 {
	static int n;
	static int map[][];
	static int nextx ,nexty;
	static int ans ;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map= new int[2002][2002];
	StringTokenizer st ;
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		int x1 = Integer.parseInt(st.nextToken())+500;
		int y1 = Integer.parseInt(st.nextToken())+500;
		int x2 = Integer.parseInt(st.nextToken())+500;
		int y2 = Integer.parseInt(st.nextToken())+500;
	
		drawRect(i+1,x1,y1,x2,y2); //그려 
		
	}
     dfs(1000,1000); // 출발한다 -> 출발하면서 다 0으로 만들며 쭉 0이아닌곳들 찾아다님 

     for (int i = 0; i < map.length; i++) { 
         for (int j = 0; j < map.length; j++) {
             if (map[i][j] != 0) { // 출발ㄱ마친후 맵 봤을때 0이아닌곳 있으면 1증가시킨후 다시 또 거기서 출발 
                 ans++;
                 dfs(i,j);
             }
         }
     }
	
	System.out.println(ans);
}

 static void drawRect (int Num, int x1, int y1, int x2, int y2) {
	 // 문제에 (−500 ≤ x1 < x2 ≤ 500), (−500 ≤ y1 < y2 ≤ 500) 라서  1이 2 보다 작아 가능 
	
	 
	 //2배를 해서 사각형들을 그려주면서 각 사각형 번호 매겨준다 
	 //->2배하는이유는 안겹치는 사각형 찾기위해 ? 
	 for(int j=2*y1; j<=2*y2; j++){
		 map[2*x1][j] = Num;
		 map[2*x2][j] = Num;
	 }
	
     for(int i = 2*x1; i <= 2*x2; i++) {
    	 map[i][2*y1] = Num;
         map[i][2*y2] = Num;
     }
 }
 
 static void dfs (int x, int y) {

     if (map[x][y] != 0) {
         map[x][y] = 0;
         for(int i =0; i<4; i++){
        	 int a = x+dx[i];
        	 int b = y+dy[i];
        	 if(a>=0 && a<2002 && b>=0 && b<2002)
        		 if(map[a][b] !=0){
        			 dfs(a,b);
        		 }
        	 }
         }
         
     }

}



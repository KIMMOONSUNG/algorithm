package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
6 5
13 15 11 12 13 14
9 0 2 7 7 4
8 10 13 2 1 3
6 9 2 15 11 13
4 5 2 13 9 1

 -> 10
    14
    19
*/

class n_2234{
	int x,y;
	n_2234(int x, int y){
		this.x = x;
		this.y= y;
		
	}
}
public class n2234 {
	static int m;
	static int n;
	static int map[][];
	static int check[][]; //방 마다 번호
	static long maxlength ; // 가장 넓은방의 넓이
     
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
	static int r[]  = {1,2,3,8,9,10,11};
	static int l[] = {2,4,6,8,10,12,14};
	static int d[] = {1,2,3,4,5,6,7};
	static int u[] = {1,4,5,8,9,12,13};
	
	static long ll2[] = new long [3000];  // 방 번호 를 인덱스로 그 번호 방의 길이를 넣어줌 
	/*
	서쪽에 벽이 있을 때는 1을, 
	북쪽에 벽이 있을 때는 2를, 
	동쪽에 벽이 있을 때는 4를, 
	남쪽에 벽이 있을 때는 8을 더한 값이 주어진다(이진수의 각 비트를 생각하면 쉽다).
	따라서 이 값은 0부터 15까지의 범위 안에 있다.
	
	->> 1,2,4,8 (서,북,동,남 ) / 3(서북),5(서동),9(서남) / 6(북동), 10(북남) / 12(동남)/ 7(서북동), 11(서북남), 13(서동남 )/ 14(북동남) / 15(동서남북)
  
       // 동 -> 4,5,6,12,7,13,14,15
	   // 서 -> 1,3,5,9,7,11,13,15
	   // 남 -> 8,9,10,12,11,13,14,15
	   // 북 -> 2,3,6,10,7,11,14,15
	*/
	

   public static void main(String[] args) throws IOException{
	   
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	m = Integer.parseInt(st.nextToken());
	n = Integer.parseInt(st.nextToken());
	map = new int [n][m];
	visit = new boolean[n][m];
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j=0; j<m; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	
	check = new int[n][m];
	int count =1;
    
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			if(check[i][j]!=count && visit[i][j] == false){
				count++; // 2부터 check에 저장될거 
				func12(i,j,count);
			
			}
		}
	}

	 
	 long le = 0;//벽 1번  뚫었을때의 방 넓이 최대  길이 
	 
  for(int t = 2; t<=count; t++){ // 방번호2가 처음이라 2부터 시작 해서 
	for(int i =0; i<n; i++){
		for(int j =0; j<m; j++){
			for(int a =0; a<4; a++){
				int x = i + dx[a];
				int y = j + dy[a];
				if(x>=0 && y>=0 && x<n && y<m){
				if(check[i][j]==t && check[x][y] !=t){  // 주변 방 중에 현위치 랑 다음 위치가 다른경우 
					le = Math.max(le, (ll2[check[i][j]] + ll2[check[x][y]] )); // 그때의 방번호 2개를 인덱스로해서 길이 배열을 찾아 더해줌 
				}
			  }
			}
		}
	}
  }
  
	
	System.out.println(count-1);
	System.out.println(maxlength);
	System.out.println(le);
}

   
   
	static void func12(int a, int b,int c) { //방번호를 매기면서 +가장 넓은 방의 길이 까지 
		Queue<n_2234> q = new LinkedList<>();
		check[a][b] = c;
		visit[a][b] = true;
		int length =1;
		q.offer(new n_2234(a, b));
		
		while (!q.isEmpty()) {
			n_2234 p = q.poll();
			for (int i = 0; i < 4; i++) {
				int x = p.x + dx[i];
				int y = p.y + dy[i];
				boolean skip = false;
				
				for (int k = 0; k < 7; k++) { 
					if(x>=0 && y>=0 && x<n && y<m){ // 오른쪽으로 이동하려 할때 현위치의 값이 벽에 걸리지 않는지 판별 그리고 0일때는 벽이 없는 경우라서 자동적으로 통과   
						if (map[p.x][p.y]==0 || (i == 0 && (map[p.x][p.y] == r[k])) || (i == 1 && (map[p.x][p.y] == l[k]))
								|| (i == 2 && (map[p.x][p.y] == d[k])) || (i == 3 && (map[p.x][p.y] == u[k]))) {
							
							skip = true;
						}
					}
				}
				
				if ((skip == true) && x>=0 && y>=0 && x<n && y<m) {
					if (visit[x][y] == false) {
						visit[x][y] = true;
						check[x][y] = c;
						length++;
						q.offer(new n_2234(x, y));
						
						
						
					}
				}
				
			}
			
		}
		maxlength = Math.max(maxlength, length); // 가장 넓은 방 길이 
		ll2[c] = length; // 그 방 번호 인덱스에 길이를 넣어줌  
		
	}
	
}

package bfs;

import java.util.*;

public class N2589 {
	
	static int n;
	static int m;
	static int map[][];
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };    
	static int result =-1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
         
		for (int i = 0; i < n; i++) { // 육지 1 바다 0
			String str = sc.next();
			for (int j = 0; j < m; j++) {

				if (str.charAt(j) == 'L') {
					map[i][j] = 1;
				}
			}
		}
		
		for (int i = 0; i < n; i++) { //전체를 다본다 
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					bfs(i, j);
				}
			}
		}
		
		System.out.println(result);

	}

	static void bfs(int i, int j) { //시작점 x y받아옴
		Queue<Integer> qx = new LinkedList<Integer>();
		Queue<Integer> qy = new LinkedList<Integer>();
		boolean visit[][] = new boolean[n][m];
		int c[][] = new int[n][m];
		int count =0; // count 긴거 세려고 하는거 
		int x = i;
		int y = j;
		qx.offer(x);
		qy.offer(y);
		visit[x][y] =true;
		while (!qx.isEmpty()&& !qy.isEmpty()) { //큐 빌때까지 다 검사함 (육지 모두 도착하기 위해 )
          x=qx.poll();
          y=qy.poll();

           for(int a=0; a<4; a++){
        	   int d_x = x+dx[a];
        	   int d_y = y+dy[a];
        	  if(d_x>=0 && d_y>=0 && d_x<n && d_y<m &&visit[d_x][d_y]==false
        			  && map[d_x][d_y]==1){ //육지일때만 
        		  	   
        		  visit[d_x][d_y] = true;
        		  c[d_x][d_y] = c[x][y] +1; // 카운트 배열 하나씩 증가 그 전 카운트에 +1; 
        		  
        		  qx.offer(d_x);
        		  qy.offer(d_y);
        		  
              	   if(count<c[d_x][d_y]){ 
               		   count = c[d_x][d_y]; //육지도착할때마다 길이를count에 넣어줌
               	   }
              	   
              	   if(result<count){ // 전체count인 result를 계속 count와 비교해줌 
             		   result = count;
             	   }
              	 
        	  }
           }
		}
		
	}
}

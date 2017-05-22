package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class n_1194{
	int x,y,cnt,now; 
	n_1194(int x, int y, int cnt,int now){
		this.x =x;
		this.y = y;
		this.cnt = cnt;
		this.now = now;
	}
}

public class N1194 { // 달이 차오른다 - > 비트마스킹 !
	static int n;
	static int m;
	static char map[][];
	static boolean visit[][][];
	static boolean key[] ;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	
	static boolean result = false;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m][64];
        Queue<n_1194>  q = new LinkedList<>();
        
		
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					q.offer(new n_1194(i,j,0,0));
					visit[i][j][0] = true;
					map[i][j] = '.';
				}
			}
		}
		
		boolean finish = false;
	
		while(!q.isEmpty()){
			n_1194 p =q.poll();
			
			for(int i =0; i<4; i++){
				int x= p.x+dx[i];
				int y =p.y+dy[i];
				int cnt = p.cnt;
				int now = p.now;
				int now2 =0;
				if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='#'){
					if(map[x][y] == '1'){
						finish = true;
						System.out.println(cnt+1);
						break;
					}
					
					if(visit[x][y][now]==false){
					     if(map[x][y]=='.'){
							 visit[x][y][now]= true;
							 q.offer(new n_1194(x,y,cnt+1,now));
						  }
					     else if(map[x][y]-'a'>=0 && map[x][y]-'a'<6){
						  
					       if((now & (1<<(102-map[x][y])))==0){ //102-'a' = 5 임 
				                                                //102-'f' = 0 임 
					   		now2 = now + (1<<(102-map[x][y])); // 더해주는거 중요  
					   		
						   	q.offer(new n_1194(x,y,cnt+1,now2));
					   	   }
					   	   else{
					   		 now2 = now;
					      	q.offer(new n_1194(x,y,cnt+1,now2));
					   	   }
					   	    visit[x][y][now2] = true;

					   }
					     
					   if(map[x][y]-'A'>=0 && map[x][y]-'A'<6){
						   
						 if((now & (1<<(70-map[x][y])))!=0){
							 visit[x][y][now] = true;
							 q.offer(new n_1194(x,y,cnt+1,now));
						 }
					   }
					 
					}
					
				}
				
			}
			if(finish == true){
				break;
			}
		}
		
		if(finish == false){
			System.out.println(-1);
		}

	}
	/*

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice{ // - > 완탐풀어본거 
	static int n;
	static int m;
	static char map[][];
	static boolean visit[][][];
	static boolean key[] ;
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	static int ans = 0;
	static boolean result = false;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new char[n][m];
		visit = new boolean[n][m][7];
		key = new boolean[7];
		int x = 0;
		int y =0 ;
		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					visit[i][j][6] = true;
					x=i;
					y=j;
					map[i][j] = '.';
					
				}
			}
		}
		func(x,y,0,6,visit,key);
		
		
	}
	
	static void func(int a, int b,int cnt,int now, boolean v[][][],boolean alpha[]){
		for(int i =0; i<4; i++){
		
			int x = a+dx[i];
			int y = b+dy[i];
			visit= new boolean[n][m][7];
			key = new boolean[7];
			for(int k=0;k<7; k++){
				key[k] = alpha[k];
				for(int h=0; h<n; h++){
					for(int j=0; j<m; j++){
						visit[h][j][k] = v[h][j][k];
					}
				}
			}
			 
			if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='#'){
				
				if(map[x][y] == '1'){
					result= true;
					System.out.println(cnt+1);
					return;
				}
				
				if(visit[x][y][now]==false){
					 if(map[x][y] == '.'){
						 visit[x][y][now] = true;
						 func(x,y,(cnt+1),now,visit,key);
					 }
					 
					 else if(map[x][y]-'a'>=0 && map[x][y]-'a'<6){
						
						 if(key[(map[x][y]-'a')]==false){
							 key[(map[x][y]-'a')]= true;
							 now = (map[x][y]-'a');
							 func(x,y,cnt+1,now,visit,key);
						 }
						 visit[x][y][now] = true;
						 
					 }
					 else if(map[x][y]-'A' >=0 && map[x][y]-'A'<6){
						
						 if(key[(map[x][y]-'A')]==true){
							 visit[x][y][now]= true;
							 func(x,y,(cnt+1),now,visit,key);
						 }
					 }

					 
				}
				if(result == true){
					return;
				}
			}
		  	
		}
		if(result == true){
			return;
		}
	}
	
   }
    
*/

}
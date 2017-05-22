package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class n2468{
	int x;
	int y;
	n2468(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class N_2468 { // 안전영역 -> 물의 높이 0 부터 가장큰  max높이까지 반복문돌면서 
	                  //         그안에서 n*n반복문돌서 water라는 메소드 호출하며 count개수 증가시킴
	                  //          water()는  그 지점에 서 4방향을 봐서 더 높이 큰곳을 임의로 -9로해버림
	                  //          0~max까지 count수 가장 큰수를 출력.
	
	static int n ;	
    static int nump[][];	
	static int resultmax=-1;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	int map[][] = new int[n][n];
	nump = new int[n][n];
	
	int maxnum =-1;
	
	for(int i =0; i<n; i++){
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		for(int j =0; j<n; j++){
			int num = Integer.parseInt(st.nextToken());
			maxnum = Math.max(num, maxnum);
			map[i][j] = num;
			nump[i][j]=num;
		}
	}

	
    int countresult =0;	
	for(int maxnumber =0; maxnumber<maxnum; maxnumber++){ // 0부터 지역 물의 높이 가장 큰곳인  maxnum까지 돌면서 
		int count =0;
		
		for(int i =0; i<n; i++){
			for(int j =0; j<n; j++){				
				if(nump[i][j]>maxnumber){ // 큰 곳일때 count수 증가시키면서 한다.			
				water(i,j,maxnumber); //
				count++; 
				}
			}
		}
		
		countresult = Math.max(countresult, count); // 
		
	  for(int i =0; i<n; i++){ // maxnum다 돌았으면 초기화 시켜주고 다시  
		  for(int j=0; j<n; j++){
			nump[i][j]=map[i][j];  
		  }
	  }
	  
	}
	System.out.println(countresult);
 }
 
 static void water(int a, int b,int maxnumber){ // maxnumber보다 큰곳을 찾아가면서 임의로 -9로 만들어버림 
	 boolean visit[][] = new boolean[n][n];
	 Queue<n2468> q = new LinkedList<n2468>();
	 q.offer(new n2468(a,b));
	 while(!q.isEmpty()){
		n2468 p = q.poll();
		for(int i =0; i<4; i++){
			int x = p.x+dx[i];
			int y = p.y+dy[i];
			if(x>=0 && y>=0 && x<n && y<n && visit[x][y] == false && nump[x][y]>maxnumber ){
				
				visit[x][y] = true;
				nump[x][y] = -9;
				q.offer(new n2468(x, y));
			}
		}
	 }
	
 }
}

package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_2344{
	int x, y,dir;
	n_2344(int x, int y,int dir){
		this.x = x;
		this.y = y;
		this.dir = dir;
		
	}
}
public class N2344 {
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int map[][] = new int [n+2][m+2];
	for(int i =1; i<n+1; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j=1; j<m+1; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}

	
	
	Queue<n_2344> start = new LinkedList<n_2344>(); // 시작지점 큐에 넣음 
	
	//0->동 1-> 북 2-> 서 3->남
	int dx[] = {0,-1,0,1};
	int dy[] = {1,0,-1,0};
	
	int cnt =1;
	
	
	// 4방향
	for(int i=1; i<n+1; i++){//동으로 쏨
		map[i][0] =  cnt++; // 맵에 빛을 비출 순서 저장 
		if(map[i][0]==1){ //거울과 시작지점 1이 겹치니 시작지점 1은 -1로 변경 
			map[i][0]=-1;
		}
		start.offer(new n_2344(i,0,0));
	}
	for(int j=1; j<m+1; j++){//북으로 쏨
		map[n+1][j] = cnt++;
		start.offer(new n_2344(n+1,j,1));
	}
	for(int i=n; i>=1; i--){// 서로 쏨
		map[i][m+1] = cnt++;
		start.offer(new n_2344(i,m+1,2));
	}
	for(int j=m; j>=1; j--){// 남으로 쏨 
		map[0][j] = cnt++;
		start.offer(new n_2344(0,j,3));
	}
	
	StringBuilder sb = new StringBuilder();
	while(!start.isEmpty()){
		n_2344 p = start.poll();
		int x = p.x+dx[p.dir];
		int y = p.y+dy[p.dir];
		int dir = p.dir;
		while(true){
			if(map[x][y]==1){ //거울을 만나면 방향을 바꾸자 
				dir = mirror(dir);
			}
			x = x+dx[dir];
			y = y+dy[dir];
			
			if(map[x][y]!=0 && map[x][y]!=1){ //도착 하면 그때의 나온 위치를 저장 하고 break
				if(map[x][y]==-1){ // -1일경우 1로해줘야함
				 sb.append(1+" ");
				}
				else{
			    sb.append(map[x][y]+" ");
				}
			  break;
		    }
		}
	}
	System.out.println(sb.toString());

  }

  static int mirror(int dir){ // 거울반사 
	  if(dir == 0){ // 동으로 쏘다가 거울반사되면 북으로 감 
		  return 1;
	  }
	  else if(dir ==1){
		  return 0;
	  }
	  else if(dir ==2){
		  return 3;
	  }
	  else if(dir ==3){
		  return 2;
	  }
	  else return -999999;
  }
}

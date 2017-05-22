package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class n_1938{
	int ax,ay,bx,by,cx,cy,cnt,dir,state;
	n_1938(int ax, int ay, int bx, int by, int cx, int cy, int cnt,int state){
		this.ax = ax;
		this.ay = ay;
		this.bx = bx;
		this.by = by;
		this.cx = cx;
		this.cy = cy;
		this.cnt = cnt;
		this.state = state; // 현재 가로상태인지 세로상태인지 확인 
	}
}
public class n1938 {  // 통나무 옮기기 
	static int n;
	static int map[][];
	static boolean visit[][][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static int d1x[]= {1,-1};
	static int d1y[]= {-1,1};
	static int d3x[]= {-1,1};
	static int d3y[]= {1,-1};
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	n = Integer.parseInt(bf.readLine());
	Queue<n_1938> q = new LinkedList<>();
	int c[][] = new int[3][2];
	map= new int [n][n];
	visit = new boolean[n][n][2];
	int index = 0;
	int index2=0;
	int t =0; // 가로 세로 판별 
	int s =0; // 가로 /세로 판별  
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		t=0;
		for(int j =0; j<n; j++){
			if(str.charAt(j)=='B'){
				map[i][j] = 0;
				c[index][index2] = i;
				c[index][index2+1] = j;
				index++;
				t++;
			}			
			else if(str.charAt(j)=='E'){
				map[i][j] = -7;
				
			}
			else{
			 map[i][j] = str.charAt(j)-48;
			}
				
		}
		if(t==3){ //가로 
			s =1;
		}
			
		
	}
	
	q.offer(new n_1938(c[0][0],c[0][1],c[1][0],c[1][1],c[2][0],c[2][1],0,s));
	
	boolean result = false;
	while(!q.isEmpty()){
		n_1938 p = q.poll();
		if(map[p.ax][p.ay]== -7 && map[p.bx][p.by]==-7 && map[p.cx][p.cy]==-7){
			System.out.println(p.cnt);
			result = true;
			break;
		}
		for(int i =0; i<4; i++){ // 이동 
			int x1 = p.ax +dx[i];
			int x2 = p.bx +dx[i];
			int x3 = p.cx +dx[i];
			int y1 = p.ay +dy[i];
			int y2 = p.by +dy[i];
			int y3 = p.cy +dy[i];
			int cnt = p.cnt;
		    int state = p.state;
		   if(x1>=0 && y1>=0 && x2>=0 && y2>=0 && x3>=0 && y3>=0 
				   && x1<n && y1<n && x2<n && y2<n && x3<n && y3<n){
			   if(visit[x2][y2][state] == false){ // 가운데 것만 방문 확인하면 된다( 가로냐 세로에 따라 )
				   visit[x2][y2][state] = true;
				   if(map[x1][y1] != 1 && map[x2][y2]!=1 && map[x3][y3]!=1){ // 하나라도 나무가 없어야 함 
					 q.offer(new n_1938(x1,y1,x2,y2,x3,y3,cnt+1,state)); 
				   }
			   }
		   }
		}
		
		int state = p.state;
		
			   if(state ==1){ // 현재 가로일경우  
				   boolean check = false;
				   for(int a =2; a<4; a++){ // 위아래 확인해서 1이있나 확인 또 범위 초과도 안되게 
					   int k1 = p.ax+dx[a];
					   int k11 = p.ay+dy[a];
					   int k2 = p.bx+dx[a];
					   int k22 = p.by+dy[a];
					   int k3 = p.cx+dx[a];
					   int k33 = p.cy+dy[a];
					   
					   if(k1>=0 && k2>=0 && k3>=0 && k1<n && k2<n && k3<n &&  k11>=0 && k22>=0 && k33>=0 && k11<n && k22<n && k33<n){
						   if(map[k1][k11]==1  || map[k2][k22] ==1 || map[k3][k33] ==1 ){
							   check = true;
						   }
					   }
					   else{
						   check = true;
					   }
				   }
				   if(check== false){ // 조건통과했으면 돌린다 가운데 냅두고 양끝에 만 돌림 
					   int i=1;
					   int x1 = p.ax+d1x[i];
					   int y1 = p.ay+d1y[i];
					   int x3 = p.cx+d3x[i];
					   int y3 = p.cy+d3y[i];
					   int x2 = p.bx;
					   int y2 = p.by;
					   int cnt = p.cnt;
					   state = 0;
					   if(x1>=0 && y1>=0 && x2>=0 && y2>=0 && x3>=0 && y3>=0 
							   && x1<n && y1<n && x2<n && y2<n && x3<n && y3<n){
						   if(visit[x2][y2][state] == false){ // 돌린상태가 false인 경우에만 돌림  
							   visit[x2][y2][state] = true;
					   q.offer(new n_1938(x1,y1,x2,y2,x3,y3,cnt+1,state));
						   }
					   }
				   }
			   }
			   else if(state == 0){ // 세로 
				   boolean check = false;
				   for(int a =0; a<2; a++){
					   int k1 = p.ax+dx[a];
					   int k11 = p.ay+dy[a];
					   int k2 = p.bx+dx[a];
					   int k22 = p.by+dy[a];
					   int k3 = p.cx+dx[a];
					   int k33 = p.cy+dy[a];
					   if(k1>=0 && k2>=0 && k3>=0 && k1<n && k2<n && k3<n && k11>=0 && k22>=0 && k33>=0 && k11<n && k22<n && k33<n){
						   if(map[k1][k11]==1  || map[k2][k22] ==1 || map[k3][k33] ==1 ){
							   check = true;
						   }
					   }
					   else{
						   check =true;
					   }
				   }
				   if(check== false){
					  
					   int i=0;
					   int x1 = p.ax+d1x[i];
					   int y1 = p.ay+d1y[i];
					   int x3 = p.cx+d3x[i];
					   int y3 = p.cy+d3y[i];
					   int x2 = p.bx;
					   int y2 = p.by;
					   int cnt = p.cnt;
					   state = 1;
					  
					   if(x1>=0 && y1>=0 && x3>=0 && y3>=0 
							   && x1<n && y1<n && x3<n && y3<n){
						   if(visit[x2][y2][state]==false){
						   visit[x2][y2][state]=true;
					      q.offer(new n_1938(x1,y1,x2,y2,x3,y3,cnt+1,state));
						   }
					   }
				   }
			   }
			   
		   	
	}
	if(result ==false){
		bw.write("0");
		bw.close();
	}
	
 }
}

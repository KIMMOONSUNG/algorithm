package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class sm{
	int x,y,dir,index;
	sm(int x, int y, int dir , int index){
		this.x = x;
		this.y = y;
		this.dir =dir;
		this.index = index;
	}
	
}
public class G_13567 { // 로봇 ( 꼭지점 )
	static int n;
	static int k;
	static int map[][];	
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
    static String order1[] ; //명령 
    static int order2[] ; // 명령 
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	k = Integer.parseInt(st.nextToken());
	map = new int[n+1][n+1]; // 꼭지점이라 그걸 사각형 하나로 보니 -> 1개 더 증가시킴 
	order1 = new String[k];
	order2 = new int [k];
	
	for(int i =0; i<k; i++){
		st = new StringTokenizer(bf.readLine());
		String str = st.nextToken().toString();
		int num = Integer.parseInt(st.nextToken());
		order1[i] = str;
		order2[i] = num;
	}
	
	Queue<sm> q= new LinkedList<>();
 	q.offer(new sm(n,0,0,0));
	boolean finish = false;
	
 	while(!q.isEmpty()) {
 		
 		sm p = q.poll();
 		
 		if(p.index >= k){ // 인덱스가 명령 초과하면 끝 
 			map[p.x][p.y] = -1; // 마지막 위치를 알아야하니 -1 로 넣어주고 
 			break;
 		}
 		String str = order1[p.index];
 		int count = order2[p.index];
 		if(str.equals("MOVE")){
 			int x = p.x+dx[p.dir]*count;
 			int y = p.y+dy[p.dir]*count;
 			if(x>=0 && y>=0 && x<=n && y<=n){ // 범위안에 들어가면 인덱스 증가시키고 
 				q.offer(new sm(x,y,p.dir,(p.index+1)));
 			}
 			if(x<0 || y<0|| x>n || y>n){ // 범위 안에 못들면 끝내야함 
 				finish = true;
 				break;
 			}
 		}
 		else if (str.equals("TURN")){  // 방향바꿔주고 인덱스 증가 
 		  q.offer(new sm(p.x,p.y,direction(p.dir,count),(p.index+1)));
 		}
 	}
 	
 	if(finish == true){
 		System.out.println(-1);
 	}
 	else{ // -1 인곳 찾아서 위치 출력 
 		int a =0;
 		
 		for(int i =n; i>=0; i--){
 			int b=0;
 			for(int j =0; j<=n; j++){
 				if(map[i][j] == -1){
 					System.out.println(b+" "+ a);
 					break;
 				}
 				b++;
 			}
 			a++;
 		}
 	}
	
 }
 static int direction(int dir, int rl){ // rl -> 0 은 왼쪽  rl -> 1 은 오른쪽 
	 // 오 -> 왼(위) , 오 (아래)
	 // 왼 -> 왼(아래), 오(위) 
	 // 아래 -> 왼(오), 오 (왼) 
	 // 위 -> 오 (오) ,왼 (왼 ) 
	 if(dir == 0){
		 if(rl ==0){
			 return 3;
		 }
		 else{
			 return 2;
		 }
	 }
	 else if(dir==1){
		 if(rl ==0){
			 return 2;
		 }
		 else {
			 return 3;
		 }
	 }
	 else if(dir==2){
		 if(rl==0){
			 return 0;
		 }
		 else{
			 return 1;
		 }
	 }
	 else if(dir==3){
		 if(rl ==0){
			 return 1;
		 }
		 else{
			 return 0;
		 }
	 }
	 else {
		 return -9999;
	 }
 }
}

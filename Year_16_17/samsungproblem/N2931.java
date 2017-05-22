package samsungproblem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class n_2931{
	int x,y;
	n_2931(int x, int y){
		this.x =x ;
		this.y = y;
	}
}
/*
3 3
14.
2.M
.Z.
*/
public class N2931 { // 2931 가스관 
	static int n;
	static int m;
	static char map[][];
	static boolean visit[][];
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	//M주변에 가스관이 없을시 . 곳에 놓아서 구할수있는 가스관 넣을 배열들 .
	static int ax [] = new int [3]; //x 좌표  
	static int ay [] = new int [3]; //y 좌
	static int ac[] = new int[3]; // 다음거를 봤 는데 z을 제외한 연결할수 있는 것  
	static char gas[] = new char[3]; // 놓을수있는 가스관 
	///M 주 변에 가스관 있으면 그냥 인덱스 0 출력하면되는거  
	
public static void main(String[] args) throws IOException{
	
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map= new char [n][m];
	visit=  new boolean[n][m];
	Queue<n_2931> q= new LinkedList<>();
	
	int sx = 0;
	int sy = 0;
	int zx = 0;
	int zy = 0;
	
	for(int i =0; i<n; i++){
		String str = bf.readLine();
		for(int j =0; j<m; j++){
			map[i][j] = str.charAt(j);
			if(map[i][j] =='M'){
				sx= i;
				sy =j;
			}
			if(map[i][j] == 'Z'){
				zx = i;
				zy = j;
			}
		}
	}
/// 1) 만일 Z주변에 가스관 이 하나라도 있으면 Z를 . 으로 바꿔준다 -> Z는가스관 하나만 연결가능 (문제나옴) 
//반ㄹㅖ
/*
|-. 
|.M
2Z.
*/
	boolean check= false;
	for(int i =0; i<4; i++){
	  int x = zx+dx[i];
	  int y=  zy+dy[i];
	  if(x>=0 && y>=0 && x<n && y<m){
		  if(map[x][y] !='.'){
			  check = true; 
		  }
	  }
	}
	if( check == true){ // 가스관 하나라도 있으면 . 으로 바꿈 
		map[zx][zy] = '.';
	}

	
	visit[sx][sy] = true;
	
	for(int i =0; i<4; i++){
	 int x = sx+dx[i];
	 int y = sy+dy[i];
	 if(x>=0 && y>=0 && x<n && y<m && map[x][y] !='.'){
		 if(visit[x][y] == false){
			 visit[x][y] = true;
		 q.offer(new n_2931(x,y));
		 }
	 }
	}
	
	int c =0;
	if(q.isEmpty()){ // M 주변 비어있을시에 
		
		for(int i =0; i<3; i++){
			ac[i] = -1;
		} // 일단 초기화 시킴 
		
		for(int i =0; i<4; i++){
			 int x = sx+dx[i];
			 int y = sy+dy[i];
			 if(x>=0 && y>=0 && x<n && y<m && map[x][y] =='.'){
				   func(x,y,i,c); // 점인거 주변 3곳의 좌표를  함수호출 
				   c++; // 인덱스라 생각 
			 }
		}
	}
	
	
	
	// '|' -> 위/아래  '-' ->  오/왼  '+' ->4방향 
	// '1' -> 오/아래    '2' ->  오/위  '3' -> 왼/위 '4' -> 왼/아래 
	else{ // M 주변 비어있지 않을때 
		
	boolean finish = false;
	
	while(!q.isEmpty()){
		
		n_2931 p = q.poll();
		for(int i =0; i<4; i++){ //현재 파이프에 모양에따라 그 방향으로 이동이 가능한지를 봄 
			if(i==0 && (map[p.x][p.y] =='|' || map[p.x][p.y] =='3' || map[p.x][p.y] =='4') ){
				continue;
			}
			if(i==1 && (map[p.x][p.y] =='|' || map[p.x][p.y] =='1' || map[p.x][p.y] =='2') ){
				continue;
			}
			if(i==2 && (map[p.x][p.y] =='-' || map[p.x][p.y] =='2' || map[p.x][p.y] =='3') ){
				continue;
            }
			if(i==3 && (map[p.x][p.y] =='-' || map[p.x][p.y] =='1' || map[p.x][p.y] =='4') ){
				continue;
            }
			
			int x=  p.x+dx[i];
			int y=  p.y+dy[i];
			if(x>=0 && y>=0 && x<n && y<m){
				if(visit[x][y] == false){

					if(map[x][y] == '.'){ // . 이 하나라도 나오면 그 곳이 해커가 뚫어놓은곳임 그래서 함수호출 
						func(x,y,i,0);
						q.clear();
					    finish = true;
						break;
					}
					
					else{
					q.offer(new n_2931(x,y));
					visit[x][y] = true;
					}
				}
			}
		}
		if(finish == true){
			break;
		}
		
	 }
	
	}
	
	///// 함수 호출 후 계산하는 부분 ////// 
	 
	if(c==0){ //M주변중 하나라도 연결되어있다는것이고 인덱스 0  출력 
		System.out.println(ax[0] +" "+ ay[0] + " " + gas[0]);
	}
	else { //M주변이 다 . 인경우 
		
		int num =-10000;
		int index = -1;
		for(int i =0; i<3; i++){
			num = Math.max(ac[i], num);
		}
		for(int i =0; i<3; i++){
			if(ac[i]==num){
				index = i;
			}
		}
		
		System.out.println(ax[index] +" "+ay[index] +" " + gas[index]);
	}
	//////////////////////////////////
	
 }

	// '1' -> 오/아래    '2' ->  오/위  '3' -> 왼/위 '4' -> 왼/아래
    // '|' -> 위/아래  '-' ->  오/왼  '+' ->4방향 
static void func(int a, int b , int dir , int in1){ // (x좌표, y좌표, 온 방향 , 인덱스 )
	boolean arr[] = new boolean[7]; // 0 ->1 , 1->2 ,2-> 3 , 3->4 , 4->| ,5->- , 6-> +
	
	int cnt = 0; // 3 이면 주변 파이프가 다 있어 무조건 + 모양 
	int excep =0; // Z를 제외하고 주변 연결될수 있는 파이프 수 계산 
	
	
	// 방향에 따라 그다음다음의 파이프모양이 받아줄수있는지를 본다 
	
	 if(dir== 0){ // 왼 ->오 로 온거임  
		//가능  - , + , 3, 4 
	  for(int i =0; i<4; i++){
		  int x = a+dx[i];
		  int y = b+dy[i];
		  if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='.'){
			  if(i==0 && (map[x][y] =='-' || map[x][y] == '+' || map[x][y] =='3' || map[x][y] =='4' || map[x][y]=='M')){ 
				  //4가지 다 가능한데 이것만이면 -  
				 cnt++;
				 excep ++;
				  arr[5] = true;
			  }
			  else if(i==0 && map[x][y] =='Z'){
				  cnt++;
				  arr[5] = true;
			  }
			  if(i==2 &&( map[x][y] =='|' || map[x][y] =='+' || map[x][y] =='2' || map[x][y] =='3' || map[x][y]=='M')){
				  // + , 4 가능데 이것만이면 4
				  cnt++;
				  excep ++;
				  arr[3] = true;
			  }
			  else if(i==2 && map[x][y] =='Z'){
				  cnt++;
				  arr[3] = true;
			  }
			  if(i==3 && (map[x][y] =='|' || map[x][y] =='+' || map[x][y] =='1' || map[x][y] == '4' ||  map[x][y]=='M')){
				  // +,3 가능한데 이것만이면 3
				  cnt++;
				  excep ++;

				  arr[2] = true;
			  }
			  else if(i==3 && map[x][y] =='Z'){
				  cnt++;
				  arr[2] = true;
			  }
		  }
	  }
	  
	 }
	 
	 else if(dir==1){ // 오 - > 왼 에서 온거 
		//가능 - , + , 1,2
		 for(int i =0; i<4; i++){
			  int x = a+dx[i];
			  int y = b+dy[i];
			  if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='.'){
				  if(i==1 && (map[x][y] =='-' || map[x][y] == '+' || map[x][y] =='1' || map[x][y] =='2' ||map[x][y]=='M')){
					  excep ++;
					  cnt++;
					  arr[5] = true;
				  }
				  else if(i==1 && map[x][y] =='Z'){
					  cnt++;
					  arr[5] = true;
				  }
				  if(i==2 &&( map[x][y] =='|' || map[x][y] =='+' || map[x][y] =='2' || map[x][y] =='3' ||map[x][y]=='M')){
			         cnt++;
			         excep ++;
			         
					  arr[0] = true;
				  }
				  else if(i==2 && map[x][y] =='Z'){
					  cnt++;
					  arr[0] = true;
				  }
				  if(i==3 && (map[x][y] =='|' || map[x][y] =='+' || map[x][y] =='1' || map[x][y] == '4' || map[x][y]=='M')){
		            cnt++;
		            excep ++;
					  arr[1] = true;
				  }
				  else if(i==3 && map[x][y] == 'Z'){
					  cnt++;
					  arr[1] = true;
				  }
			  }
		  }
		 
	 }
	 
	 else if(dir==2){ // 위 -> 아래 로 온거 
		//가능 |,+, 2,3,
		 for(int i =0; i<4; i++){
			  int x = a+dx[i];
			  int y = b+dy[i];
			  if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='.'){
				  if(i==0 && (map[x][y] =='-' || map[x][y] == '+' || map[x][y] =='3' || map[x][y] =='4'|| map[x][y]=='M')){
					 cnt++;
					 excep ++;
					  arr[1] = true;
				  }
				  else if(i==0 && (map[x][y] =='Z')){
					  cnt++;
					  arr[i] = true;
				  }
				  if(i==1 && (map[x][y] =='-' || map[x][y] == '+' || map[x][y] =='1' || map[x][y] =='2'|| map[x][y]=='M')){
					  cnt++;
					  excep++;
					  arr[2] = true;
				  }
				  else if(i==1 && map[x][y] == 'Z'){
					  cnt++;
					  arr[2] = true;
				  }
				  if(i==2 &&( map[x][y] =='|' || map[x][y] =='+' || map[x][y] =='2' || map[x][y] =='3'|| map[x][y]=='M')){
			          cnt++;
			          excep++;
					  arr[4] = true;
				  }
				  else if(i==2 && map[x][y] == 'Z'){
					  cnt ++;
					  arr[4] = true;
				  }
				  
			  }
		  }
		 
		
	 }
	 
	 else if(dir==3){ // 아래 -> 위 온거 
		//가능 |,+, 1,4,
		 
		 for(int i =0; i<4; i++){
			  int x = a+dx[i];
			  int y = b+dy[i];
		 if(x>=0 && y>=0 && x<n && y<m && map[x][y]!='.'){
			  if(i==0 && (map[x][y] =='-' || map[x][y] == '+' || map[x][y] =='3' || map[x][y] =='4'||  map[x][y]=='M')){
				 cnt++;
				 excep ++;
				  arr[0] = true;
			  }
			  else if(i==0 && map[x][y] =='Z'){
				  cnt++;
				  arr[0] = true;
			  }
			  if(i==1 && (map[x][y] =='-' || map[x][y] == '+' || map[x][y] =='1' || map[x][y] =='2'|| map[x][y]=='M')){
				  cnt++;
				  excep ++;
				 
				  arr[3] = true;
			  }
			  else if(i==1 && map[x][y] =='Z'){
				  cnt++;
				  arr[3] = true;
			  }
			  if(i==3 && (map[x][y] =='|' || map[x][y] =='+' || map[x][y] =='1' || map[x][y] == '4'|| map[x][y]=='M')){
					cnt++;
					excep ++;
				  arr[4] = true;
			  }
			  else if(i==3 && map[x][y] == 'Z'){
				  cnt ++;
				  arr[4] = true;
			  }
			  
		  }
		 }
	 }
	 
	 ///////
	 
	 if(cnt ==0){ // 하나도 맞는게 없는거니까 끝내 
		 return;
	 }
	  int index =-1 ;
	  char ch ='0';  
	  if(cnt==3){ //3 이면 주변에 맞는 파이프가 다 있는거니 +
	    ch = '+';
	  }
	  else {
		  for(int i =0; i<7; i++){
			  if(arr[i] == true){ // 맞는 파이프는 True
				  index = i;
			  }
		  }
		  
		 switch (index) {
		case 0:
			ch='1';
			break;
		case 1:
			ch='2';
			break;
		case 2:
			ch='3';
			break;
		case 3:
			ch='4';
			break;
		case 4:
			ch='|';
			break;
		case 5:
			ch='-';
			break;
		case 6:
			ch='+';
			break;
		
		default:
			break;
		}
	  }
	  
	  //M 이 다 빈공간인경우0~3 인덱스 넣어놓고 비교 
	  // M이 파이프 하나라도 연결될 경우 인덱스 0출력 
	  ax[in1] = (a+1);
	  ay[in1] = (b+1);
	  ac[in1] = excep; // Z를 제외한 주변에 맞는 파이프 개수 저장 
	  gas[in1]= ch;
}

}

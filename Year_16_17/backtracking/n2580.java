package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2580 { // 스도쿠
	static int n =9;
	static int map[][] ;
	static boolean [][][] check ;
	static boolean result ;
public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	map = new int [n][n];
	check = new boolean[3][n][10];
	StringTokenizer st;
	
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine());
		for(int j =0; j<n; j++){
			map[i][j] = Integer.parseInt(st.nextToken());
			if(map[i][j] !=0){
				check[0][i][map[i][j]] = true; // 행 ->> i행에 숫자 map[i][j] 가 있으면 true
				check[1][j][map[i][j]] = true; // 열 ->> j열에 숫자 map[i][j] 가 있으면 true 
				check[2][square(i,j)][map[i][j]] = true; // 사각형 ->>  몇번째 정사각형 에 숫자 map[i][j] 가 있으면 true
			}
		}
	}
	
	func(0);
}
 
static int square(int x, int y){ // 몇번째 정사각형인지 리턴해줌 
	
	 return (x/3) * 3 + (y/3); 
}
 
static void func(int num){
	if(result== true){ //이거 해야 시간초 단축 
		return;
	}
	 if( num == 81){ // 81 이면 다 본거니까 끝 
		 for(int i =0; i<n; i++){
			 for(int j =0; j<n; j++){
				 System.out.print(map[i][j] +" ");
			 }
			 System.out.println();
		 }
		 result = true;
		 return;
	 }
	 
	 int x = num/n; // 행 ->> 0~ 9 까지 0 10~ 19 까지 1 ....
	 int y = num%n; // 열 ->> 0~9 ..
	 
	 if(map[x][y] !=0){
		 func(num+1); // 0 이 아니면 빈칸이 아니니까  하나 올림 
	 }
	 
	 else{ // 0이면 빈칸이니까 
		 for(int i =1; i<=9; i++){
			 if(check[0][x][i]==false && check[1][y][i]==false && check[2][square(x,y)][i]==false){
				 check[0][x][i] = true;
				 check[1][y][i] = true;
				 check[2][square(x,y)][i] = true;
				 map[x][y] = i;
				 func(num+1);
				 //백트래킹 
				 map[x][y] = 0;
				 check[0][x][i] = false;
				 check[1][y][i] = false;
				 check[2][square(x,y)][i] = false;
			 }
		 }
	 }
	 
 }
}

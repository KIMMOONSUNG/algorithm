package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9663_2 { // N- Queen
	static int n;
	static boolean map[][];
	static int result =0 ;
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map = new boolean [n][n];
	func(0);
	System.out.println(result);
}

static void func(int a){// 전체 다 놓음 0,0부터 놓면서 시작 
	if(a==n){
		result +=1;
		return;
	}
	for(int b= 0; b<n ; b++){
		map[a][b] = true;
		if(check(a,b)==false){
			func(a+1);
		}
		map[a][b] = false;
	}
}

static boolean check(int a, int b){ // 검사 
	
	for(int i=0; i<a; i++){ //위로 쭉 봄 
		if(map[i][b]==true){
			 return true;	
		}
	}	
		int x = a-1;
		int y = b-1;
		while (x >= 0 && y >= 0) { // \ 대각선 위 쭉봄 
			if(map[x][y] == true){
				return true;
			}
			x -= 1;
			y -= 1;
		}
		
		x = a - 1;
		y = b + 1;
		while (x >= 0 && y < n) { // / 대가선 위 쭉
			if(map[x][y] == true){
				return true;
			}
			x -= 1;
			y += 1;
		}
		return false;
	
 }
}

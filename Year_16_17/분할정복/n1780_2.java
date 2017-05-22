package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n1780_2 { // 종이의 개수 
	static int map[][];
	static int cnt[] = new int[3];  //-> -1, 0 , 1 의 개수 저장 
	static int n;
 public static void main(String[] args) throws IOException {
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	map = new int[n+1][n+1];
	for(int i =1; i<=n; i++){
		String str[] = bf.readLine().split(" ");
		for(int j=1; j<=n; j++){
			map[i][j] = Integer.parseInt(str[j-1]);
		}
	}
	
	func(1,1,n);
	
	for(int i =0; i<3; i++){
		System.out.println(cnt[i]);
	}
 }
 
 static void func(int x, int y, int num){
	 if(same(x,y,num)==true){ 
		 cnt[map[x][y]+1] += 1;
		 return;
	 }
	 int m = num/3;
	 for(int i =0; i<3; i++){
		 for(int j =0; j<3; j++){
			 func(x+i*m , y+j*m , m); //1,1,3 // 1,4,3 // 1,7,3 // 
		 }
	 }
 }
 
 static boolean same(int x, int y, int num){
	 for (int i = x; i < x+num; i++){//행 ->> //1~3 // 1~3 // 1~3
			for (int j = y; j < y+num; j++) {// 열->>//1~3// 4~6// 7~9
				if (map[i][j] != map[x][y]) return false;
			}
	}
	return true;
 }
 
 
}

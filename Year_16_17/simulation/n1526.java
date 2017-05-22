package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//147 -> 77
//460-> 447
//700 -> 477
public class n1526 { // 가장 큰 금민 수 
	static int n;
	static int result;
 public static void main(String[] args) throws IOException {
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	dfs(4);
    dfs(7);
    System.out.println(result);
}
 
 static void dfs(int number){
	 if(number > n){
		 return;
	 }
	 result = Math.max(result , number);
	 dfs(number * 10 + 4);
	 dfs(number * 10 + 7);
 }
 
}



package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2331{ // 반복수열
	// 57-> 74-> 65-> 61-> 37 
	//-> 58 -> 89 -> 145 -> 42 -> 20 -> 4 -> 16 -> 37 
	 // 따라서 37이 5번째이니까 5-1= 4개가 답 
	static int[]check = new int[1000000];
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int a = Integer.parseInt(st.nextToken());// a숫자 시작 
	int p = Integer.parseInt(st.nextToken()); // 각자리수를 p번곱한거 ex 57 = 5*2 + 7*2 =74
	System.out.println(length(a,p,1));
	
	
}
 static int length(int a, int p, int cnt){
	 if(check[a]!=0){ // 0이 아니면 방문했는데 몇번째 방문인지를 .
		 return check[a]-1; //답
	 }
	 check[a] = cnt;
	 int b = next(a,p); //b는 다음 수   
	 // a->b로 갈때 a가 cnt이면 b는 cnt+1
	 return length(b,p,cnt+1);
 }
 
 static int next(int a, int p){
	 int ans = 0;
	 
	 while(a>0){
		 ans+=pow(a%10 , p);
		 a= a / 10; 
	 }

	 return ans;
 }
 
 static int pow (int x, int p){
	 int ans = 1;
	 for(int i =0; i<p ; i++){ // 수의 p제곱이니까 (p번곱하는거니)
		 ans = ans * x;
	 }
	 return ans;
 }

}

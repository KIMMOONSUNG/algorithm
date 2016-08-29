package SAMSUNG;

import java.util.Scanner;

public class N_10174{ //팰린드롬
 public static void main(String[] args){
	Scanner sc= new Scanner(System.in);
	int N = sc.nextInt();
	// 대소문자 구분안한다 (대문자와 소문자의 차이는 32)/빈칸은 구분
	int pel[] = new int[100000];
	sc.nextLine();
	for(int i =0; i<N; i++){
	 String str = sc.nextLine(); // 빈칸이있어 next()쓰지말고 nextLine()으로
	 for(int j =0; j<str.length(); j++){
		 pel[j] = str.charAt(j)-48; //-48해야 숫자 비교할수있다 안쓰면 밑에 +32 못함  
	 }	
	 
	 int s=0;
	 int e=str.length()-1;
	 while(true){
		 int start = pel[s];
		 int last = pel[e];
		 if(start != last){ //영문자 대소구분안하기위해 +32
			 if(start +32 == last || start == last+32){
			 }
			 else{
			 System.out.println("No");
			 break;
			 }
		 }
		 if(s==e || s+1==e){
			 System.out.println("Yes");
			 break;
		 }
		 s++;
		 e--;
	 }
	}	
 }
}

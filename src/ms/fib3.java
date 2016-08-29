package ms;

import java.util.Scanner;

//피보나치 동적프로그래밍2//

public class fib3 { 
 static Scanner sc = new Scanner(System.in);
 static int input = sc.nextInt();
 static int arr[] = new int[input];
 public static void main(String[] args) {
	for(int n= 1; n<input; n++){
		System.out.print(fibo(n)+"//");
	}
}
 
 static int fibo(int n){
	 if(arr[n]!=0) //재귀호출을 사용하되 한번 호출된것은 메모해 둠으로써 중복을 피함 -> 동적프로그래밍 메모이제이션
	  return arr[n];
	 else{
		if(n==1 || n==2){
			arr[n]=1;
		}
		else{
			arr[n]=arr[n-1]+arr[n-2];
		}
		return arr[n];
	 }
	 
 }
}

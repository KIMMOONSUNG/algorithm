package ms;

import java.util.Scanner;
///피보나치 재귀호출 함수 
public class fib {
	public static void main(String[] args) {
		int input = 10; // 10개 출력
		for (int i = 1; i <= input; i++) {
			System.out.print(fibo(i)+"//");
		}
	}

	public static int fibo(int n) { //피보나치 재귀호출 
		if (n <= 1)
			return n;
		else
			return (fibo(n - 1) + fibo(n - 2));
	}
}

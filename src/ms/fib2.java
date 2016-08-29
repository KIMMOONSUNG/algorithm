package ms;

import java.util.Scanner;

// 피보나치 동적프로그래밍1//
public class fib2 {
	static Scanner sc = new Scanner(System.in);
	static int input = sc.nextInt();
	public static int arr[] = new int[input];

	public static void main(String[] args) {
		for (int n = 1; n < input; n++) {
			System.out.print(fibo(n) + "//");
		}
	}

 public static int fibo(int n) {
		arr[1] = 1;
		arr[2] = 1; // 중복제거하기위함
		for (int a = 3; a <= n; a++) { // 배열에 값을 저장하고 호출할때 저장된 값을 불러오므로써
										// 기존 재귀함수에서 중복호출비효율 제거.
			arr[a] = (arr[a - 1] + arr[a - 2]);
		}
		return arr[n];
	}
}

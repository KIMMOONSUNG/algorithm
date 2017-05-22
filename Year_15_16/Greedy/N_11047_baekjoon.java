package Greedy;

import java.util.Scanner;

public class N_11047_baekjoon {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 개수
		int k = sc.nextInt(); // 만들어야 할 값 : K원
		int coin[] = new int[n];

		for (int i = n - 1; i >= 0; i--) { // 값 큰것부터 배열에 채우기위해
			coin[i] = sc.nextInt();
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			count += k / coin[i]; 
			k %= coin[i];
		}
		System.out.println(count);
	}
}

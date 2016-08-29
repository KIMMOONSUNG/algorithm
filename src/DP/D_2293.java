package DP;

import java.util.Scanner;

public class D_2293 {
	public static void main(String[] args) { // 동전별로 경우의 수로 구함 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 동전 개수
		int total = sc.nextInt(); //구하고자하는 최종금액
		int a[] = new int[n + 1]; // 동전종류저장
		int d[] = new int[total + 1]; // 동전 합들을 저장
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();      
		}
		d[0] = 1;
		for (int i = 1; i <= n; i++) { // coin을 위한
			for (int totalcoin = 1; totalcoin <= total; totalcoin++) { // K까지의 합이니까 동전의 값을 K까지 하나씩올라가며 
				if (totalcoin >= a[i]) { //동전종류가 구하고자하는 최종 금액보다 작거나 같아야함 
					d[totalcoin] += d[totalcoin - a[i]]; 
				}
			}
		}
		System.out.println(d[total]);
	}
}

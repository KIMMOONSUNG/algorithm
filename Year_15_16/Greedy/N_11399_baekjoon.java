package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class N_11399_baekjoon {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++){
			a[i] = sc.nextInt();
		}
		int sum = 0;
		int result = 0;
		Arrays.sort(a);
		for (int i = 0; i < n; i++){
			sum += a[i];
			result += sum;
		}
		System.out.println(result);
	}
}

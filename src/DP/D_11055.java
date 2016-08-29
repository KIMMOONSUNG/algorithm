package DP;

import java.util.Scanner;

public class D_11055 { //★ 11722, 2631 , 11053은 길이고 이거는 합이다.
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int d[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			d[i] = a[i]; 
			for (int j = 0; j < i; j++){  
				if (a[i] > a[j] && d[i]< d[j]+a[i]){ 
					// 현재값과 그 전값들을 쭉비교하는데
					// 현재값보다 작을때 && 비교하면서 그중에서 합이 가장큰거를
					// 현재 자기 자신과 더해서 
					d[i] = d[j]+a[i]; // d[i]에 넣는다.
				}
			}
		}
		int max =0;
		for (int i = 0; i < n; i++) {
			if(max<d[i]){
				max = d[i];
			}
		}
		System.out.println(max);
	}
}

package DP;

import java.util.Scanner;

public class D_2631_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n + 1];
		int d[] = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
		}
		int max =0;
		for(int i =1; i<=n; i++){
			d[i] = 1;
			for(int j=1; j<i; j++){
				if(a[i]>a[j] && d[i] < d[j]+1 ){
					d[i] = d[j]+1;
				}
			}
			max = Math.max(max, d[i]);
		}
        System.out.println(n-max);
	}
}

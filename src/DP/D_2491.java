package DP;

import java.util.Scanner;

public class D_2491 {// 11053 과 비슷 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num[] = new int[N];
		int d[] = new int[N];
		int d2[] = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		d[0] = 1;
		d2[0] = 1;
		for (int i = 1; i < N; i++) { 
			d[i]=1;
			d2[i]=1;
			for(int j = i-1; j<i; j++){ //이건 건너뛰는게 아니라서 그 바로 전 이랑 만비교 
				if (num[i] >= num[j] && d[i] < d[j] + 1) {
					d[i] = d[j] + 1;
				}
				if (num[i] <= num[j] && d2[i] < d2[j] + 1) {
					d2[i] = d2[j] + 1;
				}
			}
		}		
		int max = 0;
		int max2 = 0;
		for (int i = 0; i < N; i++) {
			if (max < d[i]) {
				max = d[i];
			}
			if (max2 < d2[i]) {
				max2 = d2[i];
			}
		}
		if (max > max2) {
			System.out.println(max);
		} else
			System.out.println(max2);
	}
}

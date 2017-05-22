package DP;

import java.util.Scanner;

public class D_11722 { //2631과 비교 //11053 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a[] = new int[n];
		int d[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}
		int max =0;
		for (int i = 0; i < n; i++) { //기준하는 인덱스값 i
			d[i]=1; // 자기 자신 포함해야해서 1을 넣어주고 시작 
			for (int j = 0; j < i; j++) { // 비교하는 인덱스값 j
				if (a[i] < a[j] && d[i]<d[j]+1) {  
					d[i] = d[j] +1;
				}
			}
			if (max < d[i]) { // 배열에 넣어진 것중 최대길이를 max에 넣는다.
				max = d[i];
			}
		}
		System.out.println(max);
	}
}

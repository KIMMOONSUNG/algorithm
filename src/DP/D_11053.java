package DP;

import java.util.Scanner;

public class D_11053 { //2631과 비슷 ★ -길이  // 11722
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int a[] = new int[N];
		int d[] = new int[N];//자기포함해 정열된 길이 수를 저장
		for(int i =0; i<N; i++){
			a[i] = sc.nextInt();
		}
		for(int i =0; i<N; i++){
			d[i] = 1;
			for(int j=0; j<i; j++){
				if(a[i]>a[j] && d[i]<d[j]+1){
					d[i] = d[j]+1;
				}
			}
		}
		int max= 0;
		for(int i =0; i<N; i++){
			if(max < d[i]){
				max = d[i];
			}
		}
		System.out.println(max);
		
	}
}

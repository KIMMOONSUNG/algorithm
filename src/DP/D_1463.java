package DP;

import java.util.Scanner;

public class D_1463 { // 1만들기 세조건 에서 의 최소 경우를 구하는 문제이다 .
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int d[] = new int[1000001]; // 10 의 6승 범위니까
		d[1]=0;
		for(int i =2 ; i<=n; i++){ 
			d[i] = d[i-1]+1; // N-1
			if(i%2==0&&d[i]>d[i/2]+1){// N-1 한거보다 더 작은가?
				d[i]= d[i/2]+1;
			}
			if(i%3==0&&d[i]>d[i/3]+1){//n-1한거보다 더 작고 n-2 한거보다 더작은가?
			    d[i]= d[i/3]+1; 
			}
		}
		System.out.println(d[n]); // 마지막답 

	}

}

package DP;

import java.util.Scanner;

//DP 피보
public class pibo {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	
	//피보나치 Bottom-up 방법//
	int d[] = new int[100];
	int n =sc.nextInt();
	d[0]=1;
	d[1] =1;
	for(int i=2 ; i<=n; i++){
		d[i] = d[i-1] +d[i+2];
	}
	
    System.out.println("n번째 수"+d[n]);
	
}
}

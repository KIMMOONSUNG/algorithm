package DP;

import java.util.Scanner;

public class D_2193_2 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int n= sc.nextInt();
	long d[] = new long[n+1]; //1차원배열에경우의수로 품 
    d[1]=1;
    for(int i =2; i<=n; i++){
    	d[i] = d[i-1]+d[i-2];
    }
	
	System.out.println(d[n]);
}
}

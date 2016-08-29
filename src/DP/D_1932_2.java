package DP;

import java.util.Scanner;

public class D_1932_2 { 
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int a[][] = new int[n][n];
	int d[][] = new int[n][n];
	for(int i =0; i<n; i++){
		for(int j=0; j<i+1; j++){
			a[i][j] = sc.nextInt();
		}
	}
	for(int i=0; i<n; i++){
		d[n-1][i] = a[n-1][i];
	}
	int count =n-1;
    for(int i=n-2; i>=0; i--){  //거꾸로 보고 품
    	for(int j =0; j<count; j++){
    		d[i][j] = Math.max(d[i+1][j], d[i+1][j+1])+a[i][j];
		}
    	count--;
	}
	System.out.println(d[0][0]);
 }
}

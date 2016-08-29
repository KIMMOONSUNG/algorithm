package DP;

import java.util.Scanner;

public class D_1309 { //까다로운문제 ★★★★★★
  public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int d[][] = new int[n+1][2];
	int mod = 9901;
	d[0][0] = 1; // 경우의수 1
	d[0][1] = 1; // 경우의수 1
	 for(int i =1; i<=n; i++){
		 d[i][0] = (d[i-1][1] + d[i-1][0])%mod; // 현재위치에 있을때  가능한 그전의 경우의 수와 현재 그위치에 없을때의 가능한 경우의수를 더하고 
		 d[i][1] = (d[i-1][0] + d[i][0])%mod; // 현재 위치에 있을때 가능한 경우의수와 없을때 그전 모든 경우를 더함   
		}
	 System.out.println(d[n][1]);
	}
 }


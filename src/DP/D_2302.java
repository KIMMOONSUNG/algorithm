package DP;

import java.util.Scanner;

public class D_2302 {
public static void main(String[] args) {
	Scanner sc  = new Scanner(System.in );
	int n = sc.nextInt();// 좌석개수
	int m = sc.nextInt();// 고정석개수
	int x,y,z,o;
	int ans =1;
	int t=1;
	for(int i =1; i<=m; i++){
	    o = sc.nextInt();
		x=1;
		y=1;
		for(int j=t; j<o-1; j++){
			z=y;
			y=x+y;
			x=z;
		}
		t=o+1;
		ans*=y ;
	}
	x=1;
	y=1;
	for(int i=t; i<n; i++){
		z=y;
		y=x+y;
		x=z;
	}
	ans *=y;
	System.out.println(ans);
	
}
}

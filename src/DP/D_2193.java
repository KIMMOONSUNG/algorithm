package DP;

import java.util.Scanner;

public class D_2193 {
public static void main(String[] args) { 
	Scanner sc= new Scanner(System.in);
	int n= sc.nextInt(); // 주어지는 N자리 
	long d[][] = new long[n+1][2]; // n자리와 마지막 수 2차원배열로 품 
	d[1][1] =1;
	for(int i=2; i<=n; i++){
      for(int j=0; j<=1; j++){
    	  if(j==0){
    	  d[i][j] = d[i-1][0]+d[i-1][1];
    	  }
    	  if(j==1){
    		  d[i][j] = d[i-1][0];
    	  }
      }
	}
	long ans=0;
	for(int j=0; j<=1; j++){
		ans+= d[n][j];
	}
	System.out.println(ans);
}
}

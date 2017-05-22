package DP;

import java.util.Scanner;

public class D_10844 {
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);
		   long mod = 1000000000L;
		  int n = sc.nextInt();
	      long d[][] = new long [n+1][10];
		  for(int a=1; a<10; a++){ //길이 d[앞]이 1이면서 맨마지막수 d[뒤]가 하나인경우 니까 다 1 넣음
			  d[1][a] = 1;  //한마디로 길이가 1이니까 한자리 0~ 9 사이인수인데 0은 마지막수가 될수 없어서 1~9까지 계단수는 1 
		  }
		  
	      for(int i=2; i<=n; i++){ //계단길이
	    	  for(int j=0; j<10; j++){ //마지막수 
	    	     if (j-1>= 0) {
	                 d[i][j] += d[i-1][j-1];
	             }
	             if (j+1<= 9) {
	                 d[i][j] += d[i-1][j+1];
	             }
	             d[i][j] %= mod;
	    	  }
		  }
	      long ans = 0;
	      for (int i=0; i<=9; i++) { //문제에서 구하는거는 n자리 계단수 그떄의
	    	                         //마지막수는 0~9까지이므로 for문돌려 더해줘야한다 
	          ans += d[n][i];
	      }
	      ans %= mod;
	      System.out.println(ans);
	  }
}

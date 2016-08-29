package math;

import java.util.Scanner;

public class N_9550 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int t = sc.nextInt();
	
	for(int i =0; i<t; i++){
	   
	  int N = sc.nextInt(); // 사탕종류수
	  int k = sc.nextInt(); // 만족양
	  int num=0;
	  int d[] = new int[N];
	  for(int j=0; j<N; j++){
		  d[j] = sc.nextInt();
		  num+=d[j]/k;
	  }
	  System.out.println(num);
	}
}
}

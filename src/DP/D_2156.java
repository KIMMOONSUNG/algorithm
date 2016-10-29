package DP;

import java.util.Scanner;

public class D_2156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt(); // 포도주의 잔의 개수
	    int d[] = new int[n+1];// 마실수있는 포도주 최대 양 저장
	    int a[] = new int[n+1];// 포도주 양 저장
	    for(int i=1; i<=n; i++){
	       	a[i] = sc.nextInt();
	    }
	    d[1] = a[1];
	    if(n>=2){ //이 조건 써줘야함 안그러면 포도주개수가 1이여도 돌아가기때문에 런타임에러남.
	 		d[2] = a[1] + a[2];
	 		}
	    for(int i=3; i<=n; i++){
	 	   d[i] = d[i-1]; // i꺼를 안마셨을때 i-1꺼는 먹어도 되고 안먹어도 되고  
	 	   if(d[i]<d[i-2]+a[i]){ // i꺼를 1잔먹었을때 i-1를 절대 먹어서는 안되고 i-2부터 먹어도되고 안먹어도 되고  
	 		   d[i] = d[i-2]+a[i]; 
	 	   }
	 	   if(d[i]<d[i-3]+a[i-1]+a[i]){ // i꺼를 2잔연속먹었을시에 i-1는 1잔을먹었을거고 i-2번째는 안되고 i-3부터 먹어도되고 안먹어도되고
	 		   d[i] = d[i-3]+a[i-1]+a[i];
	 	   }
	 	 }
	    System.out.println(d[n]);
	}
}

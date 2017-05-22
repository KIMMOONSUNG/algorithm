package DP;

import java.util.Scanner;

public class D_2579 {
  public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int num = sc.nextInt();
   int d[] = new int[num+1];  // stair[i]까지 얻을수있는 최대점수 넣는다.
   int stair[] = new int[num+1]; 
   for(int i=1; i<=num; i++){
	 stair[i] = sc.nextInt();  // i번째 계단 점수 
   }
    d[1] = stair[1] ; 
   if(num>=2){ //이 조건 써줘야함 안그러면 계단길이가 1이여도 돌아가기때문에 런타임에러남.
     d[2] = stair[1] + stair[2];
   }
   
   for(int i=3; i<=num; i++){
 		d[i] = d[i-2]+stair[i]; // 마지막에 1번연속 밟을시  
	   if(d[i] < d[i-3]+stair[i-1]+stair[i]){ // 마지막에 2번연속 밟을시 
		d[i] = d[i-3] + stair[i-1] + stair[i];
	   }
   }
    System.out.println(d[num]); 
  }
}

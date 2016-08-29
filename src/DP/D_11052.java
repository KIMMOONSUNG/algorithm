package DP;

import java.util.Scanner;

public class D_11052 {
public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int num = sc.nextInt();
	int p[] = new int [num+1]; //
	int d[] = new int[num+1]; 
	for(int i =1; i<=num; i++){
		p[i] = sc.nextInt(); //앞에새끼한테 세트메뉴i개 팔때의 가격
	}
	
	
	for(int i=1; i<=num; i++){ //num개를 팔때 
      for(int j=1; j<=i; j++){ 
           if(d[i]< p[j] +d[i-j]){//최대구하는거라서 비교하는거둘다 d[i]값인데 원래 d값과 현재 for문돌아갈때의 d값 비교해서 현재 꺼가 크면 조건만족
                                  //긍까 최대 d값구할라고 돌리는거         	   
        	  d[i]= p[j] +d[i-j];
           }
      }
	}
	
	System.out.println(d[num]);
	
}
}

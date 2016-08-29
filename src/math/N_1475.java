package math;

import java.util.Scanner;

public class N_1475 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String num = sc.next();
	int n[] = new int[11]; // 0~9 까지 넣을 배열 
	                       //마지막 인덱스 10 배열에는 6 과 9의 합을 2로나눈것을 넣을것 
	int number=0;
	for(int i=0; i<num.length(); i++){
		n[num.charAt(i)-48] = (n[num.charAt(i)-48])+1; 
	}
	// 짝수냐 홀수냐 -> 69 면 1개  696 이면 2개 필요하니까  
	if((n[6]+n[9])%2==0){
		n[10] = (n[6]+n[9])/2;	
	}
	else{
		n[10] = ((n[6]+n[9])/2)+1;
	}
	//
	 
	n[9] = 0;
	n[6] = 0;
	for(int i =0; i<=10; i++){ 
		if(number<=n[i]){
			number=n[i];
		}
	}
	System.out.println(number);
 }
}

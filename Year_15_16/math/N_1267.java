package math;

import java.util.Scanner;

public class N_1267 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); //통화의개수
		int money[] =new int[n];
		for(int i=0; i<n; i++){
	     money[i] = sc.nextInt();
		}
		int y =0; //영식
		int m =0; //민식
		int money1=0;
		int money2=0;
		for(int i=0; i<n; i++){
			 y = money[i]/30; //0 -> 10원 1->20원 2->30원
			 m = money[i]/60; //0 -> 15원 1->30원
			 money1+= (y+1)*10;
			 money2+= (m+1)*15;
		}
			 if(money1>money2){
				 System.out.println("M "+money2);
			 }
			 else if(money1<money2){
				 System.out.println("Y "+money1);
			 }
			 else if(money1==money2){
				 System.out.println("Y M "+money1);
			 }
	}
}

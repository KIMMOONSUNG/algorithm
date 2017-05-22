package math;

import java.util.Scanner;

public class D_1110 { // 더하기사이클
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int count = 0;
		int A,B,C,add;
		add = number;
		while (add!=number || count==0) { //만일 82이면 
			A= add/10;  // A는 8
			 
			B= add%10; //B=2
			
			C=(A+B)%10; // C = 0
			
			add = B*10 +C; //add = 20
			count++;
		}
		System.out.println(count);
		
	}
}

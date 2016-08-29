package math;

import java.util.Scanner;

public class D_2864 { // 5와 6의 차이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num1 = sc.next();
		String num2 = sc.next();
		char n1[] = new char[num1.length()];
		char n2[] = new char[num2.length()];
		String max = "";
		String max2 = "";
		String min = "";
		String min2 = "";
		int result =0;
		int result2 = 0;
		
		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) == '5') {
				n1[i] = '6';
			} else {
				n1[i] = num1.charAt(i);
			}
			max += n1[i];
		}
		for (int i = 0; i < num2.length(); i++) {
			if (num2.charAt(i) == '5') {
				n2[i] = '6';
			} else {
				n2[i] = num2.charAt(i);
			}
			max2 += n2[i];
		}
		result = Integer.parseInt(max)+Integer.parseInt(max2);
		
		for (int i = 0; i < num1.length(); i++) {
			if (num1.charAt(i) == '6') {
				n1[i] = '5';
			} else {
				n1[i] = num1.charAt(i);
			}
			min += n1[i];
		}
		for (int i = 0; i < num2.length(); i++) {
			if (num2.charAt(i) == '6') {
				n2[i] = '5';
			} else {
				n2[i] = num2.charAt(i);
			}
			min2 += n2[i];
		}
	
		result2 = Integer.parseInt(min)+Integer.parseInt(min2);
		
		System.out.println(result2 + " " + result);

	}
}

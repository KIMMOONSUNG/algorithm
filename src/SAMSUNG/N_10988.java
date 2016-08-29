package SAMSUNG;

import java.util.Scanner;

public class N_10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		char ch[] = new char[str.length()];
		for (int i = 0; i < str.length(); i++) {
			ch[i] = str.charAt(i);
		}
	
		int i = 0;
		int e = str.length();
		while (true) {
			char one = ch[i];
			char last = ch[e - 1];
			if (one != last) { // 처음과 끝이 다르면 팰린드롬이아니지
				System.out.println("0");
				break;
			}
			if (i == e || i + 1 == e) { // 홀수일때는 처음과 끝 비교 인덱스가 같아지면 팰린드롬
										// 짝수일때는 처음인덱스에 +1한것이 끝비교인덱스값과 같으면 팰린드롬
				System.out.println("1");
				break;
			}
			i++;
			e--;
		}

	}
}

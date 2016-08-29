package ms;

import java.util.Scanner;

public class NHN {
	static int num[] = new int[10];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		for (int i = 0; i < 10; i++) {
			num[i] = i;
		}
		RandomFunction();
		for (int i = 0; i < count; i++) {
			int Score = (int) (Math.random() * 99); // 0부터 99까지
			String Val = String.format("%05d", num[i]);
			System.out.println("NH"+Val + " " + Score);
		}
	}
	static void RandomFunction() {
		int tmp = 0;
		for (int i = 0; i < 10; i++) {
			int Value = (int) (Math.random() * 9);// 0부터 99999까지
			System.out.println("값:"+Value+"//");
			tmp = num[i];
			num[i] = num[Value];
			num[Value] = tmp;
			for(int a=0; a<10; a++){
			System.out.print(num[a]+" ");
			}
			System.out.println(" ");
		}
	}
}

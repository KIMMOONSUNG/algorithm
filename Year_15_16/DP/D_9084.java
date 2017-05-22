package DP;

import java.util.Scanner;

public class D_9084 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int Testcase = sc.nextInt(); // 10개
		int TOTAL[] = new int[Testcase + 1];
		for (int i = 1; i <= Testcase; i++) {
			int num = sc.nextInt(); // 개수
			int num2[] = new int[num + 1];
			for (int k = 1; k <= num; k++) {
				num2[k] = sc.nextInt();
			}

			int money = sc.nextInt();
			int d[] = new int[money + 1];
			d[0] = 1;

		
				for (int h = 1; h <= num; h++){
					for (int j =num2[h]; j <= money; j++){
					
						d[j] += d[j-num2[h]];
				
				}
			}
			
			TOTAL[i] = d[money];
		}

		for (int i = 1; i <= Testcase; i++) {
			System.out.println(TOTAL[i]);
		}

	}
}

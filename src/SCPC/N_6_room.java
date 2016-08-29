package SCPC;

import java.util.Scanner;

public class N_6_room { //어려움 
	public static void main(String args[]) throws Exception	{
		
		Scanner sc = new Scanner(System.in);

		int TC;
		int test_case;
		long result;

		TC = sc.nextInt();
		for (test_case = 1; test_case <= TC; test_case++) {
			// 이 부분에서 알고리즘 프로그램을 작성하십시오.
			long N = sc.nextLong();
			long K = sc.nextLong();
			String input = sc.next();
			result = 0;
			long x = 0, y = 0;
			result = 1;
			for (int i = 0; i < K; i++) {
				switch (input.charAt(i)) {
				case 'U':
					x -= 1;
					break;
				case 'D':
					x += 1;
					break;
				case 'L':
					y -= 1;
					break;
				case 'R':
					y += 1;
					break;
				}
				long z = x + y;
				if (z <= N - 1) {
					result += (z + 1) * (z + 2) / 2;
					if (z % 2 == 0) {
						result -= x;
					} else {
						result -= y;
					}
				} else {
					long tresult =0;
					long tx = N - 1 - x;
					long ty = N - 1 - y;
					long tz = tx + ty;
					tresult += (tz+1) * (tz + 2) / 2;

					if (tz % 2 == 0) {
						tresult -= tx;
					} else {
						tresult -= ty;
					}
					result += N*N+1 - tresult;
				}
			}

			// 이 부분에서 정답을 출력하십시오.
			System.out.println("Case #" + test_case);
			System.out.println(result);
		}
	}
}

package DP;

import java.util.Scanner;

public class D_9095 {
	public static void main(String[] args) { // 이거모르겠음 2방법으로 풀거임
		Scanner sc = new Scanner(System.in);
		int Testcase = sc.nextInt();
		int d[] = new int[11];
		int outputnum[] = new int[Testcase + 1];
		d[0] = 1;
		// 1,2,3 의 조합이니까 1은 1 2는 2 , 3은 4 이다. 4부터 이제 합으로 
		for (int k = 1; k <= 10; k++) {
		for(int i=1; i<=3 ; i++){ //1,2,3으로만이므로 이니까 d[i] = d[i-1] + d[i-2] +d[i-3]이므로 
			if(k>=i)
			d[k] += d[k-i];
		 }
		}

		for (int i = 1; i < Testcase + 1; i++) { // 입력횟수
			outputnum[i] = sc.nextInt();
		}

		for (int i = 1; i < Testcase + 1; i++) { // 출력
			System.out.println( d[outputnum[i]] );
		}

	}
}

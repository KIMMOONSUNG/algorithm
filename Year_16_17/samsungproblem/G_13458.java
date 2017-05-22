package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G_13458 { // 시험감독 -> 삼성 기출 문제  
	static int N; // 시험장의 개수
	static long map[];
	static int A; // 총 감독관 1명이 자기방 몇명 감독할 수 있나 ( 1방에 1명)
	static int B; // 부 감독관 1명이 자기방 몇명 감독할 수 있나 (1방에 여러명 )
	static long result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		map = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int index = 0;
		while(st.hasMoreTokens()) {
			map[index] = (Integer.parseInt(st.nextToken()));
			index++;
		}
		
		st = new StringTokenizer(bf.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {// 시험장 수
			long m = map[i] - A;
			if (m >= 1) {
				while (m >= 1) {
					m = m - B;
					result++;
				}
			}
		}
		result += N;
		System.out.println(result);
	}
	//// 다른풀이 
	/* 
	static int map[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		String a = st.nextToken();
		int k = Integer.parseInt(st.nextToken());

		map = new int[1000001][11];

		System.out.println(A(a, k));
	}

	static int A(String input, int k) {
		if (k == 0)
			return Integer.parseInt(input);

		if (map[Integer.parseInt(input)][k] != 0) {
			return map[Integer.parseInt(input)][k];
		}
		int max = -1;
		for (int i = 0; i < input.length() - 1; i++) {
			for (int j = i + 1; j < input.length(); j++) {
				if (i == 0 && input.charAt(j) == '0') {
					continue;
				}
				String result = swap(input, i, j);
				max = Math.max(max, A(result, k - 1));
			}
		}
		return map[Integer.parseInt(input)][k] = max;
	}

	static String swap(String test, int start, int end) {
		return test.substring(0, start) + test.charAt(end) 
		        + test.substring(start + 1, end) + test.charAt(start)
				+ test.substring(end + 1, test.length());
	}
	*/
	
}

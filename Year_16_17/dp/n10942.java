package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10942 { // 팰린드롬?
	static int number[];
	static boolean cnt[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		number = new int[n + 1];
		cnt = new boolean[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			number[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(bf.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			if (func(s, e) == true) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	static boolean func(int s, int e) {
		//boolean result = false;
		if (s == e) { // 시작숫자와 끝 인덱스가  같으면 true
			return true;
		}
		if (s + 1 == e) { //시작다음 인덱스와 끝 인덱스가 같으면  
			if (number[s] == number[e]) {  // 두개 값이 같으면  1 1 이면  true
				return true;
			} else {  // 1 3 이면 false
				return false;
			}
		}
		if (cnt[s][e] == true) { // # 메모이제이션 
			return cnt[s][e];
		}
		/*
		 * 23 11 23 에 경우 문자열로 풀면 팰린드롬이 아니라고 나옴 숫자로 푸는게 좋은거 같다 StringBuilder sb =
		 * new StringBuilder(); for(int i =s; i<=e; i++){ sb.append(number[i]);
		 * } String str1 = sb.toString(); String str2 = sb.reverse().toString();
		 * if(str1.equals(str2)){ cnt[s][e] = true; return true; } else{ return
		 * false; }
		 */
		if (number[s] == number[e]) { // 첫 숫자와 마지막  숫자가 같으면  
		    cnt[s][e] = func(s + 1, e - 1);  //  시작 증가 끝 감소 
		}
		//cnt[s][e] = result;  
		return cnt[s][e]; 

	}

}

package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

// 있는지 없는지 구함 ->SET
//-> 순서보장이 필요없어서 HashSet사용 (add할때 정수형으로 변환후 넣어줘야함)


public class collections_N10815 { // 숫자 카드
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		// String str = bf.readLine();
		// StringTokenizer st = new StringTokenizer(str," ");
		// 이렇게 " "로 구분을 해도 괜찮고 밑에 처럼 입력때마다 구분해도되고
		StringTokenizer st = new StringTokenizer(bf.readLine());

		HashSet<Integer> d = new HashSet<Integer>();
		// HashSet은 정수로 넣어 줘야 한다 ★★
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			d.add(num); // 각 수를 HashSet에 넣는다
		}
		int m = Integer.parseInt(bf.readLine());
		// String str2 = bf.readLine();
		// st = new StringTokenizer(str2," ");
		// 이것도 마찬가지
		st = new StringTokenizer(bf.readLine());
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (d.contains(num)) { // HashSet에 포함이 되어있나 안되어있나
				sb.append("1 "); // append를 사용해 sb뒤에 계속이어 문자열 붙임
			} else {
				sb.append("0 ");
			}
		}
		System.out.println(sb);
	}
}

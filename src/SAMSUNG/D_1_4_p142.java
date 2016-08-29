package SAMSUNG;

import java.util.Scanner;

public class D_1_4_p142 { // 팰린드롬(회문)찾기 -> 10988 / 10174
	public static void main(String[] args) { // 2글자는 X 3글자부터 성립,
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); 
		int Case = 1;
		String output[] = new String[10000]; // 밑에서 추출된 팰린드롬을 여기 넣어 나중에 출력
		for (int a = 0; a < N; a++) {
			String str = sc.next();
			char ch[] = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				ch[i] = str.charAt(i);
			}
			int s = 0; // 시작인덱스
			int l = 0; // 마지막인덱스
			int count = 0; // 밑에서 팰린드롬 된거 count를인덱스로 해서 넣고 개수센다.
			for (int k = 2; k < str.length(); k++) { // 첫글자와 마지막글자를 3차이나게하려고 즉 문자열길이 3개부터 시작
				s = 0; // 첫 글자인덱스
				l = s + k; // 마지막글자인덱스
				while (l <= str.length()-1) { //★
					int start = s; // 밑에서 팰린드롬을 찾아서 글자넣주기위해서 첫수와 마지막수를 저장해놓고 while문돌림
					int last = l;
					while (true) {
						if (ch[s] != ch[l]) { // 첫글자와 마지막글자가 다르면 팰린드롬아니다 
							break;
						}
						if (s == l || s + 1 == l) { // 첫인덱스와 마지막인덱스가같아진경우 
							String str2 = str.substring(start, last + 1); // start부터last까지문자열잘라서넣는다(마지막은+1해줘야함)
							output[count] = str2;
							count++;
							s = start; // 예로 5 7 비교하는데 66 에서 같아지고 이제 시작점을 6부터
										// 비교해야하는데 이거 없으면 while문 빠지고 s++로 7부터
										// 비교해버리기때문
							break;
						}
						s++;
						l--;
					}
					s++;
					l = k + s;
				}
			}

			System.out.print("#" + Case + " ");
			if (count != 0) { // count가 0이라는것은 팰린드롬이없다는뜻
				for (int i = 0; i < count; i++) {
					System.out.print(output[i] + " ");
				}
				System.out.println(", " + count);
			} else {
				System.out.println(count);
			}
			Case++;
		}

	}
}

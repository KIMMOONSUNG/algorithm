package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_1475_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char ch[] = bf.readLine().toCharArray();
		int num[] = new int[11]; //10번째를 6과 9로 그러고 6과 9의인덱스는 0을만들어버릴꺼 
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == '6' || ch[i] == '9') {
				count++;
				if (count % 2 != 0) { // 69 는 1개 696은 2개 니까
					num[10] += 1;
				}
			} else {
				num[(ch[i] - 48)] += 1;
			}
		}
		num[6] = 0;
		num[9] = 0;
		Arrays.sort(num);
		System.out.println(num[10]);

	}
}

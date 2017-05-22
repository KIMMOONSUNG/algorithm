package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_1157 {
	// 소문자 -97 // 대문자 -65
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] alpha = new int[26]; //sort해서 가장큰개수중같은거있나비교 
		int[] alpha2 = new int[26]; //같은거없을시에 비교하려고 
		String str = bf.readLine();
		String s = str.toUpperCase();
		for (int i = 0; i < s.length(); i++) {
			alpha[s.charAt(i) - 65] += 1;
			alpha2[s.charAt(i) - 65] += 1;
		}
		int result = -1;
		int index = 0;
		Arrays.sort(alpha);
		if (alpha[25] == alpha[24]) { // sort후 마지막 2인덱스 개수 봐서 같은거있음 ?출력
			System.out.println("?");
		} 
		else {                        // 아닐경우 비교해서 가장 개수많은 인덱스 구해서  
			for (int i = 0; i < 26; i++) {
				if (result < alpha2[i]){
					index = i;
					result = alpha2[i];
				}
			}
			System.out.println((char) ('A' + index)); // 'A'+인덱스 더해줘서 알파벳출력 
		}
	}
}
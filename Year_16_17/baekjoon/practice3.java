package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice3 { // 10769 행복한지슬픈지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine().trim());
		int happy = 0;
		int sad = 0;
		boolean result = false;
		
		StringBuilder sb = new StringBuilder();
		while (st.hasMoreTokens()) {
			String str = st.nextToken();
			for(int i =0; i<str.length(); i++){
				sb.append(str.charAt(i));
				if(sb.toString().contains(":-)")){
					result = true;
					happy ++;
					sb.delete(0,sb.length());
				}
				if(sb.toString().contains(":-(")){
					result = true;
					sad ++;
					sb.delete(0, sb.length());
				}
				
			}
		}
		if (result == true) {
			if (happy == sad) {
				System.out.println("unsure");
			} else if (happy > sad) {
				System.out.println("happy");
			} else
				System.out.println("sad");
		} 
		else {
			System.out.println("none");
		}
	}
}

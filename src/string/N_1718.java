package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1718 {
	///암호 ///
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char str[] = bf.readLine().toCharArray(); // 평문
		char key[] = bf.readLine().toCharArray(); // 암호
		   int j =0; // 키인덱스
		   
		   StringBuilder sb = new StringBuilder();
		   //for문안에 계속 syso출력하는거보다는 sb를 이용해 한번에 출력하는게 좋음
		   
		for (int i = 0; i < str.length; i++) { 
			if(j==key.length){ // 키 인덱스인 j가 문자열 길이 넘어갈경우 다시 처음 키 문자부터 비교 
				 j=0;
				}
			if (str[i] == ' ') { //빈칸인경우 빈칸출력
				//System.out.print(" ");
				sb.append(" ");
			} 
			else if((char)(str[i]-(key[j]-96))<97){ // 나의 문자에서 -몇번째암호키 문자 a보다 작다면
				// z(122) - ( (몇번째암호키인지)-(나의평문문자와 a까지의 거리) ) 
				//System.out.print((char)(122-((key[j]-96)-(str[i]-96))));
				sb.append((char)(122-((key[j]-96)-(str[i]-96))));
			}
			else { // 그렇지않으면 그냥 내 평문문자 에서 - 몇번째암호키인지 뺀다  
				//System.out.print((char)(str[i]-(key[j]-96)));
				sb.append((char)(str[i]-(key[j]-96)));
			}
				j++; //키 인덱스 올림
		}
		System.out.println(sb);
	}
}

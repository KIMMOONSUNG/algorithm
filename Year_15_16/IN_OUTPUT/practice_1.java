package IN_OUTPUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class practice_1 {
 public static void main(String[] args) throws IOException {
 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   StringBuilder sb = new StringBuilder();
 for(int i = 0; i<3; i++){ //배열 한 인덱스에 문자열을 넣는다 
     String str = bf.readLine(); 
     sb.append(str);  
 }
     System.out.println(sb);
  }
}
	

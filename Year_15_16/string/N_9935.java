package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9935 {
	 public static void main(String[] args) throws Exception {
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        String str = bf.readLine();
	        String bomb = bf.readLine();
	        int bombLen = bomb.length();
	         
	        int cur = 0;
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i=0; i<str.length(); i++){
	            char ch = str.charAt(i);
	            sb.append(ch);
	            cur++; 
	            if (cur>=bombLen && bomb.equals(sb.substring(cur-bombLen,cur))){ //문자열이 같으면 폭팔 이니 삭제시키고 
	            	//sub은 (시작지점, 끝 다음 지점)
	            	// substring은 cur-bombLen 부터 추출 cur-1까지임 .
	                sb.delete(cur-bombLen, cur); 
	                cur -= bombLen; //다시 커서는 조정됨.  
	            }
	        }
	         
	        if (sb.length() == 0) {
	            System.out.println("FRULA");
	        } else {
	            System.out.println(sb.toString());
	        }
	    }
}

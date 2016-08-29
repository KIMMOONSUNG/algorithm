package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9935 {
	/*
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		String boom = bf.readLine();
		StringBuilder sb = new StringBuilder(); 
		
		while (true) { // 이렇게풀면 시간초과 
			////////////////시간초과 
			String str2[] = str.split(boom);
			sb = new StringBuilder();
			for (int i = 0; i < str2.length; i++) {
			
				sb.append(str2[i]);
			}
			
			str = sb.toString();
			if(!str.contains(boom)){
				break; 
			}
			////////////////////////////
			//-----------------------------------------//
			
			
			////////////// 시간초과
			str = str.replace(boom,"");
			if(!str.contains(boom)){
				break; 
			}
			//////////////
		}
		if (str.equals("")) {
			System.out.println("FRULA");
		}
		System.out.println(str);

	}
	*/
	
	 public static void main(String[] args) throws Exception {
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        String str = bf.readLine();
	        String bomb = bf.readLine();
	        int bombLen = bomb.length();
	         
	        int cur = 0;
	        StringBuilder sb = new StringBuilder();
	        
	        for (int i=0; i<str.length(); i++) {
	            char ch = str.charAt(i);
	            sb.append(ch);
	            cur++; 
	            if (cur>=bombLen && bomb.equals(sb.substring(cur-bombLen))){
	            	// substring은 cur-bombLen 부터 추츌 
	                sb.delete(cur-bombLen, cur); //앞~뒤 까지 삭제 
	                cur -= bombLen; //다시 커서는 그니까 sb길이는 삭제하고의 커서로 돌아가는거지  
	            }
	        }
	         
	        if (sb.length() == 0) {
	            System.out.println("FRULA");
	        } else {
	            System.out.println(sb.toString());
	        }
	    }
}

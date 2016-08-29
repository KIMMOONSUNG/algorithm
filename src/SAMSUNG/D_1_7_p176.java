package SAMSUNG;

import java.util.Scanner;

public class D_1_7_p176 { // 도어락비밀번호 
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
        int Testcase = sc.nextInt();
        String p = sc.next(); // 비밀번호  
        char pass[] = new char[p.length()]; // 각 자리를 배열에
        int Case =1;
        for(int i =0; i<p.length(); i++){ // 저장
        	pass[i] = p.charAt(i); 
        }
        
        for(int a=0; a<Testcase; a++){
        	int count =0;
        	 String str=sc.next(); // 여러 비밀번호를 입력 
        	for(int i =0; i<str.length()-p.length()+1; i++){ //첫입력자리 를 높여가며 비교할건데 
        	 if(str.charAt(i) == pass[0]){ //첫글자가 맞으면
        		 boolean check =false; 
        		 for(int j=1; j<p.length(); j++) { // 그다음글자랑 배열에넣어져있는 비번과 비교 
        			 if(str.charAt(i+j)!=pass[j]) {  // 비교하다 다르면 for문벗어남 
        				 check =true;
        				 break;
        			 }
        		 }
        		 if(check ==false){ // 비밀번호일치한경우니까 첫입력자리 올리는 for문 아예벗어남 
        			 count=1;
            		 break;
            	 }
        	 }
        	}
        	System.out.println("#"+Case+" "+count);
            Case++;
        }
	}
}

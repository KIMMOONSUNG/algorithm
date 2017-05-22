package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1254 { // 팰린드롬 만들기 -> 원래 글자하나하나에 원래의 역글자를 붙여보면서 팰린드롬을 확인하는방법임.
	public static void main(String[] args) throws IOException{
	    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    String str = bf.readLine();
	    String str2 = func(str);
	    String result = "";
	    if(str.equals(str2)){ // 이미 팰린드롬인 상태 
	        result = str;
	    }
	    else{
	        for(int i =1; i<str.length(); i++){
	            result = str.substring(0, i) + str2; // (0,1)은 한글자 , (0,2)는 두글자  
	            //거기에 str2 즉, 원래글자리버스한것을 붙여본다 . 
	            String r = func(result); // 팰린드롬확인해보고 
	            if(result.equals(r)){//그것이 팰린드롬이면  끝
	                break; 
	            }
	        }
	    }
	    System.out.println(result.length());
	}
	  
	 static String func(String s){
	     StringBuilder sb = new StringBuilder();
	     sb.append(s);
	     return sb.reverse().toString();
	 }
	 
}

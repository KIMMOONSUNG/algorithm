package character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n9935 { // 문자열 폭팔 
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	String boom = bf.readLine();
	StringBuilder sb  = new StringBuilder();
    int cur =0;
	
	for(int i =0; i<str.length(); i++){
	 char ch =  str.charAt(i);
	 sb.append(ch);
	 cur ++;
	 if(cur>= boom.length() && boom.equals(sb.toString().substring(cur-boom.length(),cur))){
		sb.delete(cur-boom.length(), cur); 
		cur = cur-boom.length();
	 }
	 
	  
	}
	if(sb.length()==0){	
		System.out.println(sb.toString());
	}
	else{
		System.out.println("FRULA");
	}
 }
}

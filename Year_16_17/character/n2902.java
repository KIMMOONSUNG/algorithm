package character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n2902 { // KMP는 왜  KMP일까 ? 
 public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	String str = bf.readLine();
	sb.append(str.charAt(0));
	for(int i =0; i<str.length(); i++){
		if(str.charAt(i)=='-'){
			sb.append(str.charAt(i+1));
		}
	}
	System.out.println(sb.toString());
 }
}

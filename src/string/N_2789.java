package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2789 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	StringBuilder sb = new StringBuilder();
	for(int i =0; i<str.length(); i++){
		char ch = str.charAt(i);
		if(ch=='C'||ch=='A'||ch=='M'||ch=='B'||ch=='R'||ch=='I'||ch=='D'||ch=='G'||ch=='E'){
			
		}
		else{
			sb.append(ch);
		}
	}
	System.out.println(sb);
 }
}

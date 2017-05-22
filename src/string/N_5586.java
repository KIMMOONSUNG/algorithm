package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5586 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	int joi=0;
	int ioi=0;
	StringBuilder sb = new StringBuilder();
	for(int i =0; i<str.length()-2; i++){
		if(str.charAt(i)=='J'||str.charAt(i)=='I'){
			sb.append(String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1))+
					String.valueOf(str.charAt(i+2)));
			if(sb.toString().equals("JOI")){
				joi++;
			}
			else if(sb.toString().equals("IOI")){
				ioi++;
			}
			sb.delete(0, 3);
		}
	}
	System.out.println(joi);
	System.out.println(ioi);
	
 }
}

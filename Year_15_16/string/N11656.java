package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class N11656 { //접미사배열
  public static void main(String[] args) throws IOException{	 
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	String arr[] = new String[str.length()];
		for(int i =0; i<str.length(); i++){
			arr[i] = str.substring(i,str.length());
		}
		Arrays.sort(arr);		
	 for(int i =0; i<str.length(); i++){
		 System.out.println(arr[i]);
	 }	
	 
  }

}

package SORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_3047 {
 public static void main(String[] args) throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 String str[] = bf.readLine().split(" ");
	 int number[] = new int[3];
	 for(int i =0; i<3 ; i++){
		 number[i] = Integer.parseInt(str[i]);
	 }
	 Arrays.sort(number);
	 char ch[] = bf.readLine().toCharArray();
	 StringBuilder sb = new StringBuilder();
	 for(int i =0; i<3; i++){
		 if(ch[i]=='A'){
			 sb.append(number[0]+" ");
		 }
		 if(ch[i]=='B'){
			 sb.append(number[1]+" ");
		 }
		 if(ch[i]=='C'){
			 sb.append(number[2]+" ");
		 }
	 }
	 System.out.println(sb);
 }
}
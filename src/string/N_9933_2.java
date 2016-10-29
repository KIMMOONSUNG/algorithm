package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9933_2 {
 public static void main(String[] args) throws IOException{
	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	  StringBuilder sb = new StringBuilder();
      int n = Integer.parseInt(br.readLine());
      String str [] = new String[n];
      for(int i =0; i<n; i++){
    	 str[i] = br.readLine();
    	sb.append(str[i]+" "); 
      }
     
      for(int i =0; i<n; i++){
    	   StringBuilder sb2 = new StringBuilder();
    	   int length = str[i].length();
    	   sb2.append(str[i]).reverse();
    	   if(sb.toString().contains(sb2)){
    		   System.out.print(length +" ");
    		   System.out.print(sb2.charAt(length/2));
    		   break;
    	   }
    	  
      }
 }
}

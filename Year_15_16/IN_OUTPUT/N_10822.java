package IN_OUTPUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class N_10822 { // 더하기
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	///////////////////////////////////////////////////
	StringTokenizer st = new StringTokenizer(str,",");
	int sum=0;
	while(st.hasMoreTokens()){
		sum+=Integer.valueOf(st.nextToken());
	}
	///////////////////////////////////////////////////
	System.out.println(sum);
}
 
 /*
   public static void main(String[] args) {
   Scanner  sc = new Scanner(System.in);
   String s = sc.next();
   String str[] = s.split(",");
   int sum =0;
   for(int i =0; i<str.length; i++){
	 sum += Integer.parseInt(str[i]);
   }
   System.out.println(sum);
  }
  */
 
}

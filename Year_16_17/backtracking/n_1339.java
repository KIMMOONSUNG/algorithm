package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n_1339 { //단어수학 
 public static void main(String[] args) throws IOException{
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int n = Integer.parseInt(bf.readLine());
	 long alpha[] = new long[26];
	 for(int i =0; i<n; i++){
		 String str = bf.readLine();
		 int count =0 ;
		 for(int j =str.length()-1; j>=0; j--){
			 int c = (int)(str.charAt(j)) - 65;
			 alpha[c] += power(count);
			 count++;
		 }
	 }
	 Arrays.sort(alpha);
	 long sum =0 ;
	 for(int i =9; i>=0; i--){
		 sum += i* alpha[16+i];
	 }
	 System.out.println(sum);
}	
 
static long power(int b){
	long result = 1;
	for(int i =0; i< b; i++){
		result *=10;
	}
	return result;
 }

}

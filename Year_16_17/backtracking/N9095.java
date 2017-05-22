package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N9095 { // 1,2,3 더하기
	static int num;
	static int result ;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(bf.readLine());
		
		for(int i =0; i<k; i++){
			result =0;
			num = Integer.parseInt(bf.readLine());
			func(0);
			System.out.println(result);
		}
		
	}
	static void func(int number){
      if(number>num){
    	  return;
      }
	  if(number == num){
		  result ++;
		  return;
	  }
	 
	  for(int i =1; i<4; i++){
		  func(number+i);
	  }
			
	}
}

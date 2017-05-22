package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n_2661 { // 좋은수열 
	static int n ;
    static String result = "";
    static boolean success = false;
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	func(0,"");
	System.out.println(result);
	
 }
 
 static void func(int count ,String str){
	 
	// 탈출조건: 나쁜 수열일 때 -> str 날려버림 -> return
			for(int i=1 ; i<=count/2 ; i++){ // 반갈 
				if(str.substring(count-i,count).equals(str.substring(count-(2*i),count-i))) return;
			}
			
			// 탈출조건: n자리 수를 완성했을 때
			if(count==n){ 
				result=str;
				success=true; // 정답을 찾음 
				return;
			}
			
			for(int i=1 ; i<=3 ; i++){
				if(success == true) return;
				
				func(count+1, str+i+"");
			}
	 
  }
 
}


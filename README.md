# Algorithm
크롬에서 열어서 수정하면 되요 
 
package problem01;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = { -10, -3, 5, 6, -20 };
		findMaxProduct(arr);
	}

	public static void findMaxProduct(int[] arr) {
		
		
		
	}
}


배열 두 수의 곱이 최대인거 구하기
못하겠당

->> 저 5개중에 두수 곱이 최대인거 구하는거구나  잠시만 
정 수 두개 구하기 곱이 최대인 정수 
출력 -10,-20 이

public class Main{
	public static void main(String[] args) {
		int[] arr = { -10, -3, 5, 6, -20 }; 
		findMaxProduct(arr);

	}
	
	public static void findMaxProduct(int[] arr) {
	   int max = Integer.MIN_VALUE;
	   
	   for(int i =0; i<arr.length; i++) {
		   for(int j=i+1; j<arr.length; j++) {
			   max = Math.max(max,(arr[i] * arr[j])); 
		   }
	   }

	   System.out.println(max); // 최대 출력
	   
	}
	
	
}



//////////////////////////////////////////

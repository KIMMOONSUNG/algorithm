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


/////////////
정 수 두개 구하기 곱이 최대인 정수 
//////////////
출력 -10,-20 이  // 이아아 ㅏㅇ아ㅏㅇ 잠시만 
/////////////

//ㅂㅏ꿨엉 
public class Main{
	public static void main(String[] args) {
		int[] arr = { -10, -3, 5, 6, -20 }; 
		findMaxProduct(arr);

	}
	
	public static void findMaxProduct(int[] arr) {
	   int max = Integer.MIN_VALUE;
	   int num1 = 0;
	   int num2 = 0;
	   
	   for(int i =0; i<arr.length; i++) {
		   for(int j=i+1; j<arr.length; j++) {
			   
			   if(max < (arr[i] * arr[j])) {
				   num1 = arr[i];
				   num2 = arr[j];
			   }
			   
			   max = Math.max(max,(arr[i] * arr[j]));
		   }
	   }
       
	   System.out.println(num1+","+num2); // 최대정수 출력
	   
	}
	
	
}



//////////////////////////////////////////



package problem02;

public class Main {

	public static void main(String[] args) {
		String[] expressions = {"3 + 4", "12 * 4", "8 / 2", "10 - 2"};
		
		for(String expression : expressions) {
			String[] tokens = expression.split(" ");
			
			String arith = tokens[1];
			int num1 = Integer.parseInt(tokens[0]);
			int num2 = Integer.parseInt(tokens[2]);

			
			// num1, num2, arith 세 개의 변수와 getInstance 메소드를 사용하여
			// 문제의 결과화면에 맞게 출력하는 계산기 나머지 코드를 아래에 완성 하십시오.
			// 주어진 코드는 수정하지 않습니다.

		
		
		}
	}
	
	public class  Add {
		
	}
	
	public class Sub {
		
	}
	
	public class Mul {
		
	}
	
	public class Div {
		
	}

	
	public static Arithmetic getInstance(String arith) {
		
		// 메소드 구현을 완성 하십시오.
		
		return null;
	}
}

package problem02;

public interface Arithmetic {
	int calculate( int a, int b );
}

////////////////////////////////////
답
7
48
4
8
//////////////////////////////////////////////



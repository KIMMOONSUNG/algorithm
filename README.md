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


/////////////
정 수 두개 구하기 곱이 최대인 정수 
//////////////
출력 -10,-20 이 
/////////////

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
			   
			   max = Math.max(max,(arr[i//////////////////////////////////////////



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

package problem03;

public class Main {
	
	public static void main(String[] args) {
		Money five  = new Money(5);
        Money two   = new Money(2);
        Money three = new Money(3);
        Money ten   = new Money(10);
        
        if(five.equals(two.add(three)) && three.equals(five.minus(two)) && ten.equals(five.multiply(two)) && two.equals(ten.devide(five))){
            System.out.println("Money Class 구현 완료");
        }
	}
}

package problem03;

public class Money {
	
	//
	// 클래스 구현을 완성 하십시오.
	// 

	
	private int amount;
	
	public Money(int amount) {
	}

	public Money add(Money money) {
		return null;
	}

	public Money minus(Money money) {
		return null;
	}

	public Money multiply(Money money) {
		return null;
	}

	public Money devide(Money money) {
		return null;
	}
}

///////////////////////////////////////////////////
답
Money Class 구현
////////////////////////////////////////////////////

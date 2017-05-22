package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2908 {
	/*
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	 String a1 = sc.next();
	 String a2 = sc.next();
	 String num1 ="";
	 String num2 ="";
	 
	 for(int i =2; i>=0; i--){ 
	   	 num1 += a1.charAt(i);
	   	 num2 += a2.charAt(i);
	 }
	
	int result =Math.max(Integer.parseInt(num1),Integer.parseInt(num2));
	System.out.println(result);
	
 }
 */
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" "); // 빈칸구분 해서 배열에 넣고 
	String num1="";
	String num2="";
	for(int i = 2; i>=0; i--){ 
		num1+=str[0].charAt(i); // 배열에 들어간 것을 거꾸로부터 빼내서 num1에 넣음
		num2+=str[1].charAt(i); 
	}
	
	int result =Math.max(Integer.parseInt(num1),Integer.parseInt(num2));
	// INT형으로 변환뒤에 둘중큰것을 출력
	System.out.println(result);
	
	
}
}

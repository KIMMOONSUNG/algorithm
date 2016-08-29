import java.util.Scanner;

public class gob {

public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
 int a = sc.nextInt();
 int b = sc.nextInt();
 int total=0;
 //2번째 입력값을 일,십,백 의자리로 분해를 해야함
 int num1 = b%10;
 int num2 = (b%100)/10;
 int num3 = b/100;
 num1 = a*num1;
 num2 = a*num2;
 num3 = a*num3;
 total=(num1+(num2*10)+(num3*100));
 System.out.println(num1);
 System.out.println(num2);
 System.out.println(num3);
 System.out.println(total);
 
  
}
}

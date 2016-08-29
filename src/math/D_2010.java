package math;

import java.util.Scanner;

public class D_2010 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt(); //멀티탭개수
	int mul[] = new int[N];
	for(int i=0; i<N; i++){
	  mul[i]=sc.nextInt(); // 첫 멀티탭과 그다음그다음 마지막전까지 멀티탭의 플러그 1개는 다른 멀티탭과 연결해야한다 
	}                      // 마지막 멀티탭은 다 사용가능
	int number = 0;
	for(int i=0; i<N; i++){
	  if(i==N-1){
		  number+=mul[i];
	  }
	  else{
		number+= (mul[i]-1);
	  }
	}
	System.out.println(number);
}
}

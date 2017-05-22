package math;

import java.util.Scanner;

public class N_1357 { //뒤집힌 덧셈 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String x = sc.next();
		String y = sc.next();
		sc.close();

		char xx[] = new char[x.length()]; 
		char yy[] = new char[y.length()];
		String x1= "";
		String y1= "";
		String sum = "";
		for (int k = x.length() - 1; k >= 0; k--) { 
            x1+=x.charAt(k);		
		}
		for(int k=y.length()-1; k>=0; k--){
			y1+=y.charAt(k);
		}
		sum = Integer.toString(Integer.parseInt(x1) + Integer.parseInt(y1)); // 0055 -> int형으로바꾸면 55임
		String result ="";
		for(int k=sum.length()-1 ; k>=0; k--){
			result += sum.charAt(k);
		}
		
		System.out.println(Integer.parseInt(result));
	}

}

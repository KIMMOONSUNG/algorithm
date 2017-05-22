package simulation;

import java.util.Scanner;

public class N_1526 { ///////////////////////////실패 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int number[] = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			number[i] = (str.charAt(i) - 48);
		}
		String result = "";
		String num = "7";
		String num2 = "4";
		int count = 0;
		if (number[0] < 4) {
			for (int a = 0; a < str.length() - 1; a++) {
				result += num;
			}
			System.out.println(conversion(result));
		}

		else if (number[0] == 4) {
			for (int i = 1; i < str.length(); i++) {
				if (number[1] < 4 ||(number[i]==4&&number[i+1]<4)) { // 4보다 작은게 있으면 무조건 한자릿수빼고 7채움
					result = "";
					for (int a = 0; a < str.length() - 1; a++) {
						result += num;
					}
					count = 1;
					break;
				} 
				else if(number[i]==4){
					result+=num2;
				}
				else if (number[i] >= 7) {
					result += num;
				} else if(number[i]<7){
					result+=num2;
					for (int a = i+1; a < str.length(); a++) {
						result += num;
					}
					
					break;
					
				}
			}
			if (count == 1) {
				System.out.println(conversion(result));
			} else
				System.out.println(conversion(number[0] + result)); // 4보다안작을때는
																	// 첫 문자열
																	// 더해줘야 함.
																	// 위에서 안더해줘서
		}

		else if (number[0] > 4 && number[0] < 7) { // 5하고 6은 처음만 4이고 나머지 7로채움
			result = num2;
			for (int a = 1; a < str.length(); a++) {
				result += num;
			}
			System.out.println(conversion(result));
		}
		
		else if (number[0] == 7) {
			for (int i = 1; i < str.length(); i++) {
				if (number[1] < 4) {
					for (int a = 0; a < str.length(); a++) {
						   if(a==0){
							result += num2;
						   }
						   else{
							result += num;
						   }
					}
					count =2;
					break;
				}
				if(number[i]==4){
					for (int a = i; a < str.length(); a++) {
						   if(a==i){
							result += num2;
						   }
						   else{
							result += num;
						   }
					}
					break;
				}
				
				else if (number[i] >7) {
					for (int a = i; a < str.length(); a++) {
						result += num;
					}
					break;
				}
				else if(number[i]==7){
					result +=num;
				}
				else if(number[i] <7){ // 다음이 5랑 6일때

					result+=num2;
					for (int a = i+1; a < str.length(); a++) {
						result += num;
					}
					break;
				}

			}
			if (count == 2) {
				System.out.println(conversion(result));
			} else
				System.out.println(conversion(number[0] + result));
																	
		}

		else {
			for (int a = 0; a < str.length(); a++) {
				result += num;
			}
			System.out.println(conversion(result));
		}

	}

	static int conversion(String a) {
		int in = 0;
		in = Integer.parseInt(a);
		return in;
	}
}

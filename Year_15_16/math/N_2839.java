package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2839 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int a = n-(5*(n/5));// 5로 나눈후 남아있는수 29 면 4
		int num =1;
		boolean result = false;
		
		if(n%5==0){		// 5로 나눠지면 
			System.out.println(n/5);
		}
		else{ 
			if(a%3==0){ // 5로 나눈후 나머지가 3으로 나눠떨어지면 
				System.out.println((n/5)+(a/3)); // 5로 나눈몫과 3으로 나눈 몫 을 더한값.
				result = true;
			}
			else{ 
				while(n/5>num){ 
				  if((n-(5*((n/5)-num)))%3==0){ //5로나눈것을 하나하나 뺴주면서  나눈후 나머지가 3으로 나눠떨어지냐를 보고 
					  System.out.println(((n/5)-num)+((n-(5*((n/5)-num)))/3)); 
					  result = true;
					  break;
				  }
				  num++;
				}
			}
			if(n%3==0 && result==false){ // 다안되는것이니까 3으로 나눠떨어지냐를 확인 
				System.out.println(n/3);
				result=true;
			}
			
			if(result==false){ // 마지막은 다 안되는것이니까 -1
				System.out.println("-1");
			}
		}
	}
}

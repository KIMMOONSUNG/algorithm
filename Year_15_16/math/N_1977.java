package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1977 {
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n1 = Integer.parseInt(bf.readLine());
	int n2 = Integer.parseInt(bf.readLine());
	int count =1;// 1*1
	int num =1; //1도 완전제곱수이므로 1부터 시작
	int min =10001;
	int sum=0;
	boolean result = false;
	while(true){
		if(num<n1){
			count+=1;
			num = (count*count);
		}
		else if(num>=n1 && num<=n2 ){
			if(min>=num){
			 	min = num;
			}
			sum = sum+num;
			count+=1;
			num = (count*count) ;
			result =true;
		}
		else if( num>n2){
			break;
		}
	}
	if(result ==false){
	System.out.println("-1");	
	}
	else{
	System.out.println(sum);
	System.out.println(min);
	}
	
}
}
 
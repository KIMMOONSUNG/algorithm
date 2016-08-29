package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5622 { // 다이얼 
 public static void main(String[] args)throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	char ch[] = bf.readLine().toCharArray();
	int sum =0;
	//A를 9로 하고 풀었다   A =9 B =10 C=11 이래서 3으로나누면 3 
	for(int i =0; i<ch.length; i++){
		if(ch[i]=='Z'){
			sum+=10; 
		}
		else if(ch[i]-56 >=26){ // 이거는 4개로 묶여있는경우도있어서 S=27부터는 1씩빼고 3으로나눔 
			sum+= (ch[i]-57)/3;
		}
		else{
	   sum += (ch[i]-56)/3;
		}
	}
	System.out.println(sum);
}
}

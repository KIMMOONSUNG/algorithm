package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_3052 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int num[] = new int[42]; //42로나눈나머지
	for( int i =0; i<10; i++){
	String str = bf.readLine();
	  if(num[Integer.valueOf(str)%42] == 0){
		  num[Integer.valueOf(str)%42] =1;
	  }
	}
	int n =0;
	for(int i =0; i<42; i++){
		if(num[i]==1){
			n+=1;
		}
	}
	System.out.println(n);
}
}

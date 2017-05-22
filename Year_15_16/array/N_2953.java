package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2953 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int sum =0;
	int result =0;
	int winner = 0;
	for(int i =0; i<5; i++){
		String str[] = bf.readLine().split(" ");
		sum =0;
		for(int j =0; j<str.length; j++){
			sum+=Integer.parseInt(str[j]);
		}
		if(result <sum){
			result = sum ;
			winner = (i+1);
		}
	}
	System.out.println(winner+" "+result);
	
}
}

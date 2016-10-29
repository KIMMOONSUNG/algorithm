package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1254_cupang {
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	String str = bf.readLine();
	int n = str.length();
	for(int i =0; i<n; i++){
		boolean state = true;
		for(int j=0; 2*j+i<n; j++){
			if(str.charAt(i+j) != str.charAt(n-1-j)){
				state = false;
				break;
			}
		}
		if(state == true){
			System.out.println(i+n);
			break;
		}
	}
}
}

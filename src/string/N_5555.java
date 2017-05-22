package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5555 { //반지 
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String find = bf.readLine();
	int num = Integer.parseInt(bf.readLine());
	int cnt =0;
	for(int i =0; i<num; i++){
		String str = bf.readLine();
		String str2 = str+str;
		if(str2.contains(find)){
			cnt++;
		}
	}
	System.out.println(cnt);
}
}

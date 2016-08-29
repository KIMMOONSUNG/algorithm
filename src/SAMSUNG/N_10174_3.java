package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10174_3 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(bf.readLine());
	for(int i= 0; i<t; i++){
	String str = bf.readLine().toLowerCase(); // 다 소문자로 바꿈//
	StringBuffer sb = new StringBuffer(str);// 단지 reverse 쓰기위해 stringbuffer씀
	if(str.equals(sb.reverse().toString())){
		System.out.println("Yes");
	}
	else{
		System.out.println("No");
     }
	}
 }
}

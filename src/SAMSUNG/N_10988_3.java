package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10988_3 {
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str = bf.readLine();
    StringBuffer sb = new StringBuffer(str);
    if(str.equals(sb.reverse().toString())){
    	System.out.println(1);
    }
    else{
    	System.out.println(0);
    }
 }
}

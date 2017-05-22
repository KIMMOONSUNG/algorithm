package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class aa {
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str = bf.readLine();
    String boom = bf.readLine();
    int cur =0;
    StringBuilder sb = new StringBuilder();
    for(int i =0; i<str.length(); i++){   
    	sb.append(str.charAt(i));
    	cur++;
    	if(cur>=boom.length() && boom.equals(sb.substring(cur-boom.length(), cur))){
    		sb.delete(cur-boom.length(), cur);
    		cur-= boom.length();
    	}
    }
    if(sb.length()==0){
    	System.out.println("FRULA");
    }
    else{
    	System.out.println(sb.toString());
    }
 }		
}

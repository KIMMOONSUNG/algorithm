package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10988_2 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	char ch[] = bf.readLine().toCharArray();
    int s=0;
    int e=ch.length-1;
    while(true){
     	if(ch[s]!=ch[e]){
     		System.out.println("0");
     		break;
     	}
     	if(s==e || (s+1)==e){
     		System.out.println("1");
     		break;
     	}
     	s++;
     	e--;
    }
 }
}

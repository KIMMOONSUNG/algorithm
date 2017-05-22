package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1919 { // 애너그램만들기 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bf.readLine();
        String str2 = bf.readLine();
        int alpha1 [] = new int[26];
        int alpha2[] = new int[26];        
        for(int i=0; i<str1.length(); i++){
        	alpha1[str1.charAt(i)-'a']+=1;
        }
        for(int i=0; i<str2.length(); i++){
        	alpha2[str2.charAt(i)-'a']+=1;
        }
        
        int result =0;
        for(int i =0; i<26; i++){
        	if(alpha1[i]!=alpha2[i]){ // 같지않으면 큰거에서 작은거 빼주면됨 .
        		result += Math.max(alpha1[i], alpha2[i]) - Math.min(alpha1[i], alpha2[i]);
        	}
        }
        System.out.println(result);
	}

}

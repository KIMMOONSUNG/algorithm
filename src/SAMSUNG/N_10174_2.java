package SAMSUNG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_10174_2 {
public static void main(String[] args) throws IOException{
	
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int Testcase = Integer.parseInt(bf.readLine()); //숫자로변환
	int s=0; //첫인덱스
	int e=0;// 끝인덱스
	for(int i =0; i<Testcase; i++){ //Testcase만큼 
		char str[] = bf.readLine().toCharArray(); // 문자열에서 문자하나하나 배열에넣음
		
		s = 0;
		e = str.length-1;		
	   
		while(true){
			if(str[s]!= str[e]){ // 비교했는데 문자다를시에  
				//대소문자는 숫자에서 32 차이가 나니까 .
				if(((str[s]-48)+32 == (str[e]-48))||((str[s]-48)==(str[e]-48)+32)) // 대소문자 구분안하니까
				{
					
				}
				else{ //그것마져 다른경우 
				System.out.println("No");
				break;
				}
			}
		    if(s==e|| s+1 ==e){ // 비교하는 첫인덱스와 마지막인덱스가 같아지거나 맞닿은경우 
			  	System.out.println("Yes");
			  	break;
			}
			s++;
			e--;
		}
	}	
  }
}

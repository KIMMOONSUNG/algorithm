package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class N_5598 {
	/*
public static void main(String[] args) throws IOException{
	BufferedReader bt = new BufferedReader(new InputStreamReader(System.in));
    String str = bt.readLine();
    String alpa[] = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R", "S","T","U", "V", "W", "X", "Y", "Z"};
    String result ="";
    System.out.println();
    for(int i =0; i<str.length(); i++){
    	if(str.charAt(i)=='A'){
    	  result+=alpa[23];
    	}
    	else if(str.charAt(i)=='B'){
      	  result+=alpa[24];
      	}
    	else if(str.charAt(i)=='C'){
      	  result+=alpa[25];
      	}
    	else{
    	result+=alpa[str.charAt(i)-68]; // D 3 ->0으로가서 A
    	}
    	
    }
     System.out.println(result);
 }
 */
	
	public static void main(String[] args) throws IOException{
		BufferedReader bt = new BufferedReader(new InputStreamReader(System.in));
		char str[] = bt.readLine().toCharArray(); // 입력한문자열을 문자 하나 하나 char배열에 넣음
		int num =0;
		for(int i=0; i<str.length; i++){ 
			num =(int)str[i] -3;
			if(num<65){
				num+=26;
			}
			System.out.print((char)num);
		}
	}
	
	/*
	public static void main(String[] args) throws IOException{
		BufferedReader bt = new BufferedReader(new InputStreamReader(System.in));
		char str[] = bt.readLine().toCharArray(); // 입력한문자열을 문자 하나 하나 char배열에 넣음
		int num =0;
		String result =""; 
		
		for(int i =0; i<str.length; i++){
			num = (int)str[i]-3; // A는 65 인데 num은 62
			if(num<65){ // A , B ,C 는 65 66 67 인데 이건 XYZ로 가야하므로 이 조건 추가 
				num+=26;
			}
			result+=((char)num);
		}
		System.out.println(result);
	}
	*/
	
}
	
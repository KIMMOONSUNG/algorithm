package string;

import java.util.Scanner;

public class N_10808 {
	
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String str = sc.next();
	int st [] = new int[26];
	//a-97 =0// b-97= 1 이런식
	for(int i =0; i<str.length(); i++){
	 st[str.charAt(i)-97] = st[str.charAt(i)-97]+1; 
	 //그래서 그인덱스값에  +1 해줌 
	}
	for(int i =0; i<26; i++){
		System.out.print(st[i]+" ");
	}
 }

}

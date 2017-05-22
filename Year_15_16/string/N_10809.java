package string;

import java.util.Scanner;

public class N_10809 {
 public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	String str = sc.next();
	int st[] = new int[26];
	for(int i=0; i<26; i++){
		st[i] = -1;
	}
	int num=0;
	for(int i=0; i<str.length(); i++){
		if(st[str.charAt(i)-97]==-1){ //baekjoon입력시 oo가 두번들어가서 6이 되는데 이걸 5로 만들어야함 
			                          //그래서 이조건을 붙였음
		st[str.charAt(i)-97] = num;    
		}
		num++;                        //밖에서 ++해줘야함
	}
	
	for(int i =0; i<26; i++){
		System.out.print(st[i]+" ");
	}
	
}
 
}

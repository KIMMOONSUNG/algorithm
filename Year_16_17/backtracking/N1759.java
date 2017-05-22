package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N1759 { // 암호만들기 -->> 6603 로또문제와 비슷하게 풀수있다 -> N_1759_2 
	static int n;
	static int m ;
	static String alpha[];
	
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	 n = Integer.parseInt(st.nextToken());
	 m = Integer.parseInt(st.nextToken());
	 alpha = new String[m];
	 st = new StringTokenizer(bf.readLine());
	 for(int i =0; i<m; i++){
		 alpha[i] = st.nextToken();
	 }
	 Arrays.sort(alpha);
	 func("",0);
}
 
 static void func(String str , int index) {
	 if(str.length()== n){ //가능한 경우 
		 if(check(str)==true){
			 System.out.println(str);
			 return;
		 }
	 }
	 
	 if(index >= alpha.length) return ; // 불가능한 경우
	 
	 func(str+alpha[index], index+1); // 단어를 선택했을 경
	 func(str,index+1); // 선택안했을 경우 
	 
 }
 
 static boolean check(String pw){
	 int ja =0;
	 int mo =0;
	 for(int i =0; i<pw.length(); i++){
		 char ch = pw.charAt(i);
		 if(ch=='a' || ch =='e' || ch=='i' || ch=='o' || ch=='u'){
			 mo++;
		 }
		 else {
			 ja++;
		 }
	 }
	 if(mo>=1 && ja>=2){
		 return true;
	 }
	 else{
		 return false;
	 }
 }
 
}

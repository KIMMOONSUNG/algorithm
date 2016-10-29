package JG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1759 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	String alpha[] = new String[m];
	st = new StringTokenizer(bf.readLine());
	for(int i =0; i<m; i++){
	alpha[i] = st.nextToken();
	}
	
	Arrays.sort(alpha);
	go(n,alpha,"",0);
	
 }
 
 static void go(int n , String[] alpha, String password, int i){
	 // n = 만들어야하는 암호의 길이
	 // alpha = 사용할 수 있는 알파벳
	 // password = 현재까지 만든 암호 
	 // i = 사용할지 말지 결정해야하는 알파벳의 인덱스 
	 
	 //불가능한경우
	   // 더이상 사욜할수 있는 알파벳 없을때  i >= alpha.size();
	 
	 // 정답을 찾은 경우 
	 // 지금까지 만든 암호의 길이가 만들어야하는 암호의 길이와 같을때 n==password.length();
	 
	 // 다음의 경우 
	 // 사용할지말지결정 -> 사용 go(n,alpha,password+alpha[i],i+1)
	 //               사용안함 go(n,alpha,password,i+1)
	 
	 if(password.length() == n){ //정답을 찾은 경우
		 if(check(password)==true){ 
			 System.out.println(password);
		 }
		 return;
	 }
	 
	 if(i>= alpha.length) return; // 불가능한경우
	 
	 //다음의 경우
	 // 사용할수 있는경우  
	  // 사용하면 만들어야하는 암호길이 변하지않고 알파벳도 안변하고 암호는 변하고 인덱스도증가 
	 go(n, alpha, password+alpha[i] , i+1); 
	 // 사용할수 없는 경우
	 // 사용안하니까 그대로 인덱스만 증가 
	 go(n, alpha, password, i+1);
	 
 }
 
 static boolean check(String pw){
		int ja = 0;
		int mo = 0;
		int count = pw.length();
		for(int i =0; i<count; i++){
		  char ch = pw.charAt(i);		  
		  if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
			  mo++;
		  }
		  else{
			  ja++;
		  }
		}
		if(ja>=2 && mo>=1){
			return true;//// 최소 한개의 모음과 최소 두개의 자음으로 구성.
		}
		else{
			return false;
		}
 }
}

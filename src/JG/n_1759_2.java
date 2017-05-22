package JG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n_1759_2 {
	static int n;
	static String alpha[];
 public static void main(String[] args) throws IOException{
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(bf.readLine().trim());
  n = Integer.parseInt(st.nextToken());
  int m = Integer.parseInt(st.nextToken());
  alpha = new String[m];
  st = new StringTokenizer(bf.readLine());
  for(int i =0; i<m; i++){
	  alpha[i] = st.nextToken();
  }
  Arrays.sort(alpha);
  go("",0);
 } 
 
 static void go(String pass, int index){
	 
	 if(pass.length() == n){
		 if(check(pass)==true){ // 정답을 찾은 경우
			 System.out.println(pass);
			 return;
		 }
	 }
	 if(index>=alpha.length) return; // 불가능한 경우
	 
	  go(pass+alpha[index], index+1);
	  go(pass,index+1);
 }
 
 static boolean check(String pw){
	 int ja = 0;
	 int mo =0;
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
		 return true;
	 }
	 else{
		 return false;
	 }
 }
}
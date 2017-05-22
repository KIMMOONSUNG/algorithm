package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n_6603_1 { // 로또 -->> 1,2,3, 더하기와 비교 잘 
	static int k;
	static int num[] ;
 public static void main(String[] args) throws IOException{
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   StringTokenizer st ;
   while(true){
	   st = new StringTokenizer(bf.readLine().trim());
	   k = Integer.parseInt(st.nextToken());
	   if(k==0){
		   break;
	   }
	   num = new int[k];
	   for(int i =0; i<k; i++){
		   num[i] = Integer.parseInt(st.nextToken());
	   }
	   func(0,0,"");
	   System.out.println();
   }
 }
 static void func(int index, int count , String str){
	 if(count == 6){
		 System.out.println(str);
		 return ;
	 }
	 if(index >= k){
		 return ;
	 }
	 func(index +1, count+1, str+num[index]+" ");
	 func(index +1, count , str);
 }
}

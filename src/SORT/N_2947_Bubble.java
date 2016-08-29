package SORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_2947_Bubble {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str[] = bf.readLine().split(" ");
		int n[] = new int[str.length];
		for (int i = 0; i < str.length; i++) {
			n[i] = Integer.valueOf(str[i]);
		}
		////// 2번째방법 bubblesort/////
		int temp =0;
		//boolean result = false;  // 이건 조기종료하려면 넣읏ㅁ 
		for(int i =0; i<str.length-1; i++){
			for(int j=0; j<str.length-1-i; j++){
			  if(n[j]>n[j+1]){
				temp = n[j];
				n[j] = n[j+1];
				n[j+1] = temp;
				// 출력
				for(int a=0; a<str.length; a++){
					  System.out.print(n[a]+" ");
				  }
				  System.out.println();
				//
			  }
			  
			}
		}
		/////////////////////////////
		/*
		int t=0;
		boolean result = false;
		while(true){
			result = false;
        for(int i =0; i<str.length-1; i++){
           if(n[i]>n[i+1]){
        	   t= n[i];
        	   n[i] = n[i+1];
        	   n[i+1] = t;
        	   result = true;
        	   for(int j=0; j<str.length; j++){
        		   System.out.print(n[j]+" ");
        	   }
        	   System.out.println();
           }
           t=0;
         }
         if(result ==false){
        	 break; 
         }
		}
		*/
	}
}

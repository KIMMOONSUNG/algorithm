package simulation;

import java.util.Scanner;

public class N_1551 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       int N = sc.nextInt(); // 수열의 크기
       int K = sc.nextInt(); // 반복
       int arr[]= new int[N];
       String str= sc.next();
       for(int i =0; i<N ; i++){
    	   arr[i]=Integer.parseInt((str.split(",")[i]));
       }
       int count = 1;
       while(true){
    	   if(count== K+1){
    		   break;
    	   }
       for(int i =1; i<N-(count-1); i++){
    	  arr[i-1]=arr[i]-arr[i-1];
       }
       count++;
       }
         for(int i =0; i<N-(count-1); i++){
        	 if(i==(N-count)){
        		 System.out.print(arr[i]);
        	 }
        	 else{
        	 System.out.print(arr[i]+",");
        	 }
         }
	}
}

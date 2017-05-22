package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class n1977 { // 완전제곱수  
	public static void main(String[] args) throws IOException{
		BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int m =Integer.parseInt(bf.readLine());
		int summax = 0;
		int ansmin = 1000000;
		boolean check = false;
		
		for(int i =0; i<10000; i++){
		  if((i*i) >= n && m >= (i*i)){
			 ansmin = Math.min(i*i, ansmin);
			 summax += (i*i);
			 check = true;
		  }
		  else if((i*i)>m){
			  break;
		  }
		  
		}
		if(check == false){
			System.out.println(-1);
		}
		else{
			System.out.println(summax);
			System.out.println(ansmin);
		}
		
	}
}

package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_5532 {
	 public static void main(String[] args) throws IOException{
			BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
			int vacation = Integer.parseInt(bf.readLine());
			int koreanpage = Integer.parseInt(bf.readLine());
			int mathpage = Integer.parseInt(bf.readLine());
			int koreanday = Integer.parseInt(bf.readLine());
			int mathday = Integer.parseInt(bf.readLine());
			
	 /* 이것도 가능하고 
      int day=0;
       while(true){
		if(mathpage<=0 && koreanpage<=0){
			break;
		}
		day++;
		mathpage -= mathday;
		koreanpage -= koreanday;
	  }
	        System.out.println(vacation - day);
	*/
			 
		
			if(koreanpage%koreanday ==0){
				koreanpage/=koreanday;
			}
			else{
				koreanpage= koreanpage/koreanday+1;
			}
			
			if(mathpage%mathday==0){
				mathpage/=mathday;
			}
			else{
				mathpage= mathpage/mathday+1;
			}
			
			
			
			System.out.println(vacation - Math.max(koreanpage,mathpage));
		 }
}

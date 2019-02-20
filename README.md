# Algorithm
package ms;

public class bball {
 public static void main(String[] args) {
	int n = 371; 
	
	int js = 317;
	int sum = calcul(n,js);
	System.out.println(sum);
	
 }
 
 // ball + strike return;
 static int calcul(int n2, int js2){
	 
	int strike =0;
	int ball =0;
	 
   String n3 = String.valueOf(n2);
   int n3length = n3.length();
   
   String js3 = String.valueOf(js2);
   int js3length = js3.length();
   
   for(int i=0; i<n3.length(); i++){
	   int num123 = n3.charAt(i);
	   
	   for(int j=0; j<js3.length(); j++){
		   int num123_2 = js3.charAt(i);
		   
		   if( i == j){ // 같은번쨰에 있을때   
		      if(num123 == num123_2) {
		    	  strike ++;
		    	  break;
		      }
		   }else {// 같은번쨰 아닐때 
			  if(num123 == num123_2) {
				  ball++;
			  }
		   }
	   }
	   
   }
	 
   return 0;	 
 }
 
}


//////////////////////////////////////////////////////////////


2)

package ms;

public class bball {
 public static void main(String[] args) {
	int n = 371; 
	
	int js = 317;
	int sum = calcul(n,js);
	System.out.println(sum);
	
 }
 
 // ball + strike return;
 static int calcul(int n2, int js2){
	 
	int strike =0;
	int ball =0;
	 
   String n3 = String.valueOf(n2);
   int n3length = n3.length();
   
   String js3 = String.valueOf(js2);
   int js3length = js3.length();
   
   for(int i=0; i<n3.length(); i++){
	   int num123 = n3.charAt(i);
	   
	   for(int j=0; j<js3.length(); j++){
		   int num123_2 = js3.charAt(i);
		   
		   if( i == j){ // 같은번쨰에 있을때   
		      if(num123 == num123_2) {
		    	  strike ++;
		    	  break;
		      }
		   }else {// 같은번쨰 아닐때 
			  if(num123 == num123_2) {
				  ball++;
			  }
		   }
	   }
	   
   }
	 
   return 0;	 
 }
 
}

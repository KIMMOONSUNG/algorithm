import java.util.Scanner;

public class cupang1 {
	public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String str  = sc.next();
	char ch[] = new char[str.length()];
	for(int i =0; i<str.length(); i++){
		ch[i] = str.charAt(i);
	}
	 int ch_last[] = new int[str.length()];
	 StringBuffer sb = new StringBuffer();
	// String str_s = str.substring(0,4);
	 //System.out.println(str_s);
	
	for(int i =0; i<str.length(); i++){
		char s = ch[i];
	   for(int j=str.length()-1; j>=i; j--){
		   
		   if(s==str.charAt(j)){
			   int last=0;
			   String str_s = str.substring(i,j+1);
			   System.out.println(str_s);
			   sb.append(str_s);
			   if(str_s == sb.reverse().toString()){//팰린드롬이다
				   System.out.println("들");
				   ch_last[i] = Math.max(last, (j+1)-i);
				   System.out.println(Math.max(last, (j-i)));
			   }
			   else{
                  //ch_last[i] =Math.max(last, (j+1)-i);
				   
			   }
		   }
	   }
	  //String str_s= str.substring(, endIndex);
	}
	
	for(int i =0; i<str.length(); i++){
		   System.out.print(ch_last[i]+"/");
	   }
	
  }
}

import java.util.Scanner;

public class cupang2 {
 public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	String input[] = new String[7];
	for(int i =0; i<7; i++){
		input[i] = sc.next();
	}
	String q1[] = new String[(input.length)+1];
	String q2[] = new String[(input.length)+1];
	String q3[] = new String[(input.length)+1];
		q1[0] = "arr1";
		q2[0] = "arr2";
	    q3[0] = "arr3";
	    String result[] = new String[input.length];
	    int cnt = 0;
	  for(int i =0; i<input.length; i++){
        	if(cnt ==0){
        		q1[i+1] = input[i];
        		result[i] = q1[0] + "," + q1[i+1];
        		cnt++;
        	}
        	else if(cnt==1){
        		q2[i+1] = input[i];
        		result[i] = q2[0]+","+q2[i+1];
        		cnt++;
        		
        	}
        	else{
        		q3[i+1] = input[i];
        		result[i] = q3[0]+","+q3[i+1];
        		cnt=0;
        	}
        	System.out.println(result[i]);
        }
}
}

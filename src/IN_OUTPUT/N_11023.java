package IN_OUTPUT;

import java.util.Scanner;
import java.util.StringTokenizer;

public class N_11023 {


 public static void main(String[] args){
	 Scanner sc=new Scanner(System.in);
     String str=sc.nextLine();
     int sum=0;
     StringTokenizer st=new StringTokenizer(str, " ");
     while(st.hasMoreTokens())
     {
          // sum+=Integer.valueOf(st.nextToken());
    	  // OR
    	  sum+=Integer.parseInt(st.nextToken());
     }
     System.out.println(sum);
}

	     /*
	public static void main(String[] args) throws IOException{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			String str =bf.readLine(); 
			int sum =0;
			StringTokenizer st = new StringTokenizer(str);
			while(st.hasMoreTokens()){
			  sum+=Integer.parseInt(st.nextToken());
			}
			System.out.println(sum);
		}	
		*/	
	/*
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" "); //배열만들어줌 
	int num =0;
	for(int i =0; i<str.length; i++){
	  num+=Integer.parseInt(str[i]);
	}
	System.out.println(num);
}	
*/
}

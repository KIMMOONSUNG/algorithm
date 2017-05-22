package Study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1057 { // 토너먼트 
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		//int N = sc.nextInt();
		//int j_num = sc.nextInt();
		//int h_num = sc.nextInt();
	    String str[] = bf.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int j_num = Integer.parseInt(str[1]);
		int h_num = Integer.parseInt(str[2]);
		/*
        int i =0;
		for(i=0; j_num!=h_num; i++){
			j_num = j_num-j_num/2;
			h_num = h_num-h_num/2;
		}
		System.out.println(i);
		*/
	    int cnt = 0; 
	    while(true){
	     if(j_num==h_num){
	    	 break;
	     }
	     j_num = j_num-j_num/2;
		 h_num = h_num-h_num/2;
	     cnt++;
	    }
	    System.out.println(cnt);
	}
}

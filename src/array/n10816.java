package array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n10816 { // 배열
	 public static void main(String[] args) throws IOException{
			BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
			 int n = Integer.parseInt(bf.readLine());
			 StringTokenizer st = new StringTokenizer(bf.readLine());
		     int arr[][] = new int[2][10000001]; // 0쪽은 양수 1쪽은 음수 
		     for(int i=0; i<n; i++){
		    	 int num=Integer.parseInt(st.nextToken());
		    	if(num>0){
		    	arr[0][num] +=1;
		    	}
		    	else{
		    		num= num*(-1);
		    	arr[1][num] +=1;
		    	}
		     }
		     int m =Integer.parseInt(bf.readLine());
		     st = new StringTokenizer(bf.readLine());
		     StringBuilder sb = new StringBuilder();
		     for(int i =0; i<m; i++){
		       int num = Integer.parseInt(st.nextToken());
		       if(num>0){
		    	   sb.append(arr[0][num]+" ");
		       }
		       else{
		    	   num= num*(-1);
		    	   sb.append(arr[1][num]+" ");   
		       }
		     }
		     System.out.println(sb);
			
		 }
}

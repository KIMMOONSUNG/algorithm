package dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class n10819 { // 차이를 최대로 
	
	  public static boolean next_permutation(int[] a) {
		
	        int i = a.length-1;
	        while (i > 0 && a[i-1] >= a[i]) {
	            i -= 1;
	        }
	        // 마지막 순열
	        if (i <= 0) {
	            return false;
	        }

	        int j = a.length-1;
	        while (a[j] <= a[i-1]) {
	            j -= 1;
	        }

	        int temp = a[i-1];
	        a[i-1] = a[j];
	        a[j] = temp;

	        j = a.length-1;
	        while (i < j) {
	            temp = a[i];
	            a[i] = a[j];
	            a[j] = temp;
	            i += 1;
	            j -= 1;
	        }
	        return true;
	    }
	  
	    public static int calculate(int a[]) { //현재 배열 순서대로 계산했을 때  
	        int sum = 0;
	        for (int i=1; i<a.length; i++) {
	            sum += Math.abs(a[i] - a[i-1]);
	        }   
	        return sum;
	    }
	    
	    public static void main(String args[]) throws IOException{
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(bf.readLine());
	        StringTokenizer st = new StringTokenizer(bf.readLine());
	        int[] arr = new int[n];
	        for (int i=0; i<n; i++) {
	            arr[i] = Integer.parseInt(st.nextToken());
	        }
	        Arrays.sort(arr);
	        int ans = 0;
	        do {
	            int temp = calculate(arr);
	            ans = Math.max(ans, temp);
	        } while(next_permutation(arr) == true);

	        System.out.println(ans);
	       
	    }
	    
}

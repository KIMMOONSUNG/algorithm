package code_plus;

import java.util.PriorityQueue;
import java.util.Scanner;

public class hip_N_1927 {//최소힙 -> class따로필요없음 최소힙이니까 
	 public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
	        int n = sc.nextInt();
	        while (true) {
	        	if(n==0){
	        		break;
	        	}
	            int x = sc.nextInt();
	            if (x == 0) {
	                if (q.isEmpty()) {
	                    System.out.println(0);
	                } 
	                else {
	                    System.out.println(q.poll());
	                }
	            } 
	            else {
	                q.offer(x);
	            }
	            n--;
	        }
	    }
}

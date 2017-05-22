package code_plus;

import java.util.PriorityQueue;
import java.util.Scanner;

class c2 implements Comparable<c2>{
	int num ;
	c2(int num){
		this.num = num;
	}
	public int compareTo(c2 c){
		if(this.num > c.num){
			return -1;
		}
		else if (this.num == c.num){
			return 0;
		}
		else{
		  return 1;
		}
	}
}

public class hip_N_11279_2 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		PriorityQueue<c2> pq = new PriorityQueue<c2>();
		
		int n = sc.nextInt();
		while(true){
			if(n==0){
				break;
			}
			int x = sc.nextInt();
			if(x==0){
				if(pq.isEmpty()){
					System.out.println(0);
				}
				else{
					c2 c = pq.poll();
					System.out.println(c.num);
				}
			}
			else{
			   pq.offer(new c2(x));
				
			}
			n--;
		}
		
	}
}

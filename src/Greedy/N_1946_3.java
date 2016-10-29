package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;


class a8 implements Comparable<a8>{
	int x;
	int y;
	a8(int x, int y){
		this.x = x;
		this.y =y;
	}
	//이렇게 하면 x값이 정렬되고 y값은 따라옴 
	public int compareTo(a8 c){
		if(this.x >c.x){
			return 1;			
		}
		else if(this.x == c.x){
			if(this.y > c.y){
				return 1;
			}
			else if (this.y == c.y){
				return 0;
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}
	}
}

public class N_1946_3 {
	public static void main(String[] args) {
	 	Scanner sc = new Scanner(System.in);
	 	
	 	int T = sc.nextInt();
	 	
	 	for(int a =0; a<T; a++){
	 		int n = sc.nextInt();
	 		PriorityQueue<a8> pq = new PriorityQueue<a8>();
	 		for(int i =0; i<n; i++){
	 		    pq.offer(new a8(sc.nextInt(),sc.nextInt()));
	 		}
	 	    a8 p = pq.poll();
	 	    int vs = p.y;
	 		int count =1;
	 		for(int i =1; i<n; i++){
	 			p = pq.poll();
	 			if(p.y < vs){
	 				vs  = p.y;
	   			    count++;
	   			} 			
	 		}
	 		System.out.println(count);
	 	}
	 	
	  }
}

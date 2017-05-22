package code_plus;

import java.util.PriorityQueue;
import java.util.Scanner;

class a7 implements Comparable<a7>{
	int x;
	int y;
	a7(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(a7 a){
		if(this.y > a.y){
			return 1;			
		}
		else if(this.y == a.y){
			if(this.x > a.x){
				return 1;
			}
			else if(this.x == a.x){
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
public class sort_N11651_4 {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		PriorityQueue<a7> pq = new PriorityQueue<a7>();
		 for(int i =0; i<n; i++){
		    pq.offer(new a7(sc.nextInt(),sc.nextInt()));
		 }
		 
		 StringBuilder sb = new StringBuilder();
		 for(int i =0; i<n; i++){
			 a7 m = pq.poll();
		 	 sb.append(m.x+" "+m.y);
			 sb.append("\n");
		 }
		 System.out.println(sb);
	 }
}

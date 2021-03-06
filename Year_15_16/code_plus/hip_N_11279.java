package code_plus;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class hip_N_11279 { // 최대힙
	
	static class Compare implements Comparator<Integer> {
		
		public int compare(Integer one, Integer two) {
			//return two.compareTo(one);
			if(one >two){
				return -1;
			}
			else if(one==two){
				return 0;
			}
			else{
				return 1;
			}
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Compare cmp = new Compare();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(1, cmp);
		int n = sc.nextInt();
		while (true) {
			if (n == 0) {
				break;
			}
			int x = sc.nextInt();
			if (x == 0) { // 0 이면 가장 큰값출력
				if (q.isEmpty()) { // 배열이 비어있는경우
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

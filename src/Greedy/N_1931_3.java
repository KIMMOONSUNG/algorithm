package Greedy;

import java.util.PriorityQueue;
import java.util.Scanner;

class N_1931_3_c implements Comparable<N_1931_3_c>{
	int x;
	int y;
	N_1931_3_c(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(N_1931_3_c c){
		if(this.y> c.y){
			return 1;
		}
		else if(this.y == c.y ){
			if(this.x > c.x){
				return 1;
			}
			else if(this.x == c.x){
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
public class N_1931_3 {
	
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	PriorityQueue<N_1931_3_c> pq = new PriorityQueue<N_1931_3_c>();
    for(int i =0; i<num; i++){
      pq.offer(new N_1931_3_c(sc.nextInt(),sc.nextInt()));	
    }
    
    int cnt = 1;//1부터 시작
    
    N_1931_3_c p = pq.poll();
    int end = p.y;
    for(int i =1;i<num; i++){
    	 p = pq.poll();
    	if(end<= p.x){
    		end = p.y;
    		cnt++;
    	}
    }
    System.out.println(cnt);
}

}

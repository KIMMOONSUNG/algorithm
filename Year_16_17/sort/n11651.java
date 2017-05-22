package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class n_11651 implements Comparable<n_11651>{ 
	int num1 , num2;
	n_11651(int num1,int num2){
		this.num1 = num1;
		this.num2 = num2;
	}
	public int compareTo(n_11651 c){
		if(this.num2 >c.num2 ){
			return 1;
		}
		else if(this.num2 == c.num2){
			if(this.num1 > c.num1){
			 return 1;
			}
			else if(this.num1 == c.num1){
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
public class n11651 { //좌표정렬하기 2 
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	PriorityQueue<n_11651> pq = new PriorityQueue<>();
	for(int i =0; i<n; i++){
		StringTokenizer st = new StringTokenizer(bf.readLine());
		pq.offer(new n_11651(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));		
	}
	StringBuilder sb= new StringBuilder();
	for(int i =0; i<n; i++){
	    n_11651 p = pq.poll();
	    sb.append(p.num1 +" "+p.num2+"\n");
	}
	System.out.println(sb.toString());
	
}
}

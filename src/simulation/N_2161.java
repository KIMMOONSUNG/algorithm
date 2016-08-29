package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class N_2161 { // 카드 1 -> Deque로 품 
	                  //  뺀다<-[////////]<-넣고
	                  //
	 /*
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 카드 입력받음.
		sc.close();
		Deque<Integer> dq = new LinkedList<Integer>();
		for (int i = 1; i <= N; i++) { // 값 순서대로 deque에 넣고 
          dq.offer(i);
		}
		while(!dq.isEmpty()){ 
			System.out.print(dq.poll() +" ");//첫번째꺼 하나씩 빼면서 출력 //1출력하고
			if(!dq.isEmpty()){ // 비어있지않았을때 꼭 써주고 
				dq.offer(dq.poll()); // 그 다음꺼를 빼서 맨뒤로 넣어준다. // 2빼서 맨뒤로넣고 
			}
		}
	}
	*/
	public static void main(String[] args)throws IOException {
		BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		Deque<Integer> dq = new LinkedList<Integer>();
		
		for(int i =1; i<=n; i++){
			dq.offer(i);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!dq.isEmpty()){
			sb.append(dq.poll()+" ");
			if(!dq.isEmpty()){
				dq.offer(dq.poll());
			}
		}
		System.out.println(sb);
		
	}
}

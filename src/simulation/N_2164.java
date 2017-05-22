package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class N_2164 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	Queue<Integer> q = new LinkedList<Integer>();
	for(int i =1; i<=n; i++){
		q.offer(i);
	}
	int result=0;
	while(!q.isEmpty()){
		result = q.poll();
		if(!q.isEmpty()){
		q.offer(q.poll());
		}
	}
	System.out.println(result);
}
}

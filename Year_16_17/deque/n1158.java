package deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class n1158 { //조세퍼스 문제 
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(bf.readLine());
	    int n = Integer.parseInt(st.nextToken());
	    int m =Integer.parseInt(st.nextToken());
	    
	    Deque<Integer> dq = new ArrayDeque<>();
	    
	    for(int i =1; i<=n; i++){
	       dq.addLast(i);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    
	    while(!dq.isEmpty()){
	    	for(int i=0; i<m-1; i++){
	    	dq.addLast(dq.pollFirst());
	    	}
	    	sb.append(dq.pop()+", ");
	    }
	    sb.delete(sb.length()-2, sb.length());
	    System.out.println("<"+sb.toString()+">");
	    
	}
}

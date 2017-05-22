package backtracking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
 
public class n10597 { // 순열장난 
    public static BufferedReader bf = 
            new BufferedReader(new InputStreamReader(System.in));
    public static StringBuilder sb = new StringBuilder();
    public static int[] visited = new int[100];
    public static int len;
    public static int[] arr;
    public static boolean find = false;
    public static Deque<Integer> deque = new ArrayDeque<Integer>();
    
    public static void main(String args[]) throws IOException{
    	String num = bf.readLine();
    	len = num.length();
    	arr = new int[len];
    	visited[0] = 1;
    	for(int i = 0; i < len; i++){
    		arr[i] = (int)(num.charAt(i))-48;
    	}
    	func(0);
   
    }
    static void func(int place){
    	if(find == true) return;
    	if(place == len){
    		boolean error = false;
    		for(int i = 1; i < 100; i++){
    			if(visited[i-1] == 0 && visited[i] == 1){
    				error = true;
    				break;
    			}
    		}
    		if(!error){
    			find = true;
    			
    			while(!deque.isEmpty()){
    				sb.append(deque.pollFirst()+" ");
    	    	}
    			System.out.println(sb.toString());
    		}
    	}
    	
    	else if(place == len-1){
    		if(visited[arr[place]] != 1 && !find){
    			visited[arr[place]] = 1;
    			deque.addLast(arr[place]);
    			func(place+1);
    			deque.pollLast();
    			visited[arr[place]] = 0;
    		}
    	}
    	else{
    		if(arr[place+1] == 0){
    			if(visited[arr[place]*10+arr[place+1]] != 1 && !find){
        			visited[arr[place]*10+arr[place+1]] = 1;
        			deque.addLast(arr[place]*10+arr[place+1]);
        			func(place+2);
        			deque.pollLast();
        			visited[arr[place]*10+arr[place+1]] = 0;
        		}
    		}
    		else{
    			if(visited[arr[place]] != 1 && !find){
    				visited[arr[place]] = 1;
    				deque.addLast(arr[place]);
    				func(place+1);
    				deque.pollLast();
    				visited[arr[place]] = 0;
    			}
    			if(visited[arr[place]*10+arr[place+1]] != 1 && !find){
    				visited[arr[place]*10+arr[place+1]] = 1;
    				deque.addLast(arr[place]*10+arr[place+1]);
    				func(place+2);
    				deque.pollLast();
    				visited[arr[place]*10+arr[place+1]] = 0;
    			}
    		}
    	}
    }
  
}
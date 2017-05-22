package 인접;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class n11724_2 { //인접리스트
	static Node[] no;
    static int n,m;
    
    static class Node{
    	boolean visit ;
    	ArrayList<Integer> next = new ArrayList<>();
    	
    }
    
 public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st= new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	
    no = new Node[n+1];
    for(int i =1; i<=n; i++){
    	no[i] = new Node();
    }
    
    for(int i =1; i<=m; i++){
    	st = new StringTokenizer(bf.readLine());
    	
    	int a= Integer.parseInt(st.nextToken());
    	int b=  Integer.parseInt(st.nextToken());
    	
    	no[a].next.add(b);
    	no[b].next.add(a);
    }
    
    int count =0;
    
    for(int i =1; i<=n ; i++){
    	if(no[i].visit==false){
    		count++;
    		dfs(i);
    	}
    }
    
    System.out.println(count);
    
 } 
 
 static void dfs(int num){
	 
	 no[num].visit = true;

	 for(int i : no[num].next){
			 if( no[i].visit==false){
				 dfs(i);
			 }
	 }
	 
 }
 
}

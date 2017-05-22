package samsungproblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class n5{
	ArrayList<Integer> al;
	n5(){
		al = new ArrayList<>();
	}
}
public class N5214 { // 환승
	static int n; //역의 수 
	static int k; // 한 하이퍼튜뷰가 연결하는 역의 개수  
	static int m; // 하이퍼튜브개수 
	
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
     n =Integer.parseInt(st.nextToken());
     k = Integer.parseInt(st.nextToken());
     m = Integer.parseInt(st.nextToken());
     n5 p [] = new n5[n+m+1];
     
     for(int i=1; i<=n+m; i++){
    	 p[i] = new n5();
     }
     
     for(int i =1; i<=m; i++){
    	 st = new StringTokenizer(bf.readLine());
    	 for(int j=0; j<k; j++){
    		 int t = Integer.parseInt(st.nextToken());
    		 p[t].al.add(n+i); //  
    		 p[n+i].al.add(t); //
    	 }
     }
     
     int d[] = new int [n+m+1];
     d[1] = 1;
     Queue<Integer> q = new LinkedList<>();
     q.offer(1);
     boolean check = false;
     
     while(!q.isEmpty()) {
    	 
    	 int c = q.poll();
    	 if(c == n){ // 1~ n 까지 가는 거니 n 이면 끝 
    		 check = true;
    		 System.out.println(d[c]+" ");
    		 break;
    	 }
    	 
    	 for(int v =0; v< p[c].al.size(); v++){
    		 int i = p[c].al.get(v);
    		 if(d[i] !=0 ){
    			 continue;
    		 }

    		 if(i >n){
    			 d[i] = d[c];
    		 }
    		 else{
    			 d[i] = d[c]+1;
    		 }
    		 q.offer(i);
    		 
    	 }
    	 
     }
     
     if(check == false){
      System.out.println("-1");
     }
     
 }
 
}

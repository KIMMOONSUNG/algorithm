package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n1525 { // 퍼즐  -> bfs  //이중배열로 상태 못보는것을 -> map으로  
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	
  public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n = 3;
	int start = 0;
	StringTokenizer st ;
    for(int i =0; i<n; i++){
    	st = new StringTokenizer(bf.readLine());
    	for(int j =0; j<n; j++){
    		int temp = Integer.parseInt(st.nextToken());
    		if(temp == 0){ //빈칸인 0은 9로 
    			temp = 9;
    		}
    		start = start * 10 +temp; // -> 193425786 
    	}
    }
    
    Queue<Integer> q = new LinkedList<Integer>();
    HashMap<Integer,Integer> hm = new HashMap<Integer, Integer>();
    hm.put(start, 0);// 시작 지점 과 길이를 넣어준다 
    q.offer(start);
    
    while(!q.isEmpty()){
      int p = q.poll();
      String now = Integer.toString(p); // 형 변환
      int z = now.indexOf('9'); // 9 의 위치를 찾는다. (첫위치가 0임)
      int a = z/3;
      int b = z%3;
      
      for(int i=0; i<4; i++){
    	  int x = a+dx[i];
    	  int y = b+dy[i];
    	  if(x>=0 && y>=0 && x<n && y<n){
    		  StringBuilder sb = new StringBuilder(now);
    		  char temp = sb.charAt(a*3+b); 
    		  char temp2 = sb.charAt(x*3+y);
    		  //몇 번째 인덱스에 무슨 문자를 넣을것인지 
    		  //위치 바꿈
    		  sb.setCharAt(a*3+b, temp2);
    		  sb.setCharAt(x*3+y ,  temp);
    		  int num = Integer.parseInt(sb.toString());// 다시 형 변환 
    		  if(!hm.containsKey(num)){ // 포함되있지 않다면 == 방문했던상태 가 아니라면 
    			  hm.put(num, hm.get(p) + 1); //넣고 길이 1 증가시킨다고보면됨 
    			  q.offer(num);
    		  }
    	  }
      }
      
    }
    
    if(hm.containsKey(123456789)){ // 순서대로 만들었다면 
    	System.out.println(hm.get(123456789)); 
    }
    
    else{
    	System.out.println(-1);
    }
    
 }
}

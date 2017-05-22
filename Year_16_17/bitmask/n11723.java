package bitmask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class n11723 {
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	int n =Integer.parseInt(bf.readLine());
    int k = 20;
	StringTokenizer st ;
	/*
	add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
	remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
	check x: S에 x가 있으면 1을, 없으면 0을 출력한다.
	toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
	all: S를 {1, 2, ..., 20} 으로 바꾼다.
	empty: S를 공집합으로 바꾼다. 
	*/

	int  s =0 ;
	for(int i =0; i<n; i++){
	  st = new StringTokenizer(bf.readLine());
	  String str = st.nextToken();
	  int num =0;
	  
	  if (str.equals("add")) {
		  num = Integer.parseInt(st.nextToken())-1;
			 //s = (s | (1 << num)); //이것도가능  
			 s+= 1<<num; //이것도 가능 
      } else if (str.equals("remove")) {
    	  num = Integer.parseInt(st.nextToken())-1;
  		  s = (s&~(1<<num));
      }
      else if (str.equals("check")) {
    	  num = Integer.parseInt(st.nextToken())-1;
  		if((s & (1 << num))!=0){ // 들어있다 
  		   bw.write("1\n");
  		}
  		else{
  			bw.write("0\n");
  		}
      }
      else if (str.equals("toggle")) {
    	  num = Integer.parseInt(st.nextToken())-1;
          s = (s ^ (1 << num)); // 0 과 1을 서로 바꿔줌 
      }
      else if (str.equals("all")) {
    	  s = (1 << k) - 1;
      }
      else if (str.equals("empty")) {
    	  s=0;
      }
	
	}
	bw.close();
}
}

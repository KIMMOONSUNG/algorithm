package code_plus;

import java.util.*;
import java.io.*;

// 좌표정렬하기1 -> comparable / compareTo메소드씀 

class c implements Comparable<c> {
 int x, y;
  c(int x,int y){
	  this.x = x;
	  this.y = y;
  }
  
  public int compareTo(c a){
	  if( this.x > a.x){ // this가 크면 1 
		  return 1;
	  }
	  else if(this.x== a.x){ //같을때 0인디 조건에서 y를 보라했으니까 
		  if(this.y>a.y){ // this 크면 1
			  return 1;
		  }
		  else if(this.y<a.y){ //this작으면 -1
			  return -1;
		  }
		  else{ 
			  return 0; // 같으면 0
		  }
	  }
	  else{ // this가 작을때니까 -1
		  return -1;
	  }
  }
  
}

public class sort_N11650{
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		c[] a = new c[n]; // class 배열 객체 생성
		
		for(int i =0; i<n; i++){
			String[] num = bf.readLine().split(" ");
			int x = Integer.parseInt(num[0]);
			int y = Integer.parseInt(num[1]);
			a[i] = new c(x,y); // 위에서 만든 a에 넣는다 x,y 넣어
		}
		
		Arrays.sort(a); //정렬시키고 
		
		StringBuilder sb = new StringBuilder(); 
		for(int i =0; i<n; i++){
			/* 이렇게 하던가 
			c p = a[i];	 // 다시 객체 만들고
			sb.append(p.x +" "+ p.y +"\n"); //append로 이어서
			*/
			
			sb.append(a[i].x+" "+a[i].y + "\n");
		}
		System.out.println(sb); //출력
	}
}




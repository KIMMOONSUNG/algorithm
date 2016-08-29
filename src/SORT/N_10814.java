package SORT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class sort_10814 implements Comparable<sort_10814>{
	int x;
	int y;
	 sort_10814(int x ,int y){
		this.x  =x;
		this.y =y;
	}
	 public int compareTo(sort_10814 c){
		 if(this.x > c.x){
			 return 1;
		 }
		 else if(this.x == c.x){
			 if(this.y >c.y){
				 return 1;
			 }
			 else if(this.y<c.y){
				 return -1;
			 }
			 else{
				 return 0;
			 }
		 }
		 else{ 
			 return -1;
		 }
	 }
	
}
// 이름은 string형이라서 name배열에 따로넣고 그 인덱스를 
//comparable로 구분하고 y는 인덱스로 해서 넣어주고  
//출력시에 y를 출력하는게 아닌 name[y]를출력
public class N_10814 {
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	sort_10814[] a= new sort_10814[n];
	String name [] = new String[n+1]; // 이름 넣을 배열
	
	for(int i =0; i<n; i++){
	String[] num = bf.readLine().split(" ");
	int x = Integer.parseInt(num[0]);
	name[i+1] = num[1]; // 이름을 넣는다 
	int y = i+1; //순서로 넣는다
	a[i] = new sort_10814(x,y); 
	}
	Arrays.sort(a);
	StringBuilder sb = new StringBuilder();
	
	for(int i =0; i<n; i++){
		sort_10814 p = a[i];
		sb.append(p.x +" "+name[p.y]+"\n");
	}
	System.out.println(sb);
 }
}

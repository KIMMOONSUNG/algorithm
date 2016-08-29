package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class a_a implements Comparable<a_a>{
	int x ;
	int y ;
	a_a(int x,int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(a_a a){
		if(this.x >a.x){
			return 1;
		}
		else if(this.x ==a.x){
			if(this.y >a.y){
				return 1;
			}
			else if(this.y <a.y){
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

public class aa {
	public static void main(String[] args) throws IOException {
	 BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int n =Integer.parseInt(bf.readLine());
	 a_a[] p = new a_a[n];
	 
	 for(int i=0; i<n; i++){
	  String [] num = bf.readLine().split(" ");
	  int x = Integer.parseInt(num[0]);
	  int y = Integer.parseInt(num[1]);
	  p[i] = new a_a(x,y);
	 }
	 
	 Arrays.sort(p);
	 
	 StringBuilder sb=  new StringBuilder();
	 for(int i =0; i<n; i++){
		 a_a p2 = p[i];
		 sb.append(p2.x +" "+p2.y+"\n");
	 }
	 System.out.println(sb);
 }
}
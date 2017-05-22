package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//좌표정렬하기 2 ->comparable / compareTO 메소드사용

class sort_11651 implements Comparable<sort_11651>{
	int x ;
	int y ;
	sort_11651(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int compareTo(sort_11651 c){
		if(this.y > c.y){
			return 1;
		}
		else if(this.y == c.y){
			if(this.x >c.x){
				return 1;
			}
			else if(this.x<c.x){
				return -1;
			}
			else{
				return 0;
			}
		}
		else {
			return -1;
		}
	}
}

public class sort_N_11651 {
  public static void main(String[] args) throws IOException{
	
   BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
   int n = Integer.parseInt(bf.readLine());
   sort_11651[] a = new sort_11651[n];
   
   for(int i =0; i<n; i++){
	  String num[] = bf.readLine().split(" ");
	  int x = Integer.parseInt(num[0]);
	  int y = Integer.parseInt(num[1]);
	  a[i] = new sort_11651(x,y);
   }
   Arrays.sort(a);
   StringBuilder sb = new StringBuilder();
   for(int i =0; i<n; i++){
	   sort_11651 p = a[i];
	   sb.append(p.x+" "+p.y+"\n");
   }
   System.out.println(sb);
 }
}

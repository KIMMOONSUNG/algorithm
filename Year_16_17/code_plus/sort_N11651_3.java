package code_plus;

import java.util.Arrays;
import java.util.Scanner;
class abab implements Comparable<abab>{
	int x;
	int y;
	abab(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(abab a){
		if(this.y > a.y){
			return 1;			
		}
		else if(this.y == a.y){
			if(this.x > a.x){
				return 1;
			}
			else if(this.x == a.x){
				return 0;
			}
			else{
				return -1;
			}
		}
		else{
			return -1;
		}
	}
}
public class sort_N11651_3 {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt();
		abab arr[] = new abab[n];
		 for(int i =0; i<n; i++){
		    arr[i] = new abab(sc.nextInt(), sc.nextInt());
		 }
		 Arrays.sort(arr);
		 StringBuilder sb = new StringBuilder();
		 for(int i =0; i<n; i++){
			 sb.append(arr[i].x+" "+arr[i].y);
			 sb.append("\n");
		 }
		 System.out.println(sb);
	 }
}

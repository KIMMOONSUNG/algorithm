package Greedy;

import java.util.Arrays;
import java.util.Scanner;

class kkkk implements Comparable<kkkk>{
	int x;
	int y;
	kkkk(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(kkkk k){
		if(this.y> k.y){
			return 1;
		}
		else if(this.y == k.y){
			if(this.x > k.x ){
				return 1;
			}
			else if(this.x == k.x){
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
public class practice {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	kkkk a[] = new kkkk[n];
	for(int i =0; i<n; i++){
		a[i] = new kkkk(sc.nextInt(), sc.nextInt());
	}
	Arrays.sort(a);
	int cnt = 1;
	int end = a[0].y;
	for(int i =1; i<n; i++){
		if(end<=a[i].x){
			end = a[i].y;
			cnt++;
		}
	}
	System.out.println(cnt);
	
 }
}

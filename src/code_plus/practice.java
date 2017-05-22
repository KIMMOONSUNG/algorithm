package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

class mmm implements Comparable<mmm>{
	int x,y;
	mmm(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int compareTo(mmm c){
		if(this.x > c.x){
			return 1;
		}
		else if(this.x == c.x){
			if(this.y >c.y){
				return 1;
			}
			else if(this.y==c.y){
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
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	mmm arr[] = new mmm[n];
	StringTokenizer st ;
	for(int i =0; i<n; i++){
		st = new StringTokenizer(bf.readLine().trim());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		arr[i] = new mmm(x,y);
	}
	Arrays.sort(arr);
	StringBuilder sb = new StringBuilder();
	for(int i =0; i<n; i++){
		sb.append(arr[i].x+" "+arr[i].y+"\n");
	}
	System.out.println(sb);
 }
}
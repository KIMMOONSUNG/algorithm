package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_1173_2 {
  public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	String str[] = bf.readLine().split(" ");
	int num[] = new int[str.length];
	for(int i=0; i<str.length; i++){
		num[i] = Integer.parseInt(str[i]);
	}
	if(num[1]+num[3]>num[2]){
		System.out.println("-1");
	}
	else{
		int time=0;
		int heart =num[1];
		int workout =0;
		while(true){
			time++;
			if(heart+num[3]<=num[2]){ //운동
				heart = heart+num[3];
				workout++;
			}
			else{                     //휴식
			   if(heart-num[4]<num[1]){
				   heart = num[1];
			   }
			   else{
				   heart = heart-num[4];
			   }
			}
			if(workout == num[0]){
				break;
			}
		}
		System.out.println(time);
	}
	
}
}

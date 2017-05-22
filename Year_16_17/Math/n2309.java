package Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class n2309 { //일곱난쟁이 
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int map[] = new int[9];
		int sum =0;
		for(int i =0; i<9; i++){
			map[i] = Integer.parseInt(bf.readLine());
			sum += map[i];
		}
		
		for(int i =0; i<9; i++){
			for(int j=i+1; j<9; j++){
			  if(sum - (map[i]+map[j])==100){
				  map[i] = 1000;
				  map[j] = 1000;
				  i= 10;
				  j= 10;
			  }
			}
		}
		Arrays.sort(map);
		for(int i =0; i<7; i++){
			System.out.println(map[i]);
		}
		
	}
}





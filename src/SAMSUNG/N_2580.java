package SAMSUNG;

import java.util.Scanner;

public class N_2580 {
 public static void main(String[] args) {
	 Scanner sc = new Scanner(System.in);
	int map[][] = new int[9][9];
	for(int i =0; i<9; i++){
		String str = sc.next();
		for(int j=0; j<9; j++){
			map[i][j] = str.charAt(j)-48;
		}
	}
 }
}

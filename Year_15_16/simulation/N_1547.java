package simulation;

import java.util.Scanner;

public class N_1547 {
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int m = sc.nextInt(); //컵위치 몇번바꿨는지
	int cup[][] = new int[m][2];
	for(int i =0; i<m; i++){
		for(int j=0; j<2; j++){
		 cup[i][j] = sc.nextInt(); 
		}
	}
	int ball = 1; 
	for(int i=0; i<m; i++){
		for(int j=0; j<2; j++){
		  if(cup[i][j] == ball ){
			 if(j==0){
			   ball = cup[i][1];
			   break;
			 }
			 if(j==1){
				 ball = cup[i][0];
				 break;
			 }
		  }
		}
	}
	System.out.println(ball);

 }
}

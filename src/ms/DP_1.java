package ms;

import java.util.Scanner;

public class DP_1 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	char arr[][] = new char[22][3];
	int arrr[][] = new int[22][3];
	int count[][] = new int[22][1];
	int num = 1;
	int C =0;
	String str = sc.nextLine();
	
	 str = str.replace(",", "");
	 str = str.replace(".","");
	 str=str.toLowerCase();
	 
	String[] str2 = str.split(" "); //공백으로 나눠진 문자열묶음 
	
	for(int i=0; i<str2.length; i++){ // 공백 나눈 문자열 길이 
	
		for(int k=0; k<22; k++){
			if(arr[k][0]==(str2[i].charAt(0))){
				if(arr[k][1]==str2[i].charAt(str2[i].length()-1)-48){
					
					count[k][0]=count[k][0]+1; //개수배열에 넘 증가시킨값 넣기
	////////////////////				arr[k][2] = (count[k][0]);
					C++;
				}
			}	
		}
		
		if(C==0){ //C가 0인것은 arr배열에 넣어져있는게 같은게없다는것
			
		arr[i][0]=str2[i].charAt(0); //첫글자넣기
		arr[i][1]=str2[i].charAt(str2[i].length()-1);//마지막글자넣기
		
		count[i][0]=num; // 개수배열에 num넣어줌
		////////////////                 arr[i][2] =count[i][0];
		}
		
		C=0;
	}
	for(int k=0; k<22; k++){
		if(arr[k][0]!=0){
			
	        System.out.print(arr[k][0]+""+arr[k][1]+""+arr[k][2]+","+count[k][0]);//""이거 안넣어주면 문자와 문자가 더해져서 숫자가됨 
	       System.out.println();
		}
	}
	
}
}

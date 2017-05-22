package 분할정복;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n1780 { // 종이의 개수 
 public static void main(String[] args) throws IOException {
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	//3(1),9(9),27(81).....
	int ans1 = 0; 
	int ans2 = 0;
	int ans3 =0 ;
	long arr[] = new long[3]; // 답 -1, 0 ,1 개수 
	long map [][][] = new long[2188][3][3];	 // 3행 씩 확인 
	int index =0; 
	long num=0;
    boolean check =false;
    
	for(int i =0; i<n; i++){
		StringTokenizer st =new StringTokenizer(bf.readLine());
		if(i!=0 && (i)%3 == 0){
           map = new long[2188][3][3]; // 3행 씩확인후 초기화 
		}
		
		for(int j =0; j<n; j++){
			if(j!=0 && (j)%3== 0){
		    	index++;

		    }
			map[index][i%3][j%3] = Integer.parseInt(st.nextToken());
			
		}
		
		index=0;
		
		if(i%3 == 2){
			
		   for(int h=0; h<(n/3); h++){ // (3-> 1, 9->3, 27 ->9 )
			    num = map[h][0][0] ; 
			    check = false;
			    ans1=0;
			    ans2=0;
			    ans3=0;
			for(int a =0; a<3; a++){
				for(int j =0; j<3; j++){
				  if(map[h][a][j]!=num){
					  check = true; // 하나라도 다르면 true 
				  }
				  if(map[h][a][j] == -1){
					  ans1 ++;
				  }
				  if(map[h][a][j]== 0){
					  ans2 ++;
				  }
				  if(map[h][a][j]==1){
					  ans3 ++;  
				  }
				}
			
			}
			if( check == false){ // 다 같으면  1 추가 
				if(ans1!=0){ 
					arr[0] +=1;
				}
				else if(ans2!=0){
					arr[1] +=1;
				}
				else if(ans3!=0){
					arr[2] +=1;
				}
			}
			else{ // 다 다르면 각 증가한 수 만큼 추가  
			  arr[0] +=ans1;
			  arr[1] += ans2;
			  arr[2] +=ans3;
			}
		   }
		   

		}
		
	}
	
   for(int i =0; i<3; i++){
	   System.out.println(arr[i]);
   }

 }
 
}

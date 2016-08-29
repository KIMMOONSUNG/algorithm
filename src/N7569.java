import java.util.Scanner;

public class N7569{
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int M = sc.nextInt();//가로줄
	int N = sc.nextInt();//세로줄
	int H = sc.nextInt();//개수
	int arr[][] = new int[N][M];
	int count=0;
	
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
		  arr[i][j] = sc.nextInt();
		}
	}
	
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
	      if(arr[i][j]==0)
	      {
	    	 if(j==0&&arr[i][j+1]==1&&arr[i+1][j]==1){ //왼쪽위
	    		 arr[i][j]=1;
	    	 }
	    	 else if(j==M-1&&arr[i][j-1]==1&&arr[i+1][j]==1){ //오른쪽 위 
	    		 arr[i][j]=1;
	    	 }
	      }
		}
	}
	
	/*
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
		if(arr[i][j]==0){
		 if((j==0&&j<M-1&&arr[i][j+1]==1)||(j==M-1&&arr[i][j-1]==1)){
			 arr[i][j]=1;
		 }
		 else if(j!=0&&j<M-1&&arr[i][j+1]==1){
			 arr[i][j]=1;
		 }
		}
		}
	  }
	
	for(int i=0; i<M; i++){
		for(int j=0; j<N; j++){
		 if(arr[j][i]==0){
			 if((j==0&&j<N-1&&arr[j+1][i]==1)||(j==N-1&&arr[j-1][i]==1)){
				 arr[j][i]=1;
				
			 }
			 else if(j!=0&&j<N-1&&arr[j+1][i]==1){
				 arr[j][i]=1;
			 }
		 }
		}
    }
	*/
	for(int i=0; i<N; i++){
		for(int j=0; j<M; j++){
		  System.out.print(arr[i][j]+"//");
		}
		System.out.println();
	}
	
	System.out.println(count);
}
}

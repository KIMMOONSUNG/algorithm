import java.util.Scanner;

public class N_1978 {
	//에라토스테네스의 체
 public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int arr[] = new int[1001]; 
	int count=0;

	for(int i =2; i<1001; i++){
		if(i==2||i==3||i==5||i==7){
			arr[i] =-1;
		}
		if(arr[i]==0&&(i%2==0||i%3==0||i%5==0||i%7==0)){
			
		}
		else{
			arr[i]=-1;
		}
	}
	int num =0;
	for(int i =0; i<N; i++){
        num = sc.nextInt();
        if(arr[num]==-1){
        	count++;
        }
	}
	System.out.println(count);
	
}
}

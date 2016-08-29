import java.util.Scanner;

public class N2502 {
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int count = sc.nextInt();
	int num=sc.nextInt();
	int arr[] = new int[count+1];
	for(int i =1; i<num; i++){
	    arr[1]=i;
		for(int j=1; j<count+1; j++){
	   arr[2]=i+j; 
	   for(int k=3;k<count+1; k++){
	   arr[k]=arr[k-1]+arr[k-2];
	   }
	   if(arr[count]==num){
		   System.out.println(arr[1]);
		   System.out.println(arr[2]);
		   i=num;
	   }
		}
     }
}
}

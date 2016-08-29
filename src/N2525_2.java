import java.util.Scanner;

public class N2525_2 { // 1 보다 더 오래걸리고 메모리도 많아짐..
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
	int arr[] = new int[3];
	for(int a=0; a<3; a++){
		arr[a] = sc.nextInt();
	}
     if(arr[2]+arr[1]>59){
    	 arr[0]+=(arr[1]+arr[2])/60;
    	 arr[1] = (arr[1] + arr[2]) % 60;
    	 if(arr[0]>23){
    	    arr[0]=arr[0]-24;
    	 }
     }
     else{
    	 arr[1]+=arr[2];
     }
     System.out.println(arr[0]+" "+arr[1]);
}
}

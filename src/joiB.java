import java.util.Scanner;

public class joiB {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int stu=sc.nextInt();
	int bu = sc.nextInt();
	int count =1;
	int now =0;
	int arr[]= new int[stu];
	for(int k=0; k<stu; k++){
		arr[k] = sc.nextInt();
	}
	for(int j=0; j<bu; j++){
		//count=bu;
	for(int i=1; i<stu; i++){
		now=arr[i];
		if(now%count<arr[i-1]%count)
		{
			arr[i]=arr[i-1];
			arr[i-1]=now;
		}
	}
	count++;
	}
	for(int a =0; a<stu; a++){
	System.out.println(arr[a]);
	}
}
}

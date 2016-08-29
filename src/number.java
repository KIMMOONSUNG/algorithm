import java.util.Scanner;
public class number {
public static void main(String[] args) {
	int number=1;
	int arr[]=new int[10];
	Scanner sc = new Scanner(System.in);
	for(int i=0;i<3;i++){
      number*=sc.nextInt();
	}
	//String str = String.valueOf(number);
	for(int i=0;i<String.valueOf(number).length(); i++){ 
		int index = (int)String.valueOf(number).charAt(i)-48;  
		arr[index] = arr[index]+1;// 해당 인덱스 +1시킴
	}
	
	for(int i=0;i<10;i++)
	{
		System.out.println(arr[i]);
	}
	
	
}
}

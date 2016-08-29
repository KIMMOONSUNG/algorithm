import java.util.Scanner;

public class dungci7568 {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int people = sc.nextInt();
	int arr[][]=new int[people][3];
	for(int i=0;i<people; i++)
	{
		arr[i][2]=1;
		for(int j=0;j<2;j++){
			arr[i][j]=sc.nextInt();
		}
	}
		for(int j=0;j<people;j++){
			int num=1;
			for(int i=0;i<people;i++){
				
			if(arr[j][0]<arr[i][0]&&arr[j][1]<arr[i][1])
			{
                num++;
                arr[j][2]=num;
			}
		}
		}
	for(int i=0;i<people;i++){
		System.out.print(arr[i][2]+" ");
	}
}
}

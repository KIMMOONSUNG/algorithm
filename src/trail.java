import java.util.Scanner;

public class trail {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int arr[][] = new int[4][2];
	int maxpeople=0;
	int people=0;
	for(int i=0;i<4;i++)
	{
		for(int j=0;j<2;j++){
		arr[i][j]=sc.nextInt();
		}
		people-=arr[i][0];
		people+=arr[i][1];
		if(maxpeople<people)
		{
			maxpeople=people;
		}
	}
	System.out.println(maxpeople);
}
}

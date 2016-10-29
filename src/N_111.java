import java.util.Arrays;
import java.util.Scanner;

public class N_111 {
 public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int xx =0;
		int yy =0;
		int dis =0;
		if(y<0){
		 xx = Math.abs(y);
		 yy = xx;
		}
		else{
			
		}
		//dis = xx*yy + ()
	 /*
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	int map[] = new int[n];
	for(int i =0; i<n; i++){
		map[i] = sc.nextInt();
	}
	Arrays.sort(map);
	int min =100000000;
	boolean result = false;
	for(int i =0; i<n-1; i++){
		
		if(map[i]==map[i+1]){
			min = map[i];
			System.out.println(min);
			result = true;
			break;
		}
		else{
			if(min < Math.abs(map[i]-map[i+1]))
			min = Math.abs(map[i]-map[i+1]);
		}
	}
	if(result == false){
	System.out.println(min);	
	}
	
*/
 }
}

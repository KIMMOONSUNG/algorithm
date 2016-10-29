package JG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class practice {
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	int m =0;
	for(int i =0; i<n; i++){
	  	m=Integer.parseInt(bf.readLine());
	  	System.out.println(func(0,0,m));
	}
}
 static int func(int count, int sum, int goal){
	 if(sum>goal) return 0;
	 if(sum==goal) return 1;
	 int now =0;
	 for(int i =1; i<=3; i++){
		now += func(count+1,sum+i,goal);
	 }
	 return now;
 }
}

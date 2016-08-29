import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_8958 {
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int N = Integer.parseInt(bf.readLine());
	
	for(int i=0; i<N; i++){
	 char c[] = bf.readLine().toCharArray();
	 int count =0;
	 int result=0;
	 for(int j=0; j<c.length; j++){
		 if(c[j]=='O'){
           	count++;
           	result += count;
		 }
		 else{
			 count=0;
		 }
	 }
	 System.out.println(result);
	}
	
}
}

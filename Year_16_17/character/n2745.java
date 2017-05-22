package character;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2745 { // 진법변환 
	
public static void main(String[] args) throws IOException{
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	String str = st.nextToken();
	int arr[] = new int[str.length()];
	for(int a=0; a<str.length(); a++){
		arr[a] = str.charAt(a);
	}
	
	int n = Integer.parseInt(st.nextToken());
    long number = 0;
    for(int i =0; i<str.length(); i++){
    	number *= n;
    	if(arr[i]>='0' && arr[i]<='9'){
    		number += arr[i] -'0';
    	}
    	else{
    		number += arr[i] -'A' +10;
    	}
    }
    
    System.out.println(number);
}

}

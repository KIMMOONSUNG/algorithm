package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class N_1759_2 { //6603 로또문제와 비슷하게 
    static int L ;
    static int C ;
    static String map[];
    
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new String[C];
		st = new StringTokenizer(bf.readLine());
		for(int i =0; i<C; i++){
		 map[i] = st.nextToken();
		}
		Arrays.sort(map);
	    func("",0,0);
		
	}
	static void func(String str, int index, int count){
		if(count == L ){
			if(check(str) == true){
				System.out.println(str);
			}
			return;
		}
		if(count > L){
			return;
		}
		if(index>=C){
			return;
		}
		func(str+map[index], index+1, count+1);
		func(str,index+1,count);
		
	}
	
    static boolean check(String str){
    	int ja =0 ;
    	int mo =0 ;
    	for(int i =0; i<str.length(); i++){
    		char ch  =str.charAt(i);
    		if(ch=='a' || ch=='e' || ch=='o' || ch=='u' || ch=='i'){
    			mo++;
    		}
    		else{
    			ja++;
    		}
    	}
    	
    	if(ja>=2 && mo>=1){
    		return true;
    	}
    	
    	else{
    		return false;
    	}
    	
    }

}

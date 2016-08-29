import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;


public class N_10989 {
	    static int N;
	    static int M;
	    static int[] NUMS;
	    
	    public static void main(String[] args) throws Exception{
	        //System.setIn(new FileInputStream("input.txt"));
	        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(in.readLine());
	        NUMS = new int [N];
	        
	        for(int i = 0; i < N; i++) {
	        	NUMS[i] = Integer.parseInt(in.readLine());
	        }
	         Arrays.sort(NUMS);
	        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
	        for(int i = 0; i < N; i++) {
	                out.println(NUMS[i]);
	        }
	        out.flush();
	        out.close();
	    }
}

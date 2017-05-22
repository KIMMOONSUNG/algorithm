package character;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class n2251 {// 단어정렬 
 public static void main(String[] args) throws IOException{
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(bf.readLine());
	HashMap<Integer, TreeSet<String>> h = new HashMap<Integer, TreeSet<String>>();
    
    for(int i =1; i<=50; i++){ //
    	h.put(i, new TreeSet<String>());
    }
    
    for(int i =0; i< n; i++){
    	String str = bf.readLine();
    	int length = str.length();
    	h.get(length).add(str);
    }
    
    for(int i =1; i<=50; i++){
    	if(!h.get(i).isEmpty()){
    		Iterator it = h.get(i).iterator();
    		while(it.hasNext()){
    			System.out.println(it.next());
    		}
    	}
    }
    
   
 }
}

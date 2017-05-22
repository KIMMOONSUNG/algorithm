package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class practice {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	int n =Integer.parseInt(st.nextToken());
	int m =Integer.parseInt(st.nextToken());
	HashMap<String, Integer> hs = new HashMap<String, Integer>();
    for(int i =0; i<n; i++){
    	String name = bf.readLine();
    	hs.put(name,1);
    }
    for(int i=0; i<m; i++){
    	String name = bf.readLine();
    	Integer v = hs.get(name);
    	if(v!=null){
    		v+=1;
    		hs.put(name,v);
    	}
    }
    ArrayList<String> a = new ArrayList<String>();
	Iterator<String> it = hs.keySet().iterator();
	for(int i =0; i<hs.size(); i++){
		String str= it.next();
		Integer v = hs.get(str);
		if(v==2){
			a.add(str);
		}
	}
	System.out.println(a.size());
	Collections.sort(a);
	for(int i =0; i<a.size(); i++){
		String name = a.get(i);
		System.out.println(name);
	}
 }
}

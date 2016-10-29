package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class N_1764 {
 public static void main(String[] args){
	Scanner sc =new Scanner(System.in);
	int n = sc.nextInt();
	int m = sc.nextInt();
	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	for(int i =0; i<n; i++){
		String name = sc.next();
		hm.put(name, 1); //1에 넣어주고 
	}
	
	for(int i =0; i<m; i++){
		String name = sc.next();
		Integer v = hm.get(name);
		/*
		if(v==null){ 
			v=0;
		}
		v+=1;
		hm.put(name, v);
		*/
		if(v!=null){
			v+=1;
			hm.put(name, v);
		}
		
	}
	
	ArrayList<String> a = new ArrayList<String>();
	
	/* 1번방법
	for(Map.Entry<String, Integer> s : hm.entrySet()){
	 	String key = s.getKey();
	 	Integer value = s.getValue();
	 	if(value == 2){
	 		a.add(key);
	 	}
	}
	*/
	
	/* 2번방법
    Iterator<String> ke = hm.keySet().iterator();
    while(ke.hasNext()){
    	String key = ke.next();
    	Integer value = hm.get(key);
    	if(value==2){
    		a.add(key);
    	}
    }
	*/
	//3번째방법
	
	Iterator<String> ke = hm.keySet().iterator();
	
	for(int i =0; i<hm.size(); i++){
		String key = ke.next();
		Integer value = hm.get(key);
		if(value == 2){
			a.add(key);
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

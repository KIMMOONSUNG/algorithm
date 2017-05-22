  package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

public class colleections_N1764{
	
	 public static void main(String[] args) throws IOException{
			BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(bf.readLine());
			int n =Integer.parseInt(st.nextToken());
			int m =Integer.parseInt(st.nextToken());
			HashMap<String, Integer> hs = new HashMap<String, Integer>();
			for(int i =0; i<n; i++){
				String str = bf.readLine();
				hs.put(str, 1);
			}
			for(int i =0; i<m; i++){
				String str2 = bf.readLine();
				Integer value = hs.get(str2);
		        if(value!=null){
		        	value+=1;
		        	hs.put(str2, value);
		        }
			}
			ArrayList<String> a = new ArrayList<String>();
			Iterator<String> it = hs.keySet().iterator();
			for(int i =0; i<hs.size(); i++){
				String str3 = it.next();
				Integer v = hs.get(str3);
				if(v == 2){ 
					a.add(str3);
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

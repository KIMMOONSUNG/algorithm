package code_plus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class aaaaaaaaaaaaaaaa  {
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	int num = Integer.parseInt(bf.readLine());
	ArrayList<Integer> al = new ArrayList<Integer>();
	for(int i =0; i<num; i++){
		al.add(Integer.parseInt(bf.readLine()));
	}
	Collections.sort(al);
	for(int i =0; i<num; i++){
		System.out.println(al.get(i));
	}
  }
}

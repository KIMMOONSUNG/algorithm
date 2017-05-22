package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class practice2 { 
	static int n ;
	static int m;
	static String map[];
 public static void main(String[] args) throws IOException {
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st=  new StringTokenizer(bf.readLine());
	n = Integer.parseInt(st.nextToken());
	m = Integer.parseInt(st.nextToken());
	map = new String[6];
	st = new StringTokenizer(bf.readLine().trim());
	int c =0 ;
	while(st.hasMoreTokens()){
		map[c] = st.nextToken();
		c++;
	}
	Arrays.sort(map);
	func("",0);
 }
 static void func(String str , int index){
	 if(str.length()==n){
		 if(check(str)==true){
		 System.out.println(str);
		 return ;
		 }
	 }
	 if(map.length<=index){
		 return;
	 }
	 func(str+map[index],index+1);
	 func(str,index+1);
 }
 static boolean check(String str){
	 int ja =0;
	 int mo =0;
	 
	 for(int i =0; i<str.length(); i++){
		 char ch = str.charAt(i);
		 if(ch=='i'|| ch=='e' || ch=='a' || ch=='o' || ch=='u'){
			 mo++;
		 }
		 else{
			 ja++;
		 }
	 }
	 if(mo>=1 && ja>=2){
		 return true;
	 }
	 else{
		 return false;
	 }
 }
}

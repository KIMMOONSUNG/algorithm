package map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class N_2644 {
	/*
	먼저 두 숫자의 부모를 모두 찾아서 두개의 array에 담았다.
	그리고 이 두개의 array를 순서대로 비교하여 동일한 숫자가 나오는 index값을 찾아서 
	그 두개의 index를 더해주면 두 숫자의 촌수가 된다.

	예를 들어,
	7의 부모는 7을 포함하여 arrayA = 7,2,1
	3의 부모는 3을 퐇마하여 arrayB = 3,1
	7과 3의 부모를 저장한 위의 두 arrayA와 arrayB를 순차적으로 탐색했을 때 공통된 숫자는 1.
	arrayA에서 1의 index는 2, arrayB에서 1의 index는 1이다. 
	이 두개의 인덱스 2와 1의 합은 3.
	두 숫자의 촌수는 3이다.
    */

	
 public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	 int kk = Integer.parseInt(bf.readLine());
	 StringTokenizer st = new StringTokenizer(bf.readLine().trim());
	 int man1 = Integer.parseInt(st.nextToken());
	 int man2 = Integer.parseInt(st.nextToken());
	 int num = Integer.parseInt(bf.readLine());
     
	 HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
	 for(int i =0; i<num; i++){
		 st = new StringTokenizer(bf.readLine());
		 int value = Integer.parseInt(st.nextToken()); //부모
		 int key = Integer.parseInt(st.nextToken());// 자식
		 hm.put(key, value);
	 }
	 ArrayList<Integer> al = new ArrayList<Integer>();
	 ArrayList<Integer> bl = new ArrayList<Integer>();
	 al.add(man1);
	 bl.add(man2);
	 for(int i =1; i<=num; i++){
		 Integer parent = hm.get(man1);
		 if(parent == null){
			 break;
		 }
		 else{
			 al.add(parent);
			 man1 = parent;
		 }
	 }
	 for(int i =1; i<=num; i++){
		 Integer parent = hm.get(man2);
		 if(parent == null){
			 break;
		 }
		 else {
			 bl.add(parent);
			 man2 = parent;
		 }
	 }
	 int result = -1;
	 for(int i=0; i<al.size(); i++){
		 for(int j=0; j<bl.size(); j++){
			 if(al.get(i).equals(bl.get(j))){ // 공통된것이있을시 촌수 가능  
				 result = i+j; 
				 break;
			 }
		 }
		 if(result!=-1){ // 없으면 촌수 불가능 
			 break;
		 }
	 }
	 System.out.println(result);
 }
}

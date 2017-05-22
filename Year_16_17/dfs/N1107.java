package dfs;

import java.util.Scanner;

public class N1107 { // 리모컨 
	static boolean fix[];
	static int N;
	/* -> 런타임에러
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		broken = new boolean[10];
		for (int i = 0; i < k; i++) {
			broken[Integer.parseInt(st.nextToken())] = true; // 버튼이 망가져있음 true
																// 아니면 false
		}
		*/
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int k = sc.nextInt();
		fix = new boolean[10];
		for(int i =0; i<k; i++){
			fix[sc.nextInt()] = true; // 버튼 망가져있음 true;
		}
	
		
		// button - > 숫자번튼아예없이 + 나 -로만 몇번가는지 
		
		int button = Math.abs(N-100);
		
		///////////////
		
/* 1. 이동할 채널 C를 정한다.
   2. C에 포함되어있는 숫자중 망가진 버튼이 있는지 확인 
   3. 망가진 버튼이 없다면 절대값C-N을 계산해서 + 나 - 버튼을 총 몇번눌러야 하는지 계산 
*/ 
		for(int i =0; i<=1000000; i++){
			int len= func(i); // 길이를 잰다 -> 리모콘눌러야하는것중 안고장난 수들중 가장 가까운거 찾는거임 
		  if(len>0){
			int press = Math.abs(N-i); // 그 버튼 누른 후부터 몇번+,- 해야하나  
			if(button>len+press){ //버튼 안누르고 쌩으로 +,- 한거보다 작다면 
				button = len+press; 
			}
		  }
		  
		}
		System.out.println(button);
	}
	
	static int func(int num){
		if(num ==0){ // 0일때는 따로 
			if(fix[0] == true){
		        return 0;	
			}
			else{
				return 1;
			}
		}
		else{
		  int count=0; 
		  while(num>0){ 
			  int div = num%10; // 나머지 하나하나 (1234 일때 4자리수들중 하나하나봄)
			  if(fix[div] == true){ // 고장난것이면 리턴 0  
				  return 0;
			  }
			  num = num/10; // 점점 줄어들어서 
				 count++; //길이 (몇자리 수인지 ) 몇번 눌러야하는건지 
		  }
		  return count; // 결국 하나도 고장난게 아니면 길이를 리턴 
		}
		
	}

}

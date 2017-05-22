package bfs;

import java.util.*;

public class N_11403 {
	static int num;
	static int map[][];
	static int visit2[];
	static int check[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		map = new int[num][num];
		visit2= new int[num];
		check = new int[num][num];

		for (int i = 0; i < num; i++){
			for (int j = 0; j < num; j++){
				map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
	   for(int i =0; i<num; i++){ // 한줄 한줄 비교 한다 한줄 하나를 기준점으로 놓는다 .
		   BFS(i);
		   pathcheck(i);
	   }
	       printarr(); //출력 
		
	}	
	static void BFS (int vv){
		Queue<Integer> q = new LinkedList<Integer>(); 
		q.offer(vv); //한줄한줄 비교하는거니까 받은 vv 를 q에 넣는다 
		while(!q.isEmpty()){ //큐 비어있을때까지 반복 
			vv= q.poll(); // 큐에서 하나빼 (처음은 받아온 vv값이 빠질것이고 그다음은 밑에 반목문돌려 집어넣은거 빠짐		    
			for(int i =0 ; i<num; i++){ // 한줄 고정해놓고 다른 줄 쭉 반복문으로 1인거와 방문안한거 찾기
				if(map[vv][i]==1 && visit2[i] == 0){
				//	System.out.println(vv+"와"+i+"가 연결되어있음");
					visit2[i]=1; // 방문했으니 1로
					q.offer(i); // 큐에 집어넣음 
				}
				
			}

		}	
	} 
     static void pathcheck(int i){
		for(int j=0; j<num; j++){
			if(visit2[j]==1){ 
				//System.out.println(i+"와"+j+"가연결되있음");
				check[i][j]=1;
                visit2[j]=0;// 방문했던거 초기화해주는부분
			}
		}
	}
	//출력
	 static void  printarr(){
		for(int i=0; i<num; i++)
		{
			for(int j=0; j<num; j++){
		      System.out.print(check[i][j]+" ");
			}
			System.out.println();
		}
	}
	
}

package SCPC;

import java.util.Scanner;

public class SCPC_2015_mirror {// - > 2344, 2151, 2347, 10725,10726, 4211 문제와 비슷
	public static int d1[] = { 1, -1, 0, 0 }; 
	public static int d2[] = { 0, 0, 1, -1 };
	
 public static void main(String[] args) {
	Scanner sc= new Scanner(System.in);
	int testcase = sc.nextInt();
	int Case = 1;
	for(int a=0; a<testcase; a++){
		int T = sc.nextInt();
		int map[][] = new int[T][T];
		boolean visit[][] = new boolean[T][T];
		for(int i=0; i<T; i++){
			String str = sc.next();
			for(int j=0; j<T; j++){
			  map[i][j] = str.charAt(j)-48;
			}
		}
		int x=0;
		int y=0;
		int dir=2; //처음은 오른쪽에서 오므로 2
		//dir 이 0이면 = 아래 , 1 = 위 , 2 = 오, 3 = 왼    
		while(x>=0&&y>=0&&x<T&&y<T){ // 여기범위벗어나면 배열밖으로나간거니까 
			
			if(map[x][y] !=0){ // 0이아닌거는 거울이 있다는뜻 
				visit[x][y] = true; //이미 한번 반사됬으니까 중복방지위해 true로 바꿔놓음
				dir = change(dir , map[x][y]); //거울에 반사된 방향이 리턴되서 dir에 저장되고
			}
			//0일때는 거울이 비어있는것으로써 2,2 즉 오른쪽으로 이동하게된다. 
			x =x + d1[dir]; //이동
			y =y + d2[dir]; 
		}
		
		int count = 0;
		   for (int i=0; i<T; i++) { // 거울 true인거 개수 센다.
             for (int j=0; j<T; j++) {
                 if (visit[i][j]==true) {
                     count += 1;
                 }
             }
         }
		
	  System.out.println("Case #"+Case);
	  System.out.println(count);
	  Case ++;
	}
 }
 
  static int change(int dir, int mirror) { //dir 은 방향(처음은 오른쪽에서오기때문에 2) , mirror 은 1이냐 2냐
		// dir 0 = 아래 , 1 = 위, 2 = 오른쪽 ,3 = 왼쪽
		if(mirror==1){ // 좌측 하단으로 45도 거울 "/"
 			// 0-> 3, 1->2, 2->1, 3->0
			return 3-dir; // 반사되서 방향 바뀐거를 return 함 
		}
		else{ // 우측 하단으로 45도 거울 "\"
			// 0->2 , 1->3 , 2->0, 3->1
			return (dir+2)%4; // 반사되서 방향 바뀐거를 return 함
		}
 }
}

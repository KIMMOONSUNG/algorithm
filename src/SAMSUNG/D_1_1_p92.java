package SAMSUNG;

import java.util.Scanner;

public class D_1_1_p92 { //메트릭스 응용
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int T = sc.nextInt();
   int Case =1;
   for(int k=0; k<T; k++){
      int mapsize = sc.nextInt();
      int map[][] = new int[mapsize][mapsize];
      int boom[][] = new int[3][50];
      String str = sc.next();
      
      /*
      String a = str.split(",")[0];
      String b = str.split(",")[1];
      String c = str.split(",")[2];
      */
      
      for(int i =0; i<3; i++){ 
    	String boo = str.split(",")[i]; //split으로 ,별로 짤라서 
    	int length = boo.length();  // i에 맞게 자른거 길이구해
    	for(int j=0;j<boo.length(); j++){  //그 길이만큼 문자열을 잘라 
    		boom[i][j] = boo.charAt(j)-48; //배열에 집어넣고 
    	}
    	
    	for(int a=0; a<length; a=a+2){ // 그길이만큼 x좌표와 y좌표를 구별 해서
    		map[boom[i][a]][boom[i][a+1]] = i+1; //폭탄위치에 a는1로채우고 b는 2로 c는 3으로   
    	}
      }
    	int dx[] = {0,0,1,(-1),0,0,2,-2,0,0,3,-3}; 
    	int dy[] = {1,(-1),0,0,2,-2,0,0,3,-3,0,0};
    	
    	for(int a=0; a<mapsize; a++){ //배열전체를 검사 
    		for(int b=0; b<mapsize; b++){
    		  if(map[a][b] == 1){ //폭탄이 1일때 즉 a일때   
    			  for(int f=0; f<4; f++){
    				 if(a+dx[f]>=0 && b+dy[f]>=0 && a+dx[f]<mapsize && b+dy[f]<mapsize
    						 && map[a+dx[f]][b+dy[f]]!=1&& map[a+dx[f]][b+dy[f]]!=2 && map[a+dx[f]][b+dy[f]]!=3){ // -1로만들때 중간에 2나 3이나 1이 있으면 -1로만들어버리면 나중에 검사하다가 1이 -1로 바뀌어 큰일남 
    					 map[a+dx[f]][b+dy[f]] = -1;
    				 }
    			  }
    		  }
    		  if(map[a][b]==2){ //b일때
    			  for(int f=0;f<8;f++){
    				  if(a+dx[f]>=0 && b+dy[f]>=0 && a+dx[f]<mapsize && b+dy[f]<mapsize
    						  && map[a+dx[f]][b+dy[f]]!=1&& map[a+dx[f]][b+dy[f]]!=2 && map[a+dx[f]][b+dy[f]]!=3){
     					 map[a+dx[f]][b+dy[f]] = -1;
     				 } 
    			  }
    		  }
    		  if(map[a][b]==3){ //c일때
    			  for(int f=0;f<12;f++){
    				  if(a+dx[f]>=0 && b+dy[f]>=0 && a+dx[f]<mapsize && b+dy[f]<mapsize
    						  && map[a+dx[f]][b+dy[f]]!=1&& map[a+dx[f]][b+dy[f]]!=2 && map[a+dx[f]][b+dy[f]]!=3 ){
     					 map[a+dx[f]][b+dy[f]] = -1;
     				 }
    			  }
    		  }
    		}
        		
      }
      int count=0;
      for(int i=0; i<mapsize; i++){ // 배열전체검사해서 
    	  for(int j=0; j<mapsize; j++){
    		  if(map[i][j]==0){ //0은 폭탄 범위가 없는거니까 0일때 count값증가 
    			  count ++;
    		  }
    	  }
      }
      System.out.println("#"+Case+" "+count);
      Case++;
         
   }

 } 
}


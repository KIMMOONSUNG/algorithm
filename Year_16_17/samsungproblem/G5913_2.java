package samsungproblem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class G5913_2 {
	static int n;
	static BufferedReader bf;
	static BufferedWriter bw;
	static int map[][];
	static boolean visit[][];
	static int dx[] ={0,0,1,-1};
	static int dy[] ={1,-1,0,0};
	static int count;
	
 public static void main(String[] args) throws IOException {
	 
	bf= new BufferedReader(new InputStreamReader(System.in));
	bw = new BufferedWriter(new OutputStreamWriter(System.out));
	n = Integer.parseInt(bf.readLine());
	visit  = new boolean[6][6];
	StringTokenizer st;
	for(int i =1; i<=n; i++){
		st = new StringTokenizer(bf.readLine());
		int x= Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		visit[x][y] =true;
		visit[x][y] = true;
	}
	visit[1][1] = true;
	visit[5][5] = true;
	
	
	func(1,1,5,5);
	String str = Integer.toString(count);
	bw.write(str);
    bw.close();
    bf.close();
    
}
 
 static void func(int a, int b, int a2, int b2){
	 

   for(int i =0; i<4; i++){	   
	   int x = a+dx[i];
	   int y = b+dy[i];
	   
	   if(x>=1 && y>=1 && x<6 && y<6 ){
		   
		   if(visit[x][y] == false) {
			   visit[x][y] = true;
			   
			   for(int i2 =0; i2<4; i2++){
				   int x2 = a2+dx[i2];
				   int y2= b2+dy[i2];
				   
				   if(x2>=1 && y2>=1 && x2<6 && y2<6) {
					   
						   if(x==x2 && y==y2){
							   boolean check = false;
							   for(int k=1; k<6; k++){
								   for(int h=1; h<6; h++){
									   if(visit[k][h]==false){
									    check = true;
									   }
								   }
							   }
							   
							   if(check==false){
								   count++;
								   visit[x][y] = false; // 한명은 상관없는데 두명이 움직이는거니까 ㅅㅂ 맞았으면 시발 이걸해줘야 함  
								   return;
							   }
						   }
					   
					   if(visit[x2][y2] == false){
						   visit[x2][y2] = true;
						   func(x,y,x2,y2);
						   visit[x2][y2]= false; // 백트래킹 
						   
					   }
					   
				   }
				   
			   }
			   
			   visit[x][y] = false; // 백트래킹 
		   }
		   
	   }
	   
   }
   
   
 }
 
}

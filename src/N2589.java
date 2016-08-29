import java.util.Scanner;

public class N2589 { //bfs로 보물섬 
	public static Scanner sc = new Scanner(System.in);
	public static int length = 0; //길이
	public static int totallength = 0; // 가장긴길이/
	public static int cnt=0;
	public static int pos=0;
	public static int y = sc.nextInt(); 
	public static int x = sc.nextInt();
	public static char arr[][] = new char[y][x];
	public static int qx[] = new int [2500];
	public static int qy[] = new int [2500];
	public static int ql[] = new int [2500];
	public static void main(String[] args) {
		String str=null;
		
		for (int i = 0; i < y; i++) {
			str = sc.next();
			for (int j = 0; j < x; j++) { 
				arr[i][j]=str.charAt(j); //문자열 잘라 char형 배열에 차례로 넣음 
			}
		}
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
			   if(arr[i][j]=='L'){ //육지(L)일때 bfs호출  
				   BFS(i,j);
				   for(int c=0; c<y;c++){
						for(int g=0;g<x; g++){
						    if(arr[c][g]=='V'){ 
						    	arr[c][g]='L'; //도착지점도착했을시 지나간위치들을 원래 상태 L로 바꿈 
						    }
						}
				   } 
			   }
			}
		   }
		System.out.println(totallength);
	}

	 public static void enq(int _x, int _y, int _l){
	   qx[cnt] = _x;
	   qy[cnt] = _y;
	   ql[cnt] = _l;
	   arr[qx[cnt]][qy[cnt]] = 'V'; // 큐에 좌표 넣을때 지나간위치라는걸 나타낼수있게 V로 바꿔줌 
		cnt++;
	}
	
	 public static void BFS(int mi, int mj) {
		
	 int pos=0;
		enq(mi,mj,0); //출발 위치와 길이를 큐에 넣음 (0이면 출발위치길이 미포함 ,1이면 포함)
	    while(pos<cnt ){ //현 인덱스가 더이상 갈곳없을때 까지 반복문돈다 . 

		if (qy[pos] < x - 1 && arr[qx[pos]][qy[pos] + 1] == 'L') { //오 		
		
			enq(qx[pos],qy[pos]+1,ql[pos]+1);
		}
		if (qx[pos] < y - 1 && arr[qx[pos] + 1][qy[pos]] == 'L') { //아래
	
			enq(qx[pos]+1,qy[pos],ql[pos]+1);
		}
		if (qy[pos] > 0 && arr[qx[pos]][qy[pos] - 1] == 'L') { //왼
		
			enq(qx[pos],qy[pos]-1,ql[pos]+1);
		}
		if (qx[pos] > 0 && arr[qx[pos] - 1][qy[pos]] == 'L') { //위
		
			enq(qx[pos]-1,qy[pos],ql[pos]+1);
		}
	
		pos++;
		
	    }

	    length=ql[pos-1];  //도착지점까지 길이를 배열에서 찾아 length에 넣음
		if(totallength<length){ // 도착길이가 가장긴거 찾는 조건문
			totallength=length;
		}
		for(int k=0; k<cnt+1; k++) // 출발 에서 도착하면 다시 큐 배열을 초기화해준다 
		{
			qx[k]=0;
			qy[k]=0;
			ql[k]=0;
		}
		cnt=0;
	}
}

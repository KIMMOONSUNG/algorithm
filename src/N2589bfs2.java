import java.util.Scanner;

public class N2589bfs2{
	public static Scanner sc = new Scanner(System.in);
	public static int length = 0;
	public static int totallength = 0;
	public static int cnt=0;
	public static int y = sc.nextInt();
	public static int x = sc.nextInt();
	public static int arr[][] = new int[y][x];
	public static int qx[] = new int [2500];
	public static int qy[] = new int [2500];
	public static int ql[] = new int [2500];
	public static void main(String[] args) {
		String str=null;
		for (int i = 0; i < y; i++) {
			str = sc.next();
			for (int j = 0; j < x; j++) {
				if (str.charAt(j) == 'W')
					arr[i][j] = 2;
				if (str.charAt(j) == 'L')
					arr[i][j] = 1;
			}
		}
		
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
			   if(arr[i][j]==1){
				   BFS(i,j);
				   for(int c=0; c<y;c++){
						for(int g=0;g<x; g++){
						    if(arr[c][g]==0){
						    	arr[c][g]=1;
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
	   arr[qx[cnt]][qy[cnt]] = 0;
		cnt++;
	}
	
	 public static void BFS(int mi, int mj) {
		
	 int pos=0;
		enq(mi,mj,0);
	    while(pos<cnt ){ 

		if (qy[pos] < x - 1 && arr[qx[pos]][qy[pos] + 1] == 1) { 		
		
			enq(qx[pos],qy[pos]+1,ql[pos]+1);
		}
		if (qx[pos] < y - 1 && arr[qx[pos] + 1][qy[pos]] == 1) { 
	
			enq(qx[pos]+1,qy[pos],ql[pos]+1);
		}
		if (qy[pos] > 0 && arr[qx[pos]][qy[pos] - 1] == 1) { 
		
			enq(qx[pos],qy[pos]-1,ql[pos]+1);
		}
		if (qx[pos] > 0 && arr[qx[pos] - 1][qy[pos]] == 1) { 
		
			enq(qx[pos]-1,qy[pos],ql[pos]+1);
		}
		pos++;
	    }

	    length=ql[pos-1];
		if(totallength<length){
			totallength=length;
		}
		for(int k=0; k<cnt+1; k++)
		{
			qx[k]=0;
			qy[k]=0;
			ql[k]=0;
		}
		cnt=0;
	}
}

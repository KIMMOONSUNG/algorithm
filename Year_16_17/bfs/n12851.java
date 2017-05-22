package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class n_12851{
	int x, cnt;
	n_12851(int x, int cnt){
		this.x = x;
		this.cnt = cnt;
	}
}
public class n12851 { // 숨바꼭질 2  ->방문체크와 내 카운트에 맵카운트 방문 2가지 체크 
	static int dx[] = {1,-1,2};
 public static void main(String[] args) throws IOException {
	BufferedReader bf=  new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(bf.readLine());
	
	int subin =Integer.parseInt(st.nextToken()); //수빈 
	int bro = Integer.parseInt(st.nextToken()); //동생
	boolean visit[] = new boolean[100001];
	int count [] = new int[100001]; //
	Queue<n_12851> q = new LinkedList<>();
	q.offer(new n_12851(subin, 0));
	visit[subin] = true;
	boolean check = false; // 가장 빠른시간 먼저 도착한 경우 체크 
	int result = 0; // 가장 빠른 시간 
	int lengthcount = 0; // 가장 빠른 시간에 갈수 있는 경로 
	
	while(!q.isEmpty()){
		n_12851 p = q.poll();
		if(check == true && p.cnt > result ){ // 빠른시간보다 크면 제낌  
			continue;
		}
		
		if(p.x == bro){ // 도착해쓴ㄴ데 
			if(check ==false){ // 처음일경우 
				result = p.cnt;
				check = true;
				lengthcount++;
				continue; //  중요 
			}
			else if(p.cnt == result ){ // 이미 도착한 경우 있는 경우 첨도착했던 가장 빠르시간과 같은 경우  
				lengthcount++;
				continue;// 중요 
			}
		}
		
		for(int i =0; i<3; i++){
			int x ;
			if(i == 2){
				x= p.x * dx[i];
			}
			else{
				x = p.x+dx[i];
			}
			int cnt = p.cnt;
			if(x>=0 && x<100001 && (visit[x]==false || count[x]==cnt+1)){
				//방문 안했거나 내가 갈 다음 곳의 카운트가 지금 현재에서 다음 갈 카운트와 같을 시  
				
				// 즉 처음에는방문을 true로 바꾸고 카운트에 길이를 입력 할  것이고 두번째 같은 위치 왔을시에는 다음갈 칸이 그 처음 갔던 길이와 같냐 임 
				q.offer(new n_12851(x,cnt+1));
				if(p.x != bro){ // 현재값이 동생 안만났을시에만 
					visit[x] = true;
					count[x] = cnt+1;
				}
			}
		}
		
	}
	
	System.out.println(result);
	System.out.println(lengthcount);
   }
}


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class n2512 { // 예산 
	static int n;
	static int cost[];
	static int limit=0;
	static int max=-1;
	
public static void main(String[] args) throws IOException {
	BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(bf.readLine());
	cost = new int[n];
	StringTokenizer st = new StringTokenizer(bf.readLine());
	for(int i=0; i<n; i++){
		cost[i] = Integer.parseInt(st.nextToken());
		max = Math.max(cost[i], max);
	}
	limit = Integer.parseInt(bf.readLine());
	binary();
	
 }

static void binary(){
	int left = 0;
	int right = max; // 주어진 비용 중 가장큰값을 잡고 
	int mid =0;
	
	while(left<=right){ 
		mid = left+(right-left)/2;
		int number =0;
		
		for(int i =0; i<n; i++){// 주어진 비용중에 
			if(cost[i]>mid){ //중간값보다 크면 중간값을 더하고 
				number += mid; 
			}
			else{ // 같거나 작으면 비용을 더함 
				number += cost[i];
			}
		}
		
		if(number>limit){ //다 더한값이 전체 국가 예산보다 크면 
			right = mid-1; 
		}
		else{
			left = mid+1;
		}
	}
	
	System.out.println(right);
 }

}

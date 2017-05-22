package bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class N_1697 {
	static int count[];
	static int subin ;
	static int bro ;
	static boolean visit[];
public static void main(String[] args) {
	Scanner sc =new Scanner(System.in);
    count = new int [200001];
    subin = sc.nextInt();
    bro = sc.nextInt();
    visit = new boolean[200001];
    find();
}

static void find(){
	Queue<Integer> q = new LinkedList<Integer>();
	q.offer(subin);
	int d[] = {1,-1};
	while (subin != bro){
		subin = q.poll();
		if (subin == bro){
			break;
		}
		visit[subin] = true;
		if((subin * 2) < 200001 && visit[(subin * 2)] == false){
			q.offer((subin * 2));
			visit[(subin * 2)] = true;
		  count[(subin * 2)] = count[subin] + 1;
		}
		for(int i=0; i<2; i++){
		if((subin+d[i])>=0 && (subin+d[i])<100001 
				&&  visit[(subin + d[i])] == false ){
			q.offer((subin + d[i]));
			visit[(subin + d[i])] = true;
			count[(subin + d[i])] = count[subin] + 1;
		 }
		}
		
	}
	System.out.println(count[bro]);
}
}

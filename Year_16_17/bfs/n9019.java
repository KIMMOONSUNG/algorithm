package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class n9019 { //DSLR 문제 
	public static void main(String args[]) throws IOException{
        BufferedReader bf= new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(bf.readLine());
        for(int t = 1; t<=testcase; t++){
        	StringTokenizer st=  new StringTokenizer(bf.readLine());
            int before = Integer.parseInt(st.nextToken());
            int after = Integer.parseInt(st.nextToken());
            boolean[] visit = new boolean[10001];
            
            char[] result = new char[10001]; // 바뀐 결과를 저장 
            int[] v = new int[10001]; // 어떤수에서 만들었는지 저장 
            visit[before] = true;
           
            v[before] = -1;
            Queue<Integer> q = new LinkedList<>();
            q.add(before);
            
            while (!q.isEmpty()) { 
                int now = q.remove();
                int next = (now*2) % 10000; 
                if (visit[next] == false) {
                    q.add(next);
                    visit[next] = true;
                   
                    v[next] = now;
                    result[next] = 'D';
                }
                next = now-1;
                if (next == -1) next = 9999;
                if (visit[next] == false) {
                    q.add(next);
                    visit[next] = true;
                
                    v[next] = now;
                    result[next] = 'S';
                }
                next = (now%1000)*10 + now/1000; // 1234 -> 2341 로 바꿈  
                if (visit[next] == false) {
                    q.add(next);
                    visit[next] = true;
                  
                    v[next] = now;
                    result[next] = 'L';
                }
                next = (now/10) + (now%10)*1000; // 1234 -> 4123 로 바꿈 
                if (visit[next] == false) {
                    q.add(next);
                    visit[next] = true;
                  
                    v[next] = now;
                    result[next] = 'R';
                }
            }
            StringBuilder sb = new StringBuilder();
            while (after != before) {
                sb.append(result[after]);
                after = v[after];
            }
            
            System.out.println(sb.reverse());
        }
    }
   
}


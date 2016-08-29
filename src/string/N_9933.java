package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N_9933 {
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        int n = Integer.parseInt(br.readLine());
	        StringBuilder sb = new StringBuilder();
	        String[] text = new String[n]; //인덱스 n개 1차원배열생성 
	        
	        for(int i = 0; i<n; i++){ //배열 한 인덱스에 문자열을 넣는다 
	            text[i] = br.readLine();
	            sb.append(text[i] + " ");  
	        }
	        
	        for(int i = 0; i<n; i++){
	            StringBuilder sb1 = new StringBuilder();  
	            int length = text[i].length(); // 꺼낼때마다 문자열길이를 length에 넣고
	            for(int j = length-1; j>=0; j--){ //sb에 들어있는거 차례로 거꾸로 해서 sb1에 넣는거임 
	                sb1.append(text[i].charAt(j));
	            }
	            // sb -> god las psala sal 들어가있음 
	            // sb1-> dog가 들어가있고  for문 한번더 돌면 sal이 들어가있을거임 이런식이 

	            //sb에 sb1이 들어가있다면 끝남 그때 길이와 가운데 글자 출력하면 됨 
	            if(sb.toString().contains(sb1)){
	                System.out.print(length + " "); //길이와 
	                System.out.println(sb1.charAt(length/2)); //가운데 글자 출력 
	                break;
	            }
	        }
	    }
 }


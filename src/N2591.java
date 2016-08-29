import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class N2591{ // 다시 해석해야함.// 재귀호출
	static char ch[];
	static int number[];
public static void main(String[] args) throws IOException{
	BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));;
	ch = bf.readLine().toCharArray();
	number = new int[ch.length];
	System.out.println(fun(0));
}

 static int fun(int idx){ //ch[idx] 즉 ch[0]부터 시작 
	 if(idx >= ch.length){// 예로 10이면 10이라는 숫자카드1개인데 길이는 0,1 이렇게 나온다 0만나와야하는데 그래서 1로 return;
		 return 1;      
	 }
     if(number[idx] != 0){ 
         return number[idx]; 
     }
     if(idx == ch.length - 1){ 
         return 1;
     }
     else if(ch[idx] == '0'){
         return 0;
     }
     else{
         String value = String.valueOf(ch[idx]) + String.valueOf(ch[idx+1]); //string형으로 변환하고 value에저장
         if(Integer.valueOf(value) > 34){ // 합친 value의 숫자가 34보다 크면 idx+1 
             return number[idx] = fun(idx + 1); 
         }
          //합친 value의 숫자가 10,20,30 이면 idx+2 
         else if(Integer.valueOf(value) == 10 || Integer.valueOf(value) == 20 || Integer.valueOf(value) == 30){ 
             return number[idx] = fun(idx + 2);
         }
         else{
             return number[idx] = fun(idx + 1) + fun(idx + 2);
         }
     }
 }
}
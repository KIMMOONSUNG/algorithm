package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class N_5586_2 {
 public static void main(String[] args) throws IOException{
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    String str = bf.readLine();
    int joi = 0;
    int ioi = 0;
    for(int i =0; i<str.length()-2; i++){
        String ch="" ;
        if(str.charAt(i)=='J'||str.charAt(i)=='I'){
            ch = String.valueOf(str.charAt(i))+String.valueOf(str.charAt(i+1))+String.valueOf(str.charAt(i+2));
            if(ch.equals("JOI")){
                joi++;
            }
            else if(ch.equals("IOI")){
                ioi++;
            }
        }
    }
    System.out.println(joi);
    System.out.println(ioi);
 }
}

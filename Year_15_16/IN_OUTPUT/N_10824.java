package IN_OUTPUT;
import java.io.*;

public class N_10824 {
 public static void main(String[] args)throws IOException {
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  String[] line = bf.readLine().split(" ");
  String a = line[0] +line[1];
  String b = line[2] +line[3];
  //long num = Integer.parseInt(a)+Integer.parseInt(b); //int형 범위초과남 
  long num = Long.valueOf(a)+Long.valueOf(b);
  System.out.println(num);
}
}

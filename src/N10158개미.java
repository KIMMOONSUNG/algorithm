import java.util.Scanner;
 
public class N10158개미 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int W = sc.nextInt();//뒤
        int H = sc.nextInt();//앞
        int nowant2 = sc.nextInt();// 뒤
        int nowant = sc.nextInt();// 앞
        int count = sc.nextInt();
        int lo1 = 1; // ㄷ뒤
        int lo2 = 1; // 앞
        for (int i = 0; i < count; i++) {
            nowant += lo2;
            nowant2 += lo1;
            if(nowant==0||nowant==H){
            if (nowant2 == 0 || nowant2 == W) {
                lo1 = -lo1;
                lo2 = -lo2;
            } // 양모서리
            else if (nowant2 != 0 || nowant2 != W)
                     {
                        lo2 = -lo2;
            } // 위 아래
            }
            else if(nowant2==0||nowant2==W){
                if (nowant != 0 || nowant != H){
                    lo1 = -lo1;
                } //양옆  
            }
            if (i == count - 1) {
                System.out.print(nowant2 + " ");
                System.out.print(nowant);
            }
        }
    }
}
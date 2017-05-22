package math;
import java.util.Scanner;

class YeungSik{
    int total;
     
    void sum(int[] newtime){
         
        for(int i=0;i<newtime.length;i++){
             
            int result=0;
            while(newtime[i]>=0)
            {
                result+=10;
                newtime[i]-=30;
            }
             
            this.total=this.total+result;
        }
    }
}
 
class MinSik{
    int total;
     
    void sum(int[] newtime){
         
        for(int i=0;i<newtime.length;i++){
            int result=0;
            while(newtime[i]>=0)
            {
                result+=15;
                newtime[i]-=60;
            }
             
            total=total+result;
        }
    }
}
 
public class p {
    public static void main(String args[]){
         
        Scanner scan = new Scanner(System.in);
         
        int N= scan.nextInt();
        int[] time= new int[N];
        int[] time2= new int[N];
         
     
        for(int i=0; i<N;i++){
            time[i]=scan.nextInt();
            time2[i]=time[i];
        }
         
         
        YeungSik ys= new YeungSik();
        ys.sum(time);
         
        MinSik ms= new MinSik();
        ms.sum(time2);
         
     
        if(ms.total==ys.total)
            System.out.println("Y M "+ys.total);
     
        else if(ms.total>ys.total)
            System.out.println("Y "+ys.total);
        else
            System.out.println("M "+ms.total);
     
         
         
         
         
    }
    

}


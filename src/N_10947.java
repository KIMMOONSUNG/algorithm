
public class N_10947 { //개같은문제임
	static int number1[];
	static int number2[];
	static int bonus;
	public static void main(String[] args){
		boolean n[] = new boolean[46]; //중복방지 
		int count = 0;
	    number1 = new int[7];
	    number2 = new int[6];
		while (true) {
			if (count == 7) {
				break;
			}
			int random = (int) (Math.random() * 46);
			if (n[random] == false && random != 0 && random != 46) {
				n[random] = true;
				number1[count] = random;
				/*if(count!=6){
				System.out.print(random + " ");
				}*/
				count++;
			}
		}
		confirm();
	}
	
	static void confirm(){
		//System.out.println();
		boolean n[] = new boolean[46]; //중복방지 
		int count = 0;
		while (true) {
			if (count == 6) {
				break;
			}
			int random = (int) (Math.random() * 46);
			if (n[random] == false && random != 0 && random != 46) {
				n[random] = true;
				number2[count] = random;
				System.out.print(random+" ");
				count++;
			}
		}
		////////////////////
		int okay = 0;
		int not =0;
		for(int i =0; i<6; i++){
			for(int j=0; j<6; j++){
              	if(number2[i] == number1[j]){
              		okay ++;
              	}
              	else{
              		not = number2[i];
              	}              
			}
		}
		//System.out.println("OKAY::"+okay);
		if(okay==6){
		 System.out.println("100점");
		}
		else if(okay == 5){
			if(not == number1[7]){
		 System.out.println("80점");
			}
			else{
				System.out.println("60점");
			}
		}
		else if(okay == 4){
		 System.out.println("40점");
		}
		else if(okay == 3){
	     System.out.println("20점");
		}
		else{
			System.out.println("틀렸습니다");
		}
	}
}

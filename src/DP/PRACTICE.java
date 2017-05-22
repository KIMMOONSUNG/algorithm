package DP;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;



public class PRACTICE {
	public static void main(String[] args) {
	  Barista b[] = new Barista[4];
	  String name[] = {"A","B","C","D"};
	  b[0] = new Barista(name[0],0,3,2,4,4);
	  b[1] = new Barista(name[1],0,4,2,5,4);
	  b[2] = new Barista(name[2],0,3,2,5,4);
	  b[3] = new Barista(name[3],0,3,2,5,5);
	
	
	String coffee[] = { "americano", "espresso", "coffee", "mango", "icestea" };
	int count[] = { 3, 5, 1, 7, 4 }; //주문 개수 
	List<HashMap<String, Object>> list = new LinkedList<HashMap<String, Object>>();
	for (int i = 0; i < 5; i++){
		HashMap<String, Object> order_map = new HashMap<String, Object>();
		order_map.put("beverageId", coffee[i]);
		order_map.put("count", count[i]);
		list.add(order_map); 
		//list에는 주문의 개수가 넣어져있겠지 아메리카노 3개 에스프레소 5개 커피 1개 망고 7개 아이스티 4개 
	}
	
	
	//임의의 시나리오.
			b[0].addOrder(4, "juice", 3); // 만드는데 4걸리고  ,바리스타 A에게 과일주스 3잔 
			b[1].addOrder(2, "espresso", 2); // 바리스타 B에게 espresso 2잔
			b[2].addOrder(4, "cafelatte", 4);// 바리스타 C에게 카페라테 4잔
			b[3].addOrder(3, "amerikano", 1);// 바리스타 D에게 아메리카노  1잔
			
			// 제조 시작
			//new OrderThread(b, list).start();
	}
}

class Barista{
	String name;
	int state=0;
	int time =0;
	int americano_time;
	int espresso_time;
	int juice_time;
	int cafelatte_time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getAmericano_time() {
		return americano_time;
	}
	public void setAmericano_time(int americano_time) {
		this.americano_time = americano_time;
	}
	public int getEspresso_time() {
		return espresso_time;
	}
	public void setEspresso_time(int espresso_time) {
		this.espresso_time = espresso_time;
	}
	public int getJuice_time() {
		return juice_time;
	}
	public void setJuice_time(int juice_time) {
		this.juice_time = juice_time;
	}
	public int getCafelatte_time() {
		return cafelatte_time;
	}
	public void setCafelatte_time(int cafelatte_time) {
		this.cafelatte_time = cafelatte_time;
	}
	
	public void addOrder(int state,String coffee, int count){
		this.state = state;
		this.time = this.state;
		
		
	}
	public Barista(){
		
	}
	public Barista(String name, int state, int americano_time, int espresso_time, 
			       int juice_time, int cafelatte_time)
	{
        this.name = name;
        this.state = state;
        this.americano_time = americano_time;
        this.espresso_time = espresso_time;
        this.juice_time = juice_time;
        this.cafelatte_time = cafelatte_time;
	}
	
}
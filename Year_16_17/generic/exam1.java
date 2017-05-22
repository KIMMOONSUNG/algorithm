package generic;



class example<T> {
	private T t;
	public T get() { return t;}
	public void set(T t) { this.t = t;} 
}
public class exam1 {

	public static void main(String[] args) {
		example<String> e = new example<String>();
		e.set("hi");
		System.out.println(e.get());
		e.set("h");
		System.out.println(e.get()+"g");
		example<Integer> e2 = new example<Integer>();
		e2.set(100);
		System.out.println(e2.get()+1);
		//////////////////////////////////////
		
	}
}

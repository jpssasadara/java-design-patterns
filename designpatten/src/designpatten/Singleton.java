package designpatten;
public class Singleton {

	public static void main(String[] args) {
		// shall call singletonClassic hello method
		singletonClassic.getInstance().hello();
		singletonClassic.getInstance().hello();
		singletonClassic.getInstance().hello();
		singletonClassic.getInstance().hello2();
		/////////////////////////////////////////////

	}

}

class singletonClassic{
	private static singletonClassic obj;
	//Because of that private constructor outside of the class
	//can not generate objects
	private singletonClassic() {
		System.out.println("i am constractor");
		
	}
	public static singletonClassic getInstance() {
		if(obj == null) {
			obj = new singletonClassic();
		}
		return obj;
	}
	public void hello() {
		System.out.println("Hi sasadara");
	}
	//////////////////////////////////////////////////////////////////////
	//for testing whether new object can be created inside the that class
	public void hello3() {
		System.out.println("Hi sasadara2");
	}
	public void hello2() {
		singletonClassic jj = new singletonClassic();
		jj.hello3();
	}
	//////YES WE CAN  create inside the class but cann't outside the class///////////////////////////////////////////
}
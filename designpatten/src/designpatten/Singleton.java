package designpatten;
public class Singleton {

	public static void main(String[] args) throws InterruptedException {
		// shall call singletonClassic hello method
		singletonClassic.getInstance().hello();
		singletonClassic.getInstance().hello();
		singletonClassic.getInstance().hello();
		singletonClassic.getInstance().hello2();
		/////////////////////////////////////////////
		 Thread t1 = new Thread(new MThreadmy(), "t1");
	     Thread t2 = new Thread(new MThreadmy(), "t2");
	     t1.start();
	     t2.start();
	     t1.join();
	     t2.join();
	     ///////////////////////////////////////////////
	     singletonEager.getInstance().hello();
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

//singletonClassic implementation is not a thread safe shall we make it 
//thread safe using synchronize key word

class singletonThreadSafe{
	private static singletonThreadSafe obj;
	private singletonThreadSafe() {
		
	}
	public static synchronized singletonThreadSafe getInstance() {
		if(obj == null) {
			System.out.println("singletonThreadSafe => object is created");
			obj = new singletonThreadSafe();
		}
		return obj;
		
	}
	public void hello() {
		System.out.println("sasadara");
		for(int i=0;i<=20;i++) {
			System.out.println(i);
		}
	}
}

//this method is also thread safe but it is not used synchronization it does not decrease
//the performance of your program but there is a disadvantage, does not matter even we use that 
// class or not, the object will be initialized so Use this method only when your singleton class
//is light and is used throughout the execution of your program.
class singletonEager{ 
	private static singletonEager obj = new singletonEager();
	private singletonEager() {
		
	}
	public static singletonEager getInstance() {
		return obj;
	}
	public void hello() {
		System.out.println("sasadaraEager");
	}
}

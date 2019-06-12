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
	     //////////////////////////////////////////////
	     MTreadmy2 t3 = new MTreadmy2("t3");
	     MTreadmy2 t4 = new MTreadmy2("t4");
	     t3.start();
	     t4.start();
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

// “Double Checked Locking”  This is the BEST WAY

//(1)=>private constructors since objects can not be created outside of the class
//(2)=>variable is static since method is static otherwise can not access
//(3)=>variable is private otherwise outside class can be directly access since variable is static
//(4)=>method is public and static so outside classes can be directly access without creating object 
//(5)=>Double checking since before going to synchronize part it will check whether object is initialized or not so not reducing performance

class singletonDoubleCheck 
{ 
    private volatile static singletonDoubleCheck obj; 
  
    private singletonDoubleCheck() {} 
  
    public static singletonDoubleCheck getInstance() 
    { 
        if (obj == null) 
        { 
            // To make thread safe 
            synchronized (singletonDoubleCheck.class) 
            { 
                // check again as multiple threads 
                // can reach above step 
                if (obj==null) 
                    obj = new singletonDoubleCheck(); 
            } 
        } 
        return obj; 
    }
    public void hello() {
		System.out.println("hello sasadara");
		for(int i=50;i<=70;i++) {
			System.out.println(i);
		}
	}
} 


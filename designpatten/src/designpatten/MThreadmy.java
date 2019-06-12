package designpatten;

public class MThreadmy implements Runnable{

	@Override
	public void run() {
		singletonThreadSafe.getInstance().hello();
		
		
	}
	
}

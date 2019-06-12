package designpatten;

public class MTreadmy2 extends Thread {
	public MTreadmy2(String name) {
        super(name);
    }

    @Override
    public void run() {
    	singletonDoubleCheck.getInstance().hello();
    }
}

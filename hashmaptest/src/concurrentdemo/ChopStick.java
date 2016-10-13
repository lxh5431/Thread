package concurrentdemo;

public class ChopStick {
	private boolean taken=false;
	public synchronized void take() throws InterruptedException{
		while(taken)
			wait();
		taken=true;
	}
	public synchronized void drop(){
		taken=false;
		notify();
	}
	

}

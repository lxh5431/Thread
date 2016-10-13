package concurrentdemo;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Philosophers implements Runnable {
	private ChopStick left;
	private ChopStick right;
	private final int id;
	private final int ponderFactor;
	private Random rand=new Random(47);
	private void pause() throws InterruptedException{
		if(ponderFactor==0)return;
		TimeUnit.MILLISECONDS.sleep(rand.nextInt(ponderFactor*250));
	}
	

	
	public Philosophers(ChopStick left, ChopStick right, int ident, int ponder) {
		super();
		this.left = left;
		this.right = right;
		id = ident;
		ponderFactor = ponder;
	}



	@Override
	public void run() {
		try {
		while(true){
			System.out.println(this+""+"thinking");
			pause();
			System.out.println(this+""+"grabbing right");
			right.take();
			System.out.println(this+""+"grabbing left");
			left.take();
			System.out.println(this+""+"eating");
			pause();
			right.drop();
			left.drop();
			
		}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(this+""+"exiting via interrupt");
			}
			
		}



	@Override
	public String toString() {
		return "Philosophers " +id;
	}
	

	}



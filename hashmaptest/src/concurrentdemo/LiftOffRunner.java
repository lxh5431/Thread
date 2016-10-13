package concurrentdemo;

import java.util.concurrent.BlockingQueue;

import threadtest1.LiftOff;

public class LiftOffRunner  implements Runnable{
	private BlockingQueue<LiftOff> rockets;
   

	public LiftOffRunner(BlockingQueue<LiftOff> rockets) {
		super();
		this.rockets = rockets;
	}
   public void add(LiftOff lo){
	   try{
		   rockets.put(lo);
		   
	   }catch(InterruptedException e){
		   System.out.println("Interrupte during put()");
	   }
   }

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			while(!Thread.interrupted()){
				LiftOff rocket=rockets.take();
				rocket.run();
			}
		}catch(InterruptedException e){
				   System.out.println("Waking from  take()");
		}
		System.out.println("Exiting LiftOffRunner");
		
	}

}


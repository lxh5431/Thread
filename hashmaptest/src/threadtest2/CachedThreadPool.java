package threadtest2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import threadtest1.LiftOff;

public class CachedThreadPool {
	public static void main(String[] args) {
		ExecutorService exec=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			exec.execute(new LiftOff());
//			exec.shutdown();
		}
		exec.shutdown();
	}

}

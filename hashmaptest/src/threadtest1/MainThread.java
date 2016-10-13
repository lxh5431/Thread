package threadtest1;

public class MainThread {
	public static void main(String[] args) {
		for(int i=0;i<5;i++){
		Thread t=new Thread(new LiftOff());
		t.start();
		
	}
		System.out.println("waiting for liffoff");
	}

}

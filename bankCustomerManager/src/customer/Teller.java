package customer;

import java.util.concurrent.TimeUnit;

public class Teller implements Runnable,Comparable<Teller> {
	private static int counter=0;
	private final int id=counter++;
	private int customersServed=0;
	private boolean servingCustomerLine=true;
	private CustomerLine customers;
	public Teller(CustomerLine cq){customers=cq;}
	@Override
	public void run() {
		try{
			while(!Thread.interrupted()){
				Customer customer=customers.take();
				TimeUnit.MILLISECONDS.sleep(customer.getServiceTime());
				synchronized (this) {
					customersServed++;
					while(!servingCustomerLine)
						wait();
				}
			}
		}catch(InterruptedException e){
			System.out.println(this+"Interrupted");
			
		}
		System.out.println(this+"terminating");
	}
	public synchronized void doSomethingElse(){
		customersServed=0;
		servingCustomerLine=false;
		
	}
	public synchronized void serveCustomerLine(){
		assert !servingCustomerLine:"already serving:"+this;
	servingCustomerLine=true;
	notify();
	}
	

	@Override
	public String toString() {
		return "Teller " + id+"";
	}
	public String shortString(){
		return "T"+id;
	}
	@Override
	public int compareTo(Teller other) {
		// TODO Auto-generated method stub
		return customersServed<other.customersServed?-1:
			(customersServed==other.customersServed?0:1);
		
	}

	
	

}

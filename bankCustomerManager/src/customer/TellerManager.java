package customer;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class TellerManager implements Runnable {
	private ExecutorService exec;
	private CustomerLine customers;
	private PriorityQueue<Teller>workingTellers=new PriorityQueue<Teller>();
	private Queue<Teller>tellersDoingOtherThings=new LinkedList<Teller>();
	private int adjustmentPeriod;
	private static Random rand=new Random(47);
	
	


	public TellerManager(ExecutorService e, CustomerLine customers, int adjustmentPeriod) {
		super();
		this.exec = e;
		this.customers = customers;
		this.adjustmentPeriod = adjustmentPeriod;
		Teller teller=new Teller(customers);
		workingTellers.add(teller);
	}
public void adjustTellNumber(){
	if(customers.size()>2){
		if(tellersDoingOtherThings.size()>0){
			Teller teller=tellersDoingOtherThings.remove();
			teller.serveCustomerLine();
			workingTellers.offer(teller);
			return;
		}
		Teller teller=new Teller(customers);
		exec.execute(teller);
		workingTellers.add(teller);
		return;
	}
	if(workingTellers.size()>1&&customers.size()/workingTellers.size()<2)
		reassignOneTeller();
	if(customers.size()==0)
		while(workingTellers.size()>1)
			reassignOneTeller();
}

	

	private void reassignOneTeller() {
	// TODO Auto-generated method stub
		
			Teller teller=workingTellers.poll();
			teller.doSomethingElse();
			tellersDoingOtherThings.offer(teller);
		}
	

	@Override
	public void run() {
	try{
		while(!Thread.interrupted()){
			TimeUnit.MILLISECONDS.sleep(adjustmentPeriod);
			adjustTellNumber();
			System.out.println(customers+"{");
			for(Teller teller:workingTellers)
				System.out.println(teller.shortString()+" ");
			System.out.println(" }");
			
		}
	}catch(InterruptedException e){
			System.out.println(this+"interrupted");
			
		}
	System.out.println(this+"terminating");
	}
		public String toString(){
			return "TellerManager:";
		}
	}
	



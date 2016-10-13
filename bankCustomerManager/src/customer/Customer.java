package customer;

public class Customer {
	private final int serviceTime;

	public Customer(int serviceTime) {
		super();
		this.serviceTime = serviceTime;
	}
	public int getServiceTime(){return serviceTime;
	}
	public String toString(){
		return "["+serviceTime+"]";
	}

}

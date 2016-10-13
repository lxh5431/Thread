package threadtest;

public class ServiceTest {
	private String ticketName;
	private String totalCount;
	private int remaining;
	public ServiceTest(String ticketName, String totalCount, int remaining) {
		super();
		this.ticketName = ticketName;
		this.totalCount = totalCount;
		this.remaining = remaining;
	}
	public ServiceTest(String ticketName, int remaining) {
		// TODO Auto-generated constructor stub
		this.ticketName = ticketName;
		this.remaining = remaining;
	}
	public synchronized int saleTicket(int ticketNum) {
	      if (remaining > 0) {
	         remaining -= ticketNum;
	         try {        //暂停0.1秒，模拟真实系统中复杂计算所用的时间
	            Thread.sleep(100);
	         } catch (InterruptedException e) {
	            e.printStackTrace();
	         }
	 
	         if (remaining >= 0) {
	            return remaining;
	         } else {
	            remaining += ticketNum;
	            return -1;
	         }
	      }
	      return -1;
	   }
	 
	   public synchronized int getRemaining() {
	      return remaining;
	   }
	 
	   public String getTicketName() {
	      return this.ticketName;
	   }
	 
	

}

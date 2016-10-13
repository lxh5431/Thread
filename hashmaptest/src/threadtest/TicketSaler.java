package threadtest;

public class TicketSaler  implements Runnable{
	private String name;
	private ServiceTest service;
	

	public TicketSaler(String name, ServiceTest service) {
		super();
		this.name = name;
		this.service = service;
	}

 


	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(service.getRemaining()>0){
			synchronized(this){
				System.out.println(Thread.currentThread().getName()+"��Ʊ��"+service.getRemaining()+"����");
				int remaining=service.saleTicket(1);
				if(remaining>=0){
					System.out.println("��Ʊ�ɹ���ʣ��"+remaining+"����");
					
				}else{
					System.out.println("��Ʊʧ�ܣ���Ʊ����");
				}
			}
		}
		
	}
	

}
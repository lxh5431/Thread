package threadtest;

public class TicketingSystem {
	public static void main(String[] args) {
		ServiceTest service=new ServiceTest("����--������",500);
		TicketSaler ticketSaler=new TicketSaler("��Ʊ����",service);
		 Thread threads[] = new Thread[8];
	      for (int i = 0; i < threads.length; i++) {
	         threads[i] = new Thread(ticketSaler, "����" + (i + 1));
	         System.out.println("����" + (i + 1) + "��ʼ���� " + service.getTicketName() + " ��Ʊ...");
	         threads[i].start();
	      }
	}

}

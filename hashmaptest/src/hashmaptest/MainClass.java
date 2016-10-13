package hashmaptest;

import java.util.HashMap;

public class MainClass {
	public static final HashMap<String, String> firstHashMap=new HashMap<String, String>();
	public static void main(String[] args) throws InterruptedException {
		Thread t1=new Thread(){
			public void run(){
				for(int i=0;i<25;i++){
					firstHashMap.put(String.valueOf(i),String.valueOf(i));
					
				}
			}
		};
		
		Thread t2=new Thread(){
			public void run(){
				for(int j=0;j<25;j++){
					firstHashMap.put(String.valueOf(j),String.valueOf(j));
					
				}
			}
		};
		t1.start();
		t2.start();
		Thread.currentThread().sleep(1000);
		 for(int l=0;l<50;l++){
		         //如果key和value不同，说明在两个线程put的过程中出现异常。
			           if(!String.valueOf(l).equals(firstHashMap.get(String.valueOf(l)))){
			                System.err.println(String.valueOf(l)+":"+firstHashMap.get(String.valueOf(l)));
	}
		 }
	}

}

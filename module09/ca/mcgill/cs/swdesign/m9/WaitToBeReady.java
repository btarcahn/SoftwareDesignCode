package ca.mcgill.cs.swdesign.m9;

public class WaitToBeReady
{
	private volatile boolean ready = false;
	
	public void prepare() {
		while(!ready){
			System.out.print("*");
				
		}
		System.out.println("I am ready!");
	}
	
	public synchronized void setReady() {
		ready = true;
	}
	
	public static void main(String[] args)
	{
		WaitToBeReady person = new WaitToBeReady();		
		Thread t1 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				person.prepare();
			}}
				
		);
		
		Thread t2 = new Thread( new Runnable() {
			@Override
			public void run()
			{
				for(int i=0;i<100;i++) {
					System.out.print(".");
				}
				System.out.printf("\nDone counting, and to set ready\n");
				person.setReady();
			}}
				
		);
		
		t1.start();
		t2.start();
		
		
	}

}

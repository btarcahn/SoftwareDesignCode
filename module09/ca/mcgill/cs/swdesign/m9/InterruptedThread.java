package ca.mcgill.cs.swdesign.m9;

public class InterruptedThread
{

	public static void main(String[] args) throws InterruptedException
	{
		int inputLength = 100;
		Thread main = Thread.currentThread();
		Thread t1 = new Thread( new Runnable()
		{
			public void run() {
				for (int i = 0; i < inputLength; i++) {
				    System.out.println(".");
				    if (Thread.currentThread().isInterrupted()) {
				    	System.out.printf("Interrupted Status: %s\n", Thread.currentThread().isInterrupted());
				    	System.out.printf("%s Interrupted. Quit\n", Thread.currentThread().getName());
				        return;
				    }
				}
			}
			
		});
			
		t1.start();
		main.sleep(5);
		t1.interrupt();
		System.out.printf("Thread %s Finished. \n", Thread.currentThread().getName());
	}
}
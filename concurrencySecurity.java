public class concurrencySecurity{

	public static void main(String[] args) throws InterruptedException {
		
		long startTime = System.nanoTime();
		
		Thread t1 = new Thread() {
			@Override
			public void run() {
				int i = 0;
				for (i = 0; i <= 20; ++i) {
					System.out.println("Thread 1 count is: " + i);
				}
				System.out.println("Thread 1 complete\n");
			}
		};
		t1.run();
		t1.join();
		
		Thread t2 = new Thread() {
			@Override
			public void run() {
				int i = 0;
				for (i = 20; i >= 0; --i) {
					System.out.println("Thread 2 count is: " + i);
				}
				System.out.println("Thread 2 complete\n");
			}
		};
		t2.run();
		t2.join();
		
		long runTime = System.nanoTime() - startTime;
		System.out.println("Runtime in ns: " + runTime);
	}
}

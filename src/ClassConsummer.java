import java.security.SecureRandom;

public class ClassConsummer implements Runnable{

	private static final SecureRandom generator = new SecureRandom();
	private final ClassBuffer sharedLocation;
	
	public ClassConsummer(ClassBuffer sharedLocation) {
		this.sharedLocation = sharedLocation;
	}
	
	@Override
	public void run() {
		int sum = 0;
		
		for (int count = 0; count < 10; count++) {
			
			try {
				Thread.sleep(3000);
				sum+=sharedLocation.blockingGet();
				System.out.printf("\t\t\t%2d%n", sum);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
			
		}
		
		System.out.printf("%n%s %d%n%s%n", "Consumer read values totaling", sum, "Terminating Consumer");
		
	}
	
}

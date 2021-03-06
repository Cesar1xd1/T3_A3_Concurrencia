import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClassShareBufferB {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		ClassBuffer sharedLocation = new ClassSynchronized();
		
		System.out.printf("%-40s%s\t\t%s%n%-40s%s%n%n", "Operation","Buffer", "Occupied", "---------", "------\t\t--------");

		executorService.execute(new ClassProducer(sharedLocation));
		executorService.execute(new ClassConsummer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES);
		
	}

}

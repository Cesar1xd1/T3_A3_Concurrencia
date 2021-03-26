import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClassShareBufferA {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		ClassBuffer sharedLocation = new ClassUnSynchronized();
		
		System.out.println("Action\t\tValue\tSum of Produced\tSum of Consumed");
		System.out.printf("------\t\t-----\t---------------\t---------------%n%n");
		
		executorService.execute(new ClassProducer(sharedLocation));
		executorService.execute(new ClassConsummer(sharedLocation));
		
		executorService.shutdown();
		executorService.awaitTermination(1, TimeUnit.MINUTES); 
		
		
	}

}


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ClassBlockingB {

	public static void main(String[] args) throws InterruptedException{
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		ClassBuffer sharedLocation = new ClassBlockingA();
		
		executorService.execute(new ClassProducer(sharedLocation));
		executorService.execute(new ClassConsummer(sharedLocation));
		
		executorService.shutdown();
		 executorService.awaitTermination(1, TimeUnit.MINUTES); 

	}

}

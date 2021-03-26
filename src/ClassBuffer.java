
public interface ClassBuffer{
	
	public void blockingPut(int value) throws InterruptedException;
	
	public int blockingGet() throws InterruptedException;
	
}
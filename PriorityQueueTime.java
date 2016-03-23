import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;


public class PriorityQueueTime {
	private static PriorityQueue<Integer> priQueue;
	
	public PriorityQueueTime  (int size){
		Collection<Integer> c = new ArrayList<Integer>();
		
		System.out.println("size:"+size); 
		for(int i=0; i<size; i++)
			c.add(size-i);
		
		priQueue = new PriorityQueue<Integer>(c);
	}

	/**
	 * 
	 * @param args
	 * PriorityQueue<Integer> p = new PriorityQueue<>(size, Collections.reverseOrder());
	 */
	public static void main(String[] args) {
		final int size = 1500000;
		PriorityQueueTime p2 = new PriorityQueueTime(size);
		
		final long startTime = System.currentTimeMillis();

		Integer val = null;
		while( (val = priQueue.poll()) != null) {}
		final long endTime = System.currentTimeMillis();
		long interval =  endTime - startTime;
		System.out.println("time:"+interval+"ms");
		
	}
}

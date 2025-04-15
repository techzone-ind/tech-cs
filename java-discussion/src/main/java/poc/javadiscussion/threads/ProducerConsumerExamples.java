package poc.javadiscussion.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

class NumberPrinter{
	
	private AtomicInteger number =  new AtomicInteger();
	private boolean numberPrinted = false;
	
	public void printNumber(String threadId){
		
		synchronized (this) {
			if(number.get() % 2 == 0){
				if(!numberPrinted && "even".equals(threadId)){
					System.out.println(Thread.currentThread().getName()+" thread id "+threadId+" even number printed "+number);
					number.getAndIncrement();
					numberPrinted = true;
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}else{
					notify();
				}
				
				
			}else{
				if(numberPrinted && "odd".equals(threadId)){
					System.out.println(Thread.currentThread().getName()+" thread id "+threadId+" odd number printed "+number);
					number.getAndIncrement();
					numberPrinted = false;
					notify();
				}else{
					try {
						wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		
			
		}
	}
}
public class ProducerConsumerExamples {

	public static void main(String[] args) {
		
		NumberPrinter printer  = new NumberPrinter();
		
		Runnable tsk1 = () -> {
			while(true){
				printer.printNumber("even");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		Runnable tsk2 = () -> {
			while(true){
				printer.printNumber("odd");
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		ExecutorService es = Executors.newFixedThreadPool(2);
		es.execute(tsk1);
		es.execute(tsk2);
	}

}

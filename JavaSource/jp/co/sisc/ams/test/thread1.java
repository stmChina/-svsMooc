package jp.co.sisc.ams.test;

public class thread1 implements Runnable {
	 public void run(){
//		 while (testThread.index < 9) {
//			try {
//				testThread.queue.offer(testThread.index);
//				 System.out.println(" thread1 :" + testThread.arr.get((Integer)testThread.queue.poll()));
//				 testThread.index++;
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//			}
//			
////			 synchronized(testThread.arr) {
////				 System.out.println(" thread1 :" + testThread.arr.get(testThread.index));
//				 //testThread.index++;
////			}
//			// int p_x = testThread.indexJ();
//			// System.out.println(" thread1 :" + testThread.indexJ());
//		 }
//		 while (!testThread.queue.isEmpty()) {
//				//System.out.println(" thread1 :" + testThread.queue.poll());
//			 testThread.arr.add(testThread.queue.poll());
//		 }
		 while (testThread.index.get() < 9) {
			 System.out.println(" thread1 :" + testThread.index.incrementAndGet());
		 }
		 
	}
}

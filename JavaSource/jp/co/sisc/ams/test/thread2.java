package jp.co.sisc.ams.test;

public class thread2 implements Runnable {
	 public void run(){
//		 while (testThread.index < 9) {
//			 try {
//					testThread.queue.offer(testThread.index);
//					 System.out.println(" thread2 :" + testThread.arr.get((Integer)testThread.queue.poll()));
//					 testThread.index++;
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//				}
////			 synchronized(testThread.class) {
////				 System.out.println(" thread2 :" + testThread.arr.get(testThread.index));
//				 //testThread.index++;
////			}
//			// System.out.println(" thread2 :" + testThread.indexJ());
//		 }
		 while (testThread.index.get() < 9) {

			 //testThread.arrx.add(testThread.index.incrementAndGet());
			 
			 System.out.println(" thread2 :" + testThread.index.incrementAndGet());
			
		 }
	}
}

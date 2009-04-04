package jp.co.sisc.ams.test;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class testThread {
	//public static volatile Integer index = 0;
	public static volatile AtomicInteger index = new AtomicInteger(0);
	public static ArrayList arr = new ArrayList();
	public static volatile ArrayList arrx = new ArrayList();

	public static Queue queue = new ConcurrentLinkedQueue<>();
	//public static Queue queue = new ArrayBlockingQueue<>(capacity)
	public testThread() {
		arr.add("0");
		arr.add("1");
		arr.add("2");
		arr.add("3");
		arr.add("4");
		arr.add("5");
		arr.add("6");
		arr.add("7");
		arr.add("8");
		arr.add("9");
		
//		queue.offer("0");
//		queue.offer("1");
//		queue.offer("2");
//		queue.offer("3");
//		queue.offer("4");
//		queue.offer("5");
//		queue.offer("6");
//		queue.offer("7");
//		queue.offer("8");
//		queue.offer("9");
	}

	public static void main(String[] args) {
		testThread testThread = new testThread();
		thread1 t1 = new thread1();
		thread2 t2 = new thread2();
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t2);
		
		
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i=0; i< testThread.arrx.size(); i++) {
			System.out.println(testThread.arrx.get(i));
		}
		
//		
//		Integer a= 1;
//		Integer b= 2;
//		Integer c= 3;
//		Integer d= 3;
//		Integer e= 128;  
//		Integer f= 128;
//		Long g = 3L;
//		System.out.println(c == d);
//		System.out.println(e == f);
//		System.out.println(c == (a + b));
//		System.out.println(c.equals(a + b));
//		System.out.println(g == (a + b));
//		System.out.println(g.equals(a + b));
		
		
//		Iterator it = queue.iterator();
//		while(it.hasNext()) {
//			Integer ind = (Integer)it.next();
//			System.out.println(testThread.arr.get(ind));
//		}
	}

//	public static synchronized int indexJ() {
//		index = index+1;
////		System.out.println("indexJ:    " + index);
//		return index;
//	}
}
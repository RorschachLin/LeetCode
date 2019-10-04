/**
 * using CyclicBarrier print 10 times
 */
package concurrent.easy.print_in_order.cyclic_barrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class FooCyclicBarrier {
	private final CyclicBarrier barrierA = new CyclicBarrier(2);
	private final CyclicBarrier barrierB = new CyclicBarrier(2);
	private final CyclicBarrier barrierABC = new CyclicBarrier(3);

	public FooCyclicBarrier() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		try {
			for (int i = 0; i < 10; i++) {
				// printFirst.run() outputs "first". Do not change or remove this line.
				printFirst.run();
				barrierA.await();
				barrierABC.await();
			}
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void second(Runnable printSecond) throws InterruptedException {
		try {
			for (int i = 0; i < 10; i++) {
				barrierA.await();
				// printSecond.run() outputs "second". Do not change or remove this line.
				printSecond.run();
				barrierB.await();
				barrierABC.await();
			}
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void third(Runnable printThird) throws InterruptedException {
		try {
			for (int i = 0; i < 10; i++) {
				barrierB.await();
				// printThird.run() outputs "third". Do not change or remove this line.
				printThird.run();
				barrierABC.await();
			}
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		FooCyclicBarrier foo = new FooCyclicBarrier();
		PrintOrder printSecond = new PrintOrder("second");
		PrintOrder printFirst = new PrintOrder("first");
		PrintOrder printThird = new PrintOrder("third");
		Thread t2 = new OrderRun(printSecond, foo);
		Thread t1 = new OrderRun(printFirst, foo);
		Thread t3 = new OrderRun(printThird, foo);
		t1.start();
		t2.start();
		t3.start();

	}
}

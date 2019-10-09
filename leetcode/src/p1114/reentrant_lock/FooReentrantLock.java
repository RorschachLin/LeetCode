/**
 * using next as a flag to specify which will be the next to print
 */
package p1114.reentrant_lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class FooReentrantLock {
	private String next = "first";
	private Lock lock = new ReentrantLock();
	private Condition printed = lock.newCondition();

	public FooReentrantLock() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			try {
				while (!next.equals("first")) {
					printed.await();
				}
				// printFirst.run() outputs "first". Do not change or remove this line.
				printFirst.run();
				next = "second";
				printed.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	public void second(Runnable printSecond) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			try {
				while (!next.equals("second")) {
					printed.await();
				}
				// printSecond.run() outputs "second". Do not change or remove this line.
				printSecond.run();
				next = "third";
				printed.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	public void third(Runnable printThird) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			try {
				while (!next.equals("third")) {
					printed.await();
				}
				// printThird.run() outputs "third". Do not change or remove this line.
				printThird.run();
				next = "first";
				printed.signalAll();
			} finally {
				lock.unlock();
			}
		}
	}

	public static void main(String[] args) {
		FooReentrantLock foo = new FooReentrantLock();
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

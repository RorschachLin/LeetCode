/**
 * using next as a flag to specify which will be the next to print
 */
package p1114.next_flag;

class FooNext {
	private volatile String next = "first";
	private Object lock = new Object();

	public FooNext() {

	}

	public void first(Runnable printFirst) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (lock) {
				while (!next.equals("first")) {
					lock.wait();
				}
				// printFirst.run() outputs "first". Do not change or remove this line.
				printFirst.run();
				next = "second";
				lock.notifyAll();
			}
		}
	}

	public void second(Runnable printSecond) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (lock) {
				while (!next.equals("second")) {
					lock.wait();
				}
				// printSecond.run() outputs "second". Do not change or remove this line.
				printSecond.run();
				next = "third";
				lock.notifyAll();
			}
		}
	}

	public void third(Runnable printThird) throws InterruptedException {
		for (int i = 0; i < 10; i++) {
			synchronized (lock) {
				while (!next.equals("third")) {
					lock.wait();
				}
				// printThird.run() outputs "third". Do not change or remove this line.
				printThird.run();
				next = "first";
				lock.notifyAll();
			}
		}
	}

	public static void main(String[] args) {
		FooNext foo = new FooNext();
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

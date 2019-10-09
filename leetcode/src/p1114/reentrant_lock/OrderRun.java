package p1114.reentrant_lock;

class OrderRun extends Thread {
	private FooReentrantLock foo;
	private PrintOrder printOrder;



	OrderRun(PrintOrder printOrder, FooReentrantLock foo) {
		this.printOrder = printOrder;
		this.foo = foo;
	}

	@Override
	public void run() {
		try {
			if (printOrder.getPrintContent().equals("first")) {
				foo.first(printOrder);
			}
			if (printOrder.getPrintContent().equals("second")) {
				foo.second(printOrder);
			}
			if (printOrder.getPrintContent().equals("third")) {
				foo.third(printOrder);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

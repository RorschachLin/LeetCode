package p1114.cyclic_barrier;

class OrderRun extends Thread {
	private FooCyclicBarrier foo;
	private PrintOrder printOrder;



	OrderRun(PrintOrder printOrder, FooCyclicBarrier foo) {
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

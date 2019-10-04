package concurrent.easy.print_in_order.next_flag;

class OrderRun extends Thread {
	private FooNext foo;
	private PrintOrder printOrder;



	OrderRun(PrintOrder printOrder, FooNext foo) {
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

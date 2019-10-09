package p1114.cyclic_barrier;

public class PrintOrder implements Runnable {
	private String printContent;
	
	public String getPrintContent() {
		return printContent;
	}
	
	PrintOrder(String printContent) {
		this.printContent = printContent;
	}
	
	@Override
	public void run() {
		System.out.println(printContent);
	}
	
}

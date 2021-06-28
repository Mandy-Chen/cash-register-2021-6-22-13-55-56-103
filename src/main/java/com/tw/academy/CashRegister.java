package com.tw.academy;

public class CashRegister {
	private final Printer printer;
	private final Notifier notifier;

	public CashRegister(Printer printer, Notifier notifier) {
		this.printer = printer;
		this.notifier = notifier;
	}

	void process(Purchase purchase) throws IllegalArgumentException {
		notifier.notice();
		String purchaseInfo = purchase.asString();
		if (purchase.asString() == null || purchase.asString().isEmpty()) {
			throw new IllegalArgumentException("Purchase is empty");
		}
		printer.print(purchaseInfo);
	}
}

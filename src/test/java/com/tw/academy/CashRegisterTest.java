package com.tw.academy;

import org.junit.jupiter.api.Test;

class CashRegisterTest {
	@Test
	void should_process_execute_notifier() {
		//given
		Printer printer = new Printer();
		Notifier notifier = new Notifier();
		CashRegister cashRegister = new CashRegister(printer, notifier);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		//verify that cashRegister.process will trigger notifier
	}
}

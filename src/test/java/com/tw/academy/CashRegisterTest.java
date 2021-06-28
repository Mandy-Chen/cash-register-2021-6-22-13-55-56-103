package com.tw.academy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class CashRegisterTest {
	@Test
	void should_process_execute_notifier() {
		//given
		Printer printer = new Printer();
		DoubleTest doubleTest = new DoubleTest();
		CashRegister cashRegister = new CashRegister(printer, doubleTest);
		Purchase purchase = new Purchase();
		//when
		cashRegister.process(purchase);
		//then
		assertTrue(doubleTest.isCalled);
	}

	private class DoubleTest extends Notifier {
		boolean isCalled = false;
		@Override
		public void notice() {
			isCalled = true;
		}
	}
	@Test
	void should_process_throwException_() {
		//given
		Printer mockPrinter = mock(Printer.class);
		Notifier mockNotifier = mock(Notifier.class);
		CashRegister cashRegister = new CashRegister(mockPrinter, mockNotifier);
		Purchase mockPurchase = mock(Purchase.class);
		when(mockPurchase.asString()).thenReturn(null);
		//when

		//then
		assertThrows(IllegalArgumentException.class,()->cashRegister.process(mockPurchase));
	}
	@Test
	void name1() {
		//given
		Printer mockPrinter = mock(Printer.class);
		Notifier mockNotifier = mock(Notifier.class);
		CashRegister cashRegister = new CashRegister(mockPrinter, mockNotifier);
		Purchase mockPurchase = mock(Purchase.class);
		when(mockPurchase.asString()).thenReturn("");
		//when

		//then
		assertThrows(IllegalArgumentException.class,()->cashRegister.process(mockPurchase));
	}
	@Test
	void name2() {
		//given
		Printer mockPrinter = mock(Printer.class);
		Notifier mockNotifier = mock(Notifier.class);
		CashRegister cashRegister = new CashRegister(mockPrinter, mockNotifier);
		Purchase mockPurchase = mock(Purchase.class);
		when(mockPurchase.asString()).thenReturn("not empty");
		//when
		cashRegister.process(mockPurchase);
		//then
		verify(mockPrinter,times(1)).print(mockPurchase.asString());
	}
}

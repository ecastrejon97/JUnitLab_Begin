package csc131.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class GiftCardTest {

	@Test
	public void getIssuingStore() {
		double		balance;
		GiftCard 	card;
		int			issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getIssuingStore()",
				issuingStore, card.getIssuingStore());
	}
	
	@Test
	public void getBalance() {
		double		balance;
		GiftCard	card;
		int			issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("getBalance",
				balance, card.getBalance(), 0.001);
	}
	
	@Test
	public void deduct_RemainingBalance() {
		double		balance;
		GiftCard 	card;
		int			issuingStore;
		
		issuingStore = 1337;
		balance = 100.00;
		card = new GiftCard(issuingStore, balance);
		
		assertEquals("deduct(amount < 0.0)",
				"Invalid Transaction", card.deduct(-1.0));
		assertEquals("deduct(amount < balance",
				"Remaining Balance: " + String.format("%6.2f", Math.abs(balance -= 99.00)), card.deduct(99.00));
		assertEquals("deduct(amount > balance)",
				"Amount Due: " + String.format("%6.2f", Math.abs(balance - 101.00)), card.deduct(101.00));
		
	}

}

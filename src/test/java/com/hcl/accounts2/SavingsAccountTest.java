package com.hcl.accounts2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SavingsAccountTest {

	SavingsAccount account;

	@BeforeEach
	void init() {
		account = new SavingsAccount("John", 400, 0.02);
	}

	@Test
	void constructorInitializesRelevantFields() {
		assertAll(() -> assertEquals(account.getOwner(), "John"), () -> assertEquals(account.getBalance(), 400),
				() -> assertEquals(account.getAnnualInterestRate(), 0.02));
	}

	@Test
	void withdrawsValidAmount() {
		double initialAmount = account.getBalance();
		account.withdrawal(350);
		assertEquals(initialAmount - 350, account.getBalance());
	}

	@Test
	void rejectsNegativeWithdrawals() {
		assertEquals(BankAccount.INVALID_AMOUNT, account.withdrawal(-5));
	}

	@Test
	void correctlyDepositsMonthlyInterest() {
		double initialBalance = account.getBalance();
		account.depositMonthlyInterest();
		assertEquals(initialBalance * (1 + (account.getAnnualInterestRate() / 12)), account.getBalance());
	}

}

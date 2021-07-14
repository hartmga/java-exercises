package com.hcl.accounts2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CheckingAccountTest {

	CheckingAccount account;

	@BeforeEach
	void init() {
		account = new CheckingAccount("John", 400, 50);
	}

	@Test
	void constructorInitializesRelevantFields() {
		assertAll(() -> assertEquals(account.getOwner(), "John"), () -> assertEquals(account.getBalance(), 400),
				() -> assertEquals(account.getInsufficientFundsFee(), 50));
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
	void handlesInsufficientFundsFees() {
		double initialBalance = account.getBalance();
		int transactionResult = account.withdrawal(account.getBalance() + 100);
		assertEquals(transactionResult, BankAccount.INSUFFICIENT_FUNDS);
		assertEquals(initialBalance - account.getInsufficientFundsFee(), account.getBalance());
	}

	@Test
	void processesValidChecks() {
		// Check should probably be mocked and not used directly
		CheckingAccount from = new CheckingAccount("Jane", 400, 30);
		Check validCheck = new Check(from, account, 250);
		int transactionResult = CheckingAccount.processCheck(validCheck);
		assertAll(() -> assertEquals(650, account.getBalance()), () -> assertEquals(150, from.getBalance()),
				() -> assertEquals(CheckingAccount.PROCESSING_SUCCESS, transactionResult),
				() -> assertTrue(validCheck.isProcessed()));
	}

	@Test
	void rejectsInvalidChecks() {
		// Check should probably be mocked and not used directly
		CheckingAccount from = new CheckingAccount("Jane", 400, 30);
		Check invalidCheck1 = new Check(from, account, 250);
		invalidCheck1.setProcessed(true);
		Check invalidCheck2 = new Check(from, account, -250);
		Check invalidCheck3 = new Check(from, account, 7000);

		assertAll(() -> assertEquals(CheckingAccount.PROCESSING_ERROR, CheckingAccount.processCheck(null)),
				() -> assertEquals(CheckingAccount.PROCESSING_ERROR, CheckingAccount.processCheck(invalidCheck1)),
				() -> assertEquals(CheckingAccount.PROCESSING_ERROR, CheckingAccount.processCheck(invalidCheck2)),
				() -> assertEquals(CheckingAccount.PROCESSING_ERROR, CheckingAccount.processCheck(invalidCheck3)));
	}
}

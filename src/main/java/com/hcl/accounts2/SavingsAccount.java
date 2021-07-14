package com.hcl.accounts2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class SavingsAccount extends BankAccount {

	public static final Logger logger = LogManager.getLogger(SavingsAccount.class);

	private double annualInterestRate;

	public SavingsAccount(String owner, double balance, double annualInterestRate) {
		super(owner, balance);
		setAnnualInterestRate(annualInterestRate);
	}

	@Override
	public int withdrawal(double amount) {
		if (amount >= 0) {
			setBalance(getBalance() - amount);
			logger.trace("Withdrew ${} from account #{}, new balance is {}", amount, this.getAccountNo());
			return SUCCESS;
		} else {
			logger.debug("Invalid withdrawal amount ${} in account #{}", amount, this.getAccountNo());
			return INVALID_AMOUNT;
		}
	}

	public void depositMonthlyInterest() {
		// this assumes the annual rate is nominal and does not account for compounding
		setBalance(getBalance() * (1 + getAnnualInterestRate() / 12));
		logger.info("Deposited monthly interest for account #{}", getAccountNo());
	}

	@Override
	public String toString() {
		return super.toString() + ", annualInterestRate=" + annualInterestRate;
	}

}

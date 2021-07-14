package com.hcl.accounts2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public abstract class BankAccount implements Comparable<BankAccount> {

	private final static Logger logger = LogManager.getLogger(BankAccount.class);

	private String owner;
	private double balance;
	private final long accountNo;

	private static long nextAccountNo = 0;

	public static int SUCCESS = 0;
	public static int INVALID_AMOUNT = -1;
	public static int INSUFFICIENT_FUNDS = -2;

	public BankAccount(String owner, double balance) {
		setOwner(owner);
		setBalance(balance);
		accountNo = nextAccountNo++;
		logger.info("Created new BankAccount: {{}}", this);
	}

	public int deposit(double amount) {
		if (amount >= 0) {
			setBalance(getBalance() + amount);
			logger.trace("Deposited {} dollars into account #{}. New balance is {}", amount, this.getAccountNo(),
					this.getBalance());
			return SUCCESS;
		} else {
			logger.debug("Attempted to deposit negative amount to account {}", this.getAccountNo());
			return INVALID_AMOUNT;
		}
	}

	public abstract int withdrawal(double amount);

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (accountNo ^ (accountNo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankAccount other = (BankAccount) obj;
		if (accountNo != other.accountNo)
			return false;
		return true;
	}

	@Override
	public int compareTo(BankAccount o) {
		double diff = this.balance - o.balance;
		if (diff > 0) {
			return (int) Math.ceil(diff);
		} else if (diff < 0) {
			return (int) Math.floor(diff);
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return this.getClass().getSimpleName() + " " + getAccountNo() + ":  owner=" + owner + ", balance=" + balance;
	}

};
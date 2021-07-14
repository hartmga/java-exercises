package com.hcl.accounts2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class CheckingAccount extends BankAccount {

	private final static Logger logger = LogManager.getLogger(BankAccount.class);

	private double insufficientFundsFee;

	public static int PROCESSING_SUCCESS = 0;
	public static int PROCESSING_ERROR = -1;

	public CheckingAccount(String owner, double balance, double insufficientFundsFee) {
		super(owner, balance);
		setInsufficientFundsFee(insufficientFundsFee);
	}

	@Override
	public int withdrawal(double amount) {
		if (amount >= 0) {
			if (amount > getBalance()) {
				// the funds are not withdrawn, but an overdraft fee is charged
				logger.warn(
						"Attempted to withdraw ${} from account #{} with balance {}. An overdraft fee of ${} will be charged",
						amount, getAccountNo(), getBalance(), getInsufficientFundsFee());
				setBalance(getBalance() - getInsufficientFundsFee());
				return INSUFFICIENT_FUNDS;
			} else {
				setBalance(getBalance() - amount);
				logger.trace("Withdrew ${} from account #{}, new balance is {}", amount, this.getAccountNo(),
						this.getBalance());
				return PROCESSING_SUCCESS;
			}
		} else {
			logger.debug("Invalid withdrawal amount ${} in account #{}", amount, this.getAccountNo());
			return INVALID_AMOUNT;
		}
	}

	public static int processCheck(Check checkToProcess) {
		if (checkToProcess != null && !checkToProcess.isProcessed() && checkToProcess.getAmount() >= 0) {
			checkToProcess.setProcessed(true);
			if (checkToProcess.getAccountFrom().withdrawal(checkToProcess.getAmount()) == 0) {
				checkToProcess.getAccountTo().deposit(checkToProcess.getAmount());
				logger.trace("${} tranfsferred from account #{} to account #{}", checkToProcess.getAmount(),
						checkToProcess.getAccountFrom().getAccountNo(), checkToProcess.getAccountTo().getAccountNo());
				return SUCCESS;
			} else {
				logger.warn("Unable to process check {}", checkToProcess);
				return PROCESSING_ERROR;
			}
		} else {
			logger.warn("Unable to process check {}", checkToProcess);
			return PROCESSING_ERROR;
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", insufficientFundsFee=" + insufficientFundsFee;
	}

}

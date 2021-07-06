package accounts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class CheckingAccount extends BankAccount {

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
				setBalance(getBalance() - getInsufficientFundsFee());
				return INSUFFICIENT_FUNDS;
			} else {
				setBalance(getBalance() - amount);
				return PROCESSING_SUCCESS;
			}
		} else {
			return INVALID_AMOUNT;
		}
	}

	public static int processCheck(Check checkToProcess) {
		if (checkToProcess != null && !checkToProcess.isProcessed() && checkToProcess.getAmount() >= 0) {
			checkToProcess.setProcessed(true);
			if (checkToProcess.getAccountFrom().withdrawal(checkToProcess.getAmount()) == 0) {
				checkToProcess.getAccountTo().deposit(checkToProcess.getAmount());
				return SUCCESS;
			} else {
				return PROCESSING_ERROR;
			}
		} else {
			return PROCESSING_ERROR;
		}
	}

	@Override
	public String toString() {
		return super.toString() + ", insufficientFundsFee=" + insufficientFundsFee;
	}

}

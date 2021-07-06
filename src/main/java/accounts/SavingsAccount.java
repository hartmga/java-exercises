package accounts;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter(AccessLevel.PROTECTED)
public class SavingsAccount extends BankAccount {

	private double annualInterestRate;

	public SavingsAccount(String owner, double balance, double annualInterestRate) {
		super(owner, balance);
		setAnnualInterestRate(annualInterestRate);
	}

	@Override
	public int withdrawal(double amount) {
		if (amount >= 0) {
			setBalance(getBalance() - amount);
			return SUCCESS;
		} else {
			return INVALID_AMOUNT;
		}
	}

	public void depositMonthlyInterest() {
		// this assumes the annual rate is nominal and does not account for compounding
		deposit(1 + getAnnualInterestRate() / 12);
	}

	@Override
	public String toString() {
		return super.toString() + ", annualInterestRate=" + annualInterestRate;
	}

}

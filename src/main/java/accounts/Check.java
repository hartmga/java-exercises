package accounts;

import lombok.Data;

@Data
public class Check {

	private CheckingAccount accountFrom;
	private CheckingAccount accountTo;
	private double amount;
	private boolean processed = false;

	public Check(CheckingAccount accountFrom, CheckingAccount accountTo, double amount) {
		super();
		this.accountFrom = accountFrom;
		this.accountTo = accountTo;
		this.amount = amount;
	}

}

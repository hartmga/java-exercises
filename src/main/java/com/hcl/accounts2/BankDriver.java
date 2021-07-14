package com.hcl.accounts2;

public class BankDriver {

	public static void main(String[] args) {

		CheckingAccount chkAct1 = new CheckingAccount("John Smith", 4_000, 50);
		CheckingAccount chkAct2 = new CheckingAccount("Jane Smith", 2_000, 70);

		Check check = new Check(chkAct1, chkAct2, 400);
		CheckingAccount.processCheck(check);

		chkAct1.withdrawal(4000);

		chkAct1.deposit(200);
		chkAct1.deposit(-5);

		SavingsAccount svgAct = new SavingsAccount("John Smith", 40_000, 0.05);
		svgAct.depositMonthlyInterest();

	}

}

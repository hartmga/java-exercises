package accounts;

import java.util.Arrays;

public class BankDriver {

	public static void main(String[] args) {

		CheckingAccount chkAct1 = new CheckingAccount("John Smith", 4_000, 50);
		CheckingAccount chkAct2 = new CheckingAccount("Jane Smith", 2_000, 70);
		System.out.println(chkAct1);
		System.out.println(chkAct2);
		System.out.println();

		System.out.printf("transfer $400 from account %d to account %d%n", chkAct1.getAccountNo(),
				chkAct2.getAccountNo());
		Check check = new Check(chkAct1, chkAct2, 400);
		CheckingAccount.processCheck(check);
		System.out.println(chkAct1);
		System.out.println(chkAct2);
		System.out.println();

		System.out.printf(
				"Attempt to withdraw $4,000 from account %d, charge bounces and overdraft is charged instead%n",
				chkAct1.getAccountNo());
		chkAct1.withdrawal(4000);
		System.out.println(chkAct1);
		System.out.println();

		System.out.println("Withdraw $200 from account " + chkAct2.getAccountNo());
		chkAct2.withdrawal(200);
		System.out.println(chkAct2);
		System.out.println("Deposit $200 into account " + chkAct1.getAccountNo());
		chkAct1.deposit(200);
		System.out.println(chkAct1);
		System.out.println();

		SavingsAccount svgAct = new SavingsAccount("John Smith", 40_000, 0.05);
		System.out.println(svgAct);
		System.out.println("Add montly interest:");
		svgAct.depositMonthlyInterest();
		System.out.println(svgAct);
		System.out.println();

		BankAccount[] accounts = new BankAccount[] { chkAct1, chkAct2, svgAct };
		Arrays.sort(accounts);
		System.out.println("Accounts sorted by balance:");
		for (BankAccount account : accounts) {
			System.out.println(account);
		}
	}

}

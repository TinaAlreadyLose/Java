package banking;

import com.sun.javafx.runtime.VersionInfo;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amt) {
		balance+=amt;
	}
	public void withdraw(double amt) {
		balance-=amt;
	}
	public Account(double init_balance) {
		balance=init_balance;
	}
}

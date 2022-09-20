package com.fdmgroup.lambda.Exercises;

import java.util.*;
import java.util.function.*;

public class Runner {

	public static void main(String[] args) {

		BankAccount account1 = new BankAccount(12345678,987654,"Mr J Smith","savings",1.1,25362.91);
		BankAccount account2 = new BankAccount(87654321,234567,"Ms J Jones","current",0.2,550);
		BankAccount account3 = new BankAccount(74639572,946284,"Dr T Williams","savings",1.1,4763.32);
		BankAccount account4 = new BankAccount(94715453,987654,"Ms S Taylor","savings",1.1,10598.01);
		BankAccount account5 = new BankAccount(16254385,234567,"Mr P Brown","current",0.2,-195.74);
		BankAccount account6 = new BankAccount(38776543,946284,"Ms F Davies","current",0.2,-503.47);
		BankAccount account7 = new BankAccount(87609802,987654,"Mr B Wilson","savings",1.1,2.5);
		BankAccount account8 = new BankAccount(56483769,234567,"Dr E Evans","current",0.2,-947.72);


		//Question 1
		Function<BankAccount,String> getFullNameAndBalance = bankAccount -> bankAccount.getAccountHolder() + " " +
				bankAccount.getBalance();
		System.out.println(getFullNameAndBalance.apply(account3));
		System.out.println(getFullNameAndBalance.apply(account4));


		//Question 2
		Function<BankAccount,Double> getInterestOnBankAccountWithInterest = bankAccount ->
				(bankAccount.getBalance() * bankAccount.getInterestRate()) /100;
		System.out.println(getInterestOnBankAccountWithInterest.apply(account2));

		//Question 3
		System.out.println("====Question3=====");
		Function<BankAccount, Double> getInterestOnBankAccountWithInterest2 = bankAccount ->
				getInterestOnBankAccountWithInterest.apply(bankAccount) >= 0 ? bankAccount.getInterestRate() : 0.0;
		System.out.println(getInterestOnBankAccountWithInterest2.apply(account8));

		//Question 4
		Predicate<BankAccount> bankAccountIsCurrentAccount = bankAccount -> bankAccount.getAccountType().equals("savings");
		boolean bankAccountCurrentAccount = bankAccountIsCurrentAccount.test(account1);

		System.out.println(bankAccountCurrentAccount);

		//Question 5
		//Write a lambda expression which implements the Predicate interface.
		// It should take a bank account as an argument.
		// If the bank account is overdrawn it should return true,
		// otherwise it should return false. Test with
		// account5 (should return true) and account7 (should return false)
		Predicate<BankAccount> bankAccountOverdrawn = bankAccount -> bankAccount.getBalance() <= 0;
		boolean booleanBankAccountOverdrawn = bankAccountOverdrawn.test(account5);
		System.out.println(booleanBankAccountOverdrawn);

		//Question 6
		//Write a lambda expression which implements the BinaryOperator interface.
		// It should take 2 bank accounts as arguments and return the bank account
		// which has the highest balance. Test using account3 and account4 as
		// arguments, it should return account4 (balance is 10598.01).
		// You will need to use a ternary operator.
		BinaryOperator<BankAccount> bankAccountHighestBalance = (BankAccountOne, BankAccountTwo) ->
				BankAccountOne.getBalance() > BankAccountTwo.getBalance() ? BankAccountOne : BankAccountTwo;
		BankAccount HighestBalance = bankAccountHighestBalance.apply(account3,account4);
		System.out.println("Highest Balance: " + HighestBalance.getBalance() + " Account: " + HighestBalance.getAccountHolder());

		//Question 7
		/*Write a lambda expression which implements the Consumer interface. It should
		take a bank account as an
		 argument. It should then deduct a £10 fee from the balance.
		 Test using account2 and account6. Call the getBalance() method on the
		 two objects to check that their balances have been updated
		 (account2 should be 540.0 and account6 should be -513.47).*/

		Consumer<BankAccount> BankAccountDeduct10FromBalance = bankAccount ->
				bankAccount.setBalance(bankAccount.getBalance()-10);
		BankAccountDeduct10FromBalance.accept(account2);
		System.out.println(getFullNameAndBalance.apply(account2));

		//Question 8
		//Write a lambda expression which implements the BiConsumer interface.
		// It should take 2 arguments: a bank account and an integer. It should
		// deduct the integer value from the account’s balance. Test using account1
		// and 100. The getBalance() method should show that account1’s balance
		// is now 25262.91. Also test with account5 and 50. The balance afterwards
		// should be -245.7
		BiConsumer<BankAccount, Integer> BankAccountDeduct100FromAccountsBalance =
				(bankAccount, deductAmount) -> bankAccount.setBalance(bankAccount.getBalance() - deductAmount);
		BankAccountDeduct100FromAccountsBalance.accept(account1,100);
		System.out.println(getFullNameAndBalance.apply(account1));


		System.out.println("======Section 1.3=====");
		System.out.println("=======Question 1======");
		List<BankAccount> bankAccountList = new ArrayList<>(Arrays.asList(account1,account2,account3,account4,account5,
				account6,account7,account8));
		System.out.println("======Question 2======");
		Consumer<BankAccount> displayAccountInformation = bankAccount ->
				System.out.println(bankAccount.getAccountNumber() + " " + bankAccount.getAccountHolder() + " " +
						bankAccount.getAccountType() + " " + bankAccount.getBalance());
		bankAccountList.forEach(displayAccountInformation);
		System.out.println("======Question 3=======");
		bankAccountList.forEach(displayAccountInformation);
		bankAccountList.forEach(BankAccountDeduct10FromBalance);
		System.out.println("After money deducted");
		bankAccountList.forEach(displayAccountInformation);
		System.out.println("======Question 4======");
		//remove account if overdrawn by more than 500
		bankAccountList.forEach(displayAccountInformation);
		Predicate<BankAccount> accountMoreThan500 = bankAccount -> bankAccount.getBalance() > -500;
		System.out.println("Accounts less than 500");
		bankAccountList.removeIf(accountMoreThan500);
		bankAccountList.forEach(displayAccountInformation);
		System.out.println("======Question 5==========");
		bankAccountList.forEach(displayAccountInformation);
		Predicate<BankAccount> removeSavingAccounts = bankAccount -> bankAccount.getAccountType().equals("savings");
		bankAccountList.removeIf(removeSavingAccounts);
		bankAccountList.forEach(displayAccountInformation);

		System.out.println("=====Comparators=======");
		bankAccountList = new ArrayList<>(Arrays.asList(account1,account2,account3,account4,account5,
				account6,account7,account8));
		//sort accounts by balance
		Comparator<BankAccount> sortAccountsByBalance = (Account1, Account2) ->
				((Double) Account1.getBalance()).compareTo(Account2.getBalance());
		bankAccountList.forEach(displayAccountInformation);
		bankAccountList.sort(sortAccountsByBalance);
		System.out.println("After sorting");
		bankAccountList.forEach(displayAccountInformation);
		//sort accounts by account type
		Comparator<BankAccount> sortAccoutsByType = (Account1,Account2) ->
				Account1.getAccountType().compareTo(Account2.getAccountType());
		System.out.println("Before sorting");
		bankAccountList.forEach(displayAccountInformation);
		bankAccountList.sort(sortAccoutsByType);
		System.out.println("After sorting");
		bankAccountList.forEach(displayAccountInformation);
		//sort accounts by account number
		Comparator<BankAccount> sortByAccountNumber = (Account1,Account2) ->
				Account1.getAccountNumber() - Account2.getAccountNumber();
		System.out.println("Before sorting");
		bankAccountList.forEach(displayAccountInformation);
	}

}

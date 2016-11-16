/*
 * 
 * This file is part of UnitTest.
 *
 * UnitTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * UnitTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with UnitTest.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

/**
 * 
 * BankAccount is a dummy class to be used with UnitTest
 * 
 * This class is used to be tested in the UnitTest application. There is an
 * implememted test class 'AccountTest' that tests this class.
 * 
 * @author Lorenz Gerber
 * @versuib 1.0
 *
 */
public class BankAccount {

    private int balance;
    private int interest;

    /**
     * BankAccount
     * 
     * Constructor initializes account with zero balance and zero interest.
     */
    public BankAccount() {
	balance = 0;
	interest = 0;
    }

    /**
     * deposit
     * 
     * Method to deposit an amount given as integer to the account object.
     * 
     * @param amount
     *            amount to deposit
     */
    public void deposit(int amount) {
	balance += amount;
    }

    /**
     * withdraw
     * 
     * Method to withdraw an amount given as integer from the account object.
     * 
     * @param amount
     *            amount to withdraw
     */
    public void withdraw(int amount) {
	balance -= amount;
    }

    /**
     * 
     * balance
     * 
     * Method to check the balance of the BankAccount
     * 
     * @return int balance
     */
    public int balance() {

	return balance;
    }

    /**
     * setInterest
     * 
     * Setter method to set the current interest rate of the BankAccount
     * 
     * @param percent
     *            integer
     */
    public void setInterest(int percent) {
	this.interest = percent;
    }

    /**
     * 
     * addInterest
     * 
     * This Method calculates the interest for one year and deposits it on the
     * account. Based on current balance and interest rate.
     */
    public void addInterest() {
	this.deposit(balance * interest / 100);
    }

}

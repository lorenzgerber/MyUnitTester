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
import model.TestClass;

/**
 * 
 * AccountTest is a test class testing the dummy class BankAccount
 * 
 * This class is to be used in the UnitTest application. It contains
 * six tests to be executed on the BankAccount class. 
 * 
 * @author Lorenz Gerber
 * @version 1.0
 *
 */
public class AccountTest implements TestClass {
    private BankAccount testAccount;

    public AccountTest() {
    }

    /**
     * 
     * setUp
     * 
     * instantiates a BankAccount
     */
    public void setUp() {
	testAccount = new BankAccount();
    }

    /**
     * 
     * tearDown
     * 
     * removes BankAccount object
     */
    public void tearDown() {
	testAccount = null;
    }

    /**
     * 
     * testInitialisation
     * 
     * Checks that the initial bank account
     * has a balance of zero
     * 
     * @return boolean test pass or fail
     */
    public boolean testInitialisation() {
	return testAccount.balance() == 0;
    }

    /**
     * 
     * testDeposit
     * 
     * Tests the deposit function.
     * Deposits 100 units and checks the balance.
     * 
     * @return boolean test pass or fail
     */
    public boolean testDeposit() {
	testAccount.deposit(100);
	return testAccount.balance() == 100;

    }

    /**
     * 
     * testWithdraw()
     * 
     * Tests the withdraw function.
     * Deposits 100 units then withdraws 100
     * and checks the balance to be zero.
     * 
     * @return boolean test pass or fail
     */
    public boolean testWithdraw() {
	testAccount.deposit(100);
	testAccount.withdraw(100);
	return testAccount.balance() == 0;
    }
    
    /**
     * testCalcInterest
     * 
     * Tests correctness of interest
     * calculation and addition. Deposits
     * 100 units, calculates the yearly
     * interest for 5% and adds it to the
     * account.
     * 
     * @return boolean test pass or fail
     */
    public boolean testCalcInterest() {
	testAccount.deposit(100);
	testAccount.setInterest(5);
	testAccount.addInterest();
	return testAccount.balance() == 105;
    }
    
    /**
     * testOverdraft
     * 
     * Tests the possibility to 
     * overdraw an account. The test
     * withdraws 100 units and checks
     * that the balance is below 0.
     * 
     * @return boolean test pass or fail
     */
    public boolean testOverdraft() {
	testAccount.withdraw(100);
	return testAccount.balance() < 0;
    }

    /**
     * 
     * testFailingByException
     * 
     * This method is used to test the
     * actual Unit Test framework.
     * Specifically, it tests the situation when
     * a test results in an exception. This
     * is provoked by removing the account object
     * and then trying to deposit 100 units to it.
     * 
     * @return boolean always returns true
     */
    public boolean testFailingByException() {
	testAccount = null;
	testAccount.deposit(100);
	return true;

    }


}

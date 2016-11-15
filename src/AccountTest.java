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

    public void setUp() {
	testAccount = new BankAccount();
    }

    public void tearDown() {
	testAccount = null;
    }

    public boolean testInitialisation() {
	return testAccount.balance() == 0;
    }

    public boolean testDeposit() {
	testAccount.deposit(100);
	return testAccount.balance() == 100;

    }

    public boolean testWithdraw() {
	testAccount.deposit(100);
	testAccount.withdraw(100);
	return testAccount.balance() == 0;
    }
    
    public boolean testCalcInterest() {
	testAccount.deposit(100);
	testAccount.setInterest(5);
	testAccount.addInterest();
	return testAccount.balance() == 5;
    }
    
    public boolean testOverdraft() {
	testAccount.withdraw(100);
	return testAccount.balance() < 0;
    }

    public boolean testFailingByException() {
	testAccount = null;
	testAccount.deposit(100);
	return true;

    }


}

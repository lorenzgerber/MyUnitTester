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
 * @author Lorenz Gerber
 *
 */
public class Test1 implements TestClass {
    private MyInt myInt;

    public Test1() {
    }

    public void setUp() {
	myInt = new MyInt();
    }

    public void tearDown() {
	myInt = null;
    }

    // Test that should succeed
    public boolean testInitialisation() {
	return myInt.value() == 0;
    }

    // Test that should succeed
    public boolean testIncrement() {
	myInt.increment();
	myInt.increment();
	return myInt.value() == 2;

    }

    // Test that should succeed
    public boolean testDecrement() {
	myInt.increment();
	myInt.decrement();
	return myInt.value() == 0;
    }

    // Test that should fail
    public boolean testFailingByException() {
	myInt = null;
	myInt.decrement();
	return true;

    }

    // Test that should fail
    public boolean testFailing() {
	return false;

    }

}

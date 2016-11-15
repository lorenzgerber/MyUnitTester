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
 * MyInt is a dummy class used for testing in UnitTest
 * 
 * This class was given in the assignment specifications. There
 * is an implemented test class 'Test1' that tests this class. 
 * 
 */
public class MyInt {
    private int val;

    public MyInt() {
	val = 0;
    }

    public void increment() {
	val++;
    }

    public void decrement() {
	val--;
    }

    public int value() {
	return val;
    }

}

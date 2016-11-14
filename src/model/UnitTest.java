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
package model;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 
 * @author Lorenz Gerber
 *
 */
public class UnitTest {

    protected Method[] testClassMethods;
    private Class<?> classToTest;
    private Object classInstance;
    private Class<?>[] testClassInterfaces;
    public boolean verified = false;
    private boolean hasSetUp = false;
    private boolean hasTearDown = false;
    private ArrayList<String> messages = new ArrayList<String>();

    public UnitTest(String className) throws ClassNotFoundException {
	classToTest = Class.forName(className);
	testClassInterfaces = classToTest.getInterfaces();
	testClassMethods = classToTest.getMethods();
    }

    public ArrayList<String> runTestClass() {
	try {
	    classInstance = classToTest.newInstance();
	} catch (Exception e) {
	    messages.add("Could not instantiate class to be tested.\n");
	    messages.add(e.getCause().toString() + "\n");
	}

	for (int i = 0; i < testClassMethods.length; i++) {

	    if (testClassMethods[i].getName().contains("test")
		    && testClassMethods[i].getReturnType() == boolean.class) {

		if (hasSetUp) {
		    this.setUp();
		}

		try {
		    if ((boolean) classToTest.getMethod(testClassMethods[i].getName()).invoke(classInstance)) {
			messages.add("Success: \"" + testClassMethods[i].getName() + "\"\n");
		    } else {
			messages.add("Failed: \"" + testClassMethods[i].getName() + "\"\n");
		    }
		} catch (Exception e) {
		    messages.add("Failed: \"" + testClassMethods[i].getName() + "\":\n");
		    messages.add(e.getCause().toString() + "\n");
		}

		if (hasTearDown) {
		    this.tearDown();
		}

	    }
	}

	return messages;
    }

    public ArrayList<String> verifyTestClass() {
	ArrayList<String> messages = new ArrayList<String>();

	boolean implementsTestClass = false;
	boolean hasZeroArgConstructor = false;

	for (int i = 0; i < testClassInterfaces.length; i++) {
	    if (testClassInterfaces[i].getName().equals("TestClass")) {
		implementsTestClass = true;
	    }
	}

	try {
	    if (classToTest.getConstructor() != null) {
		hasZeroArgConstructor = true;
	    }
	} catch (NoSuchMethodException e) {
	    messages.add("Class to be tested has no zero argument constructor.\n");
	}

	if (implementsTestClass && hasZeroArgConstructor) {
	    verified = true;
	}

	for (int i = 0; i < testClassMethods.length; i++) {
	    if (testClassMethods[i].getName().equals("setUp")) {
		hasSetUp = true;
	    }

	    if (testClassMethods[i].getName().equals("tearDown")) {
		hasTearDown = true;
	    }
	}

	return messages;
    }

    public void setUp() {
	try {
	    classToTest.getMethod("setUp").invoke(classInstance);
	} catch (Exception e) {
	    messages.add("Set up method failed.\n");
	    messages.add(e.getCause().toString() + "\n");
	}
    }

    public void tearDown() {
	try {
	    classToTest.getMethod("tearDown").invoke(classInstance);
	} catch (Exception e) {
	    messages.add("Tear down method failed.\n");
	    messages.add(e.getCause().toString() + "\n");
	}
    }

}

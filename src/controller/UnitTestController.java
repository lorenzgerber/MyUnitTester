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
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.UnitTest;
import view.UnitTestGui;

/**
 * 
 * UnitTestController
 * 
 * This class coordinates the work in the UnitTest application.
 * In the constructor it takes the gui object as argument.
 * The class mainly contains code that links the model with
 * the view.
 * 
 * @author Lorenz Gerber
 * @version 1.0
 *
 */
public class UnitTestController {

    private UnitTestGui gui;
    private UnitTest tester;

    /**
     * UnitTestController
     * 
     * This class binds model and view together. It
     * contains the EventListener that connect to the gui
     * and it instantiates a UnitTest class when testing
     * is initiated.
     * 
     * @param gui instance of UnitTestGui
     */
    public UnitTestController(UnitTestGui gui) {
	this.gui = gui;

	gui.getRunButton().addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		runButtonPressed();
	    }

	});

	gui.getClearButton().addActionListener(new ActionListener() {

	    public void actionPerformed(ActionEvent e) {
		clearButtonPressed();
	    }

	});

    }

    /**
     * runButtonPressed
     * 
     * This method instantiates a UnitTest object, and commands
     * verification, and testing of the method received from the
     * graphical user interface.
     * 
     */
    protected void runButtonPressed() {
	ArrayList<String> messages = new ArrayList<String>();

	try {
	    tester = new UnitTest(gui.getTextField().getText());
	} catch (ClassNotFoundException e) {
	    messages.add("This test does not exist.\n");
	}
	
	if(!messages.isEmpty()){
	    for (String element : messages) {
		    gui.getTextArea().append(element);
		}
	    messages.clear();
	    return;
	}

	messages = tester.verifyTestClass();
	if(!messages.isEmpty()){
	    for (String element : messages) {
		    gui.getTextArea().append(element);
		}
	    messages.clear();
	    return;
	}
	messages = tester.runTestClass();
	for (String element : messages) {
	    gui.getTextArea().append(element);
	}

    }

    protected void clearButtonPressed() {
	gui.getTextArea().setText(null);
	
    }
}

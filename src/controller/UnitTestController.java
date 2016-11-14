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
 * @author Lorenz Gerber
 *
 */
public class UnitTestController {

    private UnitTestGui gui;
    private UnitTest tester;

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

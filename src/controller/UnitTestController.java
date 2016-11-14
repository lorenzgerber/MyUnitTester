package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.UnitTest;
import view.UnitTestGui;

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
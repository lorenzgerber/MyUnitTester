import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.util.ArrayList;

import gui.UserInterface;

public class MyUnitTestController {
    
    private UserInterface gui;
    private UnitTester tester;
    
    public MyUnitTestController(UserInterface gui){
	this.gui = gui;
	
	
	gui.getRunButton().addActionListener(new ActionListener() {
	    
	    public void actionPerformed(ActionEvent e){
		runButtonPressed();
		
	    }
	    
	});
	
	gui.getClearButton().addActionListener(new ActionListener() {
	    
	    public void actionPerformed(ActionEvent e){
		clearButtonPressed();
	    }
	    
	});
	
	
    }
    	
    protected void runButtonPressed() {
	ArrayList<String> messages = new ArrayList<String>();
	
	/*
	PrintStream redirect = new PrintStream(
                new StreamRedirect(gui.getTextArea()));
	System.setOut(redirect);
	*/
	
	
	try {
	    tester = new UnitTester(gui.getTextField().getText());
	} catch (ClassNotFoundException e) {
	    System.out.println("this test does not exist");
	}
	
	tester.verifyTestClass();
	messages = tester.runTestClass();
	for(String element : messages){
	    gui.getTextArea().append(element);  
	}
	
    }
    
    protected void clearButtonPressed(){
	gui.getTextArea().setText(null);
    }
}

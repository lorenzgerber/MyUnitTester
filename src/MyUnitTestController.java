import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

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
	
	PrintStream redirect = new PrintStream(
                new StreamRedirect(gui.getTextArea()));
	System.setOut(redirect);
	
	
	
	try {
	    tester = new UnitTester(gui.getTextField().getText());
	} catch (ClassNotFoundException e) {
	    System.out.println("this test does not exist");
	}
	
	tester.verifyTestClass();
	tester.runTestClass();
	
    }
    
    protected void clearButtonPressed(){
	gui.getTextArea().setText(null);
    }
}

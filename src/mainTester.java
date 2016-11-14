

public class mainTester {
    
    public static void main (String args[]){
		
	try {
	    UnitTester test = new UnitTester("Test1");	
	    System.out.println("what the heck");
	    test.verifyTestClass();
	    test.runTestClass();
	} catch (ClassNotFoundException e) {
			
	    // TODO Auto-generated catch block
	    e.printStackTrace();	
	}
    }
}

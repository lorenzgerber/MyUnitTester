import java.util.ArrayList;

import model.UnitTest;

public class testo {
    
    private  UnitTest t;
    
    public static void main(String args[]){
	
	UnitTest t = null;
	
	 try {
	    t = new UnitTest("Test2");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	 
	 ArrayList<String> verify = new ArrayList<String>();
		verify = t.verifyTestClass();
		if(verify.isEmpty()){
		    System.out.println("is empty");
		}
	 
	 
    }

}

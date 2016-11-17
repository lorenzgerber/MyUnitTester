package junit;

import org.junit.Test;

import static org.junit.Assert.*;

import model.UnitTest;

public class JUnitUnitTest {
    
    static UnitTest t;
    
    @Test
    public void createObject(){
	UnitTest t = null;
	
	try {
	    t = new UnitTest("Test1");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	assertNotNull(t);
    }
    
    @Test(expected=ClassNotFoundException.class)
    public void createObjectWrongClassName() throws ClassNotFoundException{
	UnitTest t = null;
	t = new UnitTest("doesnotexist");
	
    }

    @Test
    public void verifyCorrectUnitTestObject(){
	UnitTest t = null;
	try {
	    t = new UnitTest("Test1");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	assert(t.verifyTestClass().isEmpty());
    }
    
    @Test
    public void verifyFailClassDoesNotImplementInterface(){
	UnitTest t = null;
	try {
	    t = new UnitTest("Test2");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	assertFalse(t.verifyTestClass().isEmpty());
	
    }
    
    @Test
    public void verifyFailClassHasNoZeroArgConstructor(){
	UnitTest t = null;
	try {
	    t = new UnitTest("Test3");
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	assertFalse(t.verifyTestClass().isEmpty());
	
    }
   
}

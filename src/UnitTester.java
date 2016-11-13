
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UnitTester {

    protected Method[] testClassMethods;
    private Class<?> classToTest;
    private Object classInstance;
    private Class<?>[] testClassInterfaces;
    private boolean hasSetUp = false;
    private boolean hasTearDown = false;

    UnitTester(String className) throws ClassNotFoundException {
	classToTest = Class.forName(className);
	testClassInterfaces = classToTest.getInterfaces();
	testClassMethods = classToTest.getMethods();
    }

    public boolean runTestClass() {
	try {
	    classInstance = classToTest.newInstance();
	} catch (Exception e) {
	    System.out.println("Could not instantiate class to be tested.");
	    System.out.println(e.getCause().toString());
	}
	
	if(hasSetUp){
	    this.setUp();
	}
	
	for(int i = 0; i < testClassMethods.length; i++){
	    
	    if(testClassMethods[i].getName().contains("test") 
		    && testClassMethods[i].getReturnType() == boolean.class){
		
		try {
			if((boolean) classToTest.getMethod(testClassMethods[i].getName()).invoke(classInstance)) {
			    System.out.println("Success");
			} else {
			    System.out.println("Failed");			    
			}
		    } catch (Exception e) {
			System.out.println("Failed: could not invoke \""+testClassMethods[i].getName()+"\":");
			System.out.println(e.getCause().toString());
		    }
	    }
	}
	
	if(hasTearDown){
	    this.tearDown();
	}
	
	
	
	
	return true;
    }

    public boolean verifyTestClass() {
	
	boolean implementsTestClass = false;
	boolean isValidTestClass = false;
	boolean hasZeroArgConstructor = false;
	
	for (int i = 0; i < testClassInterfaces.length; i++) {
	    if (testClassInterfaces[i].getName().equals("TestClass")) {
		implementsTestClass = true;
	    }
	}
	
	try {
	    if(classToTest.getConstructor()!=null){
	        hasZeroArgConstructor = true;
	    }
	} catch (NoSuchMethodException e) {
	    System.out.println("class to be tested has no zero arg constructor");
	}
	
	if(implementsTestClass && hasZeroArgConstructor){
	    isValidTestClass = true;
	}
	
	
	for (int i = 0; i < testClassMethods.length; i++) {
	    if (testClassMethods[i].getName().equals("setUp")) {
		hasSetUp = true;
	    }
	    
	    if (testClassMethods[i].getName().equals("tearDown")){
		hasTearDown = true;
	    }
	}
	
	return isValidTestClass;
    }


    public void setUp() {
	try {
	    classToTest.getMethod("setUp").invoke(classInstance);
	} catch (Exception e) {
	    System.out.println("setUp method Failed!");
	    System.out.println(e.getCause().toString());
	} 
    }

    public void tearDown() {
	try {
	    classToTest.getMethod("tearDown").invoke(classInstance);
	} catch (Exception e) {
	    System.out.println("teardown method failed.");
	    System.out.println(e.getCause().toString());
	}
    }

}

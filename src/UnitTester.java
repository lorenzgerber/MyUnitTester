

import java.lang.reflect.Method;

public class UnitTester {
	
	protected Method[] methodArray;
	private Class<?> classToTest;
	private Object classInstance;
	private Class<?>[] testClassInterfaces;
		
	UnitTester(String className) throws ClassNotFoundException{
		classToTest = Class.forName(className);
		testClassInterfaces = classToTest.getInterfaces();
		methodArray = classToTest.getMethods();
	}
	
	
	public boolean runTestClass(){
		return true;
	}
	
	public boolean verifyTestClass(){
		
		
		return true;
	}
	
	public boolean runSingleTest(){
		return true;
	}
	
	public boolean setUp(){
		return true;
	}
	
	public boolean tearDown(){
		return true;
	}
	
	
	
	
	
	

}

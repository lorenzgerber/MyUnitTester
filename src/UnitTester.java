

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
	
	
	

}

/**
 * Created by loge on 2016-11-10.
 */
public class Test1 implements TestClass {
    private TestClass testClass;

    public Test1() {
    }

    public void setUp() {
        testClass =new TestClass();
    }

    public void tearDown() {
        testClass =null;
    }

    //Test that should succeed
    public boolean testInitialisation() {
        return testClass.value()==0;
    }

    //Test that should succeed
    public boolean testIncrement() {
        testClass.increment();
        testClass.increment();
        return testClass.value()==2;

    }

    //Test that should succeed
    public boolean testDecrement() {
        testClass.increment();
        testClass.decrement();
        return testClass.value()==0;
    }

    //Test that should fail
    public boolean testFailingByException() {
        testClass =null;
        testClass.decrement();
        return true;

    }

    //Test that should fail
    public boolean testFailing() {
        return false;

    }


}

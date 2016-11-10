import javax.swing.*;

/**
 * Created by loge on 2016-11-10.
 */
public class MyUnitTesterMain {
    public static void main( String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MyUnitTester gui = new MyUnitTester("MyUnitTester");
                gui.show();
            }
        });
    }
}

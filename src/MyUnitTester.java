import javax.swing.*;

/**
 * Created by loge on 2016-11-10.
 */
public class MyUnitTester {

    private JFrame frame;

    public MyUnitTester(String title){
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }

    public void show(){frame.setVisible(true);};


}

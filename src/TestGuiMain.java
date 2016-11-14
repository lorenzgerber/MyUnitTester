import javax.swing.SwingUtilities;

import gui.UserInterface;

public class TestGuiMain {

    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                UserInterface gui = new UserInterface("MyUnitTester");
                gui.show();
                new MyUnitTestController(gui);
            }
        });

    }



}

import javax.swing.SwingUtilities;

import gui.UnitTestGui;

public class UnitTestMain {

    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                UnitTestGui gui = new UnitTestGui("MyUnitTester");
                gui.show();
                new UnitTestController(gui);
            }
        });

    }



}

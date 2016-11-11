import javax.swing.SwingUtilities;

public class TestGuiMain {

    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                TestGui gui = new TestGui("Test");
                gui.show();

            }
        });

    }



}

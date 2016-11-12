import javax.swing.SwingUtilities;

public class TestGuiMain {

    public static void main(String args[]){

        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                ExtraGui gui = new ExtraGui("Test");
                gui.show();

            }
        });

    }



}

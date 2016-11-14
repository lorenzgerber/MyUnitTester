import javax.swing.SwingUtilities;

import controller.UnitTestController;
import view.UnitTestGui;

public class UnitTestMain {

    public static void main(String args[]) {

	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		UnitTestGui gui = new UnitTestGui("MyUnitTester");
		gui.show();
		new UnitTestController(gui);
	    }
	});
    }
}

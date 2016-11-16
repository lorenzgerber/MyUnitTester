
/*
 * 
 * This file is part of UnitTest.
 *
 * UnitTest is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * UnitTest is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with UnitTest.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */
import javax.swing.SwingUtilities;
import controller.UnitTestController;
import view.UnitTestGui;

/**
 * UnitTestMain
 * 
 * This file contains a main method to run the java class UnitTest with a
 * graphical user interface.
 * 
 * @author Lorenz Gerber
 * @version 1.0
 *
 */
public class UnitTestMain {

    public static void main(String args[]) {

	SwingUtilities.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		UnitTestGui gui = new UnitTestGui("MyUnitTester");
		gui.show();
		try {
		    new UnitTestController(gui);
		} catch (Exception e) {
		    System.out.println("Houston we got a problem");
		}

	    }
	});
    }
}

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;

import javax.swing.JComponent;

public class RectangleComponent extends JComponent {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		
		Rectangle box = new Rectangle(5, 10, 20, 30);
		g2.draw(box);
		
		box.translate(15, 25);
		g2.draw(box);
		g2.setColor(Color.BLUE);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(100, 100, 90, 30);
		g2.draw(ellipse);
		g2.fill(ellipse);
		
		g2.drawString("Message", 50, 100);
		
		g2.draw(ellipse);
		
	}

}

import javax.swing.JFrame;

public class ExtraGui {
	
	 JFrame frame;
	 RectangleComponent recta;
	 
	 public ExtraGui(String title){
		 frame = new JFrame(title);
		 recta = new RectangleComponent();
		 frame.add(recta);
		 frame.setVisible(true);
	 }
	 
	 public void show(){
		 frame.setSize(400, 400);
		 frame.setVisible(true);   
	 }
	 
}

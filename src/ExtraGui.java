import javax.swing.JFrame;

public class ExtraGui {
	
	 JFrame frame;
	 RectangleComponent recta;
	 
	 public ExtraGui(String title){
		 frame = new JFrame(title);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 recta = new RectangleComponent();
		 frame.add(recta);
		 frame.setVisible(true);
	 }
	 
	 public void show(){
		 frame.setSize(400, 400);
		 frame.setVisible(true);   
	 }
	 
}

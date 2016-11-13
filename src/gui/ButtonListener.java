package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonListener implements ActionListener {
	
	private final JTextField textField;
	private final JTextArea textArea;
	
	public ButtonListener(JTextField textField, JTextArea textArea){
		this.textField = textField;
		this.textArea = textArea;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		this.textField.setText("this is the shit");
		this.textArea.append("the real shit\n");
		//System.out.println(textField.getText());
	}

	
}

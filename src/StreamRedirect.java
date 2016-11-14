import java.io.IOException;
import java.io.OutputStream;
import javax.swing.JTextArea;

public class StreamRedirect extends OutputStream {
    
    private JTextArea textArea;
    
    
    public StreamRedirect(JTextArea textArea) {
	this.textArea = textArea;
    }

    @Override
    public void write(int byteWise) throws IOException {
	textArea.append(String.valueOf((char) byteWise));
    }
    

}

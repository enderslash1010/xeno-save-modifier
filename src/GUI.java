import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	
	JFrame frame = new JFrame();
	JFileChooser fc = new JFileChooser();
	JTextArea text = new JTextArea();
	
	JLabel label = new JLabel("No File Selected");
	
	JButton open = new JButton("Open");
	JButton again = new JButton("Compute CRC Again");
	
	crc16 c;

	public GUI() {		
        frame.setTitle("Xenoblade Chronicles (Wii) Save Modifier");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        
        CustomActionListener handler = new CustomActionListener();
        open.addActionListener(handler);
        again.addActionListener(handler);
        
        // panels
        JPanel north = new JPanel();
        north.add(open);
        north.add(again);
        
        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.NORTH, north);
        frame.getContentPane().add(BorderLayout.CENTER, text);
        frame.getContentPane().add(BorderLayout.SOUTH, label);
        frame.setVisible(true);
        
	}
	
	class CustomActionListener implements ActionListener{
	    public void actionPerformed(ActionEvent e) {
//	       if (((JButton)e.getSource()).getText().equals("Open")) {
//	    	   int result = fc.showOpenDialog(fc);
//	    	   if (result == 0) {
//	    		   clearText();
//	    		   c.setFileLocation(fc.getSelectedFile().getAbsolutePath());
//	    		   label.setText(fc.getSelectedFile().getAbsolutePath());
//	    		   c.computeCRC16();
//	    	   }
//	       }
	    
	    	switch (((JButton)e.getSource()).getText()) {
	    		case "Open": 
	    			int result = fc.showOpenDialog(fc);
	    			if (result == 0) {
		    		   clearText();
		    		   c.setFileLocation(fc.getSelectedFile().getAbsolutePath());
		    		   label.setText(fc.getSelectedFile().getAbsolutePath());
		    		   c.computeCRC16();
	    			}
	    			break;
	    		case "Compute CRC Again":
	    			clearText();
	    			c.computeCRC16();
	    			break;
	    	}
	    }
	}
	
	public void setText(String s) {
		text.setText(s);
	}
	
	public void addText(String s) {
		text.setText(text.getText() + s);
	}
	
	public void clearText() {
		text.setText("");
	}
	
	public void addcrc16(crc16 c) {
		this.c = c;
	}
	
}

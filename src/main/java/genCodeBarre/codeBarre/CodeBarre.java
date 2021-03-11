package genCodeBarre.codeBarre;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import com.onbarcode.barcode.Code128;
import com.onbarcode.barcode.Interleaved25;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JButton;

public class CodeBarre {

	private JLabel lblGnrateurDeQr = new JLabel("    Générateur de code barre");
	private JFrame frame;
	private JTextField textField= new JTextField();
	private static JButton btnGenerer = new JButton("Generer");
	Properties p = System.getProperties();
	String userName = p.getProperty("user.name");
	File dir = new File("c:\\Users\\"+userName+"\\.CodeBarre");
    File[]  files   =   dir.listFiles();
    int nb=files.length;

	/**
	 * Launch the application.
	 * @throws WriterException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					CodeBarre window = new CodeBarre();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	

	public CodeBarre() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
        if (!dir.exists()) {
            if (dir.mkdir()) {}
        }
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnGenerer.addActionListener(new ButtonGenererListener()); 
		JSplitPane splitPane = new JSplitPane();
		splitPane.setLastDividerLocation(4);
		splitPane.setDividerSize(2);
		frame.getContentPane().add(splitPane, BorderLayout.SOUTH);
		splitPane.setRightComponent(btnGenerer);
		splitPane.setLeftComponent(textField);
		textField.setColumns(10);
		
		frame.getContentPane().add(lblGnrateurDeQr, BorderLayout.NORTH);
	}
	
	  class ButtonGenererListener implements ActionListener{
		    public void actionPerformed(ActionEvent e) {
		    	try {
					CodeBarreGen();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		    }

	  }
	  
	  public void CodeBarreGen() throws Exception {
	        String data = textField.getText();
			String name= "CodeBarre";
	        String imageFormat = "png";
	        String outputFileName = dir + "\\" + name + nb + "." + imageFormat;
	        Code128 barcode2 = new Code128(); 
	        barcode2.setData(data); 
	        barcode2.drawBarcode(outputFileName); 
	  }
	  
	  
}

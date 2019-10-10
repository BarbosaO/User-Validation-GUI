package frame;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import listener.Listener;

public class LogInDisplay
{
	// instance variables
		private static JFrame frame;
		private static JPanel panel;
		public static JTextField username;
		private JLabel user, pass;
		private JButton logIn;
		public static JPasswordField passwordField;
		private JCheckBox checkBox;
		
		
		// Listener instance
		Listener mouseListener = new Listener();
		
		// Action Listener instance
		Listener actionListener = new Listener();
		
		// constructor
		public LogInDisplay()
		{
			createFrame();
		}
		
		public void createFrame()
		{
			
			// Set look and field 
	        try 
	        {
	            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
	            {
	                if ("Nimbus".equals(info.getName())) 
	                {
	                    UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } 
	        catch (ClassNotFoundException | InstantiationException |
	                IllegalAccessException | UnsupportedLookAndFeelException e) 
	        {
	        // If Nimbus is not available, you can set the GUI to another look and feel.
	        }
				
			frame = new JFrame("Log In");
			frame.setSize(800,300);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setResizable(false);
		
			panel = new JPanel(new GridBagLayout());
			
			// set up component layout
			GridBagConstraints c = new GridBagConstraints();
			
			c.insets = new Insets(10,10,10,10);
			
			// create components
			implementComponents();
			
			c.gridx = 0;	
			c.gridy = 0;
			panel.add(user, c);
			
			c.gridx = 0;
			c.gridy = 1;
			panel.add(pass, c);
			
			c.gridx = 1;	
			c.gridy = 0;
			panel.add(username, c);
			
			c.gridx = 1;
			c.gridy = 1;
			panel.add(passwordField, c);
			
			c.gridx = 2;
			c.gridy = 0;
			panel.add(logIn, c);
			
			// password check box
			c.gridx = 2;
			c.gridy = 1;
			panel.add(checkBox, c);
			
			frame.add(panel, BorderLayout.NORTH);		
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		}
		
		public void implementComponents()
		{
			// user name
			username = new JTextField(15);
			username.addMouseListener(mouseListener);
			
			// password
			passwordField = new JPasswordField(15);
			passwordField.setActionCommand("OK");
			passwordField.addMouseListener(mouseListener);
			
			// user name label
			user = new JLabel();
			user.setText("Username");
			user.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			
			// password label
			pass = new JLabel();
			pass.setText("Password");
			pass.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			
			// user name label
			user = new JLabel();
			user.setText("Username");
			user.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			
			
			// log in button
			logIn = new JButton("Log In");
			logIn.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			logIn.addActionListener(actionListener);
			
			// check box
			checkBox = new JCheckBox("Show password");
			checkBox.addActionListener(actionListener);
			checkBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
			
		}
		
		public static JFrame getFrame()
		{
			return frame;
		}
		
		public static JPanel getPanel()
		{
			return panel;	
		}	
}

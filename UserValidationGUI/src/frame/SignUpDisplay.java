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

public class SignUpDisplay
{ 
	// instance variables
	private static JFrame frame;
	private static JPanel panel;
	public static JTextField firstNameText, lastNameText, 
		usernameText;
	public static JButton signUp, signIn;
	public static JLabel instructions, firstName, lastName, user, pass;
	public static JPasswordField passwordField;
	public static JCheckBox checkBox;
	
	public static GridBagConstraints constraint;

	// Action Listener instance
	Listener actionListener = new Listener();
	
	/**
	 * Method that creates class constructor and calls the method that creates the frame. 
	 * We are not making a constructor per say, but we are instantiating one
	 * just to illustrate an OOP approach.
	 */
	public SignUpDisplay() 
	{

		createFrame();
	}
	
	/**
	 * Creates window frame where the sign up page will be displayed.
	 */
	public void createFrame()
	{
		
		// Set look and feel using code provided by Oracle
        try 
        {
        	/* Since the standard look and feel gives a dystopic and metallic look to the frame
        	 * We are going to use the "Nimbus" look and feel, which is more aesthetic and fresh 
        	 */ 
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
          e.printStackTrace();
        }
			
        /*
         * Initialize frame and set its characteristics
           the calls below are usually done sequentially and
           routinely when initializing a JFrame.     
        */
         
		frame = new JFrame("Sign Up");
		// Initialize frame and title it
		frame.setSize(800,300);
		// Sets the default exit operation 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		// Cannot resize frame
		frame.setResizable(false);  
	
		// Initialize panel with an instance of the GridBagLayout object
		panel = new JPanel(new GridBagLayout());
		
		// Set up component layout object
		// Using this layout tool gives a more precise
		// placement of the components on the frame
		createLayout();
		
		
		// Add panel into the frame and place orientation of components
		// to top
		frame.add(panel, BorderLayout.NORTH);
		// Compress any unused space on the frame
		frame.pack();
		// Set the frame to open at the center of the screen
		frame.setLocationRelativeTo(null);
		// Make the frame visible
		frame.setVisible(true);
	
	}
	
	/**
	 * Method to initialize JComponents 
	 */
	public void createComponents()
	{
		
		// Initialize first name text field
		firstNameText = new JTextField(15);
		// Initialize last name text field 
		lastNameText = new JTextField(15);
		// Initialize user name text field
		usernameText = new JTextField(15);

		// Initialize password field
		passwordField = new JPasswordField(15);
		passwordField.setActionCommand("OK");
		passwordField.addActionListener(actionListener);
		
		// Initialize instructions label
		instructions = new JLabel();
		// Set the text
		instructions.setText("Create a New Account");
		// Set the font and font size
		instructions.setFont(new Font("Bookman Old Style", Font.BOLD, 17));
		
		// Initialize first name label
		firstName = new JLabel();
		// Set the text
		firstName.setText("Fist Name");
		// Set the font and font size
		firstName.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		// Initialize last name label
		lastName = new JLabel();
		// Set the text
		lastName.setText("Last Name");
		// Set the font and font size
		lastName.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		// Initialize user name label
		user = new JLabel();
		// Set the text
		user.setText("Username");
		// Set the font and font size
		user.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		// Set the password label
		pass = new JLabel();
		// Set the text
		pass.setText("Password");
		// Set the font and font size
		pass.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		// Initialize the sign up button and set the text
		signUp = new JButton("Sign Up");
		// Link it to the action listener instance
		signUp.addActionListener(actionListener);
		// Set the font and font size
		signUp.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		// Initialize sign in button and set the text
		signIn = new JButton("Sign In");
		// Link it to the action listener instance
		signIn.addActionListener(actionListener);
		// Set the font and font size
		signIn.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));
		
		// Initialize the check box
		checkBox = new JCheckBox("Show password");
		// Link it to the action listener instance
		checkBox.addActionListener(actionListener);
		// Set the font and font size
		checkBox.setFont(new Font("Bookman Old Style", Font.PLAIN, 15));

	}
	
	/**
	 * 	Method to organize and place the components onto the panel
	 *  using the GridBagLayout class, which is a flexible layout management tool.
	 */
	public void createLayout()
	{
		
		// Create GridBagConstraints object
		constraint = new GridBagConstraints();
		
		// Set up external padding of components
		constraint.insets = new Insets(10,10,10,10);
		
		// Create components
		createComponents();
		
		// Place the first name text field
		constraint.gridx = 1;	
		constraint.gridy = 1;
		panel.add(firstNameText, constraint);
		
		// Place last name text field
		constraint.gridx = 1;	
		constraint.gridy = 2;
		panel.add(lastNameText, constraint);
		
		
		// Place user name text field 
		constraint.gridx = 1;	
		constraint.gridy = 3;
		panel.add(usernameText, constraint);
		
		// Place password field
		constraint.gridx = 1;
		constraint.gridy = 4;
		panel.add(passwordField, constraint);
		
		// Place sign up button
		constraint.gridx = 3;
		constraint.gridy = 1;
		panel.add(signUp, constraint);
		
		// Place sign in button
		constraint.gridx = 3;
		constraint.gridy = 2;
		panel.add(signIn, constraint);
		
		// Place instructions label
		constraint.gridx = 1;
		constraint.gridy = 0;
		panel.add(instructions, constraint);
		
		// Place first name label
		constraint.gridx = 0;
		constraint.gridy = 1;
		panel.add(firstName, constraint);
		
		// Place last name label
		constraint.gridx = 0;
		constraint.gridy = 2;
		panel.add(lastName, constraint);
		
		// Place user name label
		constraint.gridx = 0;
		constraint.gridy = 3;
		panel.add(user, constraint);
		
		// Place password label
		constraint.gridx = 0;
		constraint.gridy = 4;
		panel.add(pass, constraint);
		
		// Place password check box
		constraint.gridx = 3;
		constraint.gridy = 4;
		panel.add(checkBox, constraint);
		
	}
	
	/**
	 * Method to get frame
	 * @return frame
	 */
	public static JFrame getFrame()
	{
		return frame;
	}
	
	/**
	 * Method to get panel
	 * @return frame
	 */
	public static JPanel getPanel()
	{
		return panel;	
	}	
}

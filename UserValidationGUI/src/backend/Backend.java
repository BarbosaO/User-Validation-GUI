package backend;

import java.awt.GridBagConstraints;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import frame.SignUpDisplay;
import verification.UserVerification;

public class Backend 
{
	// Initialize hash map containing user's credentials
	private HashMap<String, char []> firstDatabase = new HashMap<>();
	
	// Initialize second hash map containing user's personal information
	private HashMap<String, String> secondDatabase = new HashMap<>();

	// store user's input
	/**
	 * Method that checks if all fields are entered and if the
	 * user name already exists.
	 */
	public void signUp()
	{
		
		// Get the inputs from the user as strings
		String userName = SignUpDisplay.usernameText.getText();
		String firstName = SignUpDisplay.firstNameText.getText();
		String lastName =  SignUpDisplay.lastNameText.getText();
		
		/*
		 * Initialize a char array to store the password entered by the user.
		 * We are able to do this because the password field is essentially a
		 * char array that stores the individual chars of the input.
		 */
		char [] passwordChars = SignUpDisplay.passwordField.getPassword();
		
		// Store user's credentials in first database
		
		/*
		 * The logic here is to check for empty fields in the sign up display first.
		 * If there are no empty fields, we check for user name duplicates in the first dataa
		 * base. If there are no user name duplicates, we store the four field inputs into
		 * the respective databases.
		 */
		if(userName.length() != 0 && passwordChars.length != 0 && firstName.length() != 0 && lastName.length() != 0)
		{

			// Check for duplicate user names
			if(!firstDatabase.containsKey(userName))
			{	
				// Store inputs into databases
				firstDatabase.put(userName, passwordChars);
				secondDatabase.put(firstName, lastName);
				JOptionPane.showMessageDialog(SignUpDisplay.getFrame(), "You have successfully signed up! :)", "Message",
						JOptionPane.PLAIN_MESSAGE);
			}
			else
				// If there is a user name duplicate, show error message
				JOptionPane.showMessageDialog(SignUpDisplay.getFrame(), "Username already taken! Enter another username!",
						"Error Message", JOptionPane.ERROR_MESSAGE);
		}
		else
			// If there is an empty field, show error message
			JOptionPane.showMessageDialog(SignUpDisplay.getFrame(), "Complete all fields!", "Error Message",
	                JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Method to process log in
	 */
	public void logIn()
	{
		UserVerification.checkCredentials();
	}
		
	/**
	 * Method to proceed to the log in frame.
	 * This frame will essentially be the same as the sign up frame
	 * but we are going to perform the user verification to grant access
	 * to the user with the correct credentials
	 */
	public static void nextFrame()
	{
		JPasswordField passwordField = SignUpDisplay.passwordField;
		JTextField username = SignUpDisplay.usernameText;
		JButton logIn = SignUpDisplay.signUp;
		JLabel user = SignUpDisplay.user, pass = SignUpDisplay.pass;
		JCheckBox checkBox = SignUpDisplay.checkBox;
		
		GridBagConstraints c = SignUpDisplay.c;
		JPanel panel = SignUpDisplay.getPanel();
	
		SignUpDisplay.firstName.setVisible(false);
		SignUpDisplay.lastName.setVisible(false);
		SignUpDisplay.instructions.setVisible(false);
		SignUpDisplay.firstNameText.setVisible(false);
		SignUpDisplay.lastNameText.setVisible(false);
		SignUpDisplay.signUp.setText("Log In");
		SignUpDisplay.signIn.setVisible(false);
	
		// Place user 
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
	
		username.setText("");
		passwordField.setText("");
		SignUpDisplay.getFrame().pack();
		
	}
	
	// HashMap getters 
	public HashMap getFirstDatabase()
	{
		return firstDatabase;
	}
	
	public HashMap getSecondtDatabase()
	{
		return secondDatabase;
	}
}

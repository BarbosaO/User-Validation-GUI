package verification;
import java.util.Arrays;
import java.util.HashMap;

import javax.swing.JOptionPane;

import backend.Backend;
import frame.SignUpDisplay;
import listener.Listener;

public class UserVerification 
{	
	public static void checkCredentials()
	{
	    //Process the password.
	    char[] inputPassword = SignUpDisplay.passwordField.getPassword();
	    String userName = SignUpDisplay.usernameText.getText();
	    
	    if(Listener.getBackEnd().getFirstDatabase().containsKey(userName))
	    {
	    	if (isPasswordCorrect(userName, inputPassword)) 
		    {
		        JOptionPane.showMessageDialog(SignUpDisplay.getFrame(),
		        "Success! You typed the right password.");
		    } 
		    else 
		    {
		       JOptionPane.showMessageDialog(SignUpDisplay.getFrame(),
		       "Invalid password. Try again.",
		       "Error Message",
		       JOptionPane.ERROR_MESSAGE);
		    }

		    //Zero out the possible password, for security.
		    Arrays.fill(inputPassword, '0');

		    SignUpDisplay.passwordField.selectAll();
		    SignUpDisplay.passwordField.requestFocusInWindow();    
	    }
	    else
	    	JOptionPane.showMessageDialog(SignUpDisplay.getFrame(),
	    		       "Invalid username. Try again.",
	    		       "Error Message",
	    		       JOptionPane.ERROR_MESSAGE);	
	}
	
	
	// check if correct password
	private static boolean isPasswordCorrect(String userName, char[] inputPassword) 
	{
		
		boolean isCorrect = true;
		char [] correctPassword = (char[]) Listener.getBackEnd().getFirstDatabase().get(userName);
		System.out.println(Listener.getBackEnd().getFirstDatabase());
		
	    if (inputPassword.length != correctPassword.length) 
	    {
	        isCorrect = false;
	    } 
	    else 
	    {
	        isCorrect = Arrays.equals (inputPassword, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
}

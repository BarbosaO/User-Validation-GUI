package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;

import backend.Backend;
import frame.SignUpDisplay;
import verification.UserVerification;

public class Listener implements ActionListener, MouseListener
{
	
	static Backend processInfo = new Backend();

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() instanceof JButton)
		{
			JButton button = (JButton)e.getSource();
			if(button.getText().equals("Sign Up"))
			{
				// proceed to store user's data
				processInfo.signUp();
				
			}
			else if(button.getText().equals("Log In"))
			{
				processInfo.logIn();
			}
			else if(button.getText().equals("Sign In"))
			{
				Backend.nextFrame();
			}
				
		}
		else if(e.getSource() instanceof JCheckBox)
		{
			JCheckBox checkBox = (JCheckBox)e.getSource();
			{
				if(checkBox.isSelected())
				{
					SignUpDisplay.passwordField.setEchoChar((char)0);
				}
				else
					SignUpDisplay.passwordField.setEchoChar('*');
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getSource() instanceof JTextField)
		{
			JTextField textComponent = (JTextField)e.getSource();
			if(textComponent.getText().equals("Username") || 
					textComponent.getText().equals("Password")) 
			{
				
				textComponent.setText("");
			}
		}	
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		// NOT USED
		
	}

	@Override
	public void mouseReleased(MouseEvent e) 
	{
		// NOT USED
		
	}

	@Override
	public void mouseEntered(MouseEvent e) 
	{
		// NOT USED
		
	}

	@Override
	public void mouseExited(MouseEvent e) 
	{
		// NOT USED
		
	}
	
	public static Backend getBackEnd()
	{
		return processInfo;
	}
	
}

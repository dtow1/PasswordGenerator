
package com.jasonrboyer.passwordgenerator;

/**
 * @author Jason Boyer
 * @version 0.1
 * @category passwords
 * 
 * The PasswordGenerator program takes a user supplied word and generates a password from it. The program randomizes
 * the case of the password.  The program may add special characters, extra numbers, or replace some letters with a
 * number or special character.
 * 
 * The specific password mutations are described in the PasswordCreator class.
 * 
 */


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
 

public class PasswordGenerator{


	public static void main(String[] args) {
		
		//Create panels for the Boolean input areas
		BooleanPanel specChars = new BooleanPanel("Special Characters ","Add","Omit",true);
		BooleanPanel extraNums = new BooleanPanel("Extra Numbers ","Add","Omit",true);

		//Create a panel for the text output
		TextPanel output = new TextPanel();
		
		//Create a Password creator panel that includes text input area
		PasswordCreator makePwd = new PasswordCreator(output,specChars,extraNums);
		
		//Setup Frame
		JFrame pwdFrame = new JFrame("Password Generator v0.1");
		//pwdFrame.getContentPane().setLayout(new BoxLayout(pwdFrame.getContentPane(),BoxLayout.Y_AXIS));
		pwdFrame.getContentPane().setLayout(new GridBagLayout());
		pwdFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		GridBagConstraints constraints = new GridBagConstraints();
		
		//Set the make pwd panel the top slot in the GUI
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx=0;
		constraints.gridy=0;
		constraints.gridwidth = 2;
		constraints.gridheight = 1;
		constraints.anchor = GridBagConstraints.LINE_START;
		pwdFrame.add(makePwd,constraints);
		
		//set the output panel as the last row
		constraints.gridx=0;
		constraints.gridy=2;
		pwdFrame.add(output,constraints);
		
		//set the special character selection panel the second row, first slot
		constraints.gridx=0;
		constraints.gridy=1;
		constraints.gridwidth=1;
		pwdFrame.add(specChars,constraints);
		
		//set the extra numbers selection panel the second row, second slot
		constraints.gridx=1;
		//constraints.anchor = GridBagConstraints.LINE_END;
		pwdFrame.add(extraNums,constraints);
		

		
		
		pwdFrame.pack();
		pwdFrame.setResizable(false);
		pwdFrame.setVisible(true);

	}

}

package com.jasonrboyer.passwordgenerator;

/**
 * 
 * @author Jason Boyer
 * 
 * This class sets up a panel to display text output. It is very basic at the moment, but should have additional
 * features as additional programs require this class to add functionality.
 *
 */


import java.awt.TextArea;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



public class TextPanel extends JPanel {

	private TextArea display = new TextArea("",1,38,TextArea.SCROLLBARS_NONE);
	private JLabel textLabel = new JLabel("New Password: ",SwingConstants.LEFT);
	
	/**
	 * Default constructor
	 */
	TextPanel(){
		display.setEditable(false);
		add(textLabel);
		add(display);	
	}
	
	/**
	 * Setter for the text output
	 * @param text - String, text to be output to the display panel
	 */
	public void updateDisplay(String text){
		display.setText(text);
	}
	
	
	
	
	
	
}

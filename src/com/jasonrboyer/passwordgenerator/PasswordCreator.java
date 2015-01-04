
package com.jasonrboyer.passwordgenerator;

/**
 * @author Jason Boyer
 * 
 * This class drives the functionality of the password generator program. This class allows you to add special
 * characters or additional numbers onto the password. It can also replace some letters with a number or special 
 * character.
 * 
 * Characters that can be upper, lower, or a new character are a,i,e, & s.
 * 
 */

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class PasswordCreator extends JPanel {
	
	private String basePassword;
	private String newPassword;
	private JLabel display = new JLabel("Enter base Word: ");
	private JTextField pwdText = new JTextField("",25);
	private StringBuilder tempString;
	private TextPanel textPanel = null;
	private BooleanPanel specChars = null,extraNums = null;
	private Random randNum = new Random();
	
	
	/**
	 * Default constructor
	 */
	PasswordCreator(){
		basePassword = "password";
		newPassword = "password";
		setupPanel();
	}
	
	/**
	 * Constructor for allowing interaction with two BooleanPanels and a TextPanel
	 * @param newPanel - TextPanel, text panel for output of new password
	 * @param specialChars - Boolean, true-add special characters
	 * @param extraNums - Boolean, true-add extra numbers
	 */
	PasswordCreator(TextPanel newPanel, BooleanPanel specChars,BooleanPanel extraNums){
		basePassword = "password";
		newPassword = "password";
		textPanel = newPanel;
		this.specChars = specChars;
		this.extraNums = extraNums;
		setupPanel();
	}
	
	/**
	 * Constructor for interaction with a TextPanel
	 * @param newPanel - TextPanel, text panel for output of new password
	 */
	PasswordCreator(TextPanel newPanel){
		basePassword = "password";
		newPassword = "password";
		textPanel = newPanel;
		setupPanel();
	}
	
	/**
	 * Constructor for just setting the password
	 * @param password - String, base word to be converted into a new password
	 */
	PasswordCreator(String password){
		basePassword = password;
		newPassword = null;
		setupPanel();
	}
	
	/**
	 * Method to add the components to the panel
	 */
	private void setupPanel(){
		add(display);
		add(pwdText);
		pwdText.addActionListener(new PasswordListener());
	}
	
	/**
	 * Setter for the password
	 * @param password - String, base word to be converted into a new password
	 */
	public void setBasePassword(String password){
		basePassword = password;
	}
	
	/**
	 * mMthod for generating the new password
	 * @param specialChars - Boolean, true-add special characters
	 * @param extraNums - Boolean, true-add extra numbers
	 */
	private void createNewPassword(boolean specialChars,boolean extraNums){
		if(basePassword==null){
			tempString.append("No base word has been supplied");
		}else{
			tempString = new StringBuilder(basePassword);
			setCase();
			if(specialChars){
				addSpecialChars();
			}
			if(extraNums){
				addNumbers();
			}
		}
		
	}
	
	/**
	 * Method for randomly adding 1-3 random special characters
	 */
	private void addSpecialChars(){
		int control = randNum.nextInt(3)+1;
		for(int i =0;i<control;i++){
			tempString.append(Character.toChars(randNum.nextInt(15)+32));
		}
	}
	
	/**
	 * Method for randomly adding 1-3 numbers
	 */
	private void addNumbers(){
		int control = randNum.nextInt(3)+1;
		for(int i =0;i<control;i++){
			tempString.append(randNum.nextInt(10));
		}
	}
	
	/**
	 * Method for randomly setting the case or replacing characters with a new character.
	 * Characters that can be upper, lower, or a new character are a,i,e, & s.
	 */
	private void setCase(){
		for(int i=0; i<basePassword.length();i++){
			if(Character.isAlphabetic(basePassword.charAt(i))){
				if(Character.toLowerCase(basePassword.charAt(i))=='a'){
					switch(randNum.nextInt(3)){
					case 0: tempString.setCharAt(i,'a');
							break;
					case 1: tempString.setCharAt(i,'A');
							break;
					case 2: tempString.setCharAt(i, '@');
							break;					
					}						
				}else if(Character.toLowerCase(basePassword.charAt(i))=='i'){
					switch(randNum.nextInt(3)){
					case 0: tempString.setCharAt(i,'i');
							break;
					case 1: tempString.setCharAt(i,'I');
							break;
					case 2: tempString.setCharAt(i, '!');
							break;					
					}						
				}else if(Character.toLowerCase(basePassword.charAt(i))=='e'){
					switch(randNum.nextInt(3)){
					case 0: tempString.setCharAt(i,'e');
							break;
					case 1: tempString.setCharAt(i,'E');
							break;
					case 2: tempString.setCharAt(i, '3');
							break;					
					}						
				}else if(Character.toLowerCase(basePassword.charAt(i))=='s'){
					switch(randNum.nextInt(3)){
					case 0: tempString.setCharAt(i,'s');
							break;
					case 1: tempString.setCharAt(i,'S');
							break;
					case 2: tempString.setCharAt(i, '$');
							break;					
					}						
				}else{
					switch(randNum.nextInt(2)){
						case 0: tempString.setCharAt(i,Character.toUpperCase(basePassword.charAt(i)));
								break;
						case 1: tempString.setCharAt(i,Character.toLowerCase(basePassword.charAt(i)));
								break;						
					}
				}
			}
		}
	}
	
	/**
	 * Listener for new base password being entered
	 */
	private class PasswordListener implements ActionListener{
		
		public void actionPerformed(ActionEvent textIn){
			
			setBasePassword(pwdText.getText());
			createNewPassword(specChars.getStatus(),extraNums.getStatus());
			pwdText.setText("");
			if(textPanel!=null)
				textPanel.updateDisplay(tempString.toString());
		}
		
	}
	
	

}

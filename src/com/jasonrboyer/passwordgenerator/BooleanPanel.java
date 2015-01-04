
package com.jasonrboyer.passwordgenerator;

/**
 * @author Jason Boyer
 *
 *This class creates a panel for selecting two booleans.
 *
 */

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;


public class BooleanPanel extends JPanel{

	private Boolean firstRadio = false;
	private JLabel panelTitle = null;
	private JRadioButton first = null, second = null;
	private String firstLabel = null, secondLabel = null;
	private ButtonGroup radioGroup = new ButtonGroup();
	private GridBagConstraints layoutConstraints = new GridBagConstraints();
	private RadioListener listening = new RadioListener();
	
	/**
	 * Default Constructor sets everything to indicate that there has been no setup completed.
	 */
	BooleanPanel(){
		
		panelTitle = new JLabel("Not set.");
		String firstLabel = "Not set";
		String secondLabel = "Not Set";
		first = new JRadioButton("Not Set");
		second = new JRadioButton("Not Set");
		setUpPanel();

	}
	
	/**
	 * Default constructor with initial values provided
	 * @param panelTitle - String, label for the panel
	 * @param firstRadioLabel - String, label for the first radio button
	 * @param secondRadioLabel - String, label for the second radio button
	 * @param firstSet - Boolean, indicates if the first(true) or second(false) radio button is selected
	 */
	BooleanPanel(String panelTitle, String firstRadioLabel, String secondRadioLabel, Boolean firstSet){
		
		this.panelTitle= new JLabel(panelTitle);
		first = new JRadioButton(firstRadioLabel);
		second  = new JRadioButton(secondRadioLabel);
		this.firstRadio = firstSet;
		setUpPanel();
		
	}
	
	/**
	 * This method creates the panel layout
	 */
	private void setUpPanel(){
		
		setLayout(new GridBagLayout());
		//Setup Radio buttons: Add to group, set action listener, set initial toggle value
		radioGroup.add(first);
		radioGroup.add(second);
		first.addActionListener(listening);
		second.addActionListener(listening);
		
		if(firstRadio){
			first.setSelected(firstRadio);
		}else{
			second.setSelected(firstRadio);
		}
		
		//Place and arrange the label component in the panel
		layoutConstraints.gridx=0;
		layoutConstraints.gridy=0;
		
		//Two radio buttons are stacked, set this component to 2 high to balance the look of the components
		layoutConstraints.gridheight = 1;
		layoutConstraints.gridwidth = 2;
		layoutConstraints.anchor = GridBagConstraints.LINE_START;
		this.add(panelTitle,layoutConstraints);
		
		//Place and arrange the first radio button component in the panel
		layoutConstraints.gridy=1;
		layoutConstraints.gridwidth = 1;
		this.add(first,layoutConstraints);
		
		//Place and arrange the second radio button component in the panel		
		layoutConstraints.gridx=1;
		this.add(second,layoutConstraints);
		
	}
	
	/**
	 * Getter method firstRadio
	 * @return rirst radio
	 */
	public boolean getStatus(){
		return firstRadio;
	}
	
	
	/**
	 * Listener for the radio button events
	 */
	private class RadioListener implements ActionListener{
		
		public void actionPerformed(ActionEvent buttonChange){
			if(first.isSelected()){
				firstRadio=true;
			}if(second.isSelected()){
				firstRadio=false;
			}
			
		}
		
	}
}

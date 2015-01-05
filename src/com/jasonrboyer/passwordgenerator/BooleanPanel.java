
package com.jasonrboyer.passwordgenerator;

/**
 * @author Jason Boyer
 *
 *This class creates a panel for selecting two booleans.
 *
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class BooleanPanel extends JPanel{

	private Boolean firstRadio = false;
	private JLabel panelTitle = null, countTitle = new JLabel("Amount: ");
	private JRadioButton first = null, second = null;
	private String firstLabel = null, secondLabel = null;
	private ButtonGroup radioGroup = new ButtonGroup();
	private GridBagConstraints layoutConstraints = new GridBagConstraints();
	private RadioListener listening = new RadioListener();
	private JTextField count = new JTextField("",5);
	private int addOnCount = 0;
	
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
		count.addActionListener(new TextListener());
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
		
		//Add textbox label
		layoutConstraints.gridx=2;
		layoutConstraints.gridy=0;
		this.add(countTitle,layoutConstraints);
		
		//Add textbox
		layoutConstraints.gridx=2;
		layoutConstraints.gridy=1;
		this.add(count,layoutConstraints);
		
	}
	
	/**
	 * Getter method firstRadio
	 * @return first radio true means first radio button is toggled.
	 */
	public boolean getStatus(){
		return firstRadio;
	}
	
	/**
	 * Getter method addOnCount
	 * @return the value of the addOnCount video
	 */
	public int getAddOnCount(){
		return addOnCount;
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
	
	private class TextListener implements ActionListener{
		
		public void actionPerformed(ActionEvent textIn){
			try{
				addOnCount=Integer.parseInt(count.getText());
			}
			catch (NumberFormatException e){
				JOptionPane.showMessageDialog(null, "Error: Input was not an integer");
			}
			count.setText("");
		}
		
	}
}

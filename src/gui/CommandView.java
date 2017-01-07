package gui;

import logic.Controller;

import javax.swing.*;
import java.awt.event.*;


public class CommandView extends View implements ActionListener {
	Controller controller;
	JPanel jpanel;
	JTextArea jTxtArea;
	JTextField jTextField;
	JButton jButton;
	
	public CommandView() {
		jpanel = new JPanel();
		jTxtArea = new JTextArea();
		jTextField = new JTextField(20);
		jTxtArea.setText("Commando");
		jTxtArea.setEditable(false);
		jButton = new JButton("Uitvoeren");
		jButton.addActionListener(this);
		jpanel.add(jTxtArea);
		jpanel.add(jTextField);
		jpanel.add(jButton);
		jpanel.setSize(350,250);
		jpanel.setVisible(true);
		this.add(jpanel);
		this.setSize(350,250);
	}
	
	public void setController(Controller controller)
	{
		this.controller = controller;
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton)
		{
			if(controller != null)
			{
				controller.split(jTextField.getText());
			}
		}
	}

	@Override
	public void update(Controller controller) {
	}
}

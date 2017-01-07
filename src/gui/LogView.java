package gui;

import logic.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class LogView extends View {
	ArrayList<String> commands;
	JTextArea jTextArea;
	
	public LogView() {
		commands = new ArrayList<String>();
		jTextArea = new JTextArea();
		
		this.setLayout(new GridLayout(1,1));
		
		jTextArea.setSize(350, 250);
		jTextArea.setBackground(Color.BLACK);
		jTextArea.setForeground(Color.WHITE);
		jTextArea.setText("Commando's Uitgevoerd: \n");
		jTextArea.setEditable(false);
		jTextArea.setVisible(true);
		
		this.add(jTextArea);
		
		this.setSize(350,250);
		this.setVisible(true);
	}
	
	public void printLog(ArrayList<String> commands) {
		jTextArea.setText("Commando's Uitgevoerd: \n");
		if (commands.size() > 0) {
			int size = commands.size();
			for (int i = size-1; i >= 0; i--) {
				jTextArea.setText(jTextArea.getText() + commands.get(i) + "\n");
			}
		}
	}
	
	@Override
	public void update(Controller controller) {
				this.commands = controller.getLogcommands();
				printLog(commands);
	}

}

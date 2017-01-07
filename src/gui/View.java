package gui;

import logic.Controller;

import javax.swing.*;

public abstract class View extends JPanel {
	public View()
	{
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public abstract void update(Controller controller);
}

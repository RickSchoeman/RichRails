package gui;

import domain.SmallWagon;
import domain.*;
import logic.Controller;
import logic.LogWriter;
import logic.Writer;

import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args)
	{	
		JFrame f = new JFrame();
		f.setLayout(new GridLayout(2,1));
		f.setSize(1000, 700);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		p1.setLayout(new GridLayout(1,1));
		p2.setLayout(new GridLayout(2,1));

		Writer w = new LogWriter();
		
		Controller c = new Controller();
		
		View v1 = new GraphicView();
		View v2 = new ConsoleView();
		View v3 = new LogView();
		CommandView commandView = new CommandView();
		
		commandView.setController(c);
		
		p1.add(v1);
		p2.add(v2);
		p2.add(v3);
		p2.add(commandView);
		f.add(p1);
		f.add(p2);
		
		c.addWriter(w);
		c.addView(v1);
		c.addView(v2);
		c.addView(v3);
		c.addView(commandView);

		//Hier maken we een trein om te laten zien dat alle drie de soorten werken

		Train t = new EntireTrain("Train1");
		c.addTrain(t);

		t.addObserver(c);

		Wagon wagon1 = new Locomotive("Locomotive Train1");
		Wagon wagon2 = new BigWagon("Bigw");
		Wagon wagon3 = new SmallWagon("Smallw");
		c.addWagon(wagon1);
		c.addWagon(wagon2);
		c.addWagon(wagon3);
		t.addWagon(wagon1);
		t.addWagon(wagon2);
		t.addWagon(wagon3);
	}
}
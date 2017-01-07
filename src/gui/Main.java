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
		JFrame frame1 = new JFrame();
		frame1.setLayout(new GridLayout(2,1));
		frame1.setSize(1000, 700);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setVisible(true);
		
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		panel1.setLayout(new GridLayout(1,1));
		panel2.setLayout(new GridLayout(2,1));

		Writer writer = new LogWriter();
		
		Controller c = new Controller();
		
		View v1 = new GraphicView();
		View v2 = new ConsoleView();
		View v3 = new LogView();
		CommandView v4 = new CommandView();
		
		v4.setController(c);
		
		panel1.add(v1);
		panel2.add(v2);
		panel2.add(v3);
		panel2.add(v4);
		frame1.add(panel1);
		frame1.add(panel2);
		
		c.addWriter(writer);
		c.addView(v1);
		c.addView(v2);
		c.addView(v3);
		c.addView(v4);

		Train train1 = new EntireTrain("Train1");
		c.addTrain(train1);

		train1.addObserver(c);

		Wagon wagon1 = new Locomotive("Locomotive Train1");
		Wagon wagon2 = new BigWagon("Bigw");
		Wagon wagon3 = new SmallWagon("Smallw");

		c.addWagon(wagon1);
		c.addWagon(wagon2);
		c.addWagon(wagon3);

		train1.addWagon(wagon1);
		train1.addWagon(wagon2);
		train1.addWagon(wagon3);
	}
}
package gui;

import domain.Train;
import domain.Wagon;
import logic.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class ConsoleView extends View {
	ArrayList<Train> trainArrayList;
	ArrayList<Wagon> wagonArrayList;
	JTextArea jTextArea;

	public ConsoleView() {
		trainArrayList = new ArrayList<Train>();
		jTextArea = new JTextArea();
		this.setLayout(new GridLayout(1, 1));
		jTextArea.setSize(350, 250);
		jTextArea.setEditable(false);
		jTextArea.setVisible(true);
		this.add(jTextArea);
		this.setSize(350, 250);
		this.setVisible(true);
	}

	public void printText(ArrayList<Train> trains, ArrayList<Wagon> wagons) {
		
		String wagonsOutput = "";
		String trainsOutput = "";
		jTextArea.setText("");
		for (Wagon w : wagons) {
			wagonsOutput = wagonsOutput + "(" + w.getName() + ":"
			+ w.getSeats() + ") ";
		}
		for (Train t : trains) {
			trainsOutput = trainsOutput + "(" + t.getName() + ")";
			for (Wagon w : t.getWagons()) {
				trainsOutput = trainsOutput + "-(" + w.getName() + ")";
			}
			trainsOutput = trainsOutput + "\n";
		}
		jTextArea.setText("|Wagons|\n" + wagonsOutput + "\n|Trains|\n"
				+ trainsOutput);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Controller controller) {

		this.trainArrayList = controller.getTrains();
		this.wagonArrayList = controller.getWagons();
		printText(trainArrayList, wagonArrayList);

	}
}
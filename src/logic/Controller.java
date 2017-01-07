package logic;

import domain.Train;
import domain.Wagon;
import gui.*;
import commands.*;

import javax.swing.*;
import java.util.*;

public class Controller implements Observer {
	private ArrayList<View> views;
	private ArrayList<Train> trains = new ArrayList<>();
	private ArrayList<Wagon> wagons = new ArrayList<>();
	private ArrayList<Command> commands;
	private ArrayList<String> logcommands;
	private ArrayList<Writer> writers;

	public Controller() {
		this.views = new ArrayList<>();
		this.commands = new ArrayList<>();
		this.writers = new ArrayList<>();
		this.setLogcommands(new ArrayList<>());
	}

	public Controller(ArrayList<Command> commands) {
		this();
		this.commands = commands;
	}

	public ArrayList<Train> getTrains() {
		return trains;
	}

	public ArrayList<Wagon> getWagons() {
		return wagons;
	}

	public ArrayList<Command> getCommands() {
		return commands;
	}

	public ArrayList<String> getLogcommands() {
		return logcommands;
	}

	public void setLogcommands(ArrayList<String> logcommands) {
		this.logcommands = logcommands;
	}


	public void setCommands(ArrayList<Command> commands) {
		this.commands = commands;
	}

	public void addView(View view) {
		views.add(view);
	}

	public void addTrain(Train train) {
		trains.add(train);
		update();
	}

	public void removeTrain(Train train) {
		if (trains.contains(train)) {
			trains.remove(train);
			update();
		}
	}

	public void addWagon(Wagon wagon) {
		wagons.add(wagon);
		update();
	}

	public void removeWagon(Wagon wagon) {
		if (wagons.contains(wagon)) {
			wagons.remove(wagon);
			update();
		}
	}

	public void addWriter(Writer writer) {
		writers.add(writer);
	}

	public void addLogcommand(String logcommand) {
		logcommands.add(logcommand);
	}

		public void split(String commandString) {
			if (writers != null && writers.size() > 0) {
				for (Writer w : writers) {
					w.write(commandString);
				}
			}
			String[] word = commandString.split(" ");
			if (word[0].equals("new") || word[0].equals("add") || word[0].equals("remove")
					|| word[0].equals("delete") || word[0].equals("getnumseats")) {

					if (word[0].equals("new")) {
						if (word[1].equals("train")) {
							CreateTrain ct = new CreateTrain();
							ct.setTrain(word[2].substring(0, word[2].length()));
							ct.execute(this);
						}
	
						else {
							if (word[1].equals("wagon")) {
								try {
									if (word[3].equals("numseats")) {
										CreateWagonSeats cws = new CreateWagonSeats();
										cws.setWagon(word[2]);
										cws.setSeats(Integer.parseInt(word[4].substring(0, word[4].length())));
										cws.execute(this);
									}
								}
								catch(Exception e){
									CreateWagon cw = new CreateWagon();
									cw.setWagon(word[2].substring(0, word[2].length()));
									cw.execute(this);
								}
							}
							
							else if (word[1].equals("smallwagon")) {
								CreateSmallWagon cew = new CreateSmallWagon();
								cew.setWagon(word[2].substring(0, word[2].length()));
								cew.execute(this);
							}
						}
					}
	
					else if (word[0].equals("getnumseats")) {
						Seats s = new Seats();
						if (word[1].equals("wagon")) {
							s.setWagon(word[2].substring(0, word[2].length()));
							s.execute(this);
						} 
						else if (word[1].equals("train")) {
							s.setTrain(word[2].substring(0, word[2].length()));
							s.execute(this);
						}
					} else if (word[0].equals("add")) {
						AddWagonToTrain awtt = new AddWagonToTrain();
						awtt.setWagon(word[1]);
						awtt.setTrain(word[3].substring(0, word[3].length()));
						awtt.execute(this);
					} else if (word[0].equals("delete")) {
						if (word[1].equals("train")) {
							DeleteTrain dt = new DeleteTrain();
							dt.setTrain(word[2].substring(0, word[2].length()));
							dt.execute(this);
						} else if (word[1].equals("wagon")) {
							DeleteWagon dw = new DeleteWagon();
							dw.setWagon(word[2].substring(0, word[2].length()));
							dw.execute(this);
						}
					} else if (word[0].equals("remove")) {
						RemoveWagonFromTrain rwft = new RemoveWagonFromTrain();
						rwft.setWagon(word[1]);
						rwft.setTrain(word[3].substring(0, word[3].length()));
						rwft.execute(this);

					}

			} else
				JOptionPane
						.showMessageDialog(null,
								"Ongeldig commando. Bekende commando's zijn: add, remove, delete, getnumseats ");
		}

	@Override
	public void update() {
		for (View v : views) {
			v.update(this);
		}
	}
}

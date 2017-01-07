package commands;

import logic.Controller;
import domain.*;

public class Seats extends Command {

	private String tName;
	private String wName;
	private String sString;
	
	public void execute(Controller c) {
		int seats = 0;
		if(wName == null){
			for(Train t : c.getTrains()){
				if(t.getName().equals(tName)){
					for(Wagon w :t.getWagons()){
						seats += w.getSeats();
					}
					c.addLogcommand("number of seats in train " + t.getName() + ": "+ seats);
					c.update();
				}
			}
		}
		else{
			for(Wagon wa : c.getWagons()){
				if(wa.getName().equals(wName)){
					seats = wa.getSeats();
					c.addLogcommand("number of seats in wagon " + wa.getName() + ": "+ seats);
					c.update();
				}
			}
		}
	}
	
	public String getSeatString(){
		return sString;
	}
	
	void seatText(String s){
		sString = "number of seats in " + s;
	}
	
	public void setTrain(String t) {this.tName = t;	}
	public String getTrain() {		return tName;	}
	public void setWagon(String w) {		this.wName = w;	}
	public String getWagon() {		return wName;	}

}

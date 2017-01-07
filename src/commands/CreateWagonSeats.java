package commands;

import logic.Controller;
import domain.*;

public class CreateWagonSeats extends Command {

	private String wName;
	private int seats;

	public String getWagon(){ return wName; }
	public void setWagon(String w){ this.wName = w; }

	@Override
	public void execute(Controller c) {
		NormalWagon nWagon = new NormalWagon(wName,seats);
		c.addLogcommand("wagon " + wName + " created with " + seats + " seats");
		c.addWagon(nWagon);
	}
	public void setSeats(int seats) {
		this.seats = seats;
	}
	public int getSeats() {
		return seats;
	}

}

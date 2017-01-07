package commands;

import logic.Controller;
import domain.*;


public class CreateWagon extends Command {

	private String wName;

	public String getWagon(){ return wName; }
	public void setWagon(String w){ this.wName = w; }

	@Override
	public void execute(Controller c) {
		NormalWagon nWagon = new NormalWagon(wName, 20);
		c.addLogcommand("wagon " + wName + " created with 20 seats");
		c.addWagon(nWagon);
	}

}

package commands;

import domain.EndWagon;
import logic.Controller;

public class CreateEndWagon extends Command{
	
	private String wName;

	public String getWagon(){ return wName; }
	public void setWagon(String w){ this.wName = w; }

	@Override
	public void execute(Controller c) {
		EndWagon end = new EndWagon(wName, 20);
		c.addLogcommand("endwagon " + wName + " created with 20 seats");
		c.addWagon(end);
	}
}

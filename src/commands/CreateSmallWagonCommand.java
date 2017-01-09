package commands;

import domain.SmallWagon;
import logic.Controller;

public class CreateSmallWagonCommand extends Command{
	
	private String wName;

	public String getWagon(){ return wName; }
	public void setWagon(String w){ this.wName = w; }

	@Override
	public void execute(Controller c) {
		SmallWagon end = new SmallWagon(wName, 20);
		c.addLogcommand("smallwagon " + wName + " created with 20 seats");
		c.addWagon(end);
	}
}

package commands;

import logic.Controller;
import domain.*;

public class AddWagonToTrain extends Command {

	private String wName;
	private String tName;

	public String getWagon(){ return wName; }
	public String getTrain(){ return tName; }
	public void setWagon(String w){ this.wName = w; }
	public void setTrain(String t){ this.tName = t; }

	@Override
	public void execute(Controller c) {
		boolean error1 = false;
		boolean error2 = false;
		for(Train t : c.getTrains()){
			if(t.getName().equals(tName)){
				for(Wagon wObject : c.getWagons()){
					if(wObject.getName().equals(wName)){
						t.addWagon(wObject);
						c.addLogcommand("wagon " + wName + " added to train " + tName);
						error1 = false;
						error2 = false;
						break;
					}else{
						error1 = true;
					}
				}				
			}else{
				error2 = true;
			}
		}
		if(error1)
		{
			c.addLogcommand("error: wagon " + wName + " does not exist and cannot be added to " + tName);
		}else if(error2)
		{
			c.addLogcommand("error: train " + tName + " does not exist");
		}
		c.update();
	}

}

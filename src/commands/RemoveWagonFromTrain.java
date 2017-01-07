package commands;

import logic.Controller;
import domain.*;

public class RemoveWagonFromTrain extends Command {

	private String wName;
	private String tName;

	public String getWagon(){ return wName; }
	public String getTrain(){ return tName; }
	public void setWagon(String w){ this.wName = w; }
	public void setTrain(String t){ this.tName = t; }

	@Override
	public void execute(Controller c) {
		boolean error = false;
		for(Train t : c.getTrains()){
			if(t.getName().equals(tName)){
				for(Wagon w : t.getWagons()){
					if(w.getName().equals(wName)){
						t.removeWagon(w);
						c.addLogcommand("wagon " + wName + " was removed from train " + tName);
						error = false;
						break;
					}else{
						error = true;
					}
				}				
			}			
		}
		if(error)
		{
			c.addLogcommand("error: train " + tName + " does not contain " + wName);
		}
		
		c.update();
	}

}

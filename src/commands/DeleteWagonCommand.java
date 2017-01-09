package commands;

import logic.Controller;
import domain.*;

public class DeleteWagonCommand extends Command {

	private String wName;

	public String getWagon() {
		return wName;
	}

	public void setWagon(String w) {
		this.wName = w;
	}

	@Override
	public void execute(Controller c) {
		for (Wagon w : c.getWagons()) {
			if (w.getName().equals(wName)) {
				c.removeWagon(w);
				c.addLogcommand("wagon " + wName + " deleted");
				c.update();
				break;
			}
			else if (c.getWagons().indexOf(w) == (c.getWagons().size() - 1)) {
				c.addLogcommand("wagon " + wName + " does not exist");
				c.update();
				System.out.println("Wagon does not exist");
			}
		for(Train train : c.getTrains()){
			for(Wagon wa : train.getWagons()){
				if(wa.getName().equals(this.wName)){
					train.removeWagon(wa);
				}
			}
		}
		}
		
	}
}

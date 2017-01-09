package commands;

import logic.Controller;
import domain.*;

public class DeleteTrainCommand extends Command {

	private String tName;

	@Override
	public void execute(Controller c) {
		for (Train t : c.getTrains()) {
			if (t.getName().equals(tName)) {
				c.addLogcommand("train " + tName + " deleted");
				c.removeTrain(t);
				c.removeWagon(t.getWagons().get(0));
				break;
			}
			else if (c.getTrains().indexOf(t) == (c.getTrains().size() - 1)) {
				c.addLogcommand("train " + tName + " does not exist");
				c.update();
			}
		}
	}

	public void setTrain(String t) {
		this.tName = t;
	}

	public String getTrain() {
		return tName;
	}

}

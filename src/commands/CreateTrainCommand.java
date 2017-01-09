package commands;
import logic.Controller;
import domain.*;

public class CreateTrainCommand extends Command {
	
	private String tName;

	@Override
	public void execute(Controller c) {
		EntireTrain t = new EntireTrain(tName);
		Locomotive l = new Locomotive("Locomotive " + tName);
		c.addLogcommand("train " + tName + " created");
		t.addWagon(l);
		c.addWagon(l);
		c.addTrain(t);
	}

	public void setTrain(String t) {
		this.tName = t;
	}

	public String getTrain() {
		return tName;
	}

}

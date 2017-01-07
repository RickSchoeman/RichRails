package domain;

import java.util.*;

public class EntireTrain extends Train {

	
	public EntireTrain(String name) {
		super(name);
	}
	
	public EntireTrain(String name, ArrayList<Wagon> wagons)
	{
		super(name, wagons);
	}
	
}

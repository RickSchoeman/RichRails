package domain;

import java.util.*;

public class NormalTrain extends Train {

	
	public NormalTrain(String name) {
		super(name);
	}
	
	public NormalTrain(String name, ArrayList<Wagon> wagons)
	{
		super(name, wagons);
	}
	
}

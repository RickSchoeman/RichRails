package domain;

import logic.Observer;
import logic.Subject;

import java.util.*;

public abstract class Train implements Subject {
	protected String name;
	private ArrayList<Wagon> wagons = new ArrayList<>();
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public Train()
	{
		this.name = "";
		this.wagons = new ArrayList<>();
	}
	
	public Train(String name)
	{
		this();
		this.name = name;
		this.wagons = new ArrayList<>();
	}
	
	public Train(String name, ArrayList<Wagon> wagons)
	{
		this(name);
		this.wagons = wagons;
	}
	
	public String getName()
	{
		return name;
	}

	public ArrayList<Wagon> getWagons()
	{
		return wagons;
	}
	
	public void addWagon(Wagon wagon)
	{
		this.wagons.add(wagon);
		notifyObservers();
	}
	
	public void removeWagon(Wagon wagon)
	{
		if(wagons.contains(wagon))
		{
			wagons.remove(wagon);
			notifyObservers();
		}
	}
	
	public void addObserver(Observer observer)
	{
		observers.add(observer);
	}
	
	public void removeObserver(Observer observer)
	{
		observers.remove(observer);
	}
	
	public void notifyObservers()
	{
		for(Observer observer : observers)
		{
			observer.update();
		}
	}

	@Override
	public String toString() {
		return "Train [name=" + name + ", wagons="
				+ wagons + "]";
	}
	
	
}

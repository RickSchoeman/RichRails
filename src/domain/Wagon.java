package domain;

import logic.Observer;
import logic.Subject;

import java.awt.*;
import java.util.*;

public abstract class Wagon implements Subject {
	protected String name;
	protected int seats;
	private ArrayList<Observer> observers = new ArrayList<>();
	
	public Wagon(){
		this.name = "";
		this.seats = 20;
	}
	
	public Wagon(String name)
	{
		this();
		this.name = name;
	}
	
	public Wagon(String name, int seats)
	{
		this(name);
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public int getSeats() {
		return seats;
	}
	
	public abstract void draw(Graphics g, int x, int y);
	
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
		return "Wagon [name=" + name + ", seats=" + seats + "]";
	}
}

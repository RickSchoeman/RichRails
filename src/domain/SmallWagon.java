package domain;

import java.awt.*;

public class SmallWagon extends Wagon {

	public SmallWagon(){
		super();
	}
	
	public SmallWagon(String name)
	{
		super(name);
	}
	
	public SmallWagon(String name, int seats)
	{
		super(name, seats);
	}
	
	@Override
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.GRAY);
		g.fillRect(x, (y+25), 120, 5);
		g.fillRect((x+5), (y+30), 110, 45);
		g.setColor(Color.DARK_GRAY);
		g.fillOval((x+5), (y+75), 30, 30);
		g.fillOval((x+85), (y+75), 30, 30);
		g.setColor(Color.WHITE);
		g.drawString(name, (x+10), (y+50));
		
	}

}

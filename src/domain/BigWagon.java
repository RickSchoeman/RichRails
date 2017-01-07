package domain;

import java.awt.*;

public class BigWagon extends Wagon {
	
	public BigWagon()
	{
		super();
	}
	
	public BigWagon(String name)
	{
		super(name);
	}
	
	public BigWagon(String name, int seats) {
		super(name, seats);
	}

	@Override
	public void draw(Graphics g, int x, int y) {
		g.setColor(Color.GRAY);
		g.fillRect(x, y, 120, 5);
		g.fillRect((x+5), (y+5), 110, 70);
		g.setColor(Color.DARK_GRAY);
		g.fillOval((x+5), (y+75), 30, 30);
		g.fillOval((x+85), (y+75), 30, 30);
		g.setColor(Color.WHITE);
		g.drawString(name, (x+10), (y+50));
	}
}
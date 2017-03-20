import	java.awt.*;
import	javax.swing.*;

public class Bamboo
{
	private Color c;
	private int x;
	private int y;

	public Bamboo(Color c, int x, int y)
	{
		this.c = c;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillRect(this.x, this.y, 7, 35);
		g.fillRect(this.x+8, this.y, 2, 35);
		//top coin
		g.fillOval(this.x-4, this.y-2, 15, 8);
		//middle coin
		g.fillOval(this.x-4, this.y-5+(35/2), 15, 8);
		//bottom coin
		g.fillOval(this.x-4, this.y+35-8, 15, 8);
	}
}

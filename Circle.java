import	java.awt.*;
import	javax.swing.*;

public class Circle
{
	private Color c;
	private int x;
	private int y;

	public Circle(Color c, int x, int y)
	{
		this.c = c;
		this.x = x;
		this.y = y;
	}

	public void draw(Graphics g)
	{
		g.setColor(c);
		g.fillOval(this.x, this.y, 16, 16);

		g.setColor(Color.WHITE);
		g.fillOval(this.x+2, this.y+2, 12, 12);

		g.setColor(c);
		g.fillOval(this.x+4, this.y+4, 8, 8);
	}
}

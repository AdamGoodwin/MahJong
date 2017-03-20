import	java.awt.*;
import	javax.swing.*;

public class Pancake
{
	public void draw(Graphics g)
	{
		//green background
		g.setColor(Color.GREEN);
		g.fillOval( 25, 30, 70, 70);

		//outside line
		g.setColor(Color.BLACK);
		g.drawOval(25, 30, 70, 70);

		//repeating pattern time......
		g.setColor(Color.WHITE);
		g.fillOval(57, 35, 6, 6);
		g.fillOval(57, 90, 6, 6);

		g.fillOval(57, 35, 6, 6);
		g.fillOval(57, 90, 6, 6);
	}
}

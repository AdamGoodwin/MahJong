import	java.awt.*;
import	javax.swing.*;
import	java.io.*;
import  java.util.*;
public class WhiteDragonTile extends Tile
{
	public String getDescStr()
	{
		return "WD";
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		g.setColor(Color.BLUE);
		//top	(10 Long, 10 wide & 10 between.
		g.fillRect(25, 30, 10, 10);
		g.fillRect(45, 30, 10, 10);
		g.fillRect(65, 30, 10, 10);
		g.fillRect(85, 30, 10, 10);

		//left 3
		g.fillRect(25, 50, 10, 10);
		g.fillRect(25, 70, 10, 10);

		//right 3
		g.fillRect(85, 50, 10, 10);
		g.fillRect(85, 70, 10, 10);

		//bottom 3
		g.fillRect(25, 90, 10, 10);
		g.fillRect(45, 90, 10, 10);
		g.fillRect(65, 90, 10, 10);
		g.fillRect(85, 90, 10, 10);

		g.setColor(Color.BLACK);

		//Square outline.
		g.drawRect(25, 30, 70, 70);
		g.drawRect(35, 40, 50, 50);

		//top	(10 Long, 10 wide & 10 between.
		g.drawRect(25, 30, 10, 10);
		g.drawRect(45, 30, 10, 10);
		g.drawRect(65, 30, 10, 10);
		g.drawRect(85, 30, 10, 10);

		//left 3
		g.drawRect(25, 50, 10, 10);
		g.drawRect(25, 70, 10, 10);

		//right 3
		g.drawRect(85, 50, 10, 10);
		g.drawRect(85, 70, 10, 10);

		//bottom 3
		g.drawRect(25, 90, 10, 10);
		g.drawRect(45, 90, 10, 10);
		g.drawRect(65, 90, 10, 10);
		g.drawRect(85, 90, 10, 10);

	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("White Dragon Tile");

		frame.add(new WhiteDragonTile());

		frame.pack();
		frame.setVisible(true);
	}
}

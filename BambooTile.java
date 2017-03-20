import	java.awt.*;
import	javax.swing.*;

public class BambooTile extends Tile
{
	private int num;
	
	public String getDescStr()
	{
		return "BB" + this.num;
	}

	public BambooTile(int num)
	{
		this.num = num;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		
		
		switch(num)
		{
			case 2:
				//left Column
				new Bamboo(Color.GREEN, 55, 70).draw(g);
				new Bamboo(Color.BLUE, 55, 30).draw(g);
				break;
			case 3:
				//left Column
				new Bamboo(Color.GREEN, 30, 70).draw(g);

				//middle Column
				new Bamboo(Color.BLUE, 55, 30).draw(g);

				//Right Column
				new Bamboo(Color.GREEN, 80, 70).draw(g);
				break;
			case 4:
				//left Column
				new Bamboo(Color.BLUE, 30, 30).draw(g);
				new Bamboo(Color.GREEN, 30, 70).draw(g);

				//Right Column
				new Bamboo(Color.GREEN, 80, 30).draw(g);
				new Bamboo(Color.BLUE, 80, 70).draw(g);
				break;
			case 5:
				//left Column
				new Bamboo(Color.GREEN, 30, 30).draw(g);
				new Bamboo(Color.BLUE, 30, 70).draw(g);

				//middle Column
				new Bamboo(Color.RED, 55, 48).draw(g);

				//Right Column
				new Bamboo(Color.BLUE, 80, 30).draw(g);
				new Bamboo(Color.GREEN, 80, 70).draw(g);
				break;
			case 6:
				//left Column
				new Bamboo(Color.GREEN, 30, 30).draw(g);
				new Bamboo(Color.BLUE, 30, 70).draw(g);

				//middle Column
				new Bamboo(Color.GREEN, 55, 30).draw(g);
				new Bamboo(Color.BLUE, 55, 70).draw(g);

				//Right Column
				new Bamboo(Color.GREEN, 80, 30).draw(g);
				new Bamboo(Color.BLUE, 80, 70).draw(g);
				break;
			case 7:
				//left Column
				new Bamboo(Color.GREEN, 30, 48).draw(g);
				new Bamboo(Color.GREEN, 30, 88).draw(g);

				//middle Column
				new Bamboo(Color.RED, 55, 8).draw(g);
				new Bamboo(Color.BLUE, 55, 48).draw(g);
				new Bamboo(Color.BLUE, 55, 88).draw(g);

				//Right Column
				new Bamboo(Color.GREEN, 80, 48).draw(g);
				new Bamboo(Color.GREEN, 80, 88).draw(g);
				break;
			case 8:
				//left Column
				new Bamboo(Color.GREEN, 30, 8).draw(g);
				new Bamboo(Color.RED, 40, 48).draw(g);
				new Bamboo(Color.BLUE, 30, 88).draw(g);

				//middle Column
				new Bamboo(Color.GREEN, 55, 8).draw(g);
				new Bamboo(Color.RED, 70, 48).draw(g);
				new Bamboo(Color.BLUE, 55, 88).draw(g);

				//Right Column
				new Bamboo(Color.GREEN, 80, 8).draw(g);
				new Bamboo(Color.BLUE, 80, 88).draw(g);
				break;
			case 9:
				//left Column
				new Bamboo(Color.RED, 30, 8).draw(g);
				new Bamboo(Color.RED, 30, 48).draw(g);
				new Bamboo(Color.RED, 30, 88). draw(g);

				//middle Column
				new Bamboo(Color.BLUE, 55, 8).draw(g);
				new Bamboo(Color.BLUE, 55, 48).draw(g);
				new Bamboo(Color.BLUE, 55, 88).draw(g);

				//Right Column
				new Bamboo(Color.GREEN, 80, 8).draw(g);
				new Bamboo(Color.GREEN, 80, 48).draw(g);
				new Bamboo(Color.GREEN, 80, 88).draw(g);
				break;
		}

		setToolTipText("Bamboo " + this.num);
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Bamboo Tiles");

		frame.add(new BambooTile(2));
		frame.add(new BambooTile(3));
		frame.add(new BambooTile(4));
		frame.add(new BambooTile(5));
		frame.add(new BambooTile(6));
		frame.add(new BambooTile(7));
		frame.add(new BambooTile(8));
		frame.add(new BambooTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}

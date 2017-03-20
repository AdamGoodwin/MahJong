import	java.awt.*;
import	javax.swing.*;

public class CircleTile extends Tile
{
	private int num;

	public CircleTile(int num)
	{
		this.num = num;
	}
	
	public String getDescStr()
	{
		return "CR" + this.num;
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		switch(num)
		{
			case 1:
				new Pancake().draw(g);
				new Circle(Color.RED, 52, 56).draw(g);
				break;
			case 2: //2c
				//left Column
				new Circle(Color.GREEN, 55, 38).draw(g);
				new Circle(Color.RED, 55, 78).draw(g);
				break;
			case 3: //2c
				//left Column
				new Circle(Color.BLUE, 30, 38).draw(g);
				//middle Column
				new Circle(Color.RED, 55, 56).draw(g);
				//Right Column
				new Circle(Color.GREEN, 80, 78).draw(g);
				break;
			case 4: //2c
				//left Column
				new Circle(Color.BLUE, 30, 38).draw(g);
				new Circle(Color.GREEN, 30, 78).draw(g);
				//Right Column
				new Circle(Color.GREEN, 80, 38).draw(g);
				new Circle(Color.BLUE, 80, 78).draw(g);
				break;
			case 5: //2c
				//left Column
				new Circle(Color.BLUE, 30, 38).draw(g);
				new Circle(Color.GREEN, 30, 78).draw(g);
				//middle Column
				new Circle(Color.RED, 55, 56).draw(g);
				//Right Column
				new Circle(Color.GREEN, 80, 38).draw(g);
				new Circle(Color.BLUE, 80, 78).draw(g);
				break;
			case 6: //2c
				//Row 1
				new Circle(Color.GREEN, 40, 16).draw(g);
				new Circle(Color.GREEN, 70, 16).draw(g);
				//Row 2
				new Circle(Color.RED, 40, 56).draw(g);
				new Circle(Color.RED, 70, 56).draw(g);
				//Row 3 96
				new Circle(Color.RED, 40, 96).draw(g);
				new Circle(Color.RED, 70, 96).draw(g);
				break;
			case 7: //2c
				//Row 1
				new Circle(Color.GREEN, 30, 16).draw(g);
				new Circle(Color.GREEN, 55, 24).draw(g);
				new Circle(Color.GREEN, 80, 32).draw(g);
				//Row 2
				new Circle(Color.RED, 40, 56).draw(g);
				new Circle(Color.RED, 70, 56).draw(g);
				//Row 3 96
				new Circle(Color.RED, 40, 96).draw(g);
				new Circle(Color.RED, 70, 96).draw(g);
				break;
			case 8: //2c
				//Row 1
				new Circle(Color.BLUE, 40, 7).draw(g);
				new Circle(Color.BLUE, 70, 7).draw(g);
				//Row 2
				new Circle(Color.BLUE, 40, 41).draw(g);
				new Circle(Color.BLUE, 70, 41).draw(g);
				//Row 3
				new Circle(Color.BLUE, 40, 75).draw(g);
				new Circle(Color.BLUE, 70, 75).draw(g);
				//Row 4
				new Circle(Color.BLUE, 40, 109).draw(g);
				new Circle(Color.BLUE, 70, 109).draw(g);
				break;
			case 9: //2c
				//left Column
				new Circle(Color.RED, 30, 16).draw(g);
				new Circle(Color.RED, 30, 56).draw(g);
				new Circle(Color.RED, 30, 96). draw(g);
				//middle Column
				new Circle(Color.BLUE, 55, 16).draw(g);
				new Circle(Color.BLUE, 55, 56).draw(g);
				new Circle(Color.BLUE, 55, 96).draw(g);
				//Right Column
				new Circle(Color.GREEN, 80, 16).draw(g);
				new Circle(Color.GREEN, 80, 56).draw(g);
				new Circle(Color.GREEN, 80, 96).draw(g);
				break;
		}
		setToolTipText("Circle " + this.num);
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Circle Tiles");

		frame.add(new CircleTile(1));
		frame.add(new CircleTile(2));
		frame.add(new CircleTile(3));
		frame.add(new CircleTile(4));
		frame.add(new CircleTile(5));
		frame.add(new CircleTile(6));
		frame.add(new CircleTile(7));
		frame.add(new CircleTile(8));
		frame.add(new CircleTile(9));

		frame.pack();
		frame.setVisible(true);
	}
}

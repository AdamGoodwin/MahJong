import	java.awt.*;
import	javax.swing.*;

public class Tile extends JPanel
{
	private	static	final	Dimension	SIZE = new Dimension(101, 151);
	private int x;
	private int y;
	private int z;
	//public	static	final	Dimension	SIZE = new Dimension(w, h);

	public Tile()
	{
		setPreferredSize(SIZE);
		setSize(SIZE.width, SIZE.height);
		setOpaque(false);
	}
	
	public void setLoc(int x, int y, int z)
	{
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	//public int getPos()
	//{
	//	return this.pos;
	//}

	//public void setZ(int z)
	//{
	//	this.z = z;
	//}
	
	public int getXLoc()
	{
		return this.x;
	}
	
	public int getYLoc()
	{
		return this.y;
	}
	
	public int getZLoc()
	{
		return this.z;
	}
	
	public String getString()
	{
		return "TILE";
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);

		Graphics2D g2 = (Graphics2D)g;

		//Fill Primary Tile.
		GradientPaint G2G = new GradientPaint (20F, 130F, new Color(214, 214, 214), 150F, 0F, new Color(150, 150, 150), true);
		g2.setPaint(G2G);
		g.fillRect(20, 0, 80, 130);

		//Top Gradient
		G2G = new GradientPaint (10F, 140F, new Color(214, 214, 214), 20F, 0F, new Color(150, 150, 150), true);
		g2.setPaint(G2G);
		g2.fillPolygon(new int[]{10,20,20,10}, new int[]{10,0,130,140}, 4);
		GradientPaint ABQ = new GradientPaint (10F, 140F, new Color(255, 160, 122), 20F, 0F, new Color(0, 128, 128), true);
		g2.setPaint(ABQ);
		g.fillPolygon(new int[]{0,10,10,0}, new int[]{150,140,10,20}, 4);

		G2G = new GradientPaint (10F, 140F, new Color(214, 214, 214), 150F, 130F, new Color(150, 150, 150), true);
		g2.setPaint(G2G);
		g.fillPolygon(new int[]{100,100,20,10}, new int[]{140,130,130,140}, 4);
		ABQ = new GradientPaint (10F, 140F, new Color(255, 160, 122), 150F, 130F, new Color(0, 128, 128), true);
		g2.setPaint(ABQ);
		g.fillPolygon(new int[]{0,10,100,100}, new int[]{150,140,140,150}, 4);


		//DRAW LINES
		g.setColor(Color.BLACK);
		g.drawRect(20, 0, 80, 130);
		//top side
		g.drawPolygon(new int[]{10,20,20,10}, new int[]{10,0,130,140}, 4);
		//top bottom
		g.drawPolygon(new int[]{100,100,20,10}, new int[]{140,130,130,140}, 4);
		//bottom side
		g.drawPolygon(new int[]{0,10,10,0}, new int[]{150,140,10,20}, 4);
		//bottom bottom
		g.drawPolygon(new int[]{0,10,100,100}, new int[]{150,140,140,150}, 4);

	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Tile");

		frame.add(new Tile());

		frame.pack();
		frame.setVisible(true);
	}
}

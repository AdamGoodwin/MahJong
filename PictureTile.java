import	java.awt.*;
import	javax.swing.*;
import	java.io.*;
import  java.util.*;
import	java.net.*;
public class PictureTile extends Tile
{
	private String s;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		URL imgURL = getClass().getClassLoader().getResource("images/" + this.s + ".png");
		ImageIcon image = new ImageIcon(imgURL);

		g2.drawImage(image.getImage(), ((getWidth()-image.getIconWidth())/2)+10, ((getHeight()-image.getIconHeight())/2)-10, this); //getWidth() //getHeight()
		setToolTipText(this.s);
	}

	public String getDescStr()
	{
		if(this.s == "Spring" || this.s =="Summer" || this.s == "Fall" || this.s == "Winter")
			return "SEASON";
		if(this.s == "Chrysanthemum" || this.s =="Orchid" || this.s == "Plum" || this.s == "Bamboo")
			return "FLOWER";
		if(this.s == "Bamboo 1")
			return "BB1";
		return "PIC";
	}
	
	
	public PictureTile(String s)
	{
		this.s = s;
	}

	public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Picture Tiles");

		frame.add(new PictureTile("Bamboo 1"));
		frame.add(new PictureTile("Chrysanthemum"));
		frame.add(new PictureTile("Orchid"));
		frame.add(new PictureTile("Plum"));
		frame.add(new PictureTile("Bamboo"));
		frame.add(new PictureTile("Spring"));
		frame.add(new PictureTile("Summer"));
		frame.add(new PictureTile("Fall"));
		frame.add(new PictureTile("Winter"));

		frame.pack();
		frame.setVisible(true);
	}
}

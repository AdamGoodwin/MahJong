
/**
 * @(#)CharacterTile.java
 *
 *
 * @author 
 * @version 1.00 2011/10/8
 */

import java.awt.*;
import javax.swing.*;
public class CharacterTile extends Tile
{
	private char rank;
	
    public CharacterTile(char rank)
    {
    	this.rank = rank;
    }
    
    public String getString()
    {
    	return "Character" + rank;
    }
    
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	
    	g.setColor(Color.RED);
    	g.drawString("" + rank, 58, 22);
    	
    	Font f = g.getFont();
		f = f.deriveFont(f.getSize2D() * 2.5F);
		g.setFont(f);
		
		FontMetrics fm = g.getFontMetrics();
		int width;
		int height = 75;
		int wid;
    	
    	switch(rank)
    	{
    		case '1': 
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u4E00");
    			g.drawString("\u4E00", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '2': 
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u4E8C");
    			g.drawString("\u4E8C", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '3': 
    			g.setColor(Color.BLACK);
    			
    			width = fm.stringWidth("\u4E09");
    			g.drawString("\u4E09", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '4':
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u56DB");
    			g.drawString("\u56DB", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '5': 
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u4E94");
    			g.drawString("\u4E94", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '6':
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u516D");
    			g.drawString("\u516D", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '7':
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u4E03");
    			g.drawString("\u4E03", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '8':
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u516B");
    			g.drawString("\u516B", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case '9':
    			g.setColor(Color.BLACK);
				
    			width = fm.stringWidth("\u4E5D");
    			g.drawString("\u4E5D", (70-width)/2, 50);
    			
    			g.setColor(Color.RED);
    			wid = fm.stringWidth("\u842C");
    			g.drawString("\u842C", (70-wid)/2, 85);
    			setToolTipText("Character " + rank);
    			break;
    		case 'N': 
    			g.setColor(Color.BLACK);
    			f = f.deriveFont(f.getSize2D() * 2F);
				g.setFont(f);
				
				width = fm.stringWidth("\u5317");
    			g.drawString("\u5317", ((70-width)-25)/2, height);
    			setToolTipText("Character " + rank);
    			break;
    		case 'E': 
    			g.setColor(Color.BLACK);
    			f = f.deriveFont(f.getSize2D() * 2F);
				g.setFont(f);
				
				width = fm.stringWidth("\u6771");
    			g.drawString("\u6771", ((70-width)-25)/2, height);
    			setToolTipText("Character " + rank);
    			break;
    		case 'W': 
    			g.setColor(Color.BLACK);
    			f = f.deriveFont(f.getSize2D() * 2F);
				g.setFont(f);
				
				width = fm.stringWidth("\u897F");
    			g.drawString("\u897F", ((70-width)-25)/2, height);
    			setToolTipText("Character " + rank);
    			break;
    		case 'S': 
    			g.setColor(Color.BLACK);
    			f = f.deriveFont(f.getSize2D() * 2F);
				g.setFont(f);
				
				width = fm.stringWidth("\u5357");
    			g.drawString("\u5357", ((70-width)-25)/2, height);
    			setToolTipText("Character " + rank);
    			break;
    		case 'C':
    			g.setColor(Color.RED);
    			f = f.deriveFont(f.getSize2D() * 2F);
				g.setFont(f);
				
				width = fm.stringWidth("\u4E2D");
    			g.drawString("\u4E2D", ((70-width)-25)/2, height);
    			setToolTipText("Character " + rank);
    			break;
    		case 'F':
    			g.setColor(Color.GREEN);
    			f = f.deriveFont(f.getSize2D() * 2F);
				g.setFont(f);
				
				width = fm.stringWidth("\u767C");
    			g.drawString("\u767C", ((70-width)-25)/2, height);
    			setToolTipText("Character " + rank);
    			break;
    	}
    }
    
    public static void main(String[] args)
	{
		JFrame	frame = new JFrame();

		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Character Tiles");

		frame.add(new CharacterTile('1'));
		frame.add(new CharacterTile('2'));
		frame.add(new CharacterTile('3'));
		frame.add(new CharacterTile('4'));
		frame.add(new CharacterTile('5'));
		frame.add(new CharacterTile('6'));
		frame.add(new CharacterTile('7'));
		frame.add(new CharacterTile('8'));
		frame.add(new CharacterTile('9'));
		frame.add(new CharacterTile('N'));
		frame.add(new CharacterTile('E'));
		frame.add(new CharacterTile('W'));
		frame.add(new CharacterTile('S'));
		frame.add(new CharacterTile('C'));
		frame.add(new CharacterTile('F'));

		frame.pack();
		frame.setVisible(true);
	}
}
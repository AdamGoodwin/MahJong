import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.util.*;

public class MahJong extends JFrame
{
	MahJongBoard maj;
	private int gameid;
	public Tile[][][] MJB;
	private Stack<Tile> undoStack = new Stack<Tile>();
	private int count = 0;
	private int zorder1;
	private int zorder2;
	
	public MahJong()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1920,1080);
		
		makeMenu();
		maj = null;
		
		setVisible(true);
	}
	
	public void newGame()
	{
		if(maj != null)
		{
			if(JOptionPane.showConfirmDialog(this, "Do you want to start a new game?", "New Game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			{
				remove(maj);
				gameid = (int)System.currentTimeMillis() % 1000000;
				maj = new MahJongBoard(gameid);
				add(maj);
				repaint();
				validate();
			}
		}
		else
		{
			gameid = (int)System.currentTimeMillis() % 1000000;
			maj = new MahJongBoard(gameid);
			add(maj);
			repaint();
			validate();
		}
	}
	
	public void restart()
	{
		if(maj != null)
		{
			if(JOptionPane.showConfirmDialog(this, "Do you want to restart this game?", "Restart game?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION)
			{
				remove(maj);
				maj = new MahJongBoard(gameid);
				add(maj);
				repaint();
				validate();
			}
		}
	}
	
	public void numbered()
	{
		String input = (String)JOptionPane.showInputDialog(this,"Choose a game between 1 and 999,999\n","Customized Dialog",
                    			JOptionPane.PLAIN_MESSAGE,null,null,"");
        
        if(input != null && input.length() > 0)
        {
    		gameid = Integer.parseInt(input);
		
			if(maj != null)
			{
				remove(maj);
				maj = new MahJongBoard(gameid);
				add(maj);
				repaint();
				validate();
			}
			else
			{
				maj = new MahJongBoard(gameid);
				add(maj);
				repaint();
				validate();
			}		
        }
        else
        {
        	newGame();
        }
	}
	
	//public void undo()
	//{}
	
	private void makeMenu()
	{
		JMenuBar menuBar = new JMenuBar();
    	setJMenuBar(menuBar);
    	
    	JMenu gameMenu = new JMenu("Game");
    	gameMenu.setMnemonic('G');
    	menuBar.add(gameMenu);
    	
    	JMenuItem newGame = new JMenuItem("New Game", 'N');
    	newGame.setToolTipText("Start a new game");
    	newGame.setAccelerator(KeyStroke.getKeyStroke("ctrl N"));
    	gameMenu.add(newGame);
    	newGame.addActionListener(new ActionListener()
    						{ public void actionPerformed(ActionEvent e)
    								{ newGame(); }
    						});
    						
    	JMenuItem restart = new JMenuItem("Restart", 'R');
    	restart.setToolTipText("Restart game");
    	restart.setAccelerator(KeyStroke.getKeyStroke("ctrl R"));
    	gameMenu.add(restart);
    	restart.addActionListener(new ActionListener()
    						{ public void actionPerformed(ActionEvent e)
    								{ restart(); }
    						});
    						
    	JMenuItem numbered = new JMenuItem("Numbered", 'M');
    	numbered.setToolTipText("Start a numbered game");
    	numbered.setAccelerator(KeyStroke.getKeyStroke("ctrl M"));
    	gameMenu.add(numbered);
    	numbered.addActionListener(new ActionListener()
    						{ public void actionPerformed(ActionEvent e)
    								{ numbered(); }
    						});
    	
    	/*JMenu moveMenu = new JMenu("Move");
    	gameMenu.setMnemonic('O');
    	menuBar.add(moveMenu);*/
    	
    	/*JMenuItem undo = new JMenuItem("Undo", 'U');
    	undo.setToolTipText("Undo move");
    	undo.setAccelerator(KeyStroke.getKeyStroke("ctrl Z"));
    	moveMenu.add(undo);
    	undo.addActionListener(new ActionListener()
    						{ public void actionPerformed(ActionEvent e)
    								{ undo(); }
    						});*/
	}
	
	public class MahJongBoard extends JPanel implements MouseListener
	{
		private Tile tile1 = null;
		private Tile tile2 = null;
		
		private	Border normal = BorderFactory.createLineBorder(Color.BLACK);
		private	Border selected = BorderFactory.createLineBorder(Color.RED);
		
		public Tile[][][] MJB;
		private boolean[][][] isOpen;
		
		private ArrayList<Tile> deck = new ArrayList<Tile>();
		private ImageIcon image;
		
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			image = new ImageIcon(".\\images\\dragon_bg.png");
			g.drawImage(image.getImage(), (1250 - image.getIconWidth())/2, ((768 - image.getIconHeight()))/2, this);
		}
		
		public MahJongBoard(int gameid)
		{
			setLayout(null);
			MahJongModel mjm = new MahJongModel(gameid);
			
			setTitle("Mahjong - Game Number: " + gameid);
			
			MJB = new Tile[15][8][5];
			isOpen = new boolean[15][8][5];
			
			setBoard();
			setOpen();
		}
		
		public void setBoard()
		{
			Tile t;
			int layer = 3;
			
			t = deck.remove(deck.size() - 1);  //Top Tile -- First Layer
			t.addMouseListener(this);
			MJB[4][7][layer + 1] = t;
			t.setLoc(4, 7, layer + 1);
			t.setLocation(415,355);
			add(t);			
			
			for(int y = 3; y < 5; y++)  //Second Layer
			{
				for(int x = 7; x > 5; x--)
				{
					t = deck.remove(deck.size() - 1);
					t.addMouseListener(this);
					MJB[x][y][layer] = t;
					t.setLoc(x, y, layer);
					t.setLocation(x * 70 - 30,y * 90 + 30);
					add(t);
				}
			}
			layer--;
			
			for(int y = 2; y < 6; y++)  //Third Layer
			{
				for(int x = 8; x > 4; x--)
				{
					t = deck.remove(deck.size() - 1);
					t.addMouseListener(this);
					MJB[x][y][layer] = t;
					t.setLoc(x, y, layer);
					t.setLocation(x * 70 - 20,y * 90 + 20);
					add(t);
				}
			}
			layer--;
			
			for(int y = 1; y < 7; y++)  //Fourth Layer
			{
				for(int x = 9; x > 3; x--)
				{
					t = deck.remove(deck.size() - 1);
					t.addMouseListener(this);
					MJB[x][y][layer] = t;
					t.setLoc(x, y, layer);
					t.setLocation(x * 70 - 10,y * 90 + 10);
					add(t);
				}
			}
			layer--;
			
			//Rightmost tile
			t = deck.remove(deck.size() - 1);
			t.addMouseListener(this);
			MJB[14][3][layer] = t;
			t.setLoc(14, 3, layer);
			t.setLocation(14 * 70,315);
			add(t);
			//Second Rightmost tile
			t = deck.remove(deck.size() - 1);
			t.addMouseListener(this);
			MJB[13][3][layer] = t;
			t.setLoc(13, 3, layer);
			t.setLocation(13 * 70,315);
			add(t);
			
			for(int y = 0; y < 8; y++)  //Last (Fifth) Layer
			{
				for(int x = 12; x > 0; x--)
				{
					if(y == 1 || y == 6)
						if(x == 1 || x == 2 || x == 11 || x == 12)
							continue;
							
					if(y == 2 || y == 5)
						if(x == 1 || x == 12)
							continue;
					
					t = deck.remove(deck.size() - 1);
					t.addMouseListener(this);
					MJB[x][y][layer] = t;
					t.setLoc(x, y, layer);
					t.setLocation(x * 70,y * 90);
					add(t);
				}
			}
			
			//Leftmost tile
			t = deck.remove(deck.size() - 1);
			t.addMouseListener(this);
			MJB[0][4][layer] = t;
			t.setLoc(0, 4, layer);
			t.setLocation(0,315);
			add(t);
		}
		
		public void setOpen()
		{
			int layer = 3;
			
			//Top Tile -- First Layer
			isOpen[4][7][layer + 1] = true;			
			
			for(int y = 3; y < 5; y++)  //Second Layer
			{
				for(int x = 7; x > 5; x--)
				{
					isOpen[x][y][layer] = false;
				}
			}
			layer--;
			
			for(int y = 2; y < 6; y++)  //Third Layer
			{
				for(int x = 8; x > 4; x--)
				{
					if(x == 5 || x == 8)
						isOpen[x][y][layer] = true;
					else
						isOpen[x][y][layer] = false;
				}
			}
			layer--;
			
			for(int y = 1; y < 7; y++)  //Fourth Layer
			{
				for(int x = 9; x > 3; x--)
				{
					if(x == 4 || x == 9)
						isOpen[x][y][layer] = true;
					else
						isOpen[x][y][layer] = false;
				}
			}
			layer--;
			
			//Rightmost tile
			isOpen[14][3][layer] = true;
			
			//Second Rightmost tile
			isOpen[13][3][layer] = false;

			for(int y = 0; y < 8; y++)  //Last (Fifth) Layer
			{
				for(int x = 12; x > 0; x--)
				{
					if(y == 1 || y == 6)
						if(x == 1 || x == 2 || x == 11 || x == 12)
							continue;
							
					if(y == 2 || y == 5)
						if(x == 1 || x == 12)
							continue;
					
					if((x == 1 && y == 0) || (x == 1 && y == 7) || (x == 2 && y == 2) || (x == 2 && y == 5) || (x == 3 && y == 1) || (x == 3 && y == 6) || (x == 10 && y == 1) || (x == 10 && y == 6) || (x == 11 && y == 2) || (x == 11 && y == 5) || (x == 12 && y == 0) || (x == 12 && y == 7))
						isOpen[x][y][layer] = true;
					else
						isOpen[x][y][layer] = false;
				}
			}
			
			//Leftmost tile
			isOpen[0][4][layer] = true;
		}
		
		public boolean[][][] getNeighbors(int x, int y, int z)
		{
			if(x == 4 && y == 7 && z == 4)  //Special case -- Top Tile
			{
				isOpen[6][3][3] = true;
				isOpen[7][3][3] = true;
				isOpen[6][4][3] = true;
				isOpen[7][4][3] = true;
			}
			else if(x == 0 && y == 4 && z == 0)  //Special case -- Leftmost Tile
			{
				isOpen[1][3][0] = true;
				isOpen[1][4][0] = true;
			}
			else if(x == 14 && y == 3 && z == 0)  //Special case -- Rightmost Tile
			{
				isOpen[13][3][0] = true;
			}
			else if(x == 13 && y == 3 && z == 0)  //Special case -- Second rightmost tile
			{
				isOpen[12][3][0] = true;
				isOpen[12][4][0] = true;
			}
			else if(x >= 2 && (MJB[x-1][y][z] == null || MJB[x+1][y][z] == null) && MJB[x][y][z+1] == null)
			{
				isOpen[x][y][z] = true;
			}
			
			return isOpen;
		}
		
		public void addToUndo(Tile t1, Tile t2)
		{
			undoStack.push(t1);
			undoStack.push(t2);
		}
		
		public void mousePressed(MouseEvent event)
		{
			Tile t = (Tile)event.getSource();
			
			int x = t.getXLoc();
			int y = t.getYLoc();
			int z = t.getZLoc();
			
			isOpen = getNeighbors(x,y,z);
			
			if(tile1 == null && isOpen[x][y][z])
			{				
				tile1 = t;
				tile1.setBorder(selected);			
				return;
			}
			else if(t == tile1)
			{
				tile1.setBorder(normal);
				tile1 = null;
				return;
			}
			else if(tile2 == null && isOpen[x][y][z])
			{
				tile2 = t;
				tile2.setBorder(selected);
			}
					
			if(tile1 != null && tile2 != null)
			{
				int x1 = tile1.getXLoc();
				int y1 = tile1.getYLoc();
				int z1 = tile1.getZLoc();
					
				int x2 = tile2.getXLoc();
				int y2 = tile2.getYLoc();
				int z2 = tile2.getZLoc();
				
				if(tile1.getString().equals(tile2.getString()))
				{					
					tile1.setBorder(normal);
					tile2.setBorder(normal);
					
					zorder1 = tile1.getParent().getComponentZOrder(t);
					remove(tile1);
					zorder2 = tile2.getParent().getComponentZOrder(t);
					remove(tile2);
					
					tile1 = null;
					MJB[x1][y1][z1] = null;
					tile2 = null;
					MJB[x2][y2][z2] = null;
								
					repaint();
					validate();
					addToUndo(tile1, tile2);
				}
				else
				{
					tile1.setBorder(normal);
					tile2.setBorder(normal);
								
					tile1 = null;
					tile2 = null;
				}
			}
		}

		public void mouseEntered(MouseEvent event){}		
		public void mouseExited(MouseEvent event){}
		public void mouseClicked(MouseEvent event){}
		public void mouseReleased(MouseEvent event){}
		
		public class MahJongModel
		{
			public MahJongModel(int gameid)
			{
				makeTiles();
				shuffleTiles(gameid);
			}
			
			private void shuffleTiles(int gameid)
			{
				Random seed = new Random(gameid);
				Collections.shuffle(deck, seed);
			}
			
			private void makeTiles()
			{
				for(int i = 0; i < 4; i++)
				{
					deck.add(new PictureTile("Bamboo 1"));
					deck.add(new BambooTile(2));
					deck.add(new BambooTile(3));
					deck.add(new BambooTile(4));
					deck.add(new BambooTile(5));
					deck.add(new BambooTile(6));
					deck.add(new BambooTile(7));
					deck.add(new BambooTile(8));
					deck.add(new BambooTile(9));
					
					deck.add(new CircleTile(1));
					deck.add(new CircleTile(2));
					deck.add(new CircleTile(3));
					deck.add(new CircleTile(4));
					deck.add(new CircleTile(5));
					deck.add(new CircleTile(6));
					deck.add(new CircleTile(7));
					deck.add(new CircleTile(8));
					deck.add(new CircleTile(9));
					
					deck.add(new CharacterTile('1'));
					deck.add(new CharacterTile('2'));
					deck.add(new CharacterTile('3'));
					deck.add(new CharacterTile('4'));
					deck.add(new CharacterTile('5'));
					deck.add(new CharacterTile('6'));
					deck.add(new CharacterTile('7'));
					deck.add(new CharacterTile('8'));
					deck.add(new CharacterTile('9'));
					deck.add(new CharacterTile('N'));
					deck.add(new CharacterTile('E'));
					deck.add(new CharacterTile('W'));
					deck.add(new CharacterTile('S'));
					deck.add(new CharacterTile('C'));
					deck.add(new CharacterTile('F'));
					
					deck.add(new WhiteDragonTile());
				}
				
				deck.add(new PictureTile("Chrysanthemum"));
				deck.add(new PictureTile("Orchid"));
				deck.add(new PictureTile("Plum"));
				deck.add(new PictureTile("Bamboo"));
				deck.add(new PictureTile("Spring"));
				deck.add(new PictureTile("Summer"));
				deck.add(new PictureTile("Fall"));
				deck.add(new PictureTile("Winter"));
			}
		}
	}
	
	public static void main(String[] args)
	{
		new MahJong();
	}
}
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.HeadlessException;
import javax.swing.JRadioButton;
import java.awt.Color;
 


public class Scrabblewindowbuilder
{
	JFrame frame = new JFrame("Scrabble");
	JFrame swapframe = new JFrame("Tile Swapper");
	JPanel panel1 = new JPanel();
	JPanel welcomepanel = new JPanel();
	JPanel swappanel = new JPanel();
	JPanel blank = new JPanel();
	JPanel scores= new JPanel();
	
	//objects
	dictionary dictionary1= new dictionary();
 
	//Images here for tiles and the board
	//A Tile
	static java.net.URL tileA = Scrabble.class.getResource("resources/A.jpg");
	static ImageIcon tA = new ImageIcon(tileA);
 
	//B Tile
	static java.net.URL tileB = Scrabble.class.getResource("resources/B.jpg");
	static ImageIcon tB = new ImageIcon(tileB);
 
	//C Tile
	static java.net.URL tileC = Scrabble.class.getResource("resources/C.jpg");
	static ImageIcon tC = new ImageIcon(tileC);
 
	//D Tile
	static java.net.URL tileD = Scrabble.class.getResource("resources/D.jpg");
	static ImageIcon tD = new ImageIcon(tileD);
 
	//E Tile
	static java.net.URL tileE = Scrabble.class.getResource("resources/E.jpg");
	static ImageIcon tE = new ImageIcon(tileE);
 
	//F Tile
	static java.net.URL tileF = Scrabble.class.getResource("resources/F.jpg");
	static ImageIcon tF = new ImageIcon(tileF);
 
	//G Tile
	static java.net.URL tileG = Scrabble.class.getResource("resources/G.jpg");
	static ImageIcon tG = new ImageIcon(tileG);
 
	//H Tile
	static java.net.URL tileH = Scrabble.class.getResource("resources/H.jpg");
	static ImageIcon tH = new ImageIcon(tileH);
 
	//I Tile
	static java.net.URL tileI = Scrabble.class.getResource("resources/I.jpg");
	static ImageIcon tI = new ImageIcon(tileI);
 
	//J Tile
	static java.net.URL tileJ = Scrabble.class.getResource("resources/J.jpg");
	static ImageIcon tJ = new ImageIcon(tileJ);
 
	//K Tile
	static java.net.URL tileK = Scrabble.class.getResource("resources/K.jpg");
	static ImageIcon tK = new ImageIcon(tileK);
 
	//L Tile
	static java.net.URL tileL = Scrabble.class.getResource("resources/L.jpg");
	static ImageIcon tL = new ImageIcon(tileL);
 
	//M Tile
	static java.net.URL tileM = Scrabble.class.getResource("resources/M.jpg");
	static ImageIcon tM = new ImageIcon(tileM);
 
	//N Tile
	static java.net.URL tileN = Scrabble.class.getResource("resources/N.jpg");
	static ImageIcon tN = new ImageIcon(tileN);
 
	//O Tile
	static java.net.URL tileO = Scrabble.class.getResource("resources/O.jpg");
	static ImageIcon tO = new ImageIcon(tileO);
 
	//P Tile
	static java.net.URL tileP = Scrabble.class.getResource("resources/P.jpg");
	static ImageIcon tP = new ImageIcon(tileP);
 
	//Q Tile
	static java.net.URL tileQ = Scrabble.class.getResource("resources/Q.jpg");
	static ImageIcon tQ = new ImageIcon(tileQ);
 
	//R Tile
	static java.net.URL tileR = Scrabble.class.getResource("resources/R.jpg");
	static ImageIcon tR = new ImageIcon(tileR);
 
	//S Tile
	static java.net.URL tileS = Scrabble.class.getResource("resources/S.jpg");
	static ImageIcon tS = new ImageIcon(tileS);
 
	//T Tile
	static java.net.URL tileT = Scrabble.class.getResource("resources/T.jpg");
	static ImageIcon tT = new ImageIcon(tileT);
 
	//U Tile
	static java.net.URL tileU = Scrabble.class.getResource("resources/U.jpg");
	static ImageIcon tU = new ImageIcon(tileU);
 
	//V Tile
	static java.net.URL tileV = Scrabble.class.getResource("resources/V.jpg");
	static ImageIcon tV = new ImageIcon(tileV);
 
	//W Tile
	static java.net.URL tileW = Scrabble.class.getResource("resources/W.jpg");
	static ImageIcon tW = new ImageIcon(tileW);
 
	//X Tile
	static java.net.URL tileX = Scrabble.class.getResource("resources/X.jpg");
	static ImageIcon tX = new ImageIcon(tileX);
 
	//Y Tile
	static java.net.URL tileY = Scrabble.class.getResource("resources/Y.jpg");
	static ImageIcon tY = new ImageIcon(tileY);
 
	//Z Tile
	static java.net.URL tileZ = Scrabble.class.getResource("resources/Z.jpg");
	static ImageIcon tZ = new ImageIcon(tileZ);
 
	int y1 = 95, y2 = 138, y3= 181, y4= 224, y5= 267, y6= 310, y7= 353;
	
	static JLabel ta, tb, tc, td, te, tf, tg, th, ti, tj, tk, tl, tm, tn, to, tp, tq, tr, ts, tt, tu, tv, tw, tx, ty, tz;
	ButtonListener listener = new ButtonListener();
	private JTextField txtScrabbleSolo;
	private final JTextField textField2 = new JTextField();
	JTextField txtCurrentScore = new JTextField();
	JButton btnShuffle = new JButton("Shuffle");
	static int squaresize=15;// l and w of board
	int numplayers=0;
	boolean playerturn1=true;
 
	//declares tilebag
	static ArrayList<Character> tilebag = new ArrayList <Character>();
 
	static ArrayList<Integer>tilerack = new ArrayList<Integer>();
	static int turncount = 0, tilesused = 0, scorep1 = 0, scorep2 = 0, amountoftiles, roundscore=0; 
	static String currentscore = "Current Score: ";
	JButton btnQuitGame = new JButton("Quit Game");
	JButton play = new JButton("Play");
	JButton undo = new JButton("Return Tiles");
	JButton newgame = new JButton("New Game");
	JButton swap = new JButton("Swap Tiles"); 
	private final JButton searchDictionary = new JButton("Search Dictionary");
 
	player[] names; //spothere
	
	//Tileswap
	JRadioButton[] tileSwap={new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--")};
	
	JButton swaptilesbtn = new JButton("Swap");
	JButton btnCloseTileSwapper = new JButton("Close Tile Swapper");
	JButton unselectAll = new JButton("Unselect All");
	
	//tile rack letters
	Character [] tilerackchars= new Character [7];
	Character [] otherplayer= new Character [7];
	
	JRadioButton [] Tileracks= {new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--") };
	ButtonGroup radiogroup= new ButtonGroup();
 
	char letter= '0'; //just to intilize
	int n = 0; //just to intilize
	char[][] roundspots= new char [squaresize][squaresize];
	char[][] allspots= new char [squaresize][squaresize];
	String file="";
 
	//board words
	String [] words= {"", "", "", "", "", "", "", "",};
	
	String letters= "AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ";
	
	boolean allempty = true;
	JButton btnStartGame = new JButton("Start Game");
	JButton instructionsbtn = new JButton("Instructions");
	JButton quitbtn = new JButton("Quit");
	JButton pass = new JButton("Pass");
 
	JButton[][] tileboard = new JButton[squaresize][squaresize];
	JLabel messagespot;
	private final JLabel lblPointsA = new JLabel("Points: |A=1| B=3|C=3|D=2|E=1|F=4|G=2|H=4|I=1|J=8|K=5|L=1|M=3|N=1|O=1|P=3|Q=10|R=1|S=1|T=1|U=1|V=1|W=4|X=8|Y=4|Z=10|");
 
	public Scrabblewindowbuilder() throws IOException
	{
		for(int i = 0; i < tileboard.length; i++)
		{
			for(int j = 0; j < tileboard[i].length; j++) {
				tileboard[i][j] = new JButton("");
				panel1.add(tileboard[i][j]);
				tileboard[i][j].setLocation(j*40+165, i*40+60);
				tileboard[i][j].setSize(40,40);
				tileboard[i][j].setOpaque(false);
				tileboard[i][j].setContentAreaFilled(false);
				tileboard[i][j].setBorderPainted(false);
				tileboard[i][j].setEnabled(false);
			}
		}
 
		//Creates tile bag
 
		for(int i=0; i<letters.length();i++)
		{
			tilebag.add(letters.charAt(i));
		}
 
		//Shuffles tile bag
		Collections.shuffle(tilebag);
 
		for(int i = 0; i < tilerackchars.length;i++)
			tilerackchars[i] = tilebag.remove(0);
		
		for(int i = 1; i <= 7; i++)
			Tileracks[i-1] = placeImage(i, Tileracks[i - 1]);
		
		for(int i = 0; i < Tileracks.length; i++)
			radiogroup.add(Tileracks[i]);
		
		// Set up the image labels
		ta= new JLabel(tA);
		tb= new JLabel(tB);
		tc= new JLabel(tC);
		td= new JLabel(tD);
		te= new JLabel(tE);
		tf= new JLabel(tF);
		tg= new JLabel(tG);
		th= new JLabel(tH);
		ti= new JLabel(tI);
		tj= new JLabel(tJ);
		tk= new JLabel(tK);
		tl= new JLabel(tL);
		tm= new JLabel(tM);
		tn= new JLabel(tN);
		to= new JLabel(tO);
		tp= new JLabel(tP);
		tq= new JLabel(tQ);
		tr= new JLabel(tR);
		ts= new JLabel(tS);
		tt= new JLabel(tT);
		tu= new JLabel(tU);
		tv= new JLabel(tV);
		tw= new JLabel(tW);
		tx= new JLabel(tX);
		ty= new JLabel(tY);
		tz= new JLabel(tZ);
		txtCurrentScore.setEditable(false);
		txtCurrentScore.setBackground(Color.LIGHT_GRAY);
 
 
		txtCurrentScore.setText("Current Score: 0");
		txtCurrentScore.setBounds(11, 411, 145, 23);
		txtCurrentScore.setColumns(10);
		welcomepanel.setLayout(null);
 
		
		textField2.setEditable(false);
		textField2.setColumns(10);
		textField2.setBackground(Color.LIGHT_GRAY);
		textField2.setBounds(11, 432, 145, 23);
		textField2.setBorder(null);
		panel1.add(textField2);
		
		panel1.add(txtCurrentScore);
		
		
		btnShuffle.setBounds(11, 508, 145, 23);
 
		panel1.add(btnShuffle);
		
 
		btnQuitGame.setBounds(11, 710, 145, 23);
 
		panel1.add(btnQuitGame);
 
		play.setBounds(11, 474, 145, 23);
		panel1.add(play);
		
		pass.setBounds(11, 642, 145, 23);
		panel1.add(pass);
 
		
		Tileracks[2].setBounds(19, y3, 53, 40); 
		Tileracks[3].setBounds(19, y4, 53, 40);
		Tileracks[4].setBounds(19, y5, 53, 40);
		Tileracks[5].setBounds(19, y6, 53, 40);
		Tileracks[6].setBounds(19, y7, 53, 40);
		Tileracks[0].setBounds(19, y1, 53, 40);
		Tileracks[1].setBounds(19, y2, 53, 40);
 
		for(int i = 0; i < Tileracks.length; i++)
			panel1.add(Tileracks[i]);
		
		JLabel label = new JLabel("");
		label.setBounds(166, 45, 600, 633);
		label.setIcon(new ImageIcon(Scrabble.class.getResource("/resources/600 by 600 scrabble.jpg")));
		panel1.add(label);
 
		JLabel Tileslabel = new JLabel("Tiles:");
		Tileslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Tileslabel.setBounds(19, 62, 86, 14);
		panel1.add(Tileslabel);
 
 
		JLabel ScrabbleSololabel = new JLabel("-------------------|Scrabbler|-------------------");
		ScrabbleSololabel.setBackground(Color.WHITE);
		ScrabbleSololabel.setFont(new Font("Verdana", Font.BOLD, 31));
		ScrabbleSololabel.setBounds(0, 11, 785, 40);
		panel1.add(ScrabbleSololabel);
 
		undo.setBounds(11, 542, 145, 23);
		panel1.add(undo);
 
		newgame.setBounds(11, 576, 145, 23);
		panel1.add(newgame);
 
		messagespot = new JLabel();
		
		messagespot.setBounds(11, 743, 774, 23);
		
		panel1.add(messagespot);
		messagespot.setText("Welcome to Scrabbler. This is both either a solo or multiplayer Scrabble game. Have fun playing!");
 
		
		lblPointsA.setFont(new Font("Microsoft Himalaya", Font.PLAIN, 17));
		lblPointsA.setBounds(166, 669, 622, 41);
		
		panel1.add(lblPointsA);
		
		
		swap.setBounds(11, 608, 145, 23);
		panel1.add(swap);
		
		JLabel lblWelcomeToScrabble = new JLabel("Welcome to Scrabbler");
		lblWelcomeToScrabble.setFont(new Font("Tahoma", Font.PLAIN, 64));
		lblWelcomeToScrabble.setBounds(89, 60, 622, 144);
		welcomepanel.add(lblWelcomeToScrabble);
 
		
		btnStartGame.setBounds(308, 296, 183, 45);
		welcomepanel.add(btnStartGame);
		
		instructionsbtn.setBounds(308, 360, 183, 45);
		welcomepanel.add(instructionsbtn);
		
		quitbtn.setBounds(308, 424, 183, 45);
		welcomepanel.add(quitbtn);
		
		searchDictionary.setBounds(11, 676, 145, 23);
		panel1.add(searchDictionary);
		
		//tileswap
		tileSwap[6].setBounds(18, 328, 74, 51);
		swapframe.getContentPane().add(tileSwap[6]);
		
		tileSwap[0].setBounds(18, 59, 64, 57);
		swapframe.getContentPane().add(tileSwap[0]);
		
		tileSwap[1].setBounds(18, 104, 64, 57);
		swapframe.getContentPane().add(tileSwap[1]);
		
		tileSwap[2].setBounds(18, 148, 64, 57);
		swapframe.getContentPane().add(tileSwap[2]);
		
		tileSwap[5].setBounds(18, 283, 64, 57);
		swapframe.getContentPane().add(tileSwap[5]);
		
		tileSwap[3].setBounds(18, 193, 64, 57);
		swapframe.getContentPane().add(tileSwap[3]);
 
		tileSwap[4].setBounds(18, 237, 64, 57);
		swapframe.getContentPane().add(tileSwap[4]);
 
		JLabel lblTileSwap = new JLabel("Tile Swap");
		lblTileSwap.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTileSwap.setBounds(76, 6, 148, 51);
		swapframe.getContentPane().add(lblTileSwap);
 
		swaptilesbtn.setBounds(120, 148, 159, 29);
		swapframe.getContentPane().add(swaptilesbtn);
		
		
		btnCloseTileSwapper.setBounds(120, 180, 159, 29);
		swapframe.getContentPane().add(btnCloseTileSwapper);
		
		unselectAll.setBounds(120, 114, 159, 29);
		swapframe.getContentPane().add(unselectAll);
 
	}
	public void display() throws IOException
	{
		welcomepanel.setVisible(true);
 
		
		// Panel size
		frame.setPreferredSize(new Dimension(800, 800));
		swapframe.setPreferredSize(new Dimension(300, 410));
 
		// Allows putting objects at specific coordinates
		panel1.setLayout(null);
 
		swappanel.setLayout(null);
		welcomepanel.setLayout(null);
		welcomepanel.setBackground(new Color(127, 255, 212));
 
		blank.setLayout(null);
		blank.setBackground(new Color(255, 182, 193));
		blank.setVisible(false);
		
		scores.setLayout(null);
		scores.setVisible(false);

		//Button characteristics
		btnQuitGame.addActionListener(listener);
		searchDictionary.addActionListener(listener);
		btnShuffle.addActionListener(listener);
		
		for(int i = 0; i < Tileracks.length; i++)
		{
			Tileracks[i].addActionListener(listener);
			tileSwap[i].addActionListener(listener);
		}
		
		play.addActionListener(listener);
		undo.addActionListener(listener);
		newgame.addActionListener(listener);
		swap.addActionListener(listener);
		btnStartGame.addActionListener(listener);
		instructionsbtn.addActionListener(listener);
		quitbtn.addActionListener(listener);
		swaptilesbtn.addActionListener(listener);
		btnCloseTileSwapper.addActionListener(listener);
		unselectAll.addActionListener(listener);
		pass.addActionListener(listener);
 
		
 
		for(int i = 0; i < tileboard.length; i++)
			for(int j = 0; j < tileboard[i].length; j++) 
				tileboard[i][j].addActionListener(listener);
 
		//ALWAYS include this to display the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel1);
		frame.getContentPane().add(blank);
		frame.getContentPane().add(scores);
		frame.getContentPane().add(welcomepanel);
		frame.pack();
		frame.setVisible(true);
		swapframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		swapframe.getContentPane().add(swappanel);
		swapframe.pack();
		swapframe.setVisible(false);
	}
 
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e) 
		{
			//swapper btn's
			if(e.getSource() == pass)
				try {
					undo();
					setUpNextTurn();
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
			
			int countselected = 0;
			if(e.getSource() == btnCloseTileSwapper)
			{
				swapframe.setVisible(false);
				
				for(int i = 0; i < tileSwap.length ;i++)
					tileSwap[i].setSelected(false);
 
			}
			
			
			if(e.getSource() == unselectAll)
			{
				for(int i = 0; i < tileSwap.length; i++)
				{
					tileSwap[i].setEnabled(true);
					tileSwap[i].setSelected(false);
				}
				countselected=0;
			}
			
			
			
			for(int i = 0; i < tileSwap.length; i++)
				if(tileSwap[i].isSelected())
					countselected++;
			
			if(countselected == tilebag.size())
				for(int i = 0; i < tileSwap.length; i++)
					tileSwap[i].setEnabled(false);
						
				boolean selected=false;
				for(int i = 0; i < tileSwap.length; i++)
					if(tileSwap[i].isSelected())
					{
						selected = true;
						break;
					}
			if(e.getSource() == swaptilesbtn && selected)
			{
				for(int i = 0; i < tileSwap.length; i++)
				{
					if(tileSwap[i].isSelected())
					{
						tilebag.add(tilerackchars[i]);
						tileSwap[i].setEnabled(false);
						Tileracks[i].setEnabled(false);
					}
				}
				Collections.shuffle(tilebag);
				try {
					getTiles();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				undo();
				panel1.repaint();
				swappanel.repaint();
				swapframe.setVisible(false);
 
				
				for(int i=0; i<tileSwap.length;i++)
				{
					tileSwap[i].setEnabled(false);
					tileSwap[i].setSelected(false);
 
				}
				
				swap.setEnabled(false);
				try {
					setUpNextTurn();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
 
			
			//welcome btn's
			if(e.getSource() == instructionsbtn)
			{
				JOptionPane.showMessageDialog(frame,
					    "This game is a Scrabble like game where anywhere from 1-2 people can play. While playing you place tiles on the board. Each tile is worth a different point value and"
					    + " the objective of the game is to score the most points. Good luck playing!",
					    "Instructions",
					    JOptionPane.PLAIN_MESSAGE);
			}
			
			if(e.getSource() == btnStartGame)
			{
						String[] choices = { "1", "2"};
						
						String numtemp ="";
						
						do {
							numtemp = (String) JOptionPane.showInputDialog(null, "How many people are playing?",
						        "Number of Players", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
						}while(numtemp == null);
					
						   
					   numplayers = Integer.parseInt(numtemp);
				
					   
					   	names = new player[numplayers]; //spothere
					    if(numplayers > 1)
					    for(int i = 0; i < numplayers; i++)
					    {
					    		do {
					    			names[i]= new player(JOptionPane.showInputDialog("What is player " + (i+1) + "'s name?"));
					    			System.out.print(names[i].toString());
					    		}while(names[i].toString().length()<1);
					    	
					    }
					    
					    if(numplayers == 2)
						   {
								for(int i = 0; i < otherplayer.length; i++)
									otherplayer[i]=tilebag.remove(0);
								txtCurrentScore.setText(names[0] + "'s Score: 0");
								textField2.setText(names[1] + "'s Score: 0");
						   }
					    
					welcomepanel.setVisible(false);
					blank.setVisible(false);
					frame.setContentPane(panel1);
					
					if(numplayers == 2)
					JOptionPane.showMessageDialog(frame,names[0] +" will go first.", "First Turn", JOptionPane.PLAIN_MESSAGE);
				}
			
			//panel1 buttons
			
			if(e.getSource() == searchDictionary)
				try {
					String a = JOptionPane.showInputDialog("Type in the word that you want to search:");
					if(a != null && (!dictionary1.checkDictionary(a)))
						JOptionPane.showMessageDialog(new JFrame(), "That is not a valid word.", "Dictionary Search", JOptionPane.ERROR_MESSAGE);
					
					else if(a != null) JOptionPane.showMessageDialog(frame,"That is a Word!", "Dictionary Search", JOptionPane.PLAIN_MESSAGE);
				} catch (HeadlessException | IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				
				
			if(e.getSource() == newgame)
				try {
					newGame();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
 
			if(e.getSource() == undo)
				undo();
 
			if(e.getSource() == btnQuitGame || e.getSource() == quitbtn)
				System.exit(0);
 
				
			if(e.getSource() == play)
			{
				boolean b = false;
				try {
					if(searchLegalPlay())
					{
						setUpNextTurn();
						b = true;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
				if (!b){
 
					String error = "That was not a valid play. Please try again.";
					messagespot.setText(error);
 
					for(int i = 0; i < words.length; i++)
						words[i] = "";
 
					for(int i = 0; i < roundspots.length; i++)
						for(int j = 0; j < roundspots[i].length; j++) 
							if(roundspots[i][j] != '\u0000')
								allspots[i][j] = '\u0000';
				}
 
			}
 
			if(e.getSource() == btnShuffle)
				shuffleTiles();
 
			if(e.getSource() == swap)
			{
				swapframe.setVisible(true);
				try {
					for(int i = 0;i < tileSwap.length; i++)
					tileSwap[i] = placeImage(i + 1, tileSwap[i]);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
			}

			for(int k = 0; k < Tileracks.length; k++)
			if(e.getSource() == Tileracks[k])
			{
				n = k + 1;
				letter = tilerackchars[k];
 
				for(int i = 0; i < tileboard.length; i++)
					for(int j = 0; j < tileboard[i].length; j++) 
						if(tileboard[i][j].getBackground() != Color.BLACK && tileboard[i][j].getBackground() != Color.BLUE)
							tileboard[i][j].setEnabled(true);	
			}
 
			for(int i = 0; i < tileboard.length; i++)
			{
				for(int j = 0; j < tileboard[i].length; j++) 
				{
					if(e.getSource() == tileboard[i][j] && tileboard[i][j].isEnabled() != false)
					{
 
						tileboard[i][j].setOpaque(true);
						tileboard[i][j].setContentAreaFilled(true);
						roundspots[i][j]=letter;
						tileboard[i][j].setBackground(Color.BLUE);
						
						ImageIcon temp = tA;
						switch(letter){
 
						case 'B':
							 temp = tB;
							break;
 
						case 'C':
							 temp = tC;
							break;
 
						case 'D':
							 temp = tD;
							break;
 
						case 'E':
							 temp = tE;
							break;
 
						case 'F':
							 temp = tF;
							break;
 
						case 'G':
							 temp = tG;
							break;
 
						case 'H':
							 temp = tH;
							break;
 
						case 'I':
							 temp = tI;
							break;
 
						case 'J':
							 temp = tJ;
							break;
 
						case 'K':
							 temp = tK;
							break;
 
						case 'L':
							 temp = tL;
							break;
 
						case 'M':
							 temp = tM;
							break;
 
						case 'N':
							 temp = tN;
							break;
 
						case 'O':
							 temp = tO;
							break;
 
						case 'P':
							 temp = tP;
							break;
 
						case 'Q':
							 temp = tQ;
							break;
 
						case 'R':
							 temp = tR;
							break;
 
						case 'S':
							 temp = tS;
							break;
 
						case 'T':
							 temp = tT;
							break;
 
						case 'U':
							 temp = tU;
							break;
 
						case 'V':
							 temp = tV;
							break;
 
						case 'W':
							 temp = tW;
							break;
 
						case 'X':
							 temp = tX;
							break;
 
						case 'Y':
							 temp = tY;
							break;
 
						case 'Z':
							 temp = tZ;
						}
						
						tileboard[i][j].setIcon(temp);
						tileboard[i][j].setDisabledIcon(temp);
						
						for(int b = 0; b < tileboard.length; b++)
							for(int c = 0; c < tileboard[b].length; c++) 
								tileboard[b][c].setEnabled(false);
 
						//fix later
						switch(n){
						//improve
						case 1:
							Tileracks[0].setEnabled(false);
							break;
 
						case 2:
							Tileracks[1].setEnabled(false);
							break;
 
						case 3:
							Tileracks[2].setEnabled(false);
							break;
 
						case 4:
							Tileracks[3].setEnabled(false);
							break;
 
						case 5:
							Tileracks[4].setEnabled(false);
							break;
 
						case 6:
							Tileracks[5].setEnabled(false);
							break;
 
						case 7:
							Tileracks[6].setEnabled(false);
							break;	
						}
						tilesused++;
						break;
					}
				}
			}
		}
	}
	
	public void shuffleTiles()
	{
		ArrayList<JRadioButton> tilesarraylist= new ArrayList<JRadioButton>();
		for(int i = 0;i < Tileracks.length; i++)
		tilesarraylist.add(Tileracks[i]);
 
		Collections.shuffle(tilesarraylist);
 
		tilesarraylist.get(0).setLocation(19, y1);
		tilesarraylist.get(1).setLocation(19, y2);
		tilesarraylist.get(2).setLocation(19, y3);
		tilesarraylist.get(3).setLocation(19, y4);
		tilesarraylist.get(4).setLocation(19, y5);
		tilesarraylist.get(5).setLocation(19, y6);
		tilesarraylist.get(6).setLocation(19, y7);
	}
 
	public boolean Placement()
	{
		if(turncount == 0 && roundspots[7][7] =='\u0000') //roundspots[7][7] is the start spot for scrabble games
			return false;
 
		boolean breaker = false;
		int tilesinword = 0;
		boolean place = false;
		boolean downandu = false;
		for(int i = 0; i < roundspots.length; i++)
		{
			if(breaker)
				break;
 
			for(int c = 0; c < roundspots[i].length; c++) 
			{
				int a = 0;
 
				boolean m = false;
				boolean n = false;
				
				if(i + 1 < squaresize && allspots[i + 1][c] != '\u0000')
					m = true;
 
				if(i - 1 >= 0 && allspots[i - 1][c] != '\u0000')
					n = true;
				
				if((((roundspots[i][c] != '\u0000'))) && ((m) || (n)))
				{
					a = 1;
					for(int r = 0; r < squaresize; r++)
						if(r<roundspots[i].length && roundspots[r][c] != '\u0000')
							{tilesinword++;
							downandu = true;
							}
 
					if(turncount == 0)
					{
						breaker = true;
						break;
					}
 
				}
				boolean o = false;
				boolean p = false;
				
				if(c + 1 < squaresize && allspots[i][c + 1] != '\u0000')
					o = true;
 
				if(c - 1 >= 0 && allspots[i][c - 1] != '\u0000')
					p = true;
 
				
				if((a != 1 || downandu) && (roundspots[i][c] != '\u0000') && ((o) || (p)))
				{	
					a = 2;
					for(int s = 0; s < squaresize; s++)
						if(s<roundspots[c].length && roundspots[i][s] != '\u0000')
							tilesinword++;
					
					if(downandu)
						tilesinword--;
						
					
					if(turncount == 0)
					{
						breaker = true;
						break;
					}
				}
 
				int test = c;
				if(a == 2 || a == 1 && turncount > 0)
				{
					for(int z = 0; z <= 7; z++)
					{
						if(i - 1 >= 0 && (tileboard[i - 1][c].getBackground() == Color.BLACK))
							place = true;
 
						if(i + 1 < squaresize && (tileboard[i + 1][c].getBackground() == Color.BLACK))
							place = true;
						c++;
						if(place)
							break;
 
						if(c >= squaresize)
							break;
					}
					breaker = true;
 
					if(place)
						break;
				}
 
				c = test; //test
				if((place != true) && (a == 2 || a == 1 && turncount > 0))
				{
					for(int z = 0; z <= 7; z++)
					{
						
						if(c + 1 < squaresize && tileboard[i][c + 1].getBackground() == Color.BLACK)
							place = true;
							
							if(c - 1 >= 0 && tileboard[i][c - 1].getBackground() == Color.BLACK)
								place = true;
 
						if(place)
							break;
 
						i++;
 
						if(i >= squaresize)
							break;
					}
 
					breaker = true;
					break;
				}
			}
		}
 
		if(tilesinword == tilesused && place)
			return true;
 
		else if(turncount == 0 && tilesinword == tilesused)
			return true;
 
		else return false; 
	}
	public boolean Spelling() throws IOException 
	{
 
		for(int i = 0; i < roundspots.length; i++)
			for(int c = 0; c < roundspots[i].length; c++) 
				if(roundspots[i][c] != '\u0000')
					allspots[i][c] = roundspots[i][c];
 
		for(int row = 0; row < tileboard.length; row++)
		{
			int condition = 0;
			for(int col = 0; col < tileboard[row].length; col++) 
			{
				if((allspots[row][col] != '\u0000') && (tileboard[row][col].getBackground() != Color.BLACK))// '\u0000' is the default value for an empty char array spot
				{
					char temp;
					int r = row;
					int c = col;
					condition = 1;
					int b = 0;
					boolean l = false,m = false, n = false,o = false;
 
 
					//next few lines prevent out of bounds exception bc ex if col=14 and 1 is added it would cause error
					if(col + 1 < squaresize && allspots[row][col +1 ] != '\u0000')
						l = true;
 
					if(col - 1 >= 0 && allspots[row][col - 1] != '\u0000')
						m = true;
 
					if(row + 1 < squaresize && allspots[row + 1][col] != '\u0000')
						n = true;
 
					if(row - 1 >= 0 && allspots[row - 1][col] != '\u0000')
						o = true;
 
					if((l || m) && (n || o)) //if both are true
					{
						
						if((n && roundspots[row + 1][col] != '\u0000') || (o && roundspots[row - 1][col] != '\u0000'))
							b = 2;
						
 
						else b = 1;
					}
 
 
					if((l || m) && (b ==1||b == 0))
					{	
						//horizonal word	
						do{
							c--;
							if(c >= squaresize || c < 0)
								break;
 
							temp = allspots[r][c];
 
						}while(temp != '\u0000');
 
						do{
							c++;
 
							if(c >= squaresize || c < 0)
								break;
 
							temp = allspots[r][c];
 
							if(temp != '\u0000')
								words[0] += allspots[r][c];
 
						}while(temp != '\u0000');
 
 
 
						//vertical word
						for(int i = 0;i < 7 ;i++)
						{
						c = col + i;
						r = row;
						if(roundspots[r][c] != '\u0000')
						{
							do{
								r--;
 
								if(r >= squaresize || r < 0)
									break;
 
								temp = allspots[r][c];
							}while(temp != '\u0000');
 
							do{
								r++;
 
								if(r >= squaresize || r < 0)
									break;
 
								temp = allspots[r][c];
 
								if(temp != '\u0000')
									words[i + 1] += allspots[r][c];
 
 
							}while(temp != '\u0000');
						}
 
					}
					}
 
					c = col;
					r = row;
					if(((n) || (o)) && (b == 2 || b == 0))
					{	
						//vertical word	
						do{
							r--;
							if(r >= squaresize || r < 0)
								break;
 
							temp = allspots[r][c];
 
						}while(temp != '\u0000');
 
						do{
							r++;
 
							if(r >= squaresize || r < 0)
								break;
 
							temp = allspots[r][c];
 
							if(temp != '\u0000')
								words[0] += allspots[r][c];
 
						}while(temp != '\u0000');
 
 
 
 
						//horizonal word 1
						for(int i = 0;i < 7; i++)
						{
						r = row + i;
						c = col;
						if(roundspots[r][c] != '\u0000')
						{
							do{
								c--;
 
								if(c >= squaresize || c < 0)
									break;
 
								temp = allspots[r][c];
							}while(temp != '\u0000');
 
							do{
								c++;
 
								if(c >= squaresize || c < 0)
									break;
 
								temp = allspots[r][c];
 
								if(temp != '\u0000')
									words[i + 1] += allspots[r][c];
 
 
							}while(temp != '\u0000');
						}
					}
					}
				}
				if(condition == 1)
					break;
			}
			if(condition == 1)
				break;
		}
 
		for(int i = 0; i < words.length; i++)
		if(words[i].length() > 1 && (!dictionary1.checkDictionary(words[i])))
			return false;
 
		return true;
	}
	
	
	public boolean searchLegalPlay() throws IOException //error if throw is not added
	{
		if((!Spelling())|(!Placement()))
			return false;
 
 
		else return true;
	}
 
	/**
	 * @wbp.parser.entryPoint
	 */
	public void getScore(String word)
	{
		for(int i = 0; i < word.length(); i++)
		{
			if(word.charAt(i) == 'A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'L' || word.charAt(i) == 'N' || word.charAt(i) == 'O' || word.charAt(i) == 'R' || word.charAt(i) == 'S' || word.charAt(i) == 'T' || word.charAt(i) == 'U' || word.charAt(i) == 'V')
				roundscore++;
 
			if(word.charAt(i) == 'D' || word.charAt(i) == 'G')
				roundscore += 2;
 
			if(word.charAt(i) == 'B' || word.charAt(i) == 'C' || word.charAt(i) == 'M' || word.charAt(i) == 'P')
				roundscore += 3;
 
			if(word.charAt(i) == 'F' || word.charAt(i) == 'H' || word.charAt(i) =='W'|| word.charAt(i) == 'Y')
				roundscore += 4;
 
			if(word.charAt(i) == 'K')
				roundscore += 5;
 
			if(word.charAt(i) == 'J'|| word.charAt(i) == 'X')
				roundscore += 8;
 
			if(word.charAt(i) =='Q' || word.charAt(i) == 'Z')
				roundscore += 10;
		}
	}
 
	public void getTiles() throws IOException
	{
		//test
		for(int i = 0;i < Tileracks.length; i++)
		{
		if((!Tileracks[i].isEnabled()) && tilebag.size() > 0)
		{
			tilerackchars[i] = tilebag.remove(0);
			Tileracks[i] = placeImage(i + 1,Tileracks[i]);
			Tileracks[i].setEnabled(true);
		}
		
		else if((!Tileracks[i].isEnabled()) && tilebag.size() == 0)
			tilerackchars[i] = '0';
		

		}
				
		allempty = true;
		for(int i = 0; i < Tileracks.length; i++)
		{
			if(tilerackchars[i] != '0')
			{
				allempty = false;
				break;
			}
		}
		
		
		if(allempty)	
		{
			String text = "";
			if(numplayers == 1)
				text = "The game is over. You scored " + scorep1 + " points. Congrats!";
			
			else if(numplayers == 2 && scorep1 > scorep2)
				text= "The game is over \"" + names[0] + "\" wins with a score of " + scorep1 + ". Good try \"" + names[1] + "\" you had " + scorep2 + " points.";
			
			else if(numplayers == 2 && scorep1 < scorep2)
				text= "The game is over \"" + names[1] + "\" wins with a score of " + scorep2 + ". Good try \"" + names[0] + "\" you had " + scorep1 + " points.";
			
			else if(numplayers == 2 && scorep1 == scorep2)
				text= "The game is over \"" + names[0] + "\" tied with \"" + names[0] + "\" with a score of " + scorep1 + " points.";
			
			JOptionPane.showMessageDialog(frame, text, "End Game", JOptionPane.PLAIN_MESSAGE);
		}
 
	}
 
	public void setUpNextTurn() throws IOException
	{
 
		for(int i = 0; i < roundspots.length; i++)
			for(int j = 0; j < roundspots[i].length; j++)
				if(roundspots[i][j] != '\u0000')
				{
					tileboard[i][j].setEnabled(false);
					tileboard[i][j].setBackground(Color.BLACK);
					roundspots[i][j] = '\u0000';
				}
		Character [] temp = {'-','-','-','-','-','-','-'};
		
		
		String b = "";
		
		for(int i = 0; i < words.length; i++)
			if(words[i].length()>1)
			{
				getScore(words[i]);
				b = b + " -" + words[i];
			}
		if(numplayers == 1)
		{
		scorep1 += roundscore;
		txtCurrentScore.setText(currentscore + scorep1);
		}
		
		if(numplayers == 2 && playerturn1)
		{
			scorep1 += roundscore;
			txtCurrentScore.setText(names[0] + "'s Score: " + scorep1);
		}
		
		if(numplayers == 2 && !playerturn1)
		{
			scorep2 += roundscore;
			textField2.setText(names[1] + "'s Score: " + scorep2);
		}
 
		getTiles();
		if(numplayers == 2)
		{
			for(int i = 0; i < otherplayer.length; i++)
			{
				temp[i] = tilerackchars[i];
				tilerackchars[i] = otherplayer[i];
				otherplayer[i] = temp[i];
				
			}
			
			for(int i = 0; i < Tileracks.length; i++)
				Tileracks[i] = placeImage(i + 1, Tileracks[i]);	
				
			
		}
		
		for(int i = 0; i < Tileracks.length; i++)
		{
		if(tilerackchars[i] != '0')
			Tileracks[i].setEnabled(true);
		
		if(tilerackchars[i] == '0')
		{
			Tileracks[i].setEnabled(false);
			Tileracks[i].setText("");
		}
		}
 
		tilesused = 0;
		turncount++;
 
		
		b = b + "-";
		String text = "";
		if(b.length() > 1)
			text = "On the last play the word(s)" + b +" were played for " + roundscore + " points!";
		
		else text = "No words were played on the last turn.";
		messagespot.setText(text);

		
		for(int i = 0; i < words.length; i++)
			words[i] = "";
		roundspots = new char [squaresize][squaresize];
		radiogroup.clearSelection();
		
		if(tilebag.size() > 0)
		{
		for(int i = 0; i < tileSwap.length; i++)
			tileSwap[i].setEnabled(true);
 
		swap.setEnabled(true);
		}
		
		else swap.setEnabled(false);
		
		if(numplayers == 2)
		{
			playerturn1 = !playerturn1;
			String currentname = "";
			if(playerturn1)
				currentname = names[0].toString();
			else currentname = names[1].toString();
			
			if(!allempty)
			{
			blank.setVisible(true);
			panel1.setVisible(false);
			}
			
			JOptionPane.showMessageDialog(frame,
					text + " It is \"" + currentname +  "'s\" turn. Press okay or the X in the corner to continue.", "Last Turn Played", JOptionPane.PLAIN_MESSAGE);
			
			if(!allempty)
			{
			blank.setVisible(false);
			panel1.setVisible(true);
			}
						
			
			b = "";
		}
		roundscore = 0;
		
		if(allempty)
		{
			messagespot.setText("Click New Game to play again or Quit to close the game.");
			for(int i = 0; i < Tileracks.length; i++)
				Tileracks[i].setEnabled(false);
			play.setEnabled(false);
			btnShuffle.setEnabled(false);
			pass.setEnabled(false);
			searchDictionary.setEnabled(false);
			undo.setEnabled(false);
		}
	}
 
	
	public void undo()
	{
		for(int i = 0; i < words.length; i++)
			words[i] = "";
		
		tilesused = 0;
		roundscore = 0;
 
		messagespot.setText("If tiles were placed during this turn, they were returned.");

		for(int i = 0; i < tileboard.length; i++)
			for(int j = 0; j < tileboard[i].length; j++) 
			{
				tileboard[i][j].setEnabled(false);
				if(tileboard[i][j].getBackground() != Color.BLACK)
				{
					tileboard[i][j].setIcon(null);
					tileboard[i][j].setOpaque(false);
					tileboard[i][j].setContentAreaFilled(false);
			//test=false;
					if(tileboard[i][j].getBackground() == Color.BLUE)
						tileboard[i][j].setBackground(new JButton().getBackground());
				}
			}
		
		for(int i = 0; i < roundspots.length; i++)
			for(int j = 0; j < roundspots[i].length; j++) 
				if(roundspots[i][j] != '\u0000')
				{
					allspots[i][j] = '\u0000';
					roundspots[i][j] = '\u0000';
				}

		//if(test)
		for(int i = 0; i < Tileracks.length; i++)
			if(Tileracks[i].getText() != "")
				Tileracks[i].setEnabled(true);
		
		radiogroup.clearSelection();	
	}
 
	public void newGame() throws IOException
	{
		for(int i = 0; i < Tileracks.length; i++)
			Tileracks[i].setEnabled(true);
 
		radiogroup.clearSelection();
 
		messagespot.setText("You clicked the New Game option. This starts your game over.");
		for(int i = 0; i < roundspots.length; i++)
			for(int j = 0; j < roundspots[i].length; j++) 
			{
				allspots[i][j] = '\u0000';
				roundspots[i][j] = '\u0000';
			}
 
		tilebag.clear();
		for(int i = 0; i < letters.length(); i++)
		{
			tilebag.add(letters.charAt(i));
		}
 
		for(int i = 0; i < tileboard.length; i++)
			for(int j = 0; j < tileboard[i].length; j++) 
			{
				tileboard[i][j].setIcon(null);
				tileboard[i][j].setOpaque(false);
				tileboard[i][j].setContentAreaFilled(false);
				tileboard[i][j].setEnabled(false);
				tileboard[i][j].setBackground(new JButton().getBackground());
			}
		scorep1 = 0;
		roundscore = 0;
		scorep2 = 0;
		
		if(numplayers == 1)
		txtCurrentScore.setText(currentscore + 0);
 
		for(int i = 0; i < words.length; i++)
			words[i] = "";
 
		tilesused = 0;
		turncount = 0;
 
		Collections.shuffle(tilebag);
 
		for(int i = 0; i < tilerackchars.length; i++)
			tilerackchars[i] = tilebag.remove(0);
 
		for(int i = 1; i < 8; i++)
			Tileracks[i - 1]=placeImage(i, Tileracks[i -1 ]);
		
		for(int i = 0; i < tileSwap.length; i++)
			tileSwap[i].setEnabled(true);
		
		play.setEnabled(true);
		btnShuffle.setEnabled(true);
		pass.setEnabled(true);
		undo.setEnabled(true);
		searchDictionary.setEnabled(true);
		
		swap.setEnabled(true);
		
		String[] choices = { "1", "2"};
		String numtemp = (String) JOptionPane.showInputDialog(null, "How many people are playing?",
		        "Number of Players", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
	
	   while(numtemp == null)
		   numtemp = (String) JOptionPane.showInputDialog(null, "How many people are playing?",
			        "Number of Players", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		   
	   numplayers = Integer.parseInt(numtemp);
		   names = new player[numplayers];
		    
		    if(numplayers > 1)
		    for(int i = 0; i < numplayers; i++)
		    {
		    	do {
	    			names[i] = new player(JOptionPane.showInputDialog("What is player " + (i + 1) +"'s name? (it must be less than 9 characters)"));
	    		}while(names[i] == null||names[i].toString().length() < 1 || names[i].toString().length() > 8);
		    }
		    if(numplayers == 2)
		    {
		    	textField2.setText(names[1] + "'s Score: 0"); //alt name
		    	txtCurrentScore.setText(names[0] + "'s Score: 0");
		    }
		    
		    if(numplayers == 1)
		    {
		    	txtCurrentScore.setText("Current Score: 0");
		    	textField2.setText("");
		    }
	}
 
	public JRadioButton placeImage(int a, JRadioButton btn) throws IOException
	{
		String url, html = "";
			switch(tilerackchars[a - 1])
			{
			case 'A':
				url = "" + tileA;
				html = "<html><body><img src='" + tileA + "' width=29 height=29>";
				break;
			case 'B':
				url = "" + tileB;
				html = "<html><body><img src='" + tileB + "' width=29 height=29>";
				break;
			case 'C':
				url = "" + tileC;
				html = "<html><body><img src='" + tileC + "' width=29 height=29>";
				break;
			case 'D':
				url = "" + tileD;
				html = "<html><body><img src='" + tileD + "' width=29 height=29>";
				break;
			case 'E':
				url = "" + tileE;
				html = "<html><body><img src='" + tileE + "' width=29 height=29>";
				break;
			case 'F':
				url = "" + tileF;
				html = "<html><body><img src='" + tileF + "' width=29 height=29>";
				break;
			case 'G':
				url = "" + tileG;
				html = "<html><body><img src='" + tileG + "' width=29 height=29>";
				break;
			case 'H':
				url = "" + tileH;
				html = "<html><body><img src='" + tileH + "' width=29 height=29>";
				break;
			case 'I':
				url = "" + tileI;
				html = "<html><body><img src='" + tileI + "' width=29 height=29>";
				break;
			case 'J':
				url = "" + tileJ;
				html = "<html><body><img src='" + tileJ + "' width=29 height=29>";
				break;
			case 'K':
				url = "" + tileK;
				html = "<html><body><img src='" + tileK + "' width=29 height=29>";
				break;
			case 'L':
				url = "" + tileL;
				html = "<html><body><img src='" + tileL + "' width=29 height=29>";
				break;
			case 'M':
				url = "" + tileM;
				html = "<html><body><img src='" + tileM + "' width=29 height=29>";
				break;
			case 'N':
				url = "" + tileN;
				html = "<html><body><img src='" + tileN + "' width=29 height=29>";
				break;
			case 'O':
				url = "" + tileO;
				html = "<html><body><img src='" + tileO + "' width=29 height=29>";
				break;
			case 'P':
				url = "" + tileP;
				html = "<html><body><img src='" + tileP + "' width=29 height=29>";
				break;
			case 'Q':
				url = "" + tileQ;
				html = "<html><body><img src='" + tileQ + "' width=29 height=29>";
				break;
			case 'R':
				url = "" + tileR;
				html = "<html><body><img src='" + tileR + "' width=29 height=29>";
				break;
			case 'S':
				url = "" + tileS;
				html = "<html><body><img src='" + tileS + "' width=29 height=29>";
				break;
			case 'T':
				url = "" + tileT;
				html = "<html><body><img src='" + tileT + "' width=29 height=29>";
				break;
			case 'U':
				url = "" + tileU;
				html = "<html><body><img src='" + tileU + "' width=29 height=29>";
				break;
			case 'V':
				url = "" + tileV;
				html = "<html><body><img src='" + tileV + "' width=29 height=29>";
				break;
			case 'W':
				url = "" + tileW;
				html = "<html><body><img src='" + tileW + "' width=29 height=29>";
				break;
			case 'X':
				url = "" + tileX;
				html = "<html><body><img src='" + tileX + "' width=29 height=29>";
				break;
			case 'Y':
				url = "" + tileY;
				html = "<html><body><img src='" + tileY + "' width=29 height=29>";
				break;
			case 'Z':
				url = "" + tileZ;
				html = "<html><body><img src='" + tileZ + "' width=29 height=29>";
				break;
			}
			btn.setText(html);
			return btn;
	}
}


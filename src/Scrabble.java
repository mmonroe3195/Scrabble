import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
 

public class Scrabble
{
	JFrame frame = new JFrame("Scrabble");
	JFrame swapframe = new JFrame("Tile Swapper");
	JPanel panel1 = new JPanel();
	JPanel welcomepanel = new JPanel();
	JPanel swappanel = new JPanel();
	JPanel blank = new JPanel();
	
	//objects
	dictionary dictionary1 = new dictionary();
	tileboard board = new tileboard(squaresize);
	tilebag bagoftiles = new tilebag("AAAAAAAAABBCCDDDDEEEEEEEEEEEEFFGGGHHIIIIIIIIIJKLLLLMMNNNNNNOOOOOOOOPPQRRRRRRSSSSTTTTTTUUUUVVWWXYYZ");
	player[] names;
	tilerack tilerack1 = new tilerack();

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
 
	int y1 = 95, y2 = 138, y3 = 181, y4 = 224, y5 = 267, y6 = 310, y7 = 353;
	int[] location = new int[] {y1, y2, y3, y4, y5, y6, y7};
	ImageIcon[] labels;
	
	static JLabel ta, tb, tc, td, te, tf, tg, th, ti, tj, tk, tl, tm, tn, to, tp, tq, tr, ts, tt, tu, tv, tw, tx, ty, tz;
	ButtonListener listener = new ButtonListener();
	private final JTextField textField2 = new JTextField();
	JTextField txtCurrentScore = new JTextField();
	JButton btnShuffle = new JButton("Shuffle");
	static int squaresize = 15;// l and w of board
	int numplayers = 0;
	boolean playerturn1 = true;
 
	//declares tilebag
	//static Character[] tilebag= new Character[98];
 
	static ArrayList<Integer>tilerack = new ArrayList<Integer>();
	static int turncount = 0, tilesused = 0, scorep1 = 0, scorep2 = 0, amountoftiles, roundscore = 0; 
	static String currentscore = "Current Score: ";
	JButton btnQuitGame = new JButton("Quit Game");
	JButton play = new JButton("Play");
	JButton undo = new JButton("Return Tiles");
	JButton newgame = new JButton("New Game");
	JButton swap = new JButton("Swap Tiles"); 
	private final JButton searchDictionary = new JButton("Search Dictionary");
 
	//Tileswap
	JRadioButton[] tileSwap = {new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--")};
	
	JButton swaptilesbtn = new JButton("Swap");
	JButton btnCloseTileSwapper = new JButton("Close Tile Swapper");
	JButton unselectAll = new JButton("Unselect All");
	
	//tile rack letters
	Character [] otherplayer = new Character [7];
	
	JRadioButton [] Tileracks = {new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--"),new JRadioButton("--") };
	ButtonGroup radiogroup= new ButtonGroup();
 
	char letter = '0';
	int numswitch = 0;
	
	char[][] roundspots = new char [squaresize][squaresize];
	char[][] allspots = new char [squaresize][squaresize];
	String file = "";
 
	//board words
	String [] words= {"", "", "", "", "", "", "", "",};
	
	boolean allempty = true;
	JButton btnStartGame = new JButton("Start Game");
	JButton instructionsbtn = new JButton("Instructions");
	JButton quitbtn = new JButton("Quit");
	JButton pass = new JButton("Pass");
 
	JLabel messagespot;
	private final JLabel lblPointsA = new JLabel("Points: |A=1| B=3|C=3|D=2|E=1|F=4|G=2|H=4|I=1|J=8|K=5|L=1|M=3|N=1|O=1|P=3|Q=10|R=1|S=1|T=1|U=1|V=1|W=4|X=8|Y=4|Z=10|");
 
	public Scrabble() throws IOException{
		board.setUpBoard();
		for(int i = 0; i < board.getBoardLength(); i++)
			for(int j = 0; j < board.getBoardLength(); j++) 
				panel1.add(board.getSpot(i, j));
		
		bagoftiles.setUpTileBag();
		
		//Shuffles tile bag
		bagoftiles.shuffleTileBag(); 
		
		
		for(int i = 1; i <= Tileracks.length; i++) {
			tilerack1.setNewValue(i - 1, bagoftiles.removeTile(0));
			Tileracks[i - 1] = placeImage(i, Tileracks[i - 1]);
			radiogroup.add(Tileracks[i - 1]);
			Tileracks[i - 1].setBounds(19, location[i - 1], 53, 40);
			panel1.add(Tileracks[i - 1]);
		}
					
		labels= new ImageIcon[] {tA, tB, tC, tD, tE, tF, tG, tH, tI, tJ, tK, tL, tM, tN, tO, tP, tQ, tR, tS, tT, tU, tV, tW, tX, tY, tZ};
		
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
		
		JLabel label = new JLabel("");
		label.setBounds(166, 45, 600, 633);
		label.setIcon(new ImageIcon(Scrabble.class.getResource("/resources/600 by 600 scrabble.jpg")));
		panel1.add(label);
		JLabel Tileslabel = new JLabel("Tiles:");
		Tileslabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Tileslabel.setBounds(19, 62, 86, 14);
		panel1.add(Tileslabel);
		JLabel ScrabbleSololabel = new JLabel("Scrabbler");
		ScrabbleSololabel.setBackground(Color.WHITE);
		ScrabbleSololabel.setFont(new Font("Verdana", Font.BOLD, 31));
		ScrabbleSololabel.setBounds(0, 11, 785, 40);
		ScrabbleSololabel.setHorizontalAlignment(JLabel.CENTER);
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
		swapframe.add(tileSwap[6]);
		tileSwap[0].setBounds(18, 59, 64, 57);
		swapframe.add(tileSwap[0]);
		tileSwap[1].setBounds(18, 104, 64, 57);
		swapframe.add(tileSwap[1]);
		tileSwap[2].setBounds(18, 148, 64, 57);
		swapframe.add(tileSwap[2]);
		tileSwap[5].setBounds(18, 283, 64, 57);
		swapframe.add(tileSwap[5]);
		tileSwap[3].setBounds(18, 193, 64, 57);
		swapframe.add(tileSwap[3]);
		tileSwap[4].setBounds(18, 237, 64, 57);
		swapframe.add(tileSwap[4]);
 
		JLabel lblTileSwap = new JLabel("Tile Swap");
		lblTileSwap.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblTileSwap.setBounds(76, 6, 148, 51);
		swapframe.add(lblTileSwap);
 
		swaptilesbtn.setBounds(120, 148, 159, 29);
		swapframe.add(swaptilesbtn);
		
		btnCloseTileSwapper.setBounds(120, 180, 159, 29);
		swapframe.add(btnCloseTileSwapper);
		
		unselectAll.setBounds(120, 114, 159, 29);
		swapframe.add(unselectAll);
 
	}
	public void display() throws IOException{
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
 
		
 
		for(int i = 0; i < board.getBoardLength(); i++)
			for(int j = 0; j < board.getBoardLength(); j++) 
				board.getSpot(i,j).addActionListener(listener);
 
		//ALWAYS include this to display the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel1);
		frame.add(blank);
		frame.add(welcomepanel);
		frame.pack();
		frame.setVisible(true);
		swapframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		swapframe.add(swappanel);
		swapframe.pack();
		swapframe.setVisible(false);
	}
 
	public class ButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
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
			if(e.getSource() == btnCloseTileSwapper){
				swapframe.setVisible(false);
				
				for(int i = 0; i < tileSwap.length; i++)
					tileSwap[i].setSelected(false);
			}
			
			if(e.getSource() == unselectAll){
				for(int i = 0; i < tileSwap.length; i++){
					tileSwap[i].setEnabled(true);
					tileSwap[i].setSelected(false);
				}
				countselected = 0;
			}
			
			for(int i = 0; i < tileSwap.length; i++)
				if(tileSwap[i].isSelected())
					countselected++;
			
			if(countselected == bagoftiles.getSize())
				for(int i = 0; i < tileSwap.length; i++)
					tileSwap[i].setEnabled(false);
						
				boolean selected = false;
				for(int i = 0; i < tileSwap.length; i++)
					if(tileSwap[i].isSelected()){
						selected = true;
						break;
					}
				
			if(e.getSource() == swaptilesbtn && selected){
				for(int i = 0; i < tileSwap.length; i++){
					if(tileSwap[i].isSelected()) {
						bagoftiles.addTile(tilerack1.getTile(i));
						tileSwap[i].setEnabled(false);
						Tileracks[i].setEnabled(false);
					}
				}
				
				bagoftiles.shuffleTileBag();
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
 
				for(int i=0; i < tileSwap.length; i++){
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
			if(e.getSource() == instructionsbtn){
				JOptionPane.showMessageDialog(frame,
					    "This game is a Scrabble like game where anywhere from 1-2 people can play. While playing you place tiles on the board. Each tile is worth a different point value and"
					    + " the objective of the game is to score the most points. Good luck playing!",
					    "Instructions",
					    JOptionPane.PLAIN_MESSAGE);
			}
			
			if(e.getSource() == btnStartGame){
						String[] choices = { "1", "2"};
						String numtemp = "";
						
						do {
							
							numtemp = (String) JOptionPane.showInputDialog(null, "How many people are playing?",
						        "Number of Players", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
							
						}while(numtemp == null);
				   
					   numplayers = Integer.parseInt(numtemp);
					   
					   	names = new player[numplayers];
					    if(numplayers > 1)
					    for(int i = 0; i < numplayers; i++){
					    		
					    	do {
					    		names[i] = new player(JOptionPane.showInputDialog("What is player " + (i + 1) + "'s name? (it must be less than 9 characters)"));
					    		}while(names[i] == null || names[i].toString().length() < 1 || names[i].toString().length() > 8);
					    }
					    
					    if(numplayers == 2){
							for(int i = 0; i < otherplayer.length; i++)
								otherplayer[i] = bagoftiles.removeTile(0);
							
							txtCurrentScore.setText(names[0] +"'s Score: 0");
							textField2.setText(names[1] + "'s Score: 0");
						   }
					    
					welcomepanel.setVisible(false);
					blank.setVisible(false);
					frame.setContentPane(panel1);
					
					if(numplayers == 2)
						JOptionPane.showMessageDialog(frame,names[0] +" will go first.", "First Turn", JOptionPane.PLAIN_MESSAGE);
				}
			
			if(e.getSource() == searchDictionary)
				try {
					
					String searchword = JOptionPane.showInputDialog("Type in the word that you want to search:");
					if(searchword != null && (!dictionary1.checkDictionary(searchword)))
						JOptionPane.showMessageDialog(new JFrame(), "That is not a valid word.", "Dictionary Search", JOptionPane.ERROR_MESSAGE);
					
					else if(searchword != null) JOptionPane.showMessageDialog(frame,"That is a Word!", "Dictionary Search", JOptionPane.PLAIN_MESSAGE);
				
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
 
			if(e.getSource() == play){
				boolean validplay = false;
				try {
					if(searchLegalPlay()){
						setUpNextTurn();
						validplay = true;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 
				if (!validplay){
					String error= "That was not a valid play. Please try again.";
					messagespot.setText(error);
 
					for(int i = 0; i < words.length; i++)
						words[i] = "";
 
					for(int i = 0; i < roundspots.length; i++)
						for(int j = 0; j < roundspots[i].length; j++) 
							if(roundspots[i][j]!= '\u0000')
								allspots[i][j]= '\u0000';
					
				}
			}
 
			if(e.getSource() == btnShuffle)
				shuffleTiles();
 
			if(e.getSource() == swap){
				
				swapframe.setVisible(true);
				try {
					for(int i = 0; i < tileSwap.length; i++)
					tileSwap[i] = placeImage(i + 1, tileSwap[i]);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			for(int k = 0; k < Tileracks.length; k++)
				if(e.getSource() == Tileracks[k]){
					
					numswitch = k + 1;
					letter = tilerack1.getTile(k);
 
					for(int i = 0; i < board.getBoardLength(); i++)
						for(int j = 0; j < board.getBoardLength(); j++)  
							if(board.getSpot(i,j).getBackground() != Color.BLACK && board.getSpot(i, j).getBackground() != Color.BLUE)
								board.getSpot(i, j).setEnabled(true);	
				}
 
			for(int i = 0; i < board.getBoardLength(); i++)
				for(int j = 0; j < board.getBoardLength(); j++) 
					if(e.getSource() == board.getSpot(i, j) && board.getSpot(i, j).isEnabled()!=false){
						board.getSpot(i, j).setOpaque(true);
						board.getSpot(i, j).setContentAreaFilled(true);
						roundspots[i][j]=letter;
						board.getSpot(i, j).setBackground(Color.BLUE);
						
						ImageIcon temp = labels[(int) letter - 65];
						board.getSpot(i, j).setIcon(temp);
						board.getSpot(i, j).setDisabledIcon(temp);
						
						for(int b = 0; b < board.getBoardLength(); b++)
							for(int c = 0; c < board.getBoardLength(); c++) 
								board.getSpot(b, c).setEnabled(false);
 
						Tileracks[numswitch - 1].setEnabled(false);
						tilesused++;
						break;
			}
		}
	}
	
	public void shuffleTiles(){
		
		ArrayList<JRadioButton> tilesarraylist= new ArrayList<JRadioButton>();
		for(int i = 0; i < Tileracks.length; i++)
			tilesarraylist.add(Tileracks[i]);
		
 
		Collections.shuffle(tilesarraylist);
 
		for(int i = 0; i < 7; i++)
			tilesarraylist.get(i).setLocation(19, location[i]);
	}
 
	//should this method be in the tileboard object
 
	public boolean Spelling() throws IOException{
 
		for(int i = 0; i < roundspots.length; i++)
			for(int c = 0; c < roundspots[i].length; c++) 
				if(roundspots[i][c] != '\u0000')
					allspots[i][c] = roundspots[i][c];
 
		for(int row = 0; row < board.getBoardLength(); row++){
			int condition = 0;
			
			for(int col = 0; col < board.getBoardLength(); col++){
				
				// '\u0000' is the default value for an empty char array spot
				if((allspots[row][col] != '\u0000') && (board.getSpot(row, col).getBackground() != Color.BLACK)){
					char temp;
					int r = row;
					int c = col;
					condition = 1;
					int b = 0;
					boolean l = false,m = false, n = false,o = false;
 
 
					//next few lines prevent out of bounds exception bc ex if col=14 and 1 is added it would cause error
					if(col + 1 < squaresize && allspots[row][col + 1] != '\u0000')
						l = true;
 
					if(col - 1 >= 0 && allspots[row][col - 1] != '\u0000')
						m = true;
 
					if(row + 1 < squaresize && allspots[row + 1][col] != '\u0000')
						n = true;
 
					if(row - 1 >= 0 && allspots[row - 1][col] != '\u0000')
						o = true;
 
					 //if both are true
					if((l || m) && (n || o)){
						if((n && roundspots[row + 1][col] != '\u0000') || (o && roundspots[row - 1][col] != '\u0000'))
							b = 2;

						else b = 1;
					}
 
 
					if((l || m) && (b == 1 || b == 0)){	
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
								words[0] += board.getSpecialSpot(r,c) + allspots[r][c];
								
 
						}while(temp != '\u0000');
 
						//vertical word
						for(int i = 0; i < 7; i++){
						c = col + i;
						r = row;
						if(c < squaresize && roundspots[r][c]!= '\u0000')
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
									words[i + 1] += board.getSpecialSpot(r,c)+ allspots[r][c];
 
 
							}while(temp != '\u0000');
						}
 
					}
					}
 
					c = col;
					r = row;
					if(((n) || (o)) && (b == 2 || b == 0)){	
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
								words[0] += board.getSpecialSpot(r,c) + allspots[r][c];
 
						}while(temp != '\u0000');
 
						//horizonal word 1
						for(int i = 0;i < 7; i++){
						r = row + i;
						c = col;
						if(r < squaresize && roundspots[r][c] != '\u0000'){
							
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
									words[i + 1] += board.getSpecialSpot(r,c) + allspots[r][c];
 
 
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
 
		for(int i = 0; i < words.length; i++){
			
		if(getword(words[i]).length() > 1)
			System.out.println("Word: " + words[i] + "\nNew word: "+ (getword(words[i])) +  "");	
		
		if(getword(words[i]).length() > 1 && (!dictionary1.checkDictionary(getword(words[i]))))
			return false;
		}
		
 
		return true;
	}
	
	public boolean searchLegalPlay() throws IOException{
		
		if((!Spelling()) || (!board.Placement(roundspots, turncount, allspots, tilesused)))
			return false; 
 
		else return true;
	}
 

	public String getword(String word){
		
		String newWord = "";
		for(int i = 0;i < word.length(); i++)
			if(!Character.isDigit(word.charAt(i)))
				newWord += word.charAt(i);
			else if(word.charAt(i) != '0')
				i++;
		
		return newWord;
	}
	
	public void getScore(String word){
		
		int wordmultiplier = 1;
		int wordscore = 0;

		
		for(int i = 0;i < word.length(); i++)
		{
			if(i + 1 < word.length() && (("" + word.charAt(i) + word.charAt(i + 1)).equals("2w")))
				wordmultiplier *= 2;
			
			if(i + 1 < word.length() && (("" + word.charAt(i) + word.charAt(i + 1)).equals("3w")))
				wordmultiplier *= 3;
		}
			
		for(int i = 0; i < word.length(); i++){
			int tilescore = 0;
			int tilemultiplier = 1;
			
			if(i + 1 < word.length() && ("" + word.charAt(i) + word.charAt(i + 1)).equals("2l")){
				tilemultiplier=2;
				i += 2;
			}
			
			else if (i + 1 < word.length() && ((("" + word.charAt(i) + word.charAt(i + 1)).equals("3l")))){
				tilemultiplier = 3;
				i += 2;
			}
			
			if(word.charAt(i) =='A' || word.charAt(i) == 'E' || word.charAt(i) == 'I' || word.charAt(i) == 'L' || word.charAt(i) == 'N' || word.charAt(i) == 'O' || word.charAt(i) == 'R' || word.charAt(i) =='S' || word.charAt(i) == 'T' || word.charAt(i) == 'U' || word.charAt(i) == 'V')
				tilescore = (tilescore + 1) * tilemultiplier;
 
			else if(word.charAt(i) =='D' || word.charAt(i) == 'G')
				tilescore = (tilescore + 2) * tilemultiplier;
 
			else if(word.charAt(i) == 'B' || word.charAt(i) == 'C' || word.charAt(i) == 'M' || word.charAt(i) == 'P')
				tilescore = (tilescore + 3) * tilemultiplier;
 
			else if(word.charAt(i) == 'F' || word.charAt(i) == 'H' || word.charAt(i) == 'W' || word.charAt(i) == 'Y')
				tilescore = (tilescore + 4) * tilemultiplier;
 
				if (word.charAt(i) == 'K')
				tilescore = (tilescore + 5) * tilemultiplier;
 
			else if(word.charAt(i) == 'J' || word.charAt(i) == 'X')
				tilescore = (tilescore + 8) * tilemultiplier;
 
			else if(word.charAt(i) == 'Q' || word.charAt(i) == 'Z')
				tilescore = (tilescore + 10) * tilemultiplier;
				
				wordscore += tilescore;
		}
		
		wordscore *= wordmultiplier;
		System.out.println("Points for word " + word + ": " + wordscore);

		roundscore += wordscore;
	}
 
	public void getTiles() throws IOException{
		
		for (int i = 0; i < Tileracks.length; i++) {
			if ((!Tileracks[i].isEnabled()) && bagoftiles.getSize() > 0) {
				tilerack1.setNewValue(i, bagoftiles.removeTile(0));
				Tileracks[i] = placeImage(i + 1, Tileracks[i]);
				Tileracks[i].setEnabled(true);
			}

			else if ((!Tileracks[i].isEnabled()) && bagoftiles.getSize() == 0)
				tilerack1.setNewValue(i, '0');

		}
				
		allempty = true;
		for(int i = 0; i < Tileracks.length; i++)
			
			if(tilerack1.getTile(i) != '0'){
				allempty = false;
				break;
			}
		
		if(allempty){
			
			String text = "";
			if(numplayers == 1)
				text = "The game is over. You scored " + scorep1 + " points. Congrats!";
			
			else if(numplayers == 2 && scorep1 > scorep2)
				text = "The game is over \"" + names[0] + "\" wins with a score of " + scorep1 + ". Good try \"" + names[1] + "\" you had " + scorep2 + " points.";
			
			else if(numplayers == 2 && scorep1 < scorep2)
				text = "The game is over \"" + names[1] + "\" wins with a score of " + scorep2 + ". Good try \"" + names[0] + "\" you had " + scorep1 + " points.";
			
			else if(numplayers == 2 && scorep1 == scorep2)
				text = "The game is over \"" + names[0] + "\" tied with \"" + names[0] + "\" with a score of " + scorep1 + " points.";
			
			JOptionPane.showMessageDialog(frame, text, "End Game", JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void setUpNextTurn() throws IOException{	
		
		for(int i = 0; i < roundspots.length; i++)
			for(int j = 0; j < roundspots[i].length; j++)
				
				if(roundspots[i][j] != '\u0000'){
					board.getSpot(i, j).setEnabled(false);
					board.getSpot(i, j).setBackground(Color.BLACK);
					roundspots[i][j] = '\u0000';
				}
		
		Character [] temp ={'-','-','-','-','-','-','-'};
		String formattedwords = "";
		
		for(int i = 0; i < words.length; i++)
			if(getword(words[i]).length() > 1){
				getScore(words[i]);
				formattedwords = formattedwords + " -" + getword(words[i]);
			}
		
		if(numplayers == 1){
			scorep1 += roundscore;
			txtCurrentScore.setText(currentscore + scorep1);
		}
		
		if(numplayers == 2 && playerturn1){
			scorep1 += roundscore;
			txtCurrentScore.setText(names[0] + "'s Score: " + scorep1);
		}
		
		if(numplayers == 2 && !playerturn1){
			scorep2 += roundscore;
			textField2.setText(names[1] + "'s Score: " + scorep2);
		}
 
		getTiles();
		if(numplayers == 2){
			for(int i = 0; i < otherplayer.length; i++) {
				temp[i] = tilerack1.getTile(i);
				tilerack1.setNewValue(i, otherplayer[i]);
				otherplayer[i] = temp[i];
			}
			
			for(int i = 0; i < Tileracks.length; i++)
				Tileracks[i] = placeImage(i + 1, Tileracks[i]);	
		}
		
		for(int i = 0; i < Tileracks.length; i++){
			if(tilerack1.getTile(i) != '0')
				Tileracks[i].setEnabled(true);
		
			if(tilerack1.getTile(i) == '0') {
				Tileracks[i].setEnabled(false);
				Tileracks[i].setText("");
			}
		}
 
		board.changeSpecialSpotsUsed();
		tilesused = 0;
		turncount++;
		
		formattedwords = formattedwords + "-";
		String text = "";
		if(formattedwords.length() > 1)
			text = "On the last play" + formattedwords + " was played for " + roundscore + " points!";
		
		else text = "No words were played on the last turn.";
		messagespot.setText(text);
		
		for(int i = 0; i < words.length; i++)
			words[i] = "";
		
		roundspots = new char [squaresize][squaresize];
		radiogroup.clearSelection();
		
		if(bagoftiles.getSize() > 0){
			
			for(int i = 0; i < tileSwap.length; i++)
				tileSwap[i].setEnabled(true);
			
 		swap.setEnabled(true);
		}
		
		else swap.setEnabled(false);
		
		if(numplayers == 2){
			
			playerturn1 = !playerturn1;
			String currentname = "";
			
			if(playerturn1)
				currentname = names[0].toString();
			
			else currentname = names[1].toString();
			
			if(!allempty){
				
			blank.setVisible(true);
			panel1.setVisible(false);
			}
			
			JOptionPane.showMessageDialog(frame,
					text + " It is \"" + currentname +  "'s\" turn. Press okay or the X in the corner to continue.", "Last Turn Played", JOptionPane.PLAIN_MESSAGE);
			
			if(!allempty){
				
				blank.setVisible(false);
				panel1.setVisible(true);
			}		
			
			formattedwords = "";
		}
		roundscore = 0;
		
		if(allempty){
			
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
 
	public void undo(){
		
		for(int i = 0; i < words.length; i++)
			words[i] = "";
		
		tilesused = 0;
		roundscore = 0;
 
		messagespot.setText("Any tiles placed during this turn were returned.");
		//boolean test= true;

		for(int i = 0; i < board.getBoardLength(); i++)
			for(int j = 0; j < board.getBoardLength(); j++){
				
				board.getSpot(i, j).setEnabled(false);
				
				if(board.getSpot(i, j).getBackground() != Color.BLACK){
					board.getSpot(i, j).setIcon(null);
					board.getSpot(i, j).setOpaque(false);
					board.getSpot(i, j).setContentAreaFilled(false);
			//test=false;
					if(board.getSpot(i, j).getBackground() == Color.BLUE)
						board.getSpot(i, j).setBackground(new JButton().getBackground());
				}
			}
		
		for(int i = 0; i < roundspots.length; i++)
			for(int j = 0; j < roundspots[i].length; j++) 
				
				if(roundspots[i][j] != '\u0000'){
					allspots[i][j] = '\u0000';
					roundspots[i][j] = '\u0000';
				}

		for(int i = 0; i < Tileracks.length ;i++)
			if(Tileracks[i].getText() !=  "")
				Tileracks[i].setEnabled(true);
		
		radiogroup.clearSelection();
		board.resetSpecialSpotsOfTurn();
	}
 
	public void newGame() throws IOException{
		
		for(int i = 0; i < Tileracks.length; i++)
			Tileracks[i].setEnabled(true);
 
		radiogroup.clearSelection();
 
		messagespot.setText("You clicked the New Game option. This starts your game over.");
		
		for(int i = 0; i < roundspots.length; i++)
			for(int j = 0; j < roundspots[i].length; j++){
				
				allspots[i][j] = '\u0000';
				roundspots[i][j] = '\u0000';
			}
 
		bagoftiles.clear();
		for(int i = 0; i < bagoftiles.getLetters().length(); i++)	
			bagoftiles.addTile(bagoftiles.getLetters().charAt(i));
 
		for(int i = 0; i < board.getBoardLength(); i++)
			for(int j = 0; j < board.getBoardLength(); j++){
				board.getSpot(i, j).setIcon(null);
				board.getSpot(i, j).setOpaque(false);
				board.getSpot(i, j).setContentAreaFilled(false);
				board.getSpot(i, j).setEnabled(false);
				board.getSpot(i, j).setBackground(new JButton().getBackground());
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
 
		bagoftiles.shuffleTileBag();
 
		for(int i = 0; i < tilerack1.getSize(); i++)
			tilerack1.setNewValue(i,bagoftiles.removeTile(0));
 
		for(int i = 1; i < 8; i++)
			Tileracks[i - 1] = placeImage(i, Tileracks[i - 1]);
		
		for(int i = 0; i < tileSwap.length; i++)
			tileSwap[i].setEnabled(true);
		
		play.setEnabled(true);
		btnShuffle.setEnabled(true);
		pass.setEnabled(true);
		undo.setEnabled(true);
		searchDictionary.setEnabled(true);
		
		swap.setEnabled(true);
		board.resetSpecialSpots();
		
		String[] choices = { "1", "2"};
		String numtemp = (String) JOptionPane.showInputDialog(null, "How many people are playing?",
		        "Number of Players", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
	
	   while(numtemp == null)
		   numtemp = (String) JOptionPane.showInputDialog(null, "How many people are playing?",
			        "Number of Players", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);
		   
	   numplayers = Integer.parseInt(numtemp);
		   names = new player[numplayers];
		    
		    if(numplayers > 1)
		    for(int i = 0; i < numplayers; i++){
		    	
		    	do {
	    			names[i] = new player(JOptionPane.showInputDialog("What is player " + (i + 1) +"'s name? (it must be less than 9 characters)"));
	    		
		    	}while(names[i] == null || names[i].toString().length() < 1 || names[i].toString().length() > 8);
		    }
		    
		    if(numplayers == 2){
		    	
		    	textField2.setText(names[1] + "'s Score: 0"); //alt name
		    	txtCurrentScore.setText(names[0]+ "'s Score: 0");
		    }
		    
		    if(numplayers == 1){
		    	
		    	txtCurrentScore.setText("Current Score: 0");
		    	textField2.setText("");
		    }
	}
 
	public JRadioButton placeImage(int a, JRadioButton btn) throws IOException{
		
		String url, html = "";
			switch(tilerack1.getTile(a - 1)){
			
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
				html = "<html><body><img src='" + tileL +"' width=29 height=29>";
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




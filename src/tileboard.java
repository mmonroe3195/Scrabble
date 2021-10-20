import java.awt.Color;

import javax.swing.JButton;

public class tileboard {

	JButton[][] tileboard;
	int squaresize;
	String[][]specialspots= new String[][]
	{		{"3w","0","0","2l","0","0","0","3w","0","0","0","2l","0","0","3w"},
			{"0","2w","0","0","0","3l","0","0","0","3l","0","0","0","2w","0"},
			{"0","0","2w","0","0","0","2l","0","2l","0","0","0","2w","0","0"},
			{"2l","0","0","2w","0","0","0","2l","0","0","0","2w","0","0","2l"},
			{"0","0","0","0","2w","0","0","0","0","0","2w","0","0","0","0"},
			{"0","3l","0","0","0","3l","0","0","0","3l", "0","0","0","3l","0"},
			{"0","0","2l","0","0","0","2l","0","2l","0","0","0","2l","0","0"},
			{"3w","0","0","2l","0","0","0","0","0","0","0","2l","0","0","3w"},
			{"0","0","2l","0","0","0","2l","0","2l","0","0","0","2l","0","0"},
			{"0","3l","0","0","0","3l","0","0","0","3l", "0","0","0","3l","0"},
			{"0","0","0","0","2w","0","0","0","0","0","2w","0","0","0","0"},
			{"2l","0","0","2w","0","0","0","2l","0","0","0","2w","0","0","2l"},
			{"0","0","2w","0","0","0","2l","0","2l","0","0","0","2w","0","0"},
			{"0","2w","0","0","0","3l","0","0","0","3l","0","0","0","2w","0"},
			{"3w","0","0","2l","0","0","0","3w","0","0","0","2l","0","0","3w"}
		};
		
//		//altered spots that are special spots with the ones used already removed from the array
		String[][] alteredspecialspots= specialspots.clone();
//		
//		//temporary altered spots during each turn
//		String[][] tempalteredspecialspots= specialspots.clone();

		String[][] specialSpotsUsedForTurn;
	
	public tileboard(int size){
		
		tileboard = new JButton[size][size];
		squaresize= size;
		specialSpotsUsedForTurn= new String [size][size];
		
		for(int i = 0; i < tileboard.length; i++)
			for(int j = 0; j < tileboard[i].length; j++)
				specialSpotsUsedForTurn[i][j] = "0";
	}
	
	public JButton[][] setUpBoard(){
		
		for(int i = 0; i < tileboard.length; i++)
				for(int j = 0; j < tileboard[i].length; j++) {
					tileboard[i][j] = new JButton("");
					tileboard[i][j].setLocation(j*40+165, i*40+60);
					tileboard[i][j].setSize(40,40);
					tileboard[i][j].setOpaque(false);
					tileboard[i][j].setContentAreaFilled(false);
					tileboard[i][j].setBorderPainted(false);
					tileboard[i][j].setEnabled(false);
			}
		
		return tileboard;
	}
	
	public int getBoardLength(){
		return tileboard.length;
	}
	
	public JButton getSpot(int i, int j){
		return tileboard[i][j];
	}
	
	public boolean Placement(char[][] roundspots, int turncount, char[][] allspots, int tilesused){
		if(turncount == 0 && roundspots[7][7] == '\u0000') //roundspots[7][7] is the start spot for scrabble games //fix later to make based on square size
			return false;
 
		boolean breaker = false;
		int tilesinword = 0;
		boolean place = false;
		boolean downandu = false;
		
		for(int i = 0; i < roundspots.length; i++)
		{
			if(breaker)
				break;
 
			for(int c = 0; c < roundspots[i].length; c++){
				int a = 0;
 
				boolean m = false;
				boolean n = false;
				
				if(i + 1 < squaresize && allspots[i + 1][c] != '\u0000')
					m = true;
 
				if(i - 1 >= 0 && allspots[i - 1][c] != '\u0000')
					n = true;
				
				if((((roundspots[i][c] != '\u0000'))) && ((m) || (n))){
					a = 1;
					for(int r = 0; r < squaresize; r++)
						if(r<roundspots[i].length && roundspots[r][c] != '\u0000')
							{tilesinword++;
							downandu = true;
							}
 
					if(turncount == 0){
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
 
				
				if((a != 1 || downandu) && (roundspots[i][c] != '\u0000') && ((o) || (p))){	
					a = 2;
					
					for(int s = 0; s < squaresize; s++)
						if(s < roundspots[c].length && roundspots[i][s] != '\u0000')
							tilesinword++;
					
					if(downandu)
						tilesinword--;
						
					if(turncount == 0){
						breaker = true;
						break;
					}
				}
 
				int oldc = c;
				if(a == 2||a == 1 && turncount > 0){
					for(int z = 0; z <= 7; z++){
						if(i - 1 >= 0 && (getSpot(i - 1, c).getBackground() == Color.BLACK))
							place = true;
 
						if(i + 1 < squaresize && (getSpot(i + 1, c).getBackground() == Color.BLACK))
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
 
				c = oldc;
				
				if((place != true) && (a == 2 || a == 1 && turncount > 0)){
					
					for(int z = 0; z <= 7; z++){
						
						if(c + 1 < squaresize && getSpot(i, c + 1).getBackground() == Color.BLACK)
							place=true;
							
							if(c - 1 >= 0 && getSpot(i, c - 1).getBackground() == Color.BLACK)
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
	
	public String getSpecialSpot(int i, int j){
		specialSpotsUsedForTurn[i][j] = alteredspecialspots[i][j];
		return alteredspecialspots[i][j];
	}
	
	//done with new turn
	public void changeSpecialSpotsUsed(){
		
		for(int i = 0; i < specialSpotsUsedForTurn.length; i++)
			for(int j = 0; j < specialSpotsUsedForTurn[i].length; j++)
				if(!(specialSpotsUsedForTurn[i][j].equals("0")))
					alteredspecialspots[i][j]= "0";
				
	}
	
	//done when undo or false turn
	public void resetSpecialSpotsOfTurn(){
		
		for(int i = 0; i < tileboard.length; i++)
			for(int j = 0; j < tileboard[i].length; j++)
				specialSpotsUsedForTurn[i][j] = "0";
	}
	
	//done with new game
	public void resetSpecialSpots(){
		
		alteredspecialspots= specialspots.clone();
	}
}




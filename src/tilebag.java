import java.util.ArrayList;
import java.util.Collections;

public class tilebag {
	String letters;
	//change to an array of tiles
	static ArrayList<tile> tilebag = new ArrayList <tile>();

	public tilebag(String stringofletters)
	{
		letters = stringofletters;
	}
	
	public void setUpTileBag()
	{
		//Creates tile bag
		 
				for(int i = 0; i < letters.length() ;i++)
				{
					tilebag.add(new tile(letters.charAt(i)));
				}
	}
	
	public void shuffleTileBag()
	{
		//Shuffles tile bag
		Collections.shuffle(tilebag);
	}
	
	public int getSize()
	{
		return tilebag.size();
		}
	
	public String getLetters()
	{
		return letters;
	}
	
	public void addTile(char tile)
	{
		tilebag.add(new tile(tile));
	}
	
	public char removeTile(int index)
	{
		return tilebag.remove(index).getTile();
	}
	
	public void clear()
	{
		tilebag.clear();
	}
	
	public String printTiles()
	{
		String b = "";
		for(int i = 0; i < tilebag.size(); i++)
			b += tilebag.get(i) + "";
		
		return b;
	}

}



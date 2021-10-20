
public class tilerack {

	Character [] tilerackchars= new Character [7];
	public tilerack(){
		
	}
	
	public void addToRack(char add)
	{
		for(int i = 0; i < tilerackchars.length; i++)
			tilerackchars[i] = add;
	}
	
	public char getTile(int i)
	{
		return tilerackchars[i];
	}
	
	public void setNewValue(int i, char newValue)
	{
		tilerackchars[i] = newValue;
	}
	
	public int getSize()
	{
		return tilerackchars.length;
	}
	
	
}



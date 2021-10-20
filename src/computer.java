import java.util.ArrayList;

public class computer {
	
	public computer()
	{
		
	}
	
	static public ArrayList<String> permutate(String word)
	{
		ArrayList<String> result = new ArrayList<String>();
		if (word.length() == 0)
		{
			result.add(word);
			return result;
		}
		for(int i = 0; i < word.length() ;i++)
		{
			String shorter = word.substring(0, i) + word.substring(i + 1);
			ArrayList<String> shorterPermutations = permutate(shorter);
			
			for(String s: shorterPermutations)
				result.add(word.charAt(i) + s);
		}
			return result;	
	}
	

}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class dictionary {
	
	public dictionary()
	{
	}

	public boolean checkDictionary(String a) throws FileNotFoundException {
		if (a.length() == 0)
			return false;

		a = a.toUpperCase();
		String file = "";
		switch (a.charAt(0)) {
		case 'A':
			file = "src/Adict.txt";
			break;

		case 'B':
			file = "src/Bdict.txt";
			break;

		case 'C':
			file = "src/Cdict.txt";
			break;

		case 'D':
			file = "src/Ddict.txt";
			break;

		case 'E':
			file = "src/Edict.txt";
			break;

		case 'F':
			file = "src/Fdict.txt";
			break;

		case 'G':
			file = "src/Gdict.txt";
			break;

		case 'H':
			file = "src/Hdict.txt";
			break;

		case 'I':
			file = "src/Idict.txt";
			break;

		case 'J':
			file = "src/Jdict.txt";
			break;

		case 'K':
			file = "src/Kdict.txt";
			break;

		case 'L':
			file = "src/Ldict.txt";
			break;

		case 'M':
			file = "src/Mdict.txt";
			break;

		case 'N':
			file = "src/Ndict.txt";
			break;

		case 'O':
			file = "src/Odict.txt";
			break;

		case 'P':
			file = "src/Pdict.txt";
			break;

		case 'Q':
			file = "src/Qdict.txt";
			break;

		case 'R':
			file = "src/Rdict.txt";
			break;

		case 'S':
			file = "src/Sdict.txt";
			break;

		case 'T':
			file = "src/Tdict.txt";
			break;

		case 'U':
			file = "src/Udict.txt";
			break;

		case 'V':
			file = "src/Vdict.txt";
			break;

		case 'W':
			file = "src/Wdict.txt";
			break;

		case 'X':
			file = "src/Xdict.txt";
			break;

		case 'Y':
			file = "src/Ydict.txt";
			break;

		case 'Z':
			file = "src/Zdict.txt";
			break;

		default:
			return false;
		}

		Scanner fileScanner = new Scanner(new File(file));
		while (fileScanner.hasNext()) {
			String word = fileScanner.nextLine();
			if (a.equals(word))
				return true;
		}
		return false;
	}
	
}






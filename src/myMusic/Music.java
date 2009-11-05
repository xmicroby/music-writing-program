package myMusic;

public class Music
{
	public static final int MAJOR = 0, MINOR = 1, DIMINISHED = 2;
	//public static final char[] ORDER_OF_SHARPS = {'F', 'C', 'G', 'D', 'A', 'E', 'B'};
	//public static final char[] ORDER_OF_FLATS = {'B', 'E', 'A', 'D', 'G', 'C', 'F'};
	
	
	public static int indexOf(char c, char[] a)
	{
		for (int i = 0; i < a.length; i++)
			if (a[i] == c)
				return i;
		return -1;
	}
	
	public static int getValue(String str)
	{
		int note = 0;
		char letter = ' ', acc = ' ';
		
		letter = str.charAt(0);
		
		if (str.length() == 2)
			acc = str.charAt(1);
		
		if (Character.toLowerCase(letter) == 'c')
			note = 0;
		else if (Character.toLowerCase(letter) == 'd')
			note = 2;
		else if (Character.toLowerCase(letter) == 'e')
			note = 4;
		else if (Character.toLowerCase(letter) == 'f')
			note = 5;
		else if (Character.toLowerCase(letter) == 'g')
			note = 7;
		else if (Character.toLowerCase(letter) == 'a')
			note = 9;
		else if (Character.toLowerCase(letter) == 'b')
			note = 11;
		else
			note = 0;
		
		if (acc == 'b' && note == 0)
			return 11;
		else if (acc == 'b')
			return note - 1;
		else if (acc == '#')
			return note + 1;
		else
			return note;
			
	}
	public static String getName(int note, int type)
	{
		int newNote = note % 12;
		
		if (type == Key.SHARP)
			switch(newNote)
			{
				case 0: return "C";
				case 1: return "C#";
				case 2: return "D";
				case 3: return "D#";
				case 4: return "E";
				case 5: return "F";
				case 6: return "F#";
				case 7: return "G";
				case 8: return "G#";
				case 9: return "A";
				case 10: return "A#";
				case 11: return "B";
				default: return "INVALID";
			}
		else
			switch(newNote)
			{
				case 0: return "C";
				case 1: return "Db";
				case 2: return "D";
				case 3: return "Eb";
				case 4: return "E";
				case 5: return "F";
				case 6: return "Gb";
				case 7: return "G";
				case 8: return "Ab";
				case 9: return "A";
				case 10: return "Bb";
				case 11: return "B";
				default: return "INVALID";
			}	
	}

	public static String getName(int note)
	{
		return getName(note, Key.FLAT);
	}
}

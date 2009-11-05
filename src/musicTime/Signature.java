package musicTime;

import graphics.Note;

public class Signature
{
	//add 7 each time:
	private String[] sharpKeyNames = {"C", "G", "D", "A", "E", "B", "F#", "C#"};
	private String[] flatKeyNames = {"C", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};

	public static final char[] ORDER_OF_SHARPS = {'F', 'C', 'G', 'D', 'A', 'E', 'B'};
	public static final char[] ORDER_OF_FLATS = {'B', 'E', 'A', 'D', 'G', 'C', 'F'};
	
	public static final int MAJOR = 0;
	public static final int MINOR = 1;
	
	/**The note which describes the key. "A" means the key of A. The quality of the key (major/minor) is by default major.**/
	private String name = "C";
	/**The quality of the key (major/minor). Example: A minor, C major, Db minor, etc.**/
	private int quality = Signature.MAJOR;
	
	/**Number of accidentals (sharps/flats)**/
	private int amt = 0;
	/**Way in which the key is notated (sharps/flats). Default: Flat**/
	private int accType = Note.FLAT;
	
	public Signature()
	{
	}

	/**Sets**/
	public Signature(String note)
	{
		amt = getNumberOfAcc(getEnharmonic(note));
	}
	public Signature(int accType, String note)
	{
		amt = getNumberOfAcc(getEnharmonic(note));
		this.accType = accType;
	}
	
	private int getNumberOfAcc(String note)
	{
		accType = Note.FLAT;
		for (int i = 0; i < flatKeyNames.length; i++)
			if (note.equals(flatKeyNames[i]))
				return i;
		
		accType = Note.SHARP;
		for (int i = 0; i < sharpKeyNames.length; i++)
			if (note.equals(sharpKeyNames[i]))
				return i;
		
		accType = Note.FLAT;
		return 0;
	}
	
	public int getKeyQuality()
	{
		return quality;
	}
	public String getKeyName()
	{
		return name;
	}
	
	public int getNumberOfAcc()
	{
		return amt;
	}
	public void setNumberOfAcc(int amt)
	{
		this.amt = amt;
	}
	private String getEnharmonic(String note)
	{
		if (note.equals("B#"))
			return "C";
		
		if (note.contains("#"))
			return (char)(note.charAt(0) + 1) + "b";
		
		return note;	
	}
	
	public int getAccType()
	{
		return accType;
	}
	
	public static boolean isValid(String note)
	{
		note = note.trim();
		
		if (note.length() == 0 || note.length() > 2)
			return false;

		if (note.length() == 1)
			if ((int)note.charAt(0) >= 65 && (int)note.charAt(0) <= 71)
				return true;
		
		if (note.charAt(1) == '#' || note.charAt(1) == 'b')
			return true;
		
		return false;
	}
	
	
	public boolean[] getAcc()
	{
		boolean[] acc = new boolean[7];
		
		for (int i = 0; i < acc.length; i++)
			acc[i] = false;
		
		for (int i = 0; i < amt; i++)
			acc[i] = true;
		
		return acc;
	}
	
	public boolean addAcc(String note)
	{
		if (accType == Note.FLAT)
		{
			for (int i = 0; i < amt; i++)
				if (note.charAt(0) == Signature.ORDER_OF_FLATS[i])
					return true;
		}
		else
			for (int i = 0; i < amt; i++)
				if (note.charAt(0) == Signature.ORDER_OF_SHARPS[i])
					return true;	

		return false;
	}
}
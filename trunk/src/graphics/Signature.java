package graphics;

import java.awt.Graphics;

public class Signature
{
	//add 7 each time:
	private String[] sharpKeyNames = {"C", "G", "D", "A", "E", "B", "F#", "C#"};
	private String[] flatKeyNames = {"C", "F", "Bb", "Eb", "Ab", "Db", "Gb", "Cb"};
	
	public static final char[] ORDER_OF_SHARPS = {'F', 'C', 'G', 'D', 'A', 'E', 'B'};
	public static final char[] ORDER_OF_FLATS = {'B', 'E', 'A', 'D', 'G', 'C', 'F'};
	
	private int amt = 0;
	private int accType = Note.FLAT;
	
	public Signature()
	{
	}

	//Much more useful!!
	public Signature(String note)
	{
		amt = getNumberOfAcc(convertToFlat(note));
	}
	public Signature(int accType, String note)
	{
		amt = getNumberOfAcc(convertToFlat(note));
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
	public int getNumberOfAcc()
	{
		return amt;
	}
	public void setNumberOfAcc(int amt)
	{
		this.amt = amt;
	}
	private String convertToFlat(String note)
	{
		if (note.equals("G#"))
			return "Ab";
		
		if (note.contains("#"))
			return (char)(note.charAt(0) + 1) + "b";
		
		return note;	
	}
	
	public int getAccType()
	{
		return accType;
	}
	
	public void drawSignature(Graphics g)
	{
		if (accType == Note.SHARP)
		{
			int tempAmt = amt;
			int x = 70, y = 0;
			for (int i = 0; i < ORDER_OF_SHARPS.length; i++)
			{
				if (tempAmt <= 0)
					break;
				x += 14;
				y = DrawStaff.DIST_BETWEEN_LINES * (DrawSignature.getLine(accType, ORDER_OF_SHARPS[i]) + 1) + 29;
				g.drawString("#", x, y);
				tempAmt--;
			}
		}
		else
		{
			int tempAmt = amt;
			int x = 70, y = 0;
			for (int i = 0; i < ORDER_OF_FLATS.length; i++)
			{
				if (tempAmt <= 0)
					break;
				x += 14;
				y = DrawStaff.DIST_BETWEEN_LINES * (DrawSignature.getLine(accType, ORDER_OF_FLATS[i]) + 1) + 27;
				g.drawString("b", x, y);
				tempAmt--;
			}
		}
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
package sound;

import graphics.DrawStaff;
import myMusic.Music;

public class Note
{
	public static final int BASE = 0, TREBLE = 1;
	public static final int SIXTEENTH_NOTE = 0, EIGHTH_NOTE = 1,
		QUARTER_NOTE = 2, DOTTED_QUARTER_NOTE = 3, HALF_NOTE = 4,
		DOTTED_HALF_NOTE = 5, WHOLE_NOTE = 6;
	
	private int note, start;
	/**The length of the note. 2 = sixteenth note. 8 = quarter note. 32 = whole note. Usw.**/
	private int length;
	
	public Note(){}
	public Note(int note)
	{
		this.note = note;
		if (note < 0)
			note += 12;
		length = 16;
	}
	public Note(int note, int noteType)
	{
		this.note = note;
		length = Note.getLength(noteType);
	}
	public Note(int note, int noteType, int start)
	{
		this.note = note;
		if (note < 0)
			note += 12;
		
		//multiply by 8 to keep it consistent with length
		this.start = start;
		length = Note.getLength(noteType);
	}
	
	
	public int getNote()
	{
		return note;
	}
	public void setNote(int note)
	{
		this.note = note;
	}
	public void setLength(int length)
	{
		this.length = length;
	}
	public int getLength()
	{
		return length;
	}
	
	public String toString()
	{
		return Music.getName(note);
	}
	
	public static int getLength(int noteType)
	{
		switch(noteType)
		{
			//TODO: 16th notes = 2
			case Note.SIXTEENTH_NOTE: return 1;
			case Note.EIGHTH_NOTE: return 2;
			case Note.QUARTER_NOTE: return 4;
			case Note.DOTTED_QUARTER_NOTE: return 6;
			case Note.HALF_NOTE: return 8;
			case Note.DOTTED_HALF_NOTE: return 12;
			case Note.WHOLE_NOTE: return 16;
			default: return noteType;
		}
	}
	public static String getLengthName(int noteType)
	{
		//TODO: make sure this is right, 1/8th note returns 1 or 1/2?
		switch(noteType)
		{
			//TODO: 16th notes are really 0.5
			case 0: return "16th";
			case 1: return "8th";
			case 2: return "quarter";
			case 3: return "3/8th";
			case 4: return "half";
			case 5: return "3/4th";
			case 6: return "whole";
			default: return "quarter";
		}
	}
	public static int getNote(int line)
	{
		switch(line)
		{
			case -2: return 9;
			case -1: return 7;
			case 0: return 5;
			case 1: return 4;
			case 2: return 2;
			case 3: return 0;
			case 4: return 11;
			case 5: return 9;
			case 6: return 7;
			case 7: return 5;
			case 8: return 4;
			case 9: return 2;
			default: return 0;
		}
	}
	public static int getNote(int line, int staffType)
	{
		int newNote = 0, c_line = 0;
		if (staffType == DrawStaff.TREBLE)
		{
			newNote = getNote(line) + 48;
			c_line = 3;
		}
		else
		{
			newNote = getNote(line - 2) + 24;
			c_line = 5;
		}
		
		if (line <= c_line)
			newNote+=12;
		
		return newNote;
	}
	
	
	
	public void halfStepDown()
	{
		note--;
	}
	public void halfStepUp()
	{
		note++;
	}
	public void addAcc(int acc)
	{
		note += acc;
	}
	
	public void setStart(int start)
	{
		this.start = start;
	}
	public int getStart()
	{
		return start;
	}
}

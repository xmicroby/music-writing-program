package graphics;

import java.awt.Graphics;

import musicTime.Signature;

public class DrawSignature
{
	/**
	 * Static method used to physically draw a key signature using the Graphics object that is passed in.
	 * @param g the Graphics object used to draw the signature
	 * @param sign the signature that is being drawn
	 * @param translateX any translation of the key signature
	 */
	public static void drawSignature(Graphics g, Signature sign, int translateX)
	{
		int x = 70 - translateX, y = 0;
		if (sign.getAccType() == Note.SHARP)
		{
			for (int i = 0; i < sign.getNumberOfAcc(); i++)
			{
				x += 14;
				y = DrawStaff.DIST_BETWEEN_LINES * (getLine(sign.getAccType(), Signature.ORDER_OF_SHARPS[i]) + 1) + 29;
				g.drawString("#", x, y);
			}
		}
		else
		{
			for (int i = 0; i < sign.getNumberOfAcc(); i++)
			{
				x += 14;
				y = DrawStaff.DIST_BETWEEN_LINES * (getLine(sign.getAccType(), Signature.ORDER_OF_FLATS[i]) + 1) + 27;
				g.drawString("b", x, y);
			}
		}
	}
	/**
	 * Finds which line to draw a sharp or flat on, depending on whether the key signature is written in sharps or flats.
	 * @param accType denotes how the key signature is written.
	 * 	Note.FLAT (-1) if the signature is written in flats.
	 * 	Note.SHARP (1) if the signature is written in sharps.
	 * @param note is the note that is being drawn
	 * @return the line on which the given accidental is being drawn.
	 */
	static int getLine(int accType, char note)
	{
		
		//for treble clef ONLY
		//TODO: ^ change that...
		
		switch(note)
		{
			case 'E': return 1;
			case 'D': return 2;
			case 'C': return 3;
			case 'B': return 4;
			case 'A': return 5;
			case 'G':
				if (accType == Note.FLAT)
					return 6;
				else
					return -1;
			case 'F':
				if (accType == Note.FLAT)
					return 7;
				else
					return 0;
			default: return 3;
		}
	}
}

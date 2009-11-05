package graphics;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MyImages
{
	public static Image getClef(int type)
	{
		Image img = null;
		
		try {
			if (type == DrawStaff.TREBLE)
				img = ImageIO.read(new File("Images/treble.bmp"));
			else
				img = ImageIO.read(new File("Images/base.bmp"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}
	
	public static Image getNoteImage(double beats, boolean flipped)
	{
		//This doesn't correspond to the program:
		//1 beat = quarter note, 4 = whole note, 1/2 = 1/8th note, usw....
		
		Image img = null;
		
		try {
			if (flipped)
			{
				if (beats == 0)
					img = ImageIO.read(new File("Images/16th_note_flipped.bmp"));
				else if (beats == 1)
					img = ImageIO.read(new File("Images/eigth_note_flipped.bmp"));
				else if (beats == 2)
					img = ImageIO.read(new File("Images/quarter_note_flipped.bmp"));
				else if (beats == 3)
					img = ImageIO.read(new File("Images/quarter_note_flipped.bmp"));
				else if (beats == 4)
					img = ImageIO.read(new File("Images/half_note_flipped.bmp"));
				else if (beats == 5)
					img = ImageIO.read(new File("Images/half_note_flipped.bmp"));
				else
					img = ImageIO.read(new File("Images/whole_note_flipped.bmp"));
			}
			else
			{
				if (beats == 0)
					img = ImageIO.read(new File("Images/16th_note.bmp"));
				else if (beats == 1)
					img = ImageIO.read(new File("Images/eigth_note.bmp"));
				else if (beats == 2)
					img = ImageIO.read(new File("Images/quarter_note.bmp"));
				else if (beats == 3)
					img = ImageIO.read(new File("Images/quarter_note.bmp"));
				else if (beats == 4)
					img = ImageIO.read(new File("Images/half_note.bmp"));
				else if (beats == 5)
					img = ImageIO.read(new File("Images/half_note.bmp"));
				else
					img = ImageIO.read(new File("Images/whole_note.bmp"));
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}
}

package graphics;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

public class Note
{
	public static final int FLAT = -1, SHARP = 1, NORMAL = 0;
	private final int startingPos = 240;
	
	private int type = 0, line = 0, pos = startingPos, acc = 0;
	
	public Note()
	{
		type = 0;
		line = 0;
		//acc = 0;
	}
	
	public Note(int type)
	{
		line = 0;
		this.type = type;
	}
	
	public Note(int line, int pos)
	{
		this.line = line;
		this.pos = pos + startingPos;
	}
	public Note(int line, int pos, int type)
	{
		this.line = line;
		this.pos = pos + startingPos;
		this.type = type;
	}
	
	public void setLine(int line)
	{
		this.line = line;
	}
	public void setPos(int pos)
	{
		this.pos = pos + startingPos;
	}
	
	public int getType()
	{
		return type;
	}
	public void setType(int type)
	{
		this.type = type;
	}
	public void setAcc(int acc)
	{
		this.acc = acc;
	}
	public void draw(Graphics2D g, int XChange, ImageObserver obs)
	{
		if (line <= 4)
			g.drawImage(MyImages.getNoteImage(type, true), pos - XChange, (int)(line * DrawStaff.DIST_BETWEEN_LINES) + 12 + DrawStaff.DIST_BETWEEN_LINES, obs);
		else	
			g.drawImage(MyImages.getNoteImage(type, false), pos - XChange, (int)(line * DrawStaff.DIST_BETWEEN_LINES), obs);
	
		//for even types (other than 0), add a dot ("and a half...")
		if (type == 3 || type == 5)
			g.fillOval(pos + 23 - XChange, (int)(line * DrawStaff.DIST_BETWEEN_LINES) + DrawStaff.DIST_BETWEEN_LINES + 18, 5, 5);
		if (acc == 1)
			g.drawString("#", pos - 13 - XChange, DrawStaff.DIST_BETWEEN_LINES * line + 42);
		else if (acc == -1)
			g.drawString("b", pos - 13 - XChange, DrawStaff.DIST_BETWEEN_LINES * line + 40);
	}
}

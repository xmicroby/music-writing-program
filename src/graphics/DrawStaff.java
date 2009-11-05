package graphics;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import musicTime.Fraction;
import musicTime.Signature;

@SuppressWarnings("serial")
public class DrawStaff extends JPanel
{
	public static final int BASE = 0, TREBLE = 1;
	public static final int DIST_BETWEEN_LINES = 12;
	public static final int LENGTH = 1350;
	
	private Line2D.Double[] lines = new Line2D.Double[10];
	private ArrayList<Note> notes = new ArrayList<Note>();
	private ArrayList <Line2D.Double> barLines = new ArrayList <Line2D.Double>();
	
	private int pos, staffType;
	
	private Note selectedNote;
	private Signature sign = new Signature();
	private Fraction time = new Fraction(4,4);
	
	private int translateX;
	
	public DrawStaff()
	{
		pos = 0;
		translateX = 0;
		selectedNote = new Note();
		staffType = TREBLE;
		
		for (int i = 0; i < lines.length; i++)
			lines[i] = new Line2D.Double(20 - translateX, DrawStaff.DIST_BETWEEN_LINES * (i + 1) + 20, 20 + DrawStaff.LENGTH - translateX, DrawStaff.DIST_BETWEEN_LINES * (i + 1) + 20);
	}
	public DrawStaff(int staffType)
	{
		this.staffType = staffType;
		pos = 0;
		selectedNote = new Note();
		
		for (int i = 0; i < lines.length; i++)
			lines[i] = new Line2D.Double(20 - translateX, DrawStaff.DIST_BETWEEN_LINES * (i + 1) + 20, 20 + DrawStaff.LENGTH - translateX, DrawStaff.DIST_BETWEEN_LINES * (i + 1) + 20);
	}
	
	@Override
	public void paintComponent(Graphics graphics)
	{
		Graphics2D g = (Graphics2D) graphics;
		g.setFont(g.getFont().deriveFont(0,28));
		//draw the staff:
		g.drawImage(MyImages.getClef(staffType), -translateX, 0, this);
		
		//Draw the key signature:
		
		DrawSignature.drawSignature(g, sign, translateX);
		
		//And draw the time signature:
		
		g.setFont(g.getFont().deriveFont(0, 50));
		g.drawString(String.valueOf(time.getNumerator()), 185 - translateX, 75);
		g.drawString(String.valueOf(time.getDenominator()), 185 - translateX, 120);
		g.setFont(g.getFont().deriveFont(0, 28));
		
		
		for (int i = 0; i < notes.size(); i++)
			notes.get(i).draw(g, translateX, this);
		
		selectedNote.draw(g, translateX, this);
		
		for (int i = 0; i < lines.length; i+=2)
			g.draw(lines[i]);
		
		for (int i = 0; i < barLines.size(); i++)
			g.drawLine((int)(barLines.get(i).x1 - translateX), (int)barLines.get(i).y1, (int)(barLines.get(i).x2 - translateX), (int)barLines.get(i).y2);
	}
	
	public void drawNote(int line, int type, int acc)
	{
		//notes.clear();
		Note n = new Note(line, pos, type);
		n.setAcc(acc);
		notes.add(n);
		pos += 50; //* (n.getType() + 1);
	}
	public void drawSelectedNote(int line, int type, int acc)
	{
		selectedNote.setLine(line);
		selectedNote.setPos(pos);
		selectedNote.setType(type);
		selectedNote.setAcc(acc);
	}
	
	public Note getSelectedNote()
	{
		return selectedNote;
	}
	
	public int getClosestLine(Point2D p)
	{
		double distance = 500;
		int index = 0;
		
		for (int i = 0; i < lines.length; i++)
		{
			if (lines[i].ptLineDist(p) < distance)
			{
				distance = lines[i].ptLineDist(p);
				index = i;
			}
		}
		
		return index;
	}
	public void setAcc(int acc)
	{
		selectedNote.setAcc(acc);
	}
	public void setSignature(Signature sign)
	{
		this.sign = sign;
	}
	
	public void setTime(Fraction time)
	{
		this.time = time;
	}
	public void drawBarLine()
	{
		barLines.add(new Line2D.Double(pos + 170, 33, pos + 170, 128));
	}
	public void clearAll()
	{
		pos = 0;
		notes.clear();
		barLines.clear();
		translateX = 0;
	}
	public void remove(int index)
	{
		pos -= 50; //* (notes.get(index).getType() + 1);
		notes.remove(index+1);
	}
	public void removeLastNote()
	{
		pos -= 50; //* (notes.get(notes.size() - 1).getType() + 1);
		notes.remove(notes.size() - 1);
	}
	public void deleteLastBarLine()
	{
		barLines.remove(barLines.size() - 1);
	}
	public void translateX(int x)
	{
		translateX += x;
	}
	public int getTranslation()
	{
		return translateX;
	}
	public void setTranslation(int translateX)
	{
		this.translateX = translateX;
	}
}

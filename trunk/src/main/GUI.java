package main;

import graphics.DrawStaff;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import musicTime.Fraction;
import musicTime.Signature;
import myMusic.Music;

import sound.Note;

@SuppressWarnings("serial")
public class GUI extends JFrame implements KeyListener, ActionListener, MouseListener, MouseMotionListener, MouseWheelListener
{
	private DrawStaff staff;
	private int noteType = 1, acc;
	private int position;
	
	private JButton[] selectLength;
	private JButton addSharp, addFlat, addNat, selectKey, play,
		deleteNote, clear, toStart, toEnd, moveRight, moveLeft;
	
	private String key;
	private Signature sign;
	private Fraction time;
	
	private Start startDialog;
	private Song song;
	
	private int staffType;

	public GUI()
	{
		super("Awesome Music Program!");
		
		song = new Song();
		time = new Fraction(4,4);
		sign = new Signature();
		key = "C";
		selectLength = new JButton[7];
		staffType = DrawStaff.TREBLE;
		
		setJMenuBar(getMyMenuBar());
		setLayout(new GridLayout(3,1));
		
		staff = new DrawStaff(staffType);
		staff.addMouseListener(this);
		staff.addMouseMotionListener(this);
		staff.addMouseWheelListener(this);
		add(staff);
		
		setSize(getMaximumSize());
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		startDialog = new Start(this);
		startDialog.setAlwaysOnTop(true);
		startDialog.setLocation(250, 250);
		startDialog.setVisible(true);
	}
	
	
	public JMenuBar getMyMenuBar()
	{
		JMenuBar mb = new JMenuBar();
		
		JMenu file = new JMenu("File");
		JMenu addMenu = new JMenu("Add...");

		JMenuItem addNewStaff = new JMenuItem("New Staff");
		addNewStaff.addActionListener(this);
		addNewStaff.setActionCommand("addNewStaff");
		addMenu.add(addNewStaff);
		
		file.add(addMenu);
		mb.add(file);
		
		
		toStart = new JButton("<<<");
		toStart.addActionListener(this);
		toStart.setActionCommand("toStart");
		mb.add(toStart);
		
		moveLeft = new JButton("<");
		moveLeft.addActionListener(this);
		moveLeft.setActionCommand("left");
		mb.add(moveLeft);
		
		mb.add(getLengthToolBar());
		mb.add(getAccToolBar());
		mb.add(getKeySelectionToolBar());
		
		moveRight = new JButton(">");
		moveRight.addActionListener(this);
		moveRight.setActionCommand("right");
		mb.add(moveRight);
		
		/*toEnd = new JButton(">>>");
		toEnd.addActionListener(this);
		toEnd.setActionCommand("toEnd");
		mb.add(toEnd);*/
		
		return mb;
	}
	
	public JToolBar getLengthToolBar()
	{
		JToolBar tb = new JToolBar();
		
		for (int i = 0; i < selectLength.length; i++)
		{
			selectLength[i] = new JButton();
			selectLength[i].setText(Note.getLengthName(i) + " note");
			selectLength[i].addActionListener(this);
			selectLength[i].setActionCommand("length=" + i);
			tb.add(selectLength[i]);
		}
		
		return tb;
	}
	
	public JToolBar getAccToolBar()
	{
		JToolBar tb = new JToolBar();
		
		addSharp = new JButton("Sharp #");
		addSharp.addActionListener(this);
		addSharp.setActionCommand("sharp");
		tb.add(addSharp);
		
		addFlat = new JButton("Flat b");
		addFlat.addActionListener(this);
		addFlat.setActionCommand("flat");
		tb.add(addFlat);
		
		addNat = new JButton("Natural");
		addNat.addActionListener(this);
		addNat.setActionCommand("nat");
		tb.add(addNat);
		
		return tb;
	}
	
	public JToolBar getKeySelectionToolBar()
	{
		JToolBar tb = new JToolBar();
		
		selectKey = new JButton("Select Key");
		selectKey.addActionListener(this);
		selectKey.setActionCommand("selectKey");
		//tb.add(selectKey);
		
		play = new JButton("Play");
		play.addActionListener(this);
		play.setActionCommand("play");
		tb.add(play);
		
		deleteNote = new JButton("Delete");
		deleteNote.addActionListener(this);
		deleteNote.setActionCommand("delete");
		tb.add(deleteNote);
		
		clear = new JButton("Clear All");
		clear.addActionListener(this);
		clear.setActionCommand("clear");
		tb.add(clear);
		
		return tb;
	}

	public static void main(String[] args)
	{
		new GUI();
	}
	
	
	public void mouseClicked(MouseEvent e)
	{
	}
	
	public void mouseEntered(MouseEvent e)
	{
	}
	
	public void mouseExited(MouseEvent e)
	{
	}
	
	public void mousePressed(MouseEvent e)
	{
	}
	
	
	public void mouseReleased(MouseEvent e)
	{
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			//create a new note for the given line, include accidentals, and set the length:
			Note n = new Note(Note.getNote(staff.getClosestLine(e.getPoint()), staffType), noteType, position);
			n.addAcc(acc);
			
			//and also make sure it works with the key signature!!
			if (n.toString().length() == 1)
				if (sign.addAcc(n.toString()))
						if (sign.getAccType() == graphics.Note.FLAT)
							n.halfStepDown();
						else if (sign.getAccType() == graphics.Note.SHARP)
							n.halfStepUp();
			
			staff.drawNote(staff.getClosestLine(e.getPoint()), noteType, acc);
			//ADDS THE NOTE!!!
			position+=n.getLength();
			song.getLastStaff().addNote(n);
			repaint();
		}
		else if (e.getButton() == MouseEvent.BUTTON3)
		{
			acc++;
			if (acc > 1)
				acc = -1;
		
			staff.setAcc(acc);
			repaint();
		}
	}

	public void mouseDragged(MouseEvent e)
	{
		staff.drawSelectedNote(staff.getClosestLine(e.getPoint()), noteType, acc);
		repaint();
	}

	public void mouseMoved(MouseEvent e)
	{
		staff.drawSelectedNote(staff.getClosestLine(e.getPoint()), noteType, acc);
		repaint();
	}

	public void mouseWheelMoved(MouseWheelEvent e)
	{
		noteType -= e.getWheelRotation();
		if (noteType < 0)
			noteType = 0;
		else if (noteType >= 6)
			noteType = 6;
		
		selectLength[noteType].grabFocus();
		
		staff.drawSelectedNote(staff.getClosestLine(e.getPoint()), noteType, acc);
		repaint();
	}

	public void actionPerformed(ActionEvent e)
	{
		String command = e.getActionCommand();
		if (command.startsWith("length="))
			noteType = Integer.parseInt(String.valueOf(command.charAt(command.length() - 1)));
		else if (command.equals("flat"))
			acc = -1;
		else if (command.equals("sharp"))
			acc = 1;
		else if (command.equals("nat"))
			acc = 0;
		else if (command.equals("selectKey"))
			startDialog.setVisible(true);
		else if (command.equals("play"))
			song.play();
		else if (command.equals("delete"))
			deleteLastNote();
			
		else if (command.equals("clear"))
		{
			position = 0;
			song = new Song();
			staff.clearAll();
		}
		else if (command.equals("left"))
		{
			if (staff.getTranslation() > 0)
				staff.translateX(-25);
		}
		else if (command.equals("right"))
			staff.translateX(25);
		else if (command.equals("toStart"))
			staff.setTranslation(0);
		else if (command.equals("toEnd"))
			staff.translateX(125);
		else if (command.equals("addNewStaff"))
		{
			//do not clear notes!! Only staff:
			staff.clearAll();
			position = 0;
			song.addStaff(new Staff());
		}
		
		staff.drawSelectedNote(0, noteType, acc);
		repaint();
	}
	
	public void deleteLastNote()
	{
		try{
			position -= song.getLastStaff().getLastNote().getLength();
			song.getLastStaff().deleteLastNote();
			staff.removeLastNote();
		}catch(ArrayIndexOutOfBoundsException err){}
	}
	
	/*public void changeNotes()
	{
		try{
			key = JOptionPane.showInputDialog("Enter the key:");
			while (!Signature.isValid(key))
				key = JOptionPane.showInputDialog("Error! That is an invalid key! Enter the key:");
			sign = new Signature(key);
			staff.setSignature(sign);
		}catch(NullPointerException err){
		}catch (StringIndexOutOfBoundsException err){}
		
		for (int i = 0; i < notes.size(); i++)
			//only works if there are no accidentals currently placed:
			if (notes.get(i).toString().length() == 1)
				if (sign.addAcc(notes.get(i).toString()))
					if (sign.getAccType() == graphics.Note.FLAT)
						notes.get(i).halfStepDown();
					else if (sign.getAccType() == graphics.Note.SHARP)
						notes.get(i).halfStepUp();
	}*/
	
	
	
	public class Start extends JDialog implements ChangeListener
	{
		private JTextField setKey, setTime;
		//private JButton enter, cancel;
		private JSlider selectKey, selectTime;
		
		private JComboBox selectQuality;
		private String[] qualities = {"Major", "Minor"};
		
		public Start(JFrame f)
		{
			super(f, "Select the key");
			
			setLayout(new GridBagLayout());

			addKeySelection();
			addTimeSelection();
			addAdditionalInfo();
			
			pack();
	        setVisible(true);
			setDefaultCloseOperation(HIDE_ON_CLOSE);
		}
		
		public Start()
		{
			setTitle("Select the key");
			setLayout(new GridBagLayout());

			addTimeSelection();
			addKeySelection();
			addAdditionalInfo();
			
	        pack();
	        setVisible(true);
			setDefaultCloseOperation(HIDE_ON_CLOSE);
		}
		
		public void addTimeSelection()
		{
			GridBagConstraints c = new GridBagConstraints();
			
			c.ipady = 3;
			c.ipadx = 10;
			c.insets = new Insets(5,50,5,0);
			
			add(new JLabel("Select the Time:"), c);
			
			setTime = new JTextField("4/4");
			setTime.setEditable(false);
			
			c.insets = new Insets(5,0,5,0);
			c.gridx = 1;
			c.gridy = 0;
			
			add(setTime, c);
			
			selectTime = new JSlider(JSlider.HORIZONTAL, 0, 4, 0);
			selectTime.setSnapToTicks(true);
			selectTime.addChangeListener(this);
			
			c.ipadx = 2;
			c.insets = new Insets(5,15,5,0);
			c.gridx = 2;
			
			add(selectTime, c);
		}
		
		public void addKeySelection()
		{
			GridBagConstraints c = new GridBagConstraints();
			
			c.ipady = 3;
			c.ipadx = 10;
			c.insets = new Insets(5,50,5,0);
			c.gridy = 1;
			
			add(new JLabel("Select the Key:"), c);
			
			setKey = new JTextField("C");
			setKey.setEditable(false);
			
			c.ipady = 3;
			c.ipadx = 10;
			c.insets = new Insets(5,0,5,0);
			c.gridx = 1;
			
			add(setKey, c);
			
			selectKey = new JSlider(JSlider.HORIZONTAL, 0, 11, 0);
			selectKey.addChangeListener(this);
			selectKey.setSnapToTicks(true);
			
			c.ipady = 3;
			c.ipadx = 2;
			c.insets = new Insets(5,15,5,0);
			c.gridx = 2;
			
			add(selectKey, c);
		}
		public void addAdditionalInfo()
		{
			GridBagConstraints c = new GridBagConstraints();
			
			c.ipady = 3;
			c.ipadx = 10;
			c.insets = new Insets(5,50,5,0);
			c.gridwidth = 1;
			c.gridy = 2;
			
			add(new JLabel("Select the Quality:"), c);
			
			c.gridx = 1;
			c.ipady = 0;
			c.insets = new Insets(5,0,5,0);
			
			selectQuality = new JComboBox(qualities);
			add(selectQuality, c);
		}
		
		public void stateChanged(ChangeEvent e)
		{
			//set the key:
			key = Music.getName(selectKey.getValue());
			setKey.setText(key);
			//changeNotes();
			
			sign = new Signature(key);
			staff.setSignature(sign);
			this.getOwner().repaint();
			
			
			//set the time:
			time = getTime(selectTime.getValue());
			setTime.setText(time.toString());
			staff.setTime(time);
		}
		
		public Fraction getTime(int tick)
		{
			switch (tick)
			{
				case 0: return new Fraction(4,4);
				case 1: return new Fraction(3,4);
				case 2: return new Fraction(2,4);
				case 3: return new Fraction(2,2);
				case 4: return new Fraction(6,4);
				default: return new Fraction(4,4);
			}
		}
	}



	public void keyPressed(KeyEvent e)
	{
	}


	public void keyReleased(KeyEvent e)
	{
		if (e.getKeyChar() == ' ')
			song.play();
		else if (e.getKeyCode() == KeyEvent.VK_DELETE)
		{
			if (e.isShiftDown())
				song.clear();
			else
				deleteLastNote();
		}
	}


	public void keyTyped(KeyEvent e)
	{	
	}
	
}

package main;

import java.util.ArrayList;

import sound.Note;
import musicTime.Signature;
import myMusic.MusicPlayer;

public class Song
{
	private ArrayList<Staff> staffs = new ArrayList<Staff>();
	private int time;
	private String name;
	private Signature key;
	
	public Song()
	{
		staffs.add(new Staff());
	}
	public Song(Signature key)
	{
		this.key=key;
		staffs.add(new Staff());
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public int getTime()
	{
		return time;
	}
	public void setTime(int time)
	{
		this.time = time;
	}
	public void addStaff(Staff staff)
	{
		staffs.add(staff);
	}
	public void play()
	{
		MusicPlayer player = new MusicPlayer();
		for (int i = 0; i < staffs.size(); i++)
			staffs.get(i).play(player);
	}
	public void clear()
	{
		staffs.clear();
	}
	public void deleteLastStaff()
	{
		staffs.remove(staffs.size() - 1);
	}
	public Staff getLastStaff()
	{
		return staffs.get(staffs.size() - 1);
	}
	public Staff getStaff(int index)
	{
		return staffs.get(index);
	}
	public int getNumberOfStaffs()
	{
		return staffs.size();
	}
}

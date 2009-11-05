package main;

import java.util.ArrayList;

import myMusic.MusicPlayer;

import sound.Note;

public class Staff
{
	private ArrayList<Note> notes = new ArrayList<Note>();
	public void play(MusicPlayer player)
	{
		player.play(notes);
	}
	public void addNote(Note n)
	{
		notes.add(n);
	}
	public void clear()
	{
		notes.clear();
	}
	public void deleteLastNote()
	{
		notes.remove(notes.size() - 1);
	}
	public Note getLastNote()
	{
		return notes.get(notes.size() - 1);
	}
	public int getNumberOfNotes()
	{
		return notes.size();
	}
}

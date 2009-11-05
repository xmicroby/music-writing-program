package test;

import java.util.ArrayList;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;
import javax.sound.midi.ShortMessage;
import javax.sound.midi.Track;

import myMusic.Music;

import sound.Note;

public class TESTTTTTTTT
{
	public static void main(String[] args)
	{
		//NOTE: 8 = quarter note!
		System.out.println("moo");
		playSong1();
	}
	
	public static void playSong2()
	{
	}
	
	public static void playSong1()
	{
		ArrayList<Note> notes = new ArrayList<Note>();
		
		notes.add(new Note(Music.getValue("C") + 48, Note.WHOLE_NOTE, 0));
		notes.add(new Note(Music.getValue("E") + 48, Note.WHOLE_NOTE, 0));
		notes.add(new Note(Music.getValue("A") + 48, Note.WHOLE_NOTE, 0));
		
		System.out.println(notes.get(2).getLength());
		
		notes.add(new Note(Music.getValue("B") + 48, Note.WHOLE_NOTE, 16));
		notes.add(new Note(Music.getValue("E") + 48, Note.WHOLE_NOTE, 16));
		notes.add(new Note(Music.getValue("Ab") + 48, Note.WHOLE_NOTE, 16));
		
		notes.add(new Note(Music.getValue("G") + 48, Note.WHOLE_NOTE, 32));
		notes.add(new Note(Music.getValue("E") + 48, Note.WHOLE_NOTE, 32));
		notes.add(new Note(Music.getValue("C") + 60, Note.WHOLE_NOTE, 32));
		notes.add(new Note(Music.getValue("C") + 36, Note.WHOLE_NOTE, 32));
		
		notes.add(new Note(Music.getValue("B") + 48, Note.WHOLE_NOTE, 48));
		notes.add(new Note(Music.getValue("G") + 60, Note.WHOLE_NOTE, 48));
		notes.add(new Note(Music.getValue("D") + 36, Note.WHOLE_NOTE, 48));
		
		notes.add(new Note(Music.getValue("F") + 48, Note.WHOLE_NOTE, 64));
		notes.add(new Note(Music.getValue("E") + 60, Note.WHOLE_NOTE, 64));
		notes.add(new Note(Music.getValue("C") + 48, Note.WHOLE_NOTE, 64));
		notes.add(new Note(Music.getValue("A") + 36, Note.WHOLE_NOTE, 64));
		
		notes.add(new Note(Music.getValue("E") + 48, Note.WHOLE_NOTE, 80));
		notes.add(new Note(Music.getValue("E") + 60, Note.WHOLE_NOTE, 80));
		notes.add(new Note(Music.getValue("G") + 48, Note.WHOLE_NOTE, 80));
		notes.add(new Note(Music.getValue("B") + 36, Note.WHOLE_NOTE, 80));
		notes.add(new Note(Music.getValue("B") + 60, Note.WHOLE_NOTE, 80));
		
		notes.add(new Note(Music.getValue("F") + 36, Note.WHOLE_NOTE, 96));
		notes.add(new Note(Music.getValue("A") + 60, Note.WHOLE_NOTE, 96));
		notes.add(new Note(Music.getValue("E") + 48, Note.WHOLE_NOTE, 96));
		notes.add(new Note(Music.getValue("F") + 60, Note.WHOLE_NOTE, 96));
		notes.add(new Note(Music.getValue("A") + 48, Note.WHOLE_NOTE, 96));
		
		notes.add(new Note(Music.getValue("G") + 36, Note.WHOLE_NOTE, 112));
		notes.add(new Note(Music.getValue("B") + 60, Note.WHOLE_NOTE, 112));
		notes.add(new Note(Music.getValue("D") + 72, Note.WHOLE_NOTE, 112));
		notes.add(new Note(Music.getValue("G") + 60, Note.WHOLE_NOTE, 112));
		notes.add(new Note(Music.getValue("B") + 36, Note.WHOLE_NOTE, 112));
		
		
		
		notes.add(new Note(Music.getValue("G") + 60, Note.WHOLE_NOTE, 128));
		notes.add(new Note(Music.getValue("C") + 72, Note.WHOLE_NOTE, 128));
		notes.add(new Note(Music.getValue("C") + 48, Note.WHOLE_NOTE, 128));
		notes.add(new Note(Music.getValue("G") + 48, Note.WHOLE_NOTE, 128));
		notes.add(new Note(Music.getValue("E") + 60, Note.WHOLE_NOTE, 128));
		
		notes.add(new Note(Music.getValue("F#") + 60, Note.WHOLE_NOTE, 144));
		notes.add(new Note(Music.getValue("C") + 72, Note.WHOLE_NOTE, 144));
		notes.add(new Note(Music.getValue("D") + 48, Note.WHOLE_NOTE, 144));
		notes.add(new Note(Music.getValue("A") + 48, Note.WHOLE_NOTE, 144));
		notes.add(new Note(Music.getValue("D") + 60, Note.WHOLE_NOTE, 144));
		
		notes.add(new Note(Music.getValue("E") + 60, Note.WHOLE_NOTE, 160));
		notes.add(new Note(Music.getValue("B") + 72, Note.WHOLE_NOTE, 160));
		notes.add(new Note(Music.getValue("D") + 48, Note.WHOLE_NOTE, 160));
		notes.add(new Note(Music.getValue("E") + 48, Note.WHOLE_NOTE, 160));
		notes.add(new Note(Music.getValue("G#") + 60, Note.WHOLE_NOTE, 160));
		
		
		notes.add(new Note(Music.getValue("Gb") + 48, Note.WHOLE_NOTE, 176));
		notes.add(new Note(Music.getValue("Db") + 48, Note.WHOLE_NOTE, 176));
		notes.add(new Note(Music.getValue("Bb") + 48, Note.WHOLE_NOTE, 176));
		
		notes.add(new Note(Music.getValue("C") + 60, Note.WHOLE_NOTE, 192));
		notes.add(new Note(Music.getValue("Ab") + 48, Note.WHOLE_NOTE, 192));
		notes.add(new Note(Music.getValue("Eb") + 48, Note.WHOLE_NOTE, 192));
		
		notes.add(new Note(Music.getValue("F") + 60, Note.WHOLE_NOTE, 208));
		notes.add(new Note(Music.getValue("Bb") + 60, Note.WHOLE_NOTE, 208));
		notes.add(new Note(Music.getValue("Db") + 60, Note.WHOLE_NOTE, 208));
		notes.add(new Note(Music.getValue("Db") + 72, Note.WHOLE_NOTE, 208));
		
		//melody:
		
		notes.add(new Note(Music.getValue("G") + 60, Note.DOTTED_HALF_NOTE, 0));
		notes.add(new Note(Music.getValue("F") + 60, Note.EIGHTH_NOTE, 12));
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 14));
		
		notes.add(new Note(Music.getValue("F") + 60, Note.DOTTED_HALF_NOTE, 16));
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 28));
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 30));
		
		notes.add(new Note(Music.getValue("E") + 60, Note.DOTTED_HALF_NOTE, 32));
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 44));
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 46));
		
		notes.add(new Note(Music.getValue("G") + 60, Note.HALF_NOTE, 48));
		notes.add(new Note(Music.getValue("G") + 48, Note.HALF_NOTE, 56));
		
		notes.add(new Note(Music.getValue("A") + 36, Note.EIGHTH_NOTE, 72));
		notes.add(new Note(Music.getValue("B") + 36, Note.EIGHTH_NOTE, 74));
		notes.add(new Note(Music.getValue("A") + 36, Note.EIGHTH_NOTE, 76));
		notes.add(new Note(Music.getValue("B") + 36, Note.EIGHTH_NOTE, 78));
		
		notes.add(new Note(Music.getValue("A") + 60, Note.EIGHTH_NOTE, 72));
		notes.add(new Note(Music.getValue("B") + 60, Note.EIGHTH_NOTE, 74));
		notes.add(new Note(Music.getValue("A") + 60, Note.EIGHTH_NOTE, 76));
		notes.add(new Note(Music.getValue("B") + 60, Note.EIGHTH_NOTE, 78));
		
		notes.add(new Note(Music.getValue("C") + 60, Note.HALF_NOTE, 80));
		
		notes.add(new Note(Music.getValue("C") + 60, Note.HALF_NOTE, 96));
		
		notes.add(new Note(Music.getValue("C") + 36, Note.EIGHTH_NOTE, 104));
		notes.add(new Note(Music.getValue("D") + 36, Note.EIGHTH_NOTE, 106));
		notes.add(new Note(Music.getValue("C") + 36, Note.EIGHTH_NOTE, 108));
		notes.add(new Note(Music.getValue("D") + 36, Note.EIGHTH_NOTE, 110));
		
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 104));
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 106));
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 108));
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 110));
		
		
		
		
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 128));
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 130));
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 132));
		notes.add(new Note(Music.getValue("G") + 60, Note.EIGHTH_NOTE, 134));
		
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 136));
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 138));
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 140));
		notes.add(new Note(Music.getValue("G") + 60, Note.EIGHTH_NOTE, 142));
		
		
		
		
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 144));
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 146));
		notes.add(new Note(Music.getValue("F#") + 60, Note.EIGHTH_NOTE, 148));
		notes.add(new Note(Music.getValue("A") + 60, Note.EIGHTH_NOTE, 150));
		
		notes.add(new Note(Music.getValue("D") + 60, Note.EIGHTH_NOTE, 152));
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 154));
		notes.add(new Note(Music.getValue("F#") + 60, Note.EIGHTH_NOTE, 156));
		notes.add(new Note(Music.getValue("A") + 60, Note.EIGHTH_NOTE, 158));
		
		
		
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 160));
		notes.add(new Note(Music.getValue("F#") + 60, Note.EIGHTH_NOTE, 162));
		notes.add(new Note(Music.getValue("G#") + 60, Note.EIGHTH_NOTE, 164));
		notes.add(new Note(Music.getValue("B") + 60, Note.EIGHTH_NOTE, 166));
		
		notes.add(new Note(Music.getValue("E") + 60, Note.EIGHTH_NOTE, 168));
		notes.add(new Note(Music.getValue("F#") + 60, Note.EIGHTH_NOTE, 170));
		notes.add(new Note(Music.getValue("G#") + 60, Note.EIGHTH_NOTE, 172));
		notes.add(new Note(Music.getValue("B") + 60, Note.EIGHTH_NOTE, 174));
		
		notes.add(new Note(Music.getValue("Db") + 60, Note.DOTTED_HALF_NOTE, 176));
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 188));
		notes.add(new Note(Music.getValue("Bb") + 60, Note.EIGHTH_NOTE, 190));
		
		notes.add(new Note(Music.getValue("Eb") + 60, Note.DOTTED_HALF_NOTE, 192));
		notes.add(new Note(Music.getValue("F") + 60, Note.EIGHTH_NOTE, 204));
		notes.add(new Note(Music.getValue("C") + 60, Note.EIGHTH_NOTE, 206));
		
		play(notes);
	}
	public static void play(ArrayList<Note> notes)
	{
		Sequencer sequencer;
		MidiEvent start, stop;
		ShortMessage message, message2;
		Track track;

		try
		{
			sequencer = MidiSystem.getSequencer();
			sequencer.open();
			Sequence sequence = new Sequence(Sequence.PPQ, 4);
			track = sequence.createTrack();
			
			for (int i = 0; i < notes.size(); i++)
			{
				message = new ShortMessage();
				message.setMessage(ShortMessage.NOTE_ON, 1, notes.get(i).getNote(), 100);
				start = new MidiEvent(message, notes.get(i).getStart());
				track.add(start);
			}
			
			for (int i = 0; i < notes.size(); i++)
			{
				message2 = new ShortMessage();
				message2.setMessage(ShortMessage.NOTE_OFF, 1, notes.get(i).getNote(), 100);
				stop = new MidiEvent(message2, notes.get(i).getStart() + notes.get(i).getLength());
				track.add(stop);
			}
	
			sequencer.setSequence(sequence);
			//sequencer.setTempoInBPM(220);
			sequencer.start();
		}
		catch (MidiUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (InvalidMidiDataException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
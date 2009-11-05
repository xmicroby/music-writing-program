package myMusic;

import java.util.ArrayList;

import javax.sound.midi.*;

import sound.Note;

public class MusicPlayer
{
	public void play(ArrayList<Note> notes)
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

package test;

import javax.sound.midi.*;

public class TestClass
{ 
	public static void main(String[] args)
	{
		try {
			System.out.println("moo");
          	Synthesizer synth = MidiSystem.getSynthesizer(); 
          	synth.open(); 
        
          	final MidiChannel[] mc = synth.getChannels();
          	//Instrument[] instr = synth.getDefaultSoundbank().getInstruments(); 
          	//System.out.println(instr.length);
          	//synth.loadInstrument(instr[0]);
          	for (int i = 48; i < 60; ++i)
          	{
          		mc[1].noteOn(i,100);
          		try
          		{ 
          			Thread.sleep(300); 
               	}
          		catch (InterruptedException e){} 
          		mc[1].noteOff(i,100);
          	} 
          	synth.close();
		}catch (MidiUnavailableException e){} 
	} 
} 

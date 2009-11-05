package myMusic;

public class Key
{
	public static final int NORMAL = 0, FLAT = -1, SHARP = 1;
	public static boolean isBlackKey(int note)
	{
		int key = note % 12;

		switch(key)
		{
			//C C# D D# E F F# G G# A A# B C...
			case 0: return false;
			case 1: return true;
			case 2: return false;
			case 3: return true;
			case 4: return false;
			case 5: return false;
			case 6: return true;
			case 7: return false;
			case 8: return true;
			case 9: return false;
			case 10: return true;
			case 11: return false;
			//default is true:
			default: return true;
		}
	}
}

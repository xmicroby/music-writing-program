package musicTime;

public class Fraction
{
	private int num, den;
	
	public Fraction()
	{
		num = 1;
		den = 1;
	}
	public Fraction(int num)
	{
		this.num = num;
		den = 1;
	}
	public Fraction(int num, int den)
	{
		this.num = num;
		this.den = den;
		setSigns();
	}
	public Fraction(int number, int num, int den)
	{
		this.num = den * number + num;
		this.den = den;
		setSigns();
	}
	
	public void setSigns()
	{
		if ((double)num / den < 0)
		{
			num = -Math.abs(num);
			den = Math.abs(den);
		}
		else
		{
			num = Math.abs(num);
			den = Math.abs(den);
		}
	}
	
	public void inverse()
	{
		//reverse num and den:
		int temp = num;
		num = den;
		den = temp;
	}
	
	public void reduce()
	{
		for (int i = Math.abs(num); i > 1; i--)
			if (Math.abs(num) % i == 0 && den % i == 0)
			{
				num /= i;
				den /= i;
			}
	}
	
	public double toDecimal()
	{
		return (double) num / den;
	}
	
	public void add(int num)
	{
		add(new Fraction(num));
	}
	public void add(int num, int den)
	{
		add(new Fraction(num, den));
	}
	public void add(Fraction f)
	{
		//a/b + c/d = (a * d + c * b) / (b * d)
		num = num * f.den + f.num * den;
		den *= f.den;
		reduce();
	}
	public int getNumerator()
	{
		return num;
	}
	public int getDenominator()
	{
		return den;
	}
	
	public String toString()
	{
		if (den == 0)
			return "UND";
		else if (den == 1 || num == 0)
			return String.valueOf(num);
		else
			return num + "/" + den;
	}
}


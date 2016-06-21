import java.lang.*;

/**
* De klasse EersteProg is een Java applicatie
*
* @author Sean Tempels
*
* @version	1,5
*/

public class EersteProg
{
	/*
	* Dit is de main methode
	* @param args Dit is een commandline argument
	*/
	public static void main( String args[] )
	{
		Februari();
	}
	
	//Oef 1
	
	public static void Tafels()
	{	
		for (byte x = 0; x <= 9; x++)
		{
			for (byte y = 0; y <= 9; y++)
			{
				System.out.println(x + " x " + y + " = " + x * y);
			}
		}
	}
	
	//Oef 2
	
	public static void Februari()
	{
		int weekdag = 0;
		
		for (byte dag = 1; dag <= 28; dag++)
		{
			if (weekdag == 0) System.out.print("zon");
			if (weekdag == 1) System.out.print("maan");
			if (weekdag == 2) System.out.print("dins");
			if (weekdag == 3) System.out.print("woens");
			if (weekdag == 4) System.out.print("donder");
			if (weekdag == 5) System.out.print("vrij");
			if (weekdag == 6) System.out.print("zater");
			
			weekdag++;
			
			if (weekdag > 6) weekdag = 0;
			
			System.out.println("dag " + dag + " februari 2009");
		}
	}
	
	//Oef 3
	
	public static void PI()
	{
		int pi;
		
		for (int i = 0; i <= 10000; i++)
		{
			
		}
	}
	
	//Oef 4
	
	public static void InvertInt()
	{
		
	}
}

//javac is de compiler vb. >javac bestandsnaam
//java voert het programma uit vb. >java classnaam
import java.lang.*;

/**
* @author Seppe Peelman
* @version 1.05
*/

public class oef1blz12
{
    /**
    * Dit is een main-functie, hier start het programma
    * @param args   Dit is een array van strings waarmee parameters
    * kunnen meegegeven worden vanaf de commandline
    */
    
	public static void main( String args[] )
	{
		System.out.println("Hello world");
        drukaf(100);
	}
    
    /**
    * Deze functie print getallen af tot een gegeven getal
    * @param m  Dit is een integer die het aantal getallen dat wordt afgedrukt bepaalt
    */
    
    public static void drukaf(int m)
    {
        int a;
        for(a=0;a<m;a++)
        {
            System.out.println(a);
        }
    }
}
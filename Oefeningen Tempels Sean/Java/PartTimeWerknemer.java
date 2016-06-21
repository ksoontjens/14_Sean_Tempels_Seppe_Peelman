import java.lang.*;

public class PartTimeWerknemer extends Werknemer
{
	int aantalUrenGewerkt;
	
	public PartTimeWerknemer(String vNaam, String aNaam, int wNummer, float sal, int aantalUren)
	{
		super(vNaam, aNaam, wNummer, sal);
		aantalUrenGewerkt = aantalUren;
	}
	
	public float GetWeekLoon()
	{
		return aantalUrenGewerkt * salaris;
	}
	
	public void salarisVerhogen(int perc)
	{
		if (perc > 10)
		{
			System.out.println("Part Time Werknemers kunnen maar maximum 10% opslag krijgen.");
		}
		else
		{
			super.salarisVerhogen(perc);
		}
	}
}
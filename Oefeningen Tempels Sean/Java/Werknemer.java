import java.lang.*;

public class Werknemer
{
	public String voornaam;
	public String achternaam;
	public int werknemerNummer;
	protected float salaris;
	private float RSZpercentage = 33.0f;
	
	public Werknemer(String voornaam, String achternaam, int werknemerNr, float salaris)
	{
		this.voornaam = voornaam;
		this.achternaam = achternaam;
		werknemerNummer = werknemerNr;
		this.salaris = salaris;
	}
	
	public void salarisVerhogen(float RSZpercentage)
	{
		float verhogingsFactor = RSZpercentage / 100;
		
		salaris += salaris * verhogingsFactor;
	}
	
	public float GetSalaris()
	{
		return salaris;
	}
	
	
}
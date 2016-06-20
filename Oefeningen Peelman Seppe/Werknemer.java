public class Werknemer implements Betaalbaar
{
    public String voornaam;
    public String achternaam;
    public int werknemerNummer;
    protected float salaris;
    private float RSZpercentage = 33.0f;
    
    public Werknemer(String initVoornaam, String initAchternaam, int initWNummer, float initSalaris)
    {
        voornaam = initVoornaam;
        achternaam = initAchternaam;
        werknemerNummer = initWNummer;
        salaris = initSalaris;
    }
    
    public void salarisVerhogen(int perc)
    {
        salaris += salaris*(perc/100.0);
    }
    
    public float getSalaris()
    {
        return salaris;
    }
    
    public void setRSZ(float RSZ)
    {
        RSZpercentage = RSZ;
    }
    
    public float getRSZ()
    {
        return RSZpercentage;
    }
    
    public void betaal()
    {
        System.out.println("Betaal het salaris van " + salaris + " aan de werknemer " + voornaam + " " + achternaam);
    }
}
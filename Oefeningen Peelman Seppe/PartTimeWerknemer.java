public class PartTimeWerknemer extends Werknemer
{ 
    int aantalUrenGewerkt;
    public PartTimeWerknemer(String vNaam, String aNaam, int wNummer, float sal, int aantalUren)
    {
        super(vNaam, aNaam, wNummer, sal);
        aantalUrenGewerkt = aantalUren;
    }
    
    public float getWeekLoon()
    {
        return aantalUrenGewerkt*salaris;
    }
    
    public void salarisVerhogen(int perc)
    {
        if(perc > 5)
        {
            perc = 0;
            System.out.println("Fout: slechts 5% opslag toegestaan");
        }
        else
        {
            super.salarisVerhogen(perc);
        }
    }

}
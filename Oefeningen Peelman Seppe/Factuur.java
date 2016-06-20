public class Factuur implements Betaalbaar
{   
    public int factuurNr;
    public float factuurBedrag;
    
    public Factuur(int initNr, float initBedrag)
    {
        factuurNr = initNr;
        factuurBedrag = initBedrag;
    }
    
    public void betaal()
    {
        System.out.println("Betaal het factuur " + factuurNr + " voor een bedrag van " + factuurBedrag);
    }
}
import java.lang.*;

public class oef
{
    public static void main(String args[])
    {
        Werknemer jan = new Werknemer("Jan","Man",1,35.0f);
        Werknemer bob = new Werknemer("Bob","De Bouwer",2,30.0f);
        Werknemer dan = new Werknemer("Dan","Bull",3,32.0f);
        Werknemer jack = new Werknemer("Jack","Septiceye",4,40.0f);
        
        PartTimeWerknemer john = new PartTimeWerknemer("John","Tempola",5,20.0f,20);
        PartTimeWerknemer james = new PartTimeWerknemer("James","LaFleur",6,40.0f,25);
        
        StudentWerknemer mark = new StudentWerknemer("Mark","Tremonti",7,35.0f,20);
        
        Factuur fact1 = new Factuur(123456, 625.00f);
        
        Betaalbaar BetDingen[] = {jan, john, mark, fact1};
        
        jan.salarisVerhogen(10);
        bob.salarisVerhogen(10);
        john.salarisVerhogen(10);
        jack.setRSZ(31.0f);
        james.setRSZ(30.0f);
        
        System.out.println(jan.getSalaris() + " " + bob.getSalaris() + " " + dan.getSalaris() + " " + jack.getSalaris() + " " + john.getSalaris());
        System.out.println(jack.getRSZ() + " " + james.getRSZ());
        System.out.println(mark.getRSZ());
        
        for(int k=0;k<BetDingen.length;k++)
        {
            BetDingen[k].betaal();
        }
    }
}
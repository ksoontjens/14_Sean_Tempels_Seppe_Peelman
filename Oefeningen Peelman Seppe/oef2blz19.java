import java.lang.*;

public class oef2blz19
{
    public static void main(String args[])
    {
        String dagen[] = {"zondag","maandag","dinsdag","woensdag","donderdag","vrijdag","zaterdag"};
        int i = 0;
        for(int x=1;x<=28;x++)
        {
            System.out.println(dagen[i] + " " + x + " februari");
            i++;
            if(i == 7)
            {
                i = 0;
            }
        }
    }
}
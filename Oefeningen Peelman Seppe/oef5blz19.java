import java.lang.*;

public class oef5blz19
{
    public static void main(String args[])
    {
        boolean isPrime = true;
        for(int i=3;i<100;i++)
        {
            for(int j=2;j<i;j++)
            {
                if(i%j == 0)
                {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
            {
                System.out.println(i);
            }
            isPrime = true;
        }
    }
}
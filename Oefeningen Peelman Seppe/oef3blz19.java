import java.lang.*;

public class oef3blz19
{
    public static void main(String args[])
    {
        System.out.println(calcPi(10000));
    }
    

    public static double calcPi(int n) 
    {
        double sum = 0;

        for(double i = 1; i < n; i += 2) 
        {
            sum = sum + ((1 / (2 * i - 1)) - (1 / (2 * i + 1)));
        }
        
        double pi = 4 * sum;
        return pi;
    }
}
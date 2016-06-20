import java.lang.*;

public class oef7blz19
{
    public static void main(String args[])
    {
        int a[] = {12,34,56,78,123,234,99,88};
        int b[] = new int[8];
        int max = 0;
        int indexOfMax = 0;
        for (int j=0;j<b.length;j++)
        {
            for (int i=0;i<a.length;i++)
            {
                if (a[i]>max)
                {
                    max = a[i];
                    indexOfMax = i;
                }
            }
            b[j] = a[indexOfMax];
            System.out.println(b[j]);
            a[indexOfMax] = 0;
            max = 0;
        }
    }
}
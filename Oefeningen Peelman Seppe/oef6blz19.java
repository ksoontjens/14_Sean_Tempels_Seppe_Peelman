import java.lang.*;

public class oef6blz19
{
    public static void main(String args[])
    {
        int a[]={12,34,56,78,123,234,99,88};
        int max = 0;
        for (int i=0;i<a.length;i++)
        {
            if (a[i]>max)
            {
                max = a[i];
            }
        }
        System.out.println("Het maximum is " + max);
    }
}
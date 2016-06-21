import java.lang.*;

public class WerknemerOef
{
	public static void main(String args[])
	{
		Werknemer werknemers[] = new Werknemer[]
		{
			new Werknemer("blah", "blah", 1, 10.0f),
			new Werknemer("facq", "joe", 2, 20.0f),
			new Werknemer("terro", "rist", 3, 30.0f),
			new Werknemer("anar", "chist", 4, 40.0f)
		};
		
		PartTimeWerknemer PTWn1 = new PartTimeWerknemer("jan", "nietJansens", 5, 5.0f);
		PartTimeWerknemer PTWn2 = new PartTimeWerknemer("nietJan", "welJansens", 6, 10.0f);
	}
}
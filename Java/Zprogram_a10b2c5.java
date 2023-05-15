
public class Zprogram_a10b2c5
{
  public static void main (String[]args)
  {
    String s = "a10b3c1";
    String letter = "";
    int j = -1;int digit=0;
    for (int i = 0; i < s.length (); i++)
      {
	if (Character.isAlphabetic(s.charAt (i)))
	  {
	    letter += s.charAt (i);
	    j++;

	  }
	else {
	  digit = Character.getNumericValue(s.charAt (i));
	if (i + 1 < s.length ())
	  {
	    if (Character.isDigit (s.charAt(i + 1)))
	      {
		String a = String.valueOf(digit);
		a += s.charAt (i + 1);
		digit = Integer.parseInt (a);
	      }
	  }
	for (int k = 0; k < digit; k++)
	  {
	    System.out.print (letter.charAt(j));
	  }
	}
      }

  }
}

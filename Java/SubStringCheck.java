public class SubStringCheck
{
  public static void main (String[]args)
  {
    String s = "GeeksForGeeks", x = "Fr";
    int xlength = x.length (), start = 0;
    for (int i = 0; i < s.length () - x.length (); i++, xlength++)
      {
	if (x.equalsignoreCase (s.substring (i, xlength)))
	  res = i;
      }
    if (res == 0)
      res = -1;
    System.out.println ("Result  -> " + res);
  }

}

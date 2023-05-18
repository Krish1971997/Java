public class DecendingOrderBasedOnFrequencyArray
{
  public static void main (String args[])
  {
    int input = { 2, 2, 3, 4, 5, 12, 2, 3, 3, 3, 12 };
    int res = new int[input.length];
    Map < Integer, Integer > map = new HashMap ();
    int count = 1;
    for (int i = 0; i < input.length; i++)
      {
	for (int j = i + 1; j < input.length; j++)
	  {
	    if (input[i] = input[j])
	      {
		count++;
	      }
	  }
	map.put (input[i], count);
      }
  }
for (Map.Entry m:map.enrtySet ())
    {
      for (int i = 0; i < m.getValue (); i++)
	{
	  System.out.print (m.getKey () + " ");
	}
    }
}
}

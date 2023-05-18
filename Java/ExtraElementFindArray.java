public class ExtraElementFindArray
{
  public static void main (String args[])
  {
    int arr1 = { 10, 20, 30, 12, 5 };
    int arr2 = { 10, 5, 30, 20 };
    int res = extraElement (arr1, arr2);
    System.out.println ("Result-->" + res);
  }
  public static int extraElement (int arr1[], int arr2[])
  {
    for (int i = 0; i < arr1.length; i++)
      {
	for (int j = 0; j < arr2.length; j++)
	  {
	    if (arr1[i] == arr2[j] && arr1[i] != -1)
	      {
		arr1[i] = -1;
		arr2[j] = -1;
	      }
	  }
      }

    if (arr1.length > arr2.length)
      {
	for (int i = 0; i < arr1.length; i++)
	  {
	    if (arr1[i] != -1)
	      return i;
	  }
      }
    else
      {
	for (int i = 0; i < arr1.length; i++)
	  {
	    if (arr1[i] != -1)
	      return i;
	  }
      }
  }
}

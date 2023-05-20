class XPattern {

  public static void main(String[] args) {
    String s = "geeksforgeeks";
    if (s.length() % 2 == 1) {
      int n = s.length();
      for (int i = 0; i < s.length(); i++) {
        for (int j = 0; j < s.length(); j++) {
          if (j == i)
            System.out.print(s.charAt(i));
          else if (j == n - i - 1)
            System.out.print(s.charAt(n - i - 1));
          else
            System.out.print(" ");
        }
        System.out.println();  }
    } else
      System.out.println("Please enter odd number");
  }
}

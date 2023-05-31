public class SubStringCheck {
    public static void main(String[] args) {
        // String s = "abcabcabcd", x = "abcd";
        // String s = "GeeksForGeeks", x = "For";
        String s = "a", x = "ab";
        int xlength = x.length(), res = 0;
        boolean entry = true;
        if (s.length() >= x.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (x.equalsIgnoreCase(s.substring(i, xlength))) {
                    res = i;
                    entry = false;
                    break;
                } else if (xlength < s.length())
                    xlength++;
            }
        }
        if (entry)
            res = -1;
        System.out.println("Result  -> " + res);
    }
}

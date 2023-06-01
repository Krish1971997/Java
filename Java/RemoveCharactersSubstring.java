import java.util.ArrayList;
import java.util.List;

public class RemoveCharactersSubstring {
    public static void main(String[] args) {
        String s1 = "expErIence", s2 = "En";
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        List<Character> list1 = new ArrayList<>();
        for (char cs : ch1) {
            list1.add(cs);
        }
        List<Character> list2 = new ArrayList<>();
        for (char cs : ch2) {
            list2.add(cs);
        }
        list1.removeAll(list2);
        String s="";
        for (Character character : list1) {
            s+=character;
        }
        System.out.println(list1);
    }

}

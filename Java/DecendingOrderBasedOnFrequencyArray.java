import java.util.HashMap;
import java.util.Map;

//https://www.javatpoint.com/how-to-sort-hashmap-by-value
//https://www.javatpoint.com/java-basics
public class DecendingOrderBasedOnFrequencyArray implements Comparable<Map.Entry<Integer, Integer>> {
	public static void main(String args[]) {
	
		int[] input = { 2, 2, 3, 4, 5, 12, 2, 3, 3, 3, 12 };
		int[] res = new int[input.length];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 1;
		for (int i = 0; i < input.length; i++) {
			count=1;
			for (int j = i + 1; j < input.length; j++) {
				if ((input[i] == input[j])&&(input[i]!=0)) {
					count++;
					input[j]=0;
				}
			}
			if(input[i]!=0)
				map.put(input[i], count);
			}
	/*	Map<Integer, Integer> byValue=map.entrySet().stream()
				.sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getKey, 
						Map.Entry::getValue, (e1,e2) -> e1,LinkedHashMap::new));
		*/	for (Map.Entry m : map.entrySet()) {
			int num=(int) m.getValue();
			for (int i = 0; i < num; i++) 
			{
				System.out.print(m.getKey() + " ");
			}
		}
	}

	public int compareTo(Map.Entry<Integer, Integer> o) {
		return o.getKey().compareTo(hashCode());
	}

/*class ValueCompare implements Comparator<Map.Entry<Integer, Integer>> {

	@Override
	public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
		if(o1.getValue()==o2.getValue())
			return 0;
		else if(o1.getValue()>o2.getValue()) 
			return 1;
		else
			return -1;
	}*/
}


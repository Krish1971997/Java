package zoho;

/**3. Sort the array elements in descending order according to their frequency of occurrence

Input : [ 2 2 3 4 5 12 2 3 3 3 12 ]
Output : 3 3 3 3 2 2 2 12 12 4 5
Explanation : 3 occurred 4 times, 2 occurred 3 times, 12 occurred 2 times, 4 occurred 1 time, 5 occurred 1 time

Input : [ 0 -1 2 1 0 ]
Output : 0 0 -1 1 2
Note : sort single occurrence elements in ascending order
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

//https://www.javatpoint.com/how-to-sort-hashmap-by-value
//https://www.javatpoint.com/java-basics
public class DecendingOrderBasedOnFrequencyArray {
	public static void main(String args[]) {

		int[] input = { 2, 2, 3, 4, 5, 12, 2, 3, 3, 3, 12 };
		//int[] input = {4, 4, 5, 6, 4, 2, 2, 8, 5};
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int count = 1;
		for (int i = 0; i < input.length; i++) {
			count = 1;
			for (int j = i + 1; j < input.length; j++) {
				if ((input[i] == input[j]) && (input[i] != 0)) {
					count++;
					input[j] = 0;
				}
			}
			if (input[i] != 0)
				map.put(input[i], count);
		}
		sortValues(map);
	}

	private static void sortValues(Map<Integer, Integer> map) {
		List<Entry<Integer, Integer>> list = new LinkedList<Entry<Integer, Integer>>(map.entrySet());

		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() { //sorting
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});

		Map<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>(); //values add to the map from list
		for (Entry<Integer, Integer> entry : list)
			sortedMap.put(entry.getKey(), entry.getValue());

		for (Map.Entry m : sortedMap.entrySet()) {
			int num = (int) m.getValue();
			for (int i = 0; i < num; i++) {
				System.out.print(m.getKey() + " ");
			}
		}
	}
}

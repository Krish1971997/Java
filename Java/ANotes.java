
https://www.geeksforgeeks.org/zoho-interview-experience-set-36-software-developer/

https://www.geeksforgeeks.org/word-break-problem-dp-32/

https://krish1971997-psychic-broccoli-r94jqp4pwx62p6x.github.dev/?autoStart=false

//C output questions
https://www.geeksforgeeks.org/output-c-programs-set-59-loops-control-statements/

To get the top 3 numbers based on their frequency in an array in Java, you can use the following approach:

```java
import java.util.*;

public class TopThreeNumbers {
    public static List<Integer> getTopThreeNumbers(int[] nums) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) {
                return b.getKey() - a.getKey(); // If frequencies are equal, prioritize lower number
            }
            return b.getValue() - a.getValue(); // Sort by frequency in descending order
        });

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            pq.offer(entry);
        }

        List<Integer> topThreeNumbers = new ArrayList<>();
        while (topThreeNumbers.size() < 3 && !pq.isEmpty()) {
            topThreeNumbers.add(pq.poll().getKey());
        }

        return topThreeNumbers;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
        List<Integer> topThree = getTopThreeNumbers(nums);
        System.out.println("Top three numbers based on frequency: " + topThree);
    }
}
```

Here's how it works:

1. We start by creating a `frequencyMap` using a `HashMap` to store the frequency of each number in the input array.
2. We iterate through the `nums` array and update the frequencies in the `frequencyMap`.
3. Next, we use a `PriorityQueue` (`pq`) to store the entries of the `frequencyMap`. The priority queue is sorted based on the frequency of the numbers in descending order.
4. We iterate through the entries in the `frequencyMap` and add them to the priority queue (`pq`).
5. We create a `topThreeNumbers` list to store the top three numbers with the highest frequency.
6. While the `topThreeNumbers` list has fewer than three numbers and the priority queue is not empty, we poll the entry with the highest frequency from the priority queue and add its key (the number) to the `topThreeNumbers` list.
7. Finally, we return the `topThreeNumbers` list containing the top three numbers based on their frequency.

In the example above, the input array `{1, 2, 2, 3, 3, 3, 4, 4, 4, 4}` will output `[4, 3, 2]` because the number 4 has the highest frequency (4 occurrences), followed by 3 (3 occurrences), and 2 (2 occurrences).

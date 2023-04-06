import java.util.Set;
import java.util.TreeSet;

public class MergeArrayUsingTreeSet {
	
	public static void main(String[] args) {
		int arr1[]= {2,4,5,6,7,9,10,13};
		int arr2[]= {2,3,4,5,6,7,8,9,11,15};

		Set<Integer> treeSet=Arrays.asList(arr1,arr2);
		/*for (Integer integer : arr1) 
			treeSet.add(integer);
		
		for (Integer integer : arr2) 
			treeSet.add(integer); */
		
		System.out.println("Size : "+treeSet.size());
		
		for (Integer integer : treeSet) {
			System.out.print(integer+" ");
		}
	}

}

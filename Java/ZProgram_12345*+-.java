public class ZProgram_12345*+-{
public static void main(String[] args) {
		String s = "374291--*+-", sp="";
		int arr[] = new int[s.length() / 2 + 1];
		int j = 0, sum = 0,  x = 1, y = 0;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				arr[j++] = Character.getNumericValue(s.charAt(i));
			} else
				sp += (s.charAt(i));
		}
		sum = arr[0];
		for (int i = 0; i < sp.length(); i++) {
			sum = calculation(sum, arr[x++], sp.charAt(y++));
		}
		System.out.println("Sum ---> "+sum);
	}

	public static int calculation(int summ, int arr, char c) {
		int sum=0;
		switch (c) {
		case '+': sum=summ+arr; return sum;
		case '-': sum=summ-arr; return sum;
		case '*': sum=summ*arr; return sum;
		case '/': sum=summ/arr; return sum;
		default:
			throw new IllegalArgumentException("Unexpected value: " + c);
    }		
	}
}

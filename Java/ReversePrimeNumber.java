public class ReversePrimeNumber {
    public static void main(String[] args) {
        int num = 23;
        boolean check = primeCheck(num);
        if (check) {
            int reverse = ReverseNumber(num);
            boolean twistedNum = primeCheck(reverse);
            if (twistedNum) {
                System.out.println(num + " is twisted prime number");
                return;
            } else
                System.out.println(num + " is not twisted prime number");

            System.out.println("Prime number but not twisted prime number");
        } else
            System.out.println("Not Prime number");
    }

    private static int ReverseNumber(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum * 10 + num % 10;
            num /= 10;
        }
        return sum;
    }

    private static boolean primeCheck(int num) {
        boolean flag = true;
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

public class Factorial {
    public static void main(String[] args) {
        int num = 3;
        factorial(num);
    }

    static void factorial(int num) {
        int s = 1;
        while(num > 0) {
            s *= num;
            num -= 1;
        }
        System.out.println(s);
    }
}

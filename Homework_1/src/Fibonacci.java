public class Fibonacci {
    public static void main(String[] args) {
        int n = 5;
        fibonacci(n);
    }

    static void fibonacci(int num) {
        int f0 = 0;
        int f = 1;
        int s = 0;
        while(num != 0) {
            System.out.println(f);
            s = f;
            f += f0;
            f0 = s;
            num -= 1;
        }
    }
}

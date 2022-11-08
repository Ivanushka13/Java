public class Fibonacci {
    public static void main(String[] args) {
        int n = 7;
        fibonacci(n);
    }

    static void fibonacci(int num) {
        int el_prev = 0;
        int el_curr = 1;
        int swap = 0;
        while(num != 0) {
            System.out.print(el_curr);
            System.out.print(" ");
            swap = el_curr;
            el_curr += el_prev;
            el_prev = swap;
            num -= 1;
        }
    }
}

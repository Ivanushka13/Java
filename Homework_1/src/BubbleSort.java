public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 2, 1, 4, 3};
        for (int i = 1; i < arr.length; ++i) {
            int flag = 0;
            for (int j = 0; j < arr.length - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                    flag = 1;
                }
            }
            if (flag == 0) {
                break;
            }
        }
        for (int el : arr) {
            System.out.println(el);
        }
    }
}

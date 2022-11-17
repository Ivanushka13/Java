public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = bubbleSort(new int[]{5, 3, 1, 2, 4});
        for (int el : arr) {
            System.out.println(el);
        }
    }

    static int[] bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; ++i) {
            boolean flag = true;
            for (int j = 0; j < arr.length - i; ++j) {
                if (arr[j] > arr[j + 1]) {
                    int num = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = num;
                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }
}

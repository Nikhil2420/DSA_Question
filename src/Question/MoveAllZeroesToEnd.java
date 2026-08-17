package Question;

public class MoveAllZeroesToEnd {

    void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
        int i = 0;
        for (int j = 0; j < n; j++) {
            if (arr[j] != 0) {
                swap(arr, i, j);
                i++;
            }
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
public class MergeSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] digit, Context ct) {
        ct.startExecution();
        if (digit == null || digit.length <= 1) {
            return digit;
        }
        int[] temp = new int[digit.length];
        mergeSort(digit, 0, digit.length - 1, temp);
        ct.endExecution();
        return digit;
    }

    private void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;

        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        merge(arr, left, mid, right, temp);
    }
    private void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0; 
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t++] = arr[i++];
            } else {
                temp[t++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[t++] = arr[i++];
        }

        while (j <= right) {
            temp[t++] = arr[j++];
        }

        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
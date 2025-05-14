import java.util.Arrays;

public class SelectionSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] digit, Context ct) {
        ct.startExecution();
        int[] copy = Arrays.copyOf(digit, digit.length); // 创建副本
        int n = copy.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (copy[j] < copy[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = copy[i];
                copy[i] = copy[minIndex];
                copy[minIndex] = temp;
            }
        }
        ct.endExecution();
        return copy; // 返回排序后的副本
    }
}

public class ShellSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] digit, Context ct) {

        ct.startExecution();

        if (digit == null || digit.length <= 1) {
            return digit;
        }

        int n = digit.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = digit[i];
                int j = i;
                while (j >= gap && digit[j - gap] > temp) {
                    digit[j] = digit[j - gap];
                    j -= gap;
                }
                digit[j] = temp;
            }
        }
        ct.endExecution();
        return digit;
    }
}

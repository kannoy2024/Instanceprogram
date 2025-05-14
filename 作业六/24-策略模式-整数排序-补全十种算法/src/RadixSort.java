public class RadixSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] digit, Context ct) {
        ct.startExecution();

        if (digit == null || digit.length == 0) {
            return digit;
        }
        int max = getMax(digit);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(digit, exp);
        }
        ct.endExecution();
        return digit;
    }

    private int getMax(int[] digit) {
        int max = digit[0];
        for (int num : digit) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }
    
    private void countingSortByDigit(int[] digit, int exp) {
        int n = digit.length;
        int[] output = new int[n]; // 输出数组
        int[] count = new int[10]; // 基数为10，表示0~9

        for (int num : digit) {
            int digitPlace = (num / exp) % 10;
            count[digitPlace]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digitPlace = (digit[i] / exp) % 10;
            output[count[digitPlace] - 1] = digit[i];
            count[digitPlace]--;
        }
        // 将排序结果复制回原数组
        System.arraycopy(output, 0, digit, 0, n);
    }
}
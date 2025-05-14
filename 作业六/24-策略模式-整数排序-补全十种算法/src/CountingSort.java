public class CountingSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] digit, Context ct) {
        ct.startExecution();
        if (digit == null || digit.length == 0) {
            return digit;
        }

        int max = digit[0];
        int min = digit[0];
        for (int num : digit) {
            if (num > max) max = num;
            if (num < min) min = num;
        }

        int range = max - min + 1;
        int[] count = new int[range]; // 计数数组
        int[] output = new int[digit.length]; // 输出数组

        for (int num : digit) {
            count[num - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = digit.length - 1; i >= 0; i--) {
            int num = digit[i];
            output[count[num - min] - 1] = num;
            count[num - min]--;
        }

        System.arraycopy(output, 0, digit, 0, digit.length);
        ct.endExecution();
        return digit;
    }
}
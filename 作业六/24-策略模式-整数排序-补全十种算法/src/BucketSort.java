
import java.util.ArrayList;
import java.util.Collections;
// 思路：大问题化小
// 桶排序 (Bucket sort)或所谓的箱排序，是一种分块的排序算法，
// 工作的原理是将数组分到有限数量的桶里，每个桶的大小都相等。
// 每个桶再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序）
// 把待排序序列（数组）中的数据根据函数映射方法分配到若干个桶中，
// 在分别对各个桶进行排序，最后依次按顺序取出桶中的数据。
// 适用于数据分配均匀，数据比较大，相对集中的情况。

public class BucketSort implements SortAlgorithm {

    @Override
    public int[] sort(int[] digit, Context ct) {
        ct.startExecution();
        if (digit == null || digit.length <= 1) {
            return digit;
        }

        // 找出最大值和最小值
        int max = digit[0];
        int min = digit[0];
        for (int num : digit) {
            if (num > max)
                max = num;
            if (num < min)
                min = num;
        }

        int bucketCount = digit.length;
        ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketCount);

        // 初始化桶
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new ArrayList<Integer>());
        }

        // 将数据放入对应的桶中
        for (int num : digit) {
            int index = Math.min(bucketCount - 1, (num - min) * bucketCount / (max - min + 1));
            buckets.get(index).add(num);
        }

        for (ArrayList<Integer> bucket : buckets) {
            Collections.sort(bucket);
        }
        // 合并所有桶的数据回原数组
        int idx = 0;
        for (ArrayList<Integer> bucket : buckets) {
            for (int num : bucket) {
                digit[idx++] = num;
            }
        }
        ct.endExecution();
        return digit;
    }
}
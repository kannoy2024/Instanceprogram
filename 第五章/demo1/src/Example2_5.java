import java.util.Scanner;
import java.util.Arrays;

public class Example2_5 {
    public static void main(String[] args) {
        // 初始化数组
        int[] a = {1, 22, 3, 444, 235, 126, 27, 148, 239, 110,323,3256,65,466,876,32,78,94,23223};
        int N = a.length;

        // 选择排序
        for (int i = 0; i < N - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < N; j++) {
                if (a[j] < a[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = a[i];
                a[i] = a[minIndex];
                a[minIndex] = temp;
            }
        }

        // 打印排序后的数组
        System.out.println("排序后的数组: " + Arrays.toString(a));

        // 用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要查找的数:");
        int key = scanner.nextInt();

        // 二分查找
        int start = 0;
        int end = N - 1;
        boolean found = false;

        while (start <= end) {
            int middle = start + (end - start) / 2;//取中间值
            if (a[middle] == key) {
                found = true;
                break;
            } else if (a[middle] < key) {
                start = middle + 1;
            } else {
                end = middle - 1;
            }
        }

        if (found) {
            System.out.println("查找成功");
        } else {
            System.out.println("查找失败");
        }
        scanner.close();
    }
}
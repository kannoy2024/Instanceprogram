package work4;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> basket = new HashMap<>();
        int left = 0;
        int maxFruits = 0;
        for(int right = 0;right <fruits.length;right++){
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0)+1);

            while(basket.size() > 2){
                basket.put(fruits[left], basket.get(fruits[left])-1);
                if(basket.get(fruits[left]) == 0){
                    basket.remove(fruits[left]);
                }
                left++;
            }
            maxFruits = Math.max(maxFruits, right-left+1);
        }
        return maxFruits;
    }
}



// class Solution {
//     public int totalFruit(int[] fruits) {
//         int l = 0, r = 1, res = 0;
//         //使用first 和 second动态记录窗口内两种水果类型各自的最后出现位置。
//         int first = 0;      // 记录当前篮子中第一种水果的最后出现位置
//         // 跳过开头连续相同的果树（如[1,1,1,2]）
//         while (r < fruits.length && fruits[r] == fruits[0]) {
//             first = r;      // 更新第一种水果的最后位置
//             r++;
//         }

//         // 如果整个果园只有一种水果，直接返回总长度
//         if (r == fruits.length) {
//             return fruits.length;
//         }
//         // 记录当前篮子中第二种水果的最后出现位置
//         int second = r;

//         // 开始滑动窗口扫描
//         while (r < fruits.length) {
//             int cur = fruits[r];

//             // 情况1：当前水果与第一种水果相同
//             if (cur == fruits[first]) {
//                 // 交换两种水果的标记（因为后续需要优先保留最近出现的水果）
//                 first = second;  // 将原第二种水果设为第一种
//                 // 注意：second将在后面更新为当前位置
//             }
//             // 情况2：当前水果是新的第三种水果
//             else if (cur != fruits[second]) {
//                 // 更新结果：计算当前窗口大小
//                 res = Math.max(res, r - l);
//                 // 关键：移动左边界到「被淘汰水果」最后位置的下一位
//                 l = first + 1;  // first此时记录的是即将被淘汰的水果的最后位置
//                 // 保留当前第二种水果，作为窗口内剩余的一种水果
//                 first = second;
//             }
//             // 更新第二种水果的最后位置为当前位置
//             second = r;
//             r++;  // 右边界右移
//         }
//         // 循环结束后计算最终窗口大小
//         res = Math.max(res, r - l);
//         return res;
//     }
// }
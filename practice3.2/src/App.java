//求100 以内的素数
public class App {
    public static void main(String[] args) throws Exception {
        int i, j, flag;
        for (i = 2; i <= 100; i++) {
            flag = 1;
            for (j = 2; j <= Math.sqrt(i); j++) { // 修改内层循环的变量为j，并检查i是否为素数
                if (i % j == 0) {
                    flag = 0;
                    break;
                }
            }
            if (flag == 1) { // 如果flag为1，说明i是素数
                System.out.print(i + " ");
            }
        }
    }
}
//Math.sqrt(i) 用于计算 i 的平方根。在判断一个数是否为素数时，
// 我们只需要检查该数是否能被小于或等于其平方根的任何整数整除。这是因为如果 i 
// 能被一个大于其平方根的数整除，那么它必然也能被一个小于其平方根的数整除。

// //具体来说，假设 i 是一个合数（非素数），那么可以表示为两个因数的乘积 i = a * b。
// 如果 a 和 b 都大于 sqrt(i)，那么 a * b 将会大于 i，这与 i = a * b 矛盾。因此，至少有一个因数小于或等于 sqrt(i)。
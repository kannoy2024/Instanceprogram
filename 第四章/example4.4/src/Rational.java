
/**
 * Rational 类用于表示有理数，并提供对有理数的基本操作。
 * 有理数由分子 (numerator) 和分母 (denominator) 组成。
 */
public class Rational {
    // 分子
    int numerator = 1;
    // 分母
    int denominator =  1;

    /**
     * 获取分子的值。
     * @return 分子的值
     */
    int GetNumerator() {
        return numerator;
    }

    /**
     * 获取分母的值。
     * @return 分母的值
     */
    int GetDenominator() {
        return denominator;
    }

    /**
     * 计算两个整数的最大公约数 (GCD)。
     * 使用欧几里得算法实现。
     * @param a 第一个整数
     * @param b 第二个整数
     * @return 最大公约数
     */
    int f(int a, int b) {
        if (a == 0) return 1; // 如果其中一个数为0，则返回1
        if (a < b) { // 确保a >= b
            int c = a;
            a = b;
            b = c;
        }
        int r = a % b; // 求余数
        while (r != 0) { // 当余数不为0时继续循环
            a = b;
            b = r;
            r = a % b;
        }
        return b; // 返回最大公约数
    }

    /**
     * 设置分子的值，并自动约分化简。
     * @param a 新的分子值
     */
    void SetNumerator(int a) {
        int c = f(Math.abs(a), denominator); // 计算分子和分母的最大公约数
        numerator = a / c; // 约分后的分子
        denominator = denominator / c; // 约分后的分母
        if (numerator < 0 && denominator < 0) { // 如果分子和分母都为负数，则将两者转为正数
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * 设置分母的值，并自动约分化简。
     * @param b 新的分母值
     */
    void SetDenominator(int b) {
        if (b == 0) { // 如果分母为0，则抛出异常
            throw new IllegalArgumentException("分母不能为0");
            
        }
        int c = f(numerator, Math.abs(b)); // 计算分子和分母的最大公约数
        numerator = numerator / c; // 约分后的分子
        denominator = b / c; // 约分后的分母
        if (numerator < 0 && denominator < 0) { // 如果分子和分母都为负数，则将两者转为正数
            numerator = -numerator;
            denominator = -denominator;
        }
    }

    /**
     * 两个有理数相加。
     * @param r 另一个有理数
     * @return 相加结果的新有理数
     */
    Rational add(Rational r) {
        int a = r.GetNumerator(); // 获取另一个有理数的分子
        int b = r.GetDenominator(); // 获取另一个有理数的分母
        int newNumerator = numerator * b + denominator * a; // 计算新分子
        int newDenominator = denominator * b; // 计算新分母
        if (newDenominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero after addition.");
        }
        Rational result = new Rational(); // 创建新的有理数对象
        result.SetNumerator(newNumerator); // 设置新分子
        result.SetDenominator(newDenominator); // 设置新分母
        return result; // 返回结果
    }

    /**
     * 两个有理数相减。
     * @param r 另一个有理数
     * @return 相减结果的新有理数
     */
    Rational sub(Rational r) {
        int a = r.GetNumerator(); // 获取另一个有理数的分子
        int b = r.GetDenominator(); // 获取另一个有理数的分母
        int newNumerator = numerator * b - denominator * a; // 计算新分子
        int newDenominator = denominator * b; // 计算新分母
        if (newDenominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero after subtraction.");
        }
        Rational result = new Rational(); // 创建新的有理数对象
        result.SetNumerator(newNumerator); // 设置新分子
        result.SetDenominator(newDenominator); // 设置新分母
        return result; // 返回结果
    }

    /**
     * 两个有理数相乘。
     * @param r 另一个有理数
     * @return 相乘结果的新有理数
     */
    Rational mul(Rational r) {
        int a = r.GetNumerator(); // 获取另一个有理数的分子
        int b = r.GetDenominator(); // 获取另一个有理数的分母
        int newNumerator = numerator * a; // 计算新分子
        int newDenominator = denominator * b; // 计算新分母
        if (newDenominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero after subtraction.");
        }
        Rational result = new Rational(); // 创建新的有理数对象
        result.SetNumerator(newNumerator); // 设置新分子
        result.SetDenominator(newDenominator); // 设置新分母
        return result; // 返回结果
    }

    /**
     * 两个有理数相除。
     * @param r 另一个有理数
     * @return 相除结果的新有理数
     */
    Rational div(Rational r) {
        int a = r.GetNumerator(); // 获取另一个有理数的分子
        int b = r.GetDenominator(); // 获取另一个有理数的分母
        int newNumerator = numerator * b; // 计算新分子
        int newDenominator = denominator * a; // 计算新分母
        if (newDenominator == 0) {
            throw new ArithmeticException("Denominator cannot be zero after subtraction.");
        }
        Rational result = new Rational(); // 创建新的有理数对象
        result.SetNumerator(newNumerator); // 设置新分子
        result.SetDenominator(newDenominator); // 设置新分母
        return result; // 返回结果
    }
}
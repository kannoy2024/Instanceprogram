public class work5 {
    public static void main(String[] args) {
        int sum = show(1,2,3,4,5,6,7,8,9,10);
        System.out.println(sum);

        sum = show(1,2,3);
        System.out.println(sum);
// 没有参数，也不会报错
        sum = show();
        System.out.println(sum);
    }
//使用了可变参数
    public static int show(int... args){
        int sum = 0;
      for (int args2 : args) {
        sum+=args2;
      }
        return sum;
    }
}

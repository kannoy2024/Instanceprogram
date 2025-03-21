public class example1 {
    public static void main(String[] args) {
        // String hello="hello you!";
        // String testOne = "testOne"+"testTwo";
        int address = System.identityHashCode("hello you!");
        System.out.printf("你好的引用:%x",address);
        String s1 = "天道酬勤";
        String s2 = "天道酬勤";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("使用equals判断两者是否相同"+s1.equals(s2));
        String s3 = "Hello";
        String s4 = "hELLO";
        System.out.println("equals在比较的时候不会忽略大小写"+s3.equals(s4));
        System.out.println("使用.length输出字符串的长度,s3长度是"+s3.length());
      }   
}
 